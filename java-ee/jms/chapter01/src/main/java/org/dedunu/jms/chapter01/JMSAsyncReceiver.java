package org.dedunu.jms.chapter01;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSAsyncReceiver implements MessageListener {

    public JMSAsyncReceiver() {
        try {
            Connection connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("TRADE");
            MessageConsumer messageConsumer = session.createConsumer(queue);
            messageConsumer.setMessageListener(this);
            System.out.println("Waiting for messages");
        } catch (Exception up) {
            up.printStackTrace();
        }
    }

    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Trader Name : " + textMessage.getStringProperty("TradeName"));
            System.out.println(textMessage.getText());
        } catch (Exception up) {
            up.printStackTrace();
        }
    }

    public static void main(String args[]) throws Exception {
        new Thread() {
            public void run(){
                new JMSAsyncReceiver();
            }
        }.start();
    }
}
