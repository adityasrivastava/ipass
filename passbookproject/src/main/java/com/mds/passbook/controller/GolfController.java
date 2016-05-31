package com.mds.passbook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mds.passbook.bean.Golf;
import com.mds.passbook.bean.GolfCourse;
import com.mds.passbook.bean.GolfGame;
import com.mds.passbook.bean.GolfHoles;
import com.mds.passbook.bean.GolfPass;
import com.mds.passbook.bean.GolfScore;
import com.mds.passbook.bean.GolfTee;
import com.mds.passbook.bean.GolfUser;
import com.mds.passbook.repo.GolfCourseRepository;
import com.mds.passbook.repo.GolfHolesRepository;
import com.mds.passbook.repo.GolfPassRepository;
import com.mds.passbook.repo.GolfRepository;
import com.mds.passbook.repo.GolfScoreRepository;
import com.mds.passbook.repo.GolfTeeRepository;
import com.mds.passbook.repo.GolfUserRepository;
import com.mds.passbook.repo.dao.GolfDao;
import com.mds.passbook.repo.dao.GolfScoreDao;
import com.mds.passbook.service.GolfService;
import com.mds.passkit.GeneratePass;
import com.mds.passkit.GolfWallet;


@RestController
public class GolfController {
	
	@Autowired
	GolfService service;
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String user(@RequestBody(required=true) GolfUser user, @RequestParam(name="target", required=true) String target){
		String response;
		
		switch(target.toLowerCase()){
			case "add":
				service.addUser(user);
				response = "ADD";
				break;
			case "remove":
				service.deleteUser(user);
				response = "DELETE";
				break;
			case "update":
				service.updateUser(user);
				response = "UPDATE";
				break;
			default:
				response = "-1";
				break;
		}
		
		return response;
		
	}
	
	@RequestMapping(value="/golfCourse", method=RequestMethod.POST)
	public String golfCourse(@RequestBody GolfCourse course, @RequestParam(name="target") String target){
		String response;
		
		switch(target.toLowerCase()){
			case "add":
				service.addGolfCourse(course);
				response = "ADD";
				break;
			case "remove":
				service.deleteGolfCourse(course);
				response = "DELETE";
				break;
			case "update":
				service.updateGolfCourse(course);
				response = "UPDATE";
				break;
			default:
				response = "-1";
				break;
		}
		
		return response;
	}
	
	@RequestMapping(value="/holes", method=RequestMethod.POST)
	public String holes(@RequestBody(required=true) GolfHoles holes, @RequestParam(name="target") String target){
		String response;
		
		
		switch(target.toLowerCase()){
			case "add":
				service.addGolfHole(holes);
				response = "ADD";
				break;
			case "remove":
				service.deleteGoldHole(holes);
				response = "DELETE";
				break;
			case "update":
				service.updateGolfHole(holes);
				response = "UPDATE";
				break;
			default:
				response = "-1";
				break;
		}
		
		return response;
	}
	
	@RequestMapping(value="/tee", method=RequestMethod.POST)
	public String golf(@RequestBody(required=true) GolfTee tee, @RequestParam(name="target") String target){
		
		String response;
		

		switch(target.toLowerCase()){
			case "add":
				service.addGolfTee(tee);
				response = "ADD";
				break;
			case "remove":
				service.deleteGolfTee(tee);
				response = "DELETE";
				break;
			case "update":
				service.updateGolfTee(tee);
				response = "UPDATE";
				break;
			default:
				response = "-1";
				break;
		}
		
		return response;
		
	}
	

	@RequestMapping(value="/score", method=RequestMethod.POST)
	public String score(@RequestBody(required=true) GolfScore score, @RequestParam(name="target") String target){
		String response;
		
		switch(target.toLowerCase()){
		case "add":
			service.addGolfScore(score);
			response = "ADD";
			break;
		case "remove":
			service.deleteGolfScore(score);
			response = "DELETE";
			break;
		case "update":
			service.updateGolfScore(score);
			response = "UPDATE";
			break;
		default:
			response = "-1";
			break;
		}
		
		return response;
	}
	
	@RequestMapping(value="/pass", method=RequestMethod.POST)
	public String pass(@RequestBody(required=true) GolfPass pass, @RequestParam(name="target") String target){
		String response;
		
		switch(target.toLowerCase()){
		case "add":
			service.addGolfPass(pass);
			response = "ADD";
			break;
		case "remove":
			service.deleteGolfPass(pass);
			response = "DELETE";
			break;
		case "update":
			service.updateGolfPass(pass);
			response = "UPDATE";
			break;
		default:
			response = "-1";
			break;
	}
		
		return response;
	}
}
