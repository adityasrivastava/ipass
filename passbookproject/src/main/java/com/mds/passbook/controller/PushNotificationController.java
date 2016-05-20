package com.mds.passbook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mds.passbook.notification.PassbookNotification;
import com.mds.passkit.GeneratePass;

/**
 * Apple Wallet webservice which allow Update, Delete, Add new Pass to wallet of an iOS device
 * 
 * @author adityasrivastava
 *
 */
@RestController
public class PushNotificationController{
	
	public static final Logger logger = LoggerFactory.getLogger(PushNotificationController.class);
	public static String token = "15c19c99888bed405f91785e4140b9f267c3f8fc191556ae562fb96ab31f83f4";
	
	private static String username;
	private static String userAge;
	private static String userGender;
	
	
	/**
	 * Check Server status
	 */
	@RequestMapping(value="/serverStatus", method=RequestMethod.GET, produces="text/html")
	public String serverStatus(){
		return "Server Working...";
	}
	
	@RequestMapping(value="/passbookStatus", produces="text/html")
	public String passbookStatus(){
		return PassbookStatus.getInstance().getUpdateStatus().toString();
	}
	
	@RequestMapping(value="/changeStatus")
	public void changeStatus(){
		PassbookStatus.getInstance().setUpdateStatus(false);
	}

	/**
	 * Download new pass 
	 * 
	 * @return Pkpass file
	 * @throws IOException
	 */
	
	@RequestMapping(value="/downloadPass", method=RequestMethod.GET, produces="application/vnd.apple.pkpass")
	public ResponseEntity<InputStreamResource> downloadPass (@RequestParam(name="name", required=false) String name,
							@RequestParam(name="age", required=false) String age, @RequestParam(name="gender", required=false) String gender
							   ) throws IOException{

		long fileLength;
		File newPass;
		InputStream passInputStream;
		HttpHeaders responseHeaders;
		GeneratePass generatePass;

		responseHeaders = new HttpHeaders();
		generatePass = new GeneratePass();
		
		username = name;
		userAge = age;
		userGender = gender;
		
		logger.info("Downloading Pass.....");
		
		// Create Pass
		try {
			generatePass.createPass("passes/file3.pkpass", "2221", name, age, gender);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get new generated pass
		newPass = new File("passes/file3.pkpass");
		
		fileLength = newPass.length();
		passInputStream = new FileInputStream(newPass);

		// Setup headers for 0 expiry and no cache
		responseHeaders.add("Cache-Control", "no-cache, no-store, must-revalidate");
		responseHeaders.add("Pragma", "no-cache");
		responseHeaders.add("Expires", "0");
		responseHeaders.setContentDispositionFormData("filename", "file1.pkpass");
		responseHeaders.setLastModified(new Date().getTime());
	
		// Send in response
		return ResponseEntity
	            .ok()
	            .headers(responseHeaders)
	            .contentLength(fileLength)
	            .body(new InputStreamResource(passInputStream));
	}
	
	/**
	 * Send a push notification to APN server for new updates notification to 
	 * devices with registerd passes
	 */
	@RequestMapping(value="/pushNotifications")
	public void pushToken(){

		PassbookNotification pushNotification = new PassbookNotification();
		pushNotification.initialize(token);
		PassbookStatus.getInstance().setUpdateStatus(false);
		logger.info("Push notification initiated....");

	}
	
	/**
	 * To Add newly register pass of a device with push token 
	 * 
	 * @param deviceLibraryIdentifier - Device UUID ( DeviceId )
	 * @param passTypeIdentifier - Pass Type Id ( Bundle Id )
	 * @param serialNumber - Pass Serial Number
	 * @param payload - Wallet request body with Push Token ( Device Token )
	 * @return 201 Status
	 */
	@RequestMapping(value="/v1/devices/{deviceLibraryIdentifier}/registrations/{passTypeIdentifier}/{serialNumber}", method=RequestMethod.POST)
	public ResponseEntity<String> addPassbook(
							   @PathVariable("deviceLibraryIdentifier") String deviceLibraryIdentifier,
							   @PathVariable("passTypeIdentifier") String passTypeIdentifier,
							   @PathVariable("serialNumber") String serialNumber,
							   @RequestBody(required=false) Map<String, Object> payload){
		
		logger.info("Adding Passbook......");
		logger.debug("DeviceLib: {} >>> PassType: {} >>> SerialNo.: {}",deviceLibraryIdentifier, passTypeIdentifier, serialNumber); 
		logger.debug("Request: {}", payload);
		PassbookStatus.getInstance().setUpdateStatus(true);
		token = payload.get("pushToken").toString();

		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	/**
	 * Send response with list of serial number of pass which have been recently updated 
	 * with last update timestamp in JSON
	 * 
	 * @param deviceLibraryIdentifier - Device UUID ( DeviceId )
	 * @param passTypeIdentifier - Pass Type Id ( Bundle Id )
	 * @param passesUpdatedSince - Updated last timestamp
	 * @param payload - Wallet request body
	 * @return JSON string with serial number array and lastUpdated
	 */
	
	@RequestMapping(value="/v1/devices/{deviceLibraryIdentifier}/registrations/{passTypeIdentifier}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSerialIdsOfPassForDevice(
							   @PathVariable("deviceLibraryIdentifier") String deviceLibraryIdentifier,
							   @PathVariable("passTypeIdentifier") String passTypeIdentifier,
							   @RequestParam(value="passesUpdatedSince", required=false) String passesUpdatedSince,
							   @RequestBody(required=false) Map<String, Object> payload){
		
		logger.info("Sending list of serial no. request for update....");
		logger.debug("DeviceLib: {} >>> PassType: {}",deviceLibraryIdentifier, passTypeIdentifier); 
		
		if(passesUpdatedSince !=null){
			logger.debug("Update Tag: "+passesUpdatedSince);
		}
		
		logger.debug("Request: {}", payload);
	
		return new ResponseEntity<String>("{\"serialNumbers\": [\"2221\"], \"lastUpdated\" : \""+new Timestamp(System.currentTimeMillis() - (1000 * 60 * 60))+"\"}", HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param deviceLibraryIdentifier - Device UUID ( DeviceId )
	 * @param passTypeIdentifier - Pass Type Id ( Bundle Id )
	 * @return updated new pass in response to device
	 * @throws IOException
	 */
	@RequestMapping(value="/v1/passes/{passTypeIdentifier}/{serialNumber}", method=RequestMethod.GET)
	public ResponseEntity<InputStreamResource> updatePassbook (
							   @PathVariable("passTypeIdentifier") String passTypeIdentifier,
							   @PathVariable("serialNumber") String serialNumber,
							   @RequestBody(required=false) Map<String, Object> payload) throws IOException{
		long fileLength;
		File newPass;
		InputStream passInputStream;
		HttpHeaders responseHeaders;
		GeneratePass gp;
	
		logger.info("Generating pass for update response....");
		logger.debug("PassType: {} >>> SerialNo.: {}",passTypeIdentifier, serialNumber); 
		logger.debug("Request: {}", payload);
		PassbookStatus.getInstance().setUpdateStatus(true);
		responseHeaders = new HttpHeaders();
		gp = new GeneratePass();

		// Create Pass
		try {
			gp.createPass("passes/file3.pkpass", "2221", username, userAge, userGender);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get new generated pass
		newPass = new File("passes/file3.pkpass");
		
		fileLength = newPass.length();
		passInputStream = new FileInputStream(newPass);

		// Setup headers for 0 expiry and no cache
		responseHeaders.add("Cache-Control", "no-cache, no-store, must-revalidate");
		responseHeaders.add("Pragma", "no-cache");
		responseHeaders.add("Expires", "0");
		responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		responseHeaders.setContentDispositionFormData("filename", "file3.pkpass");
		responseHeaders.setLastModified(new Date().getTime());

		// Send in response
		return ResponseEntity
	            .ok()
	            .headers(responseHeaders)
	            .contentLength(fileLength)
	            .body(new InputStreamResource(passInputStream));
	}
	
	/**
	 * 
	 * @param deviceLibraryIdentifier - Device UUID ( DeviceId )
	 * @param passTypeIdentifier - Pass Type Id ( Bundle Id )
	 * @param serialNumber - Pass Serial Number
	 * @return 200 Status 
	 */
	@RequestMapping(value="/v1/devices/{deviceLibraryIdentifier}/registrations/{passTypeIdentifier}/{serialNumber}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deletePassbook(
							   @PathVariable("deviceLibraryIdentifier") String deviceLibraryIdentifier,
							   @PathVariable("passTypeIdentifier") String passTypeIdentifier,
							   @PathVariable("serialNumber") String serialNumber,
							   @RequestBody(required=false) Map<String, Object> payload){
		
		logger.info("Delete pass as requested by user.....");
		logger.debug("DeviceLib: {} >>> PassType: {} >>> SerialNo.: {}",deviceLibraryIdentifier, passTypeIdentifier, serialNumber); 
		logger.debug("Request: {}", payload);
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	/**
	 * Logging device errors from request body sent by a particular Device
	 */
	@RequestMapping(value="/v1/log", method=RequestMethod.POST)
	public void logPassbookErrors(
							   @RequestBody Map<String, Object> payload){
		
		logger.info("Request: {}", payload);

	}
}
