package com.mds.passkit;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import com.mds.passkit.exception.PasskitException;
import com.mds.passkit.pass.container.StorePassContainer;
import com.mds.passkit.utils.PassKitUtils;
import com.ryantenney.passkit4j.model.DateField;
import com.ryantenney.passkit4j.model.EventTicket;
import com.ryantenney.passkit4j.model.Generic;
import com.ryantenney.passkit4j.model.TextAlignment;
import com.ryantenney.passkit4j.model.TextField;

/*
 * Generate new pass and store to system configure file in myapplication.properties file in resources
 */
public class GeneratePass {
	
	private Properties properites;
	private StorePassContainer storeCardPass;
	
	public void createGenericPass(String passLocation, String serialNumber, String name, String age, String gender, String holeType, String hole, String score) throws IOException{
		
		properites = PassKitUtils.getProperties();
		
		long unixTime = System.currentTimeMillis() / 1000L;
		Aviva aviva = new Aviva();
		
		TextField changeField = new TextField("heading", "Gulf Course", ""+unixTime);
		changeField.changeMessage("Update with new Pass");

	      try {
	        aviva.generateStorePass(passLocation, "12345678912345678", serialNumber,  new Generic()
	        	      .headerFields(changeField)
	        	      .primaryFields(new TextField())
	        	      .auxiliaryFields(
	        	    		  new TextField("game","Game", holeType).textAlignment(TextAlignment.LEFT),
	        	              new TextField("par", "Par", ""+35).textAlignment(TextAlignment.RIGHT)
	        	      )
	        	      .secondaryFields(
	        	    		  new TextField("age","Age", gender.charAt(0)+age).textAlignment(TextAlignment.LEFT),
	        	              new TextField("name", "Name", ""+name).textAlignment(TextAlignment.RIGHT)
	        	    		 )
	        	      .backFields(
	        	              new DateField("datetime", "Date & Time", new Date()),
	        	              new TextField("hole1", hole+" - "+ score, "3 Par, 7 Stroke, White Tee, 110 Yards")
	        	      ));
	      } catch (PasskitException e) {
	        e.printStackTrace();
	      }
	}
	
	public void createPass(String passLocation, String serialNumber, String name, String age, String gender) throws IOException{
		
		properites = PassKitUtils.getProperties();
		
		long unixTime = System.currentTimeMillis() / 1000L;
		Aviva aviva = new Aviva();
		
		TextField changeField = new TextField("heading", "Gulf Course", ""+unixTime);
		changeField.changeMessage("Update with new Pass");

	      try {
	        aviva.generateStorePass(passLocation, "12345678912345678", serialNumber,  new EventTicket()
	        	      .headerFields(changeField)
//	        	      .primaryFields(new TextField("client", name))
	        	      .auxiliaryFields(
	        	    		  new TextField("gender","Gender", gender),
	        	              new TextField("score", "Score", ""+43)
	        	      )
	        	      .secondaryFields(
	        	    		  new TextField("age","Age", age),
	        	              new TextField("name", "Name", ""+name)
	        	    		 )
	        	      .backFields(
	        	              new TextField("address", "address_label", "address_value"),
	        	              new TextField("phone", "phone_label", "phone_value"),
	        	              new TextField("email", "email_label", "email_value"),
	        	              new TextField("site", "site_label", "site_value"),
	        	              new TextField("disclaimer", "disclaimer_label", "disclaimer_value")
	        	              
	        	      ));
	      } catch (PasskitException e) {
	        e.printStackTrace();
	      }
	}
}
