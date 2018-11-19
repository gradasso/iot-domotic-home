package it.christianlusardi.estia.controllers;

import java.util.Set;

import it.christianlusardi.estia.responses.BaseResponse;
import it.christianlusardi.estia.responses.Constants;
import spark.Request;
import spark.Response;



/**
 * Controller for anomaly recording
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
public class AnomalyController {
	
	public static BaseResponse registerAnomaly(Request req, Response res) {
		BaseResponse response = new BaseResponse();
		
		Set<String> hs = req.headers();
		
		for (String header : hs) {
			System.out.println("header --> "+header );
		}
		
		System.out.println();
		System.out.println(req.headers("SENSOR_UUID"));
		
		System.out.println(req.body());
		
		return response;
	}
	
	
	/**
	 * Constructor
	 */
	private AnomalyController() {
		throw new IllegalAccessError(Constants.STANDARD_UTILITY_MESSAGE);
	}

}
