package org.dedunu.jms.chapter01;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

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

