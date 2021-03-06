package sample;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.Queue;

public class sender {
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		try (JMSContext jmsContext = connectionFactory.createContext();) {
			Queue queue = jmsContext.createQueue("TRADE");
			jmsContext
			.createProducer()
			.setDeliveryDelay(5000)
			.setProperty("TradeName","Dedunu")
			.setDeliveryMode(DeliveryMode.NON_PERSISTENT)
			.send(queue, "SELL AAPL 1500 SHARES");
			System.out.println("message sent");
		}
	}
}
