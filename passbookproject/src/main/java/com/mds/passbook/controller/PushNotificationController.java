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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mds.passbook.notification.PassbookNotification;
import com.mds.passkit.GeneratePass;

@RestController
public class PushNotificationController {
	
	public static final Logger logger = LoggerFactory.getLogger(PushNotificationController.class);
	public static String token = "641e29475d7213c5b075268bb2bf5300f66e4c8f17a4a5b8fa2741c89edc57d3";

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
		return "Server Working...";
	}
	
	@RequestMapping(value="/pushNotifications")
	public void pushToken(){
		
		PassbookNotification pushNotification = new PassbookNotification();
		pushNotification.initialize(token);

	}
	
	@RequestMapping(value="/v1/devices/{deviceLibraryIdentifier}/registrations/{passTypeIdentifier}/{serialNumber}", method=RequestMethod.POST)
	public ResponseEntity<Object> addPassbook(
							   @PathVariable("deviceLibraryIdentifier") String deviceLibraryIdentifier,
							   @PathVariable("passTypeIdentifier") String passTypeIdentifier,
							   @PathVariable("serialNumber") String serialNumber,
							   @RequestBody(required=false) Map<String, Object> payload){
		
		logger.info("DeviceLib: {} >>> PassType: {} >>> SerialNo.: {}",deviceLibraryIdentifier, passTypeIdentifier, serialNumber); 
		logger.info("Request: {}", payload);
	
		token = payload.get("pushToken").toString();

		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/v1/devices/{deviceLibraryIdentifier}/registrations/{passTypeIdentifier}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSerialIdsOfPassForDevice(
							   @PathVariable("deviceLibraryIdentifier") String deviceLibraryIdentifier,
							   @PathVariable("passTypeIdentifier") String passTypeIdentifier,
							   @RequestParam(value="passesUpdatedSince", required=false) String passesUpdatedSince,
							   @RequestBody(required=false) Map<String, Object> payload){
		
		logger.info("DeviceLib: {} >>> PassType: {}",deviceLibraryIdentifier, passTypeIdentifier); 
		
		if(passesUpdatedSince !=null){
			logger.info("Update Tag: "+passesUpdatedSince);
		}
		
		logger.info("Request: {}", payload);
	
		return new ResponseEntity<String>("{\"serialNumbers\": [\"323323\"], \"lastUpdated\" : \""+new Timestamp(System.currentTimeMillis() - (30*60*1000))+"\"}", HttpStatus.OK);
	}
	
	@RequestMapping(value="/v1/passes/{passTypeIdentifier}/{serialNumber}", method=RequestMethod.GET, produces="application/vnd.apple.pkpass")
	public ResponseEntity<InputStreamResource> updatePassbook (
							   @PathVariable("passTypeIdentifier") String passTypeIdentifier,
							   @PathVariable("serialNumber") String serialNumber,
							   @RequestBody(required=false) Map<String, Object> payload) throws IOException{
		long fileLength;
		File newPass;
		InputStream passInputStream;
		HttpHeaders responseHeaders;
		GeneratePass gp;
		
		logger.info("PassType: {} >>> SerialNo.: {}",passTypeIdentifier, serialNumber); 
		logger.info("Request: {}", payload);
		
		responseHeaders = new HttpHeaders();
		gp = new GeneratePass();
		
		try {
			gp.createPass("passes/testfiles.pkpass", "323323");
		} catch (IOException e) {
			e.printStackTrace();
		}

		newPass = new File("passes/testfiles.pkpass");
		
		fileLength = newPass.length();
		passInputStream = new FileInputStream(newPass);

		responseHeaders.add("Cache-Control", "no-cache, no-store, must-revalidate");
		responseHeaders.add("Pragma", "no-cache");
		responseHeaders.add("Expires", "0");
		responseHeaders.setContentDispositionFormData("filename", "testfiles.pkpass");
		responseHeaders.setLastModified(new Date().getTime());

		return ResponseEntity
	            .ok()
	            .headers(responseHeaders)
	            .contentLength(fileLength)
	            .body(new InputStreamResource(passInputStream));
	}
	
	@RequestMapping(value="/v1/devices/{deviceLibraryIdentifier}/registrations/{passTypeIdentifier}/{serialNumber}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deletePassbook(
							   @PathVariable("deviceLibraryIdentifier") String deviceLibraryIdentifier,
							   @PathVariable("passTypeIdentifier") String passTypeIdentifier,
							   @PathVariable("serialNumber") String serialNumber,
							   @RequestBody Map<String, Object> payload){
		
		logger.info("DeviceLib: {} >>> PassType: {} >>> SerialNo.: {}",deviceLibraryIdentifier, passTypeIdentifier, serialNumber); 
		logger.info("Request: {}", payload);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/v1/log", method=RequestMethod.POST)
	public void logPassbookErrors(
							   @RequestBody Map<String, Object> payload){
 
		logger.info("Request: {}", payload);

	}
}
