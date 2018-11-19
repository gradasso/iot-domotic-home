package it.christianlusardi.estia.requests;



/**
 * Request to register sensor's anomaly from device
 * 
 * @author Christian Lusardi
 * @version 1.0
 *
 */
public class AnomalyRequest {
	
	private String type;
	
	public AnomalyRequest() {
		super();
	}
	
	public AnomalyRequest(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
