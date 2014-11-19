package org.dedunu.java_ee.jms.jms_sender;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by dedunu on 11/18/14.
 */
public class JMSSender {
    public static void main(String args[]) throws Exception {
        Context context = new InitialContext();
        Connection connection = ((ConnectionFactory) context.lookup("ConnectionFactory")).createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("TRADE");
        MessageProducer messageProducer = session.createProducer(queue);

        TextMessage textMessage = session.createTextMessage("TRADE SELL");
        textMessage.setStringProperty("TradeName","Dedunu");
        messageProducer.send(textMessage);
        System.out.println("Message sent");
        connection.close();
    }
}
