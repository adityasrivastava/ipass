package com.mds.passbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update(){
		PassbookStatus.getInstance();
		PassbookStatus.setUpdateStatus(false);
		return "update";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(){
		PassbookStatus.getInstance();
		PassbookStatus.setUpdateStatus(false);
		return "login";
	}
}
