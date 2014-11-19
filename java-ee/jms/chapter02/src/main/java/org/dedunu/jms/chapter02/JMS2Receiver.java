package org.dedunu.jms.chapter02;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

public class JMS2Receiver {
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		try(JMSContext jmsContext = connectionFactory.createContext();){
			Queue queue = jmsContext.createQueue("TRADE");
			String body = jmsContext.createConsumer(queue).receiveBody(String.class);
			System.out.println(body);
		}

	}
}
