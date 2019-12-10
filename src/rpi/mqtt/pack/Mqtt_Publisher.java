package rpi.mqtt.pack;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Mqtt_Publisher {
	private static MqttMessage message;
	private MqttClient sampleClient;
	private MqttConnectOptions connOpts = new MqttConnectOptions();
	private char pass[]= {'7','K','8','w','v','T','t','U','4','y','7','f'};
	private String topic        = "iot_mqtt";
    private String content      = "Hello this is from my computer!";
    private int qos             = 1;
    private String broker       = "tcp://tailor.cloudmqtt.com:13947";
    private String clientId     = "maochifa";
    private MemoryPersistence persistence = new MemoryPersistence();
	
	

	public Mqtt_Publisher() throws MqttException {

	     

       try {
    	   sampleClient= new MqttClient(broker, clientId, persistence);
           
           connOpts.setUserName("maochifa");
           connOpts.setPassword(pass);
           connOpts.setCleanSession(true);
           
           
           
           
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


    public void connect() {
    	System.out.println("Connecting to broker: "+broker);
        try {
			sampleClient.connect(connOpts);
			System.out.println("Connected");
		} catch (MqttSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
public void PublishMessage(String msg) throws MqttPersistenceException, MqttException {
		
		System.out.println("Publishing message: "+msg);
        message= new MqttMessage(msg.getBytes());
        message.setQos(qos);
        sampleClient.publish(topic, message);
        System.out.println("Message published");
	}

}
