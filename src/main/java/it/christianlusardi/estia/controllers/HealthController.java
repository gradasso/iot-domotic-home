package it.christianlusardi.estia.controllers;

import it.christianlusardi.estia.responses.BaseResponse;
import spark.Request;
import spark.Response;

public class HealthController {
	
	public static BaseResponse health(Request req, Response res) {
		BaseResponse response = new BaseResponse();
		
		response.setStatus("OK");
		response.setMessage("Service is up and running");
		
		return response;
	}

}
