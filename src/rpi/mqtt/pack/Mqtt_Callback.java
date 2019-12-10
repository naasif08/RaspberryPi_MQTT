package rpi.mqtt.pack;

import java.util.concurrent.Flow.Publisher;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Mqtt_Callback implements MqttCallback {
	 private Mqtt_Publisher publisher=new Mqtt_Publisher();

	public Mqtt_Callback() throws MqttException {
		
		 String user2="naasif08";
		 char pass[]= {'0','f','b','0','4','5','2','5','e','a','1','5','4','7','7','2','8','4','4','8','3','3','d','0','3','c','f','8','a','3','e','0'};
		 char pass2[]= {'v','R','-','k','H','H','A','p','8','v','j','Z'};
		//MqttClient client = new MqttClient("tcp://tailor.cloudmqtt.com:13947","maochifa");
		 MqttClient client = new MqttClient("tcp://io.adafruit.com:1883","naasif08");
	     client.setCallback(this);
	MqttConnectOptions mqOptions=new MqttConnectOptions();
	mqOptions.setUserName("naasif08");
	mqOptions.setPassword(pass);
	     mqOptions.setCleanSession(true);
	     client.connect(mqOptions);      //connecting to broker 
	        client.subscribe("naasif08/feeds/myfeed"); //subscribing to the topic name  test/topic


	}

	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		System.out.println("Connection to MQTT broker lost!"+cause.getMessage());
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Message received:\n\t"+ new String(message.getPayload()) );
		//publisher.connect();
		//publisher.PublishMessage("I have got that message"+ new String(message.getPayload()));
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		try {
			System.out.println("delivery complete: "+token.getMessage());
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}