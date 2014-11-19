package sample;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;

public class reciever {
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		try(JMSContext jmsContext = connectionFactory.createContext();){
			Queue queue = jmsContext.createQueue("TRADE");
			Message message = jmsContext.createConsumer(queue).receive();
			System.out.println(message.getBody(String.class));
			System.out.println("Trader : " + message.getStringProperty("TradeName"));
		}

	}
}
