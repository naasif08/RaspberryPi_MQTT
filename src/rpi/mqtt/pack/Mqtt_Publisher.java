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
	private char pass[]= {'0','f','b','0','4','5','2','5','e','a','1','5','4','7','7','2','8','4','4','8','3','3','d','0','3','c','f','8','a','3','e','0'};
	private char pass2[]= {'v','R','-','k','H','H','A','p','8','v','j','Z'};
	private String user2="naasif08";
	private String topic        = "naasif08/feeds/myfeed";
    private String content      = "Hello this is from my computer!";
    private int qos             = 1;
    private String broker       = "tcp://io.adafruit.com:1883";
    private String broker2       = "tcp://farmer.cloudmqtt.com:11367";
    private String clientId     = "naasif08";
    private MemoryPersistence persistence = new MemoryPersistence();
	
	

	public Mqtt_Publisher() throws MqttException {

	     

       try {
    	   sampleClient= new MqttClient(broker, clientId, persistence);
           
           //connOpts.setUserName("maochifa");
    	   connOpts.setUserName("naasif08");
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