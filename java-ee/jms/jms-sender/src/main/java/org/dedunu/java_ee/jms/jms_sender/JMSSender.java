package org.dedunu.java_ee.jms.jms_sender;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by dedunu on 11/18/14.
 */
public class JMSSender {
    public static void main(String args[]) throws Exception {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("TRADE");
        MessageProducer messageProducer = session.createProducer(queue);

        TextMessage textMessage = session.createTextMessage("TRADE DONE");
        messageProducer.send(textMessage);
        System.out.println("Message sent");
        connection.close();
    }
}
