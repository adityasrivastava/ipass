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
	public static String token = "15c19c99888bed405f91785e4140b9f267c3f8fc191556ae562fb96ab31f83f4";
	

	@RequestMapping(value="/serverStatus", method=RequestMethod.GET)
	public String serverStatus(){
		return "Server Working...";
	}
	
	@RequestMapping(value="/downloadPass", method=RequestMethod.GET, produces="application/vnd.apple.pkpass")
	public ResponseEntity<InputStreamResource> downloadPass (
							   ) throws IOException{
		long fileLength;
		File newPass;
		InputStream passInputStream;
		HttpHeaders responseHeaders;
		GeneratePass gp;
	
		responseHeaders = new HttpHeaders();
		gp = new GeneratePass();
		
		try {
			gp.createPass("passes/file3.pkpass", "222");
		} catch (IOException e) {
			e.printStackTrace();
		}

		newPass = new File("passes/file3.pkpass");
		
		fileLength = newPass.length();
		passInputStream = new FileInputStream(newPass);

		responseHeaders.add("Cache-Control", "no-cache, no-store, must-revalidate");
		responseHeaders.add("Pragma", "no-cache");
		responseHeaders.add("Expires", "0");
		responseHeaders.setContentDispositionFormData("filename", "file1.pkpass");
		responseHeaders.setLastModified(new Date().getTime());

		return ResponseEntity
	            .ok()
	            .headers(responseHeaders)
	            .contentLength(fileLength)
	            .body(new InputStreamResource(passInputStream));
	}
	
	@RequestMapping(value="/pushNotifications")
	public void pushToken(){
		System.out.println("Token :>>"+token);
		PassbookNotification pushNotification = new PassbookNotification();
		pushNotification.initialize(token);

	}
	
	@RequestMapping(value="/v1/devices/{deviceLibraryIdentifier}/registrations/{passTypeIdentifier}/{serialNumber}", method=RequestMethod.POST)
	public ResponseEntity<String> addPassbook(
							   @PathVariable("deviceLibraryIdentifier") String deviceLibraryIdentifier,
							   @PathVariable("passTypeIdentifier") String passTypeIdentifier,
							   @PathVariable("serialNumber") String serialNumber,
							   @RequestBody(required=false) Map<String, Object> payload){
		
		logger.info("DeviceLib: {} >>> PassType: {} >>> SerialNo.: {}",deviceLibraryIdentifier, passTypeIdentifier, serialNumber); 
		logger.info("Request: {}", payload);
	
		token = payload.get("pushToken").toString();

		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/v1/devices/{deviceLibraryIdentifier}/registrations/{passTypeIdentifier}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSerialIdsOfPassForDevice(
							   @PathVariable("deviceLibraryIdentifier") String deviceLibraryIdentifier,
							   @PathVariable("passTypeIdentifier") String passTypeIdentifier,
							   @RequestParam(value="passesUpdatedSince", required=false) String passesUpdatedSince,
							   @RequestBody(required=false) Map<String, Object> payload){
		System.out.println("In getSerialIdsOfPassForDevice");
		logger.info("DeviceLib: {} >>> PassType: {}",deviceLibraryIdentifier, passTypeIdentifier); 
		
		if(passesUpdatedSince !=null){
			logger.info("Update Tag: "+passesUpdatedSince);
		}
		
		logger.info("Request: {}", payload);
	
		return new ResponseEntity<String>("{\"serialNumbers\": [\"222\"], \"lastUpdated\" : \""+new Timestamp(System.currentTimeMillis() - (1000 * 60 * 60))+"\"}", HttpStatus.OK);
	}
	
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
		System.out.println("Test");
		logger.info("PassType: {} >>> SerialNo.: {}",passTypeIdentifier, serialNumber); 
		logger.info("Request: {}", payload);
		System.out.println("In updatePassbook");
		responseHeaders = new HttpHeaders();
		gp = new GeneratePass();
		
		try {
			gp.createPass("passes/file3.pkpass", "222");
		} catch (IOException e) {
			e.printStackTrace();
		}

		newPass = new File("passes/file3.pkpass");
		
		fileLength = newPass.length();
		passInputStream = new FileInputStream(newPass);

		responseHeaders.add("Cache-Control", "no-cache, no-store, must-revalidate");
		responseHeaders.add("Pragma", "no-cache");
		responseHeaders.add("Expires", "0");
		responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		responseHeaders.setContentDispositionFormData("filename", "file1.pkpass");
		responseHeaders.setLastModified(new Date().getTime());

		return ResponseEntity
	            .ok()
	            .headers(responseHeaders)
	            .contentLength(fileLength)
	            .body(new InputStreamResource(passInputStream));
	}
	
	@RequestMapping(value="/v1/devices/{deviceLibraryIdentifier}/registrations/{passTypeIdentifier}/{serialNumber}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deletePassbook(
							   @PathVariable("deviceLibraryIdentifier") String deviceLibraryIdentifier,
							   @PathVariable("passTypeIdentifier") String passTypeIdentifier,
							   @PathVariable("serialNumber") String serialNumber,
							   @RequestBody(required=false) Map<String, Object> payload){
		
		logger.info("DeviceLib: {} >>> PassType: {} >>> SerialNo.: {}",deviceLibraryIdentifier, passTypeIdentifier, serialNumber); 
		logger.info("Request: {}", payload);
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/v1/log", method=RequestMethod.POST)
	public void logPassbookErrors(
							   @RequestBody Map<String, Object> payload){
 
		logger.info("Request: {}", payload);

	}
}
