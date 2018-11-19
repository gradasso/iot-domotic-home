package it.christianlusardi.estia.requests;



/**
 * Request to collect data from device
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
public class DataRequest {

	private String humidity;

	private String temperature;

	private String heatIndex;

	public DataRequest() {
		super();
	}

	public DataRequest(String humidity, String temperature, String heatIndex) {
		super();
		this.humidity = humidity;
		this.temperature = temperature;
		this.heatIndex = heatIndex;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHeatIndex() {
		return heatIndex;
	}

	public void setHeatIndex(String heatIndex) {
		this.heatIndex = heatIndex;
	}

}
