package it.christianlusardi.estia.controllers;

import it.christianlusardi.estia.responses.BaseResponse;
import it.christianlusardi.estia.responses.Constants;
import spark.Request;
import spark.Response;



/**
 * Controller for data collection
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
public class DataController {
	
	public static BaseResponse collectData(Request req, Response res) {
		BaseResponse response = new BaseResponse();
		
		for (String header : req.headers()) {
			System.out.println("header --> "+header );
		}
		
		System.out.println(req.body());
		
		return response;
	}
	
	
	/**
	 * Constructor
	 */
	private DataController() {
		throw new IllegalAccessError(Constants.STANDARD_UTILITY_MESSAGE);
	}

}
