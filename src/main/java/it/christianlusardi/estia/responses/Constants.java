package it.christianlusardi.estia.responses;


/**
 * Centralized constants
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
public class Constants {
	
	
	/**
	 * Root path
	 */
	public static final String ROOT = "/";
	
	
	
	/**
	 * Data path
	 */
	public static final String PATH_DATA = "/data";

	
	
	/**
	 * Anomaly path
	 */
	public static final String PATH_ANOMALY = "/anomaly";
	
	
	
	/**
	 * Contentent type JSON
	 */
	public static final String CONTENT_TYPE_JSON = "application/json";
	
	
	
	/**
	 * Header key for Authorization
	 */
	public static final String HEADER_AUTH_TOKEN = "Authorization";
	
	
	
	/**
	 * Header key for Device UUID
	 */
	public static final String HEADER_DEVICE_UUID = "Device";
	
	
	
	/**
	 * The standardized message for private constructor exception
	 */
	public static final String STANDARD_UTILITY_MESSAGE = "Utility class";
	
	
	
	/**
	 * Default server port
	 */
	public static final int DEFAULT_PORT = 8080;
	
	
	
	/**
	 * Constructor
	 */
	private Constants() {
		throw new IllegalAccessError(STANDARD_UTILITY_MESSAGE);
	}

}
