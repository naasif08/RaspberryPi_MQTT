package rpi.mqtt.pack;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Mqtt_Publisher {

	public Mqtt_Publisher() throws MqttException {
	
		 String topic        = "iot_mqtt";
         String content      = "New Message!!";
         int qos             = 1;
         String broker       = "tcp://mqtt.flespi.io:1883";
         String clientId     = "ioWXCk8dVx0aQKog8UarqWh3q6ys6Pkc14XufTx0glYWVd1RVZ99Le3Z8pf24o4U";
       MemoryPersistence persistence = new MemoryPersistence();

       try {
           MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
           MqttConnectOptions connOpts = new MqttConnectOptions();
           connOpts.setCleanSession(true);
           System.out.println("Connecting to broker: "+broker);
           sampleClient.connect(connOpts);
           System.out.println("Connected");
           System.out.println("Publishing message: "+content);
           MqttMessage message = new MqttMessage(content.getBytes());
           message.setQos(qos);
           sampleClient.publish(topic, message);
           System.out.println("Message published");
           
           //System.exit(0);
       } catch(MqttException me) {
           System.out.println("reason "+me.getReasonCode());
           System.out.println("msg "+me.getMessage());
           System.out.println("loc "+me.getLocalizedMessage());
           System.out.println("cause "+me.getCause());
           System.out.println("excep "+me);
           me.printStackTrace();
       }
		


	}

}
