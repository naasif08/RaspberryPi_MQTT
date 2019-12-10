package rpi.mqtt.pack;

import java.util.Scanner;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Main {

	public static void main(String[] args) throws MqttException {
		
	 Mqtt_Publisher p=new Mqtt_Publisher();
	 p.connect();
	
	 Scanner n =new Scanner(System.in);
	String value=null;
       while(true) {
    	   System.out.println("Enter value:");
    	   value=n.nextLine();
    	   
    		   p.PublishMessage(value);
    	  
    	   
       }


	}

}
