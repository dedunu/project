package sample;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;

import com.sun.messaging.ConnectionFactory;

public class JMS2SharedSubscriber implements MessageListener{

	public JMS2SharedSubscriber() {
		try{
			ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
			JMSContext jmsContext = connectionFactory.createContext();
			Topic topic = jmsContext.createTopic("TRADET");
			JMSConsumer jmsConsumer = jmsContext.createSharedConsumer(topic,"sub:3e");
			
			jmsConsumer.setMessageListener(this);
			System.out.println("Waiting for messages");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void onMessage(Message arg0) {
		try {
			System.out.println(arg0.getBody(String.class));
		} catch(Exception e ){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				new JMS2SharedSubscriber();
			}
		}.start();
	}

}
