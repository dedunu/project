package org.dedunu.jms.chapter02;

import javax.jms.*;
import javax.jms.JMSContext;
import javax.jms.Queue;

public class JMS2Sender {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		try (JMSContext jmsContext = connectionFactory.createContext();) {
			Queue queue = jmsContext.createQueue("TRADE");
			jmsContext.createProducer().send(queue, "SELL AAPL 1500 SHARES");
			System.out.println("message sent");
		}
	}

}
