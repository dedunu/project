package sample;

import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;

import com.sun.messaging.ConnectionFactory;

public class AsyncReceiver implements MessageListener {

	public AsyncReceiver() {
		try {
			ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
			JMSContext jmsContext = connectionFactory.createContext();
			Queue queue = jmsContext.createQueue("TRADE");
			jmsContext.createConsumer(queue).setMessageListener(this);
			System.out.println("waiting on messages...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				new AsyncReceiver();
			}
		}.start();
	}

	@Override
	public void onMessage(Message arg0) {
		try {
			if (arg0.isBodyAssignableTo(String.class)) {
				System.out.println("Message received : "
						+ arg0.getBody(String.class));
			} else {
				System.out.println("Invalid message type");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
