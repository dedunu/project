package org.dedunu.jms.chapter01;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSReceiver {
    public static void main(String args[]) throws Exception {
        Connection connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("TRADE");
        MessageConsumer messageConsumer = session.createConsumer(queue);
        TextMessage textMessage = (TextMessage) messageConsumer.receive();
        System.out.println(textMessage.getText());
        connection.close();
    }
}
