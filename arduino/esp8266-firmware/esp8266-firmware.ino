/**
 * Software for reading temperature and humidity and send to POST request
 * using the DHT22 and ESP8266
 *
 * Copyright (c) 2018 Christian Lusardi. All rights reserved.
 * https://www.christianlusardi.net
 */

#include "DHT.h"
#include <ESP8266HTTPClient.h>
#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>
#include <WiFiClient.h>

#define DHTPIN 5     // what digital pin the DHT22 is conected to
#define DHTTYPE DHT22   // there are multiple kinds of DHT sensors

#define WIFI_SSD "ECHELON" 
#define WIFI_PWD "Chr15t1@n@91?"

#define DEVICE_UUID "3ea0aa05-f78c-4e17-8448-8da4f66efc9a"
#define AUTH_TOKEN "6CFBDFC76B6F5B2FD67C783C9158A"

#define PROTOCOL "http"
#define HOST "192.168.1.9"
#define PORT "8080"
#define SERVICE_DATA "/data"
#define SERVICE_ANOMALY "/anomaly"


DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(115200);
  Serial.setTimeout(2000);

  WiFi.begin(WIFI_SSD, WIFI_PWD);   //WiFi connection


  // Wait for serial to initialize.
  while(!Serial) {
    delay(500);
    Serial.println("Waiting for serial initialization");
  }
  
  while (WiFi.status() != WL_CONNECTED) {
    //Wait for the WiFI connection completion
 
    delay(500);
    Serial.println("Waiting for connection");
 
  }

  

  Serial.println("Device Started");
  Serial.println("-------------------------------------");
  Serial.println("Running DHT!");
  Serial.println("-------------------------------------");

}

int timeSinceLastRead = 0;
void loop() {

   HTTPClient http;    //Declare object of class HTTPClient

    String url = String(PROTOCOL) + "://" + String(HOST) + ":" + String(PORT) + "/" ;
    
    
    

  // Report every 2 seconds.
  if(WiFi.status()== WL_CONNECTED && timeSinceLastRead > 5000) {
    
    // Reading temperature or humidity takes about 250 milliseconds!
    // Sensor readings may also be up to 2 seconds 'old' (its a very slow sensor)
    float h = dht.readHumidity();
    
    // Read temperature as Celsius (the default)
    float t = dht.readTemperature();
    

    // Check if any reads failed and exit early (to try again).
    if (isnan(h) || isnan(t)) {
      Serial.println("Failed to read from DHT sensor!");
      timeSinceLastRead = 0;

      http.begin(url + String(SERVICE_ANOMALY));      //Specify request destination
      http.addHeader("Content-Type", "application/json");  //Specify content-type header
    http.addHeader("Authorization", AUTH_TOKEN); //Specify authorization token header
    http.addHeader("Device", DEVICE_UUID);   //Specify sensor uuid header
    
      http.POST("{\"type\":\"DHT-22\"}");   //Send the request
      
      return;
    }
    
    // Compute heat index in Celsius (isFahreheit = false)
    float hic = dht.computeHeatIndex(t, h, false);

    Serial.print("Humidity: ");
    Serial.print(h);
    Serial.print(" %\t");
    Serial.print("Temperature: ");
    Serial.print(t);
    Serial.print(" *C ");
    Serial.print("Heat index: ");
    Serial.print(hic);
    Serial.print(" *C ");


    http.begin(url + String(SERVICE_DATA));      //Specify request destination
http.addHeader("Content-Type", "application/json");  //Specify content-type header
    http.addHeader("Authorization", AUTH_TOKEN); //Specify authorization token header
    http.addHeader("Device", DEVICE_UUID);   //Specify sensor uuid header
    
    String message = "{\"humitidy\":\""+String(h)+"\", \"temperature\":\""+String(t)+"\", \"heatIndex\":\""+String(hic)+"\"}";

    Serial.println("");
    Serial.println("[POST] - "+url);
    Serial.println("Request body: "+message);
    
    int httpCode = http.POST(message);   //Send the request
    String responsePayload = http.getString();   //Get the response payload

    Serial.println("");
    Serial.println("Status code: "+httpCode);   //Print HTTP return code
    Serial.println("Response body: "+responsePayload);    //Print request response payload
 
    http.end();  //Close connection

    timeSinceLastRead = 0;
  }
  
  delay(100);
  timeSinceLastRead += 100;
}
