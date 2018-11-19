package it.christianlusardi.estia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.christianlusardi.estia.controllers.AnomalyController;
import it.christianlusardi.estia.controllers.DataController;
import it.christianlusardi.estia.controllers.HealthController;
import it.christianlusardi.estia.responses.Constants;
import it.christianlusardi.estia.transformers.JsonTransformer;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.port;
import static spark.Spark.before;
import static spark.Spark.after;




/**
 * Estia server engine
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
public class Estia {
	
	
	//Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(Estia.class);

	
	/**
	 * Main
	 */
	public static void main(String[] args) {
		
		serverConfig();
		
		registerRoutes();
	}
	
	
	/**
	 * Procedure to setup server configurations
	 */
	private static void serverConfig() {
		port(Constants.DEFAULT_PORT);
		
		before((request, response) -> response.type(Constants.CONTENT_TYPE_JSON));
		
		after((request, response) -> response.type(Constants.CONTENT_TYPE_JSON));
	}
	
	
	
	/**
	 * Procedure to setup server routes
	 */
	private static void registerRoutes() {
		
		LOGGER.debug("start registering routes");
		
		get(Constants.ROOT, HealthController::health, new JsonTransformer());
		
		post(Constants.PATH_DATA, DataController::collectData, new JsonTransformer());
		
		post(Constants.PATH_ANOMALY, AnomalyController::registerAnomaly, new JsonTransformer());
		
		LOGGER.debug("routes registered");
		
	}
}
