package com.mds.passkit.test;

import java.io.IOException;

import com.mds.passkit.GeneratePass;

public class GenericPassExample {
	
	public static void main(String args[]){
		
		GeneratePass gp = new GeneratePass();
		try {
			gp.createGenericPass("/Users/adityasrivastava/Desktop/file.pkpass", "111", "aditya", "1", "male", "9 Hole","Hole 1", "0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
