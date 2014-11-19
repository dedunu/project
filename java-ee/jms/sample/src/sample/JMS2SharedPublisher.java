package sample;

import java.text.DecimalFormat;

import javax.jms.JMSContext;

import com.sun.messaging.ConnectionFactory;
import javax.jms.Topic;

public class JMS2SharedPublisher {
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		try (JMSContext jmsContext = connectionFactory.createContext();) {
			Topic topic =  jmsContext.createTopic("TRADET");
			DecimalFormat decimalFormat = new DecimalFormat("##.00");
			String price = decimalFormat.format(98.0 + Math.random());
			jmsContext.createProducer().send(topic, price);
			System.out.println("Message published");
		}
	}
}
