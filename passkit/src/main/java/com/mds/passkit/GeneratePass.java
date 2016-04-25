package com.mds.passkit;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import com.mds.passkit.exception.PasskitException;
import com.mds.passkit.pass.container.StorePassContainer;
import com.mds.passkit.utils.PassKitUtils;
import com.ryantenney.passkit4j.model.Barcode;
import com.ryantenney.passkit4j.model.BarcodeFormat;
import com.ryantenney.passkit4j.model.EventTicket;
import com.ryantenney.passkit4j.model.Field;
import com.ryantenney.passkit4j.model.Generic;
import com.ryantenney.passkit4j.model.StoreCard;
import com.ryantenney.passkit4j.model.TextField;

/*
 * Generate new pass and store to system configure file in myapplication.properties file in resources
 */
public class GeneratePass {
	
	private Properties properites;
	private StorePassContainer storeCardPass;
	
	public void createPass(String passLocation, String serialNumber) throws IOException{
		
		properites = PassKitUtils.getProperties();
		
		long unixTime = System.currentTimeMillis() / 1000L;
		Aviva aviva = new Aviva();
		
		TextField changeField = new TextField("heading", "Head", ""+new Date().getTime());
		changeField.changeMessage("Update with new Pass");
		
		
		
		
	      try {
	        aviva.generateStorePass(passLocation, "12345678912345678", serialNumber,  new StoreCard()
//	        		   .headerFields(new TextField("card", "card_label"))
	        	      .headerFields(changeField)
	        	      .auxiliaryFields(
	        	              new TextField("name", "client_name", "Test Client"),
	        	              new TextField("id", "client_id", ""+unixTime)
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
