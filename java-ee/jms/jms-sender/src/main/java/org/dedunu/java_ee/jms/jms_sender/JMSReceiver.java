package org.dedunu.java_ee.jms.jms_sender;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by dedunu on 11/18/14.
 */
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
