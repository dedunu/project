package sample;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;

import com.sun.messaging.ConnectionFactory;

import javax.jms.Queue;

import com.sun.messaging.jmq.jmsclient.ConnectException;

public class ReceiverAsyncCount implements MessageListener {

	JMSContext jmsContext = null;

	public ReceiverAsyncCount() {
		try {
			ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
			jmsContext = connectionFactory.createContext(Session.SESSION_TRANSACTED);
			Queue queue = jmsContext.createQueue("TRADE");
			JMSConsumer jmsConsumer = jmsContext.createConsumer(queue);
			jmsConsumer.setMessageListener(this);
			System.out.println("waiting on messages");
		} catch (Exception e ) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMessage(Message arg0) {
		try {
			System.out.println("Recieved: " + arg0.getBody(String.class));
			
			Thread.sleep(500);
			jmsContext.commit();
			System.out.println("Error processing retries - " + arg0.getIntProperty("JMSXDeliveryCount"));
		} catch (Exception e){
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		new Thread() {
			public void run(){
				new ReceiverAsyncCount();
			}
		}.start();
	}

}
