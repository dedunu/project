package sample;

import java.util.concurrent.CountDownLatch;

import javax.jms.CompletionListener;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Queue;

import com.sun.messaging.ConnectionFactory;

public class JMS2SenderAsync {

	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		try (JMSContext jmsContext = connectionFactory.createContext();) {
			Queue queue = jmsContext.createQueue("TRADE");
			
			CountDownLatch countDownLatch = new CountDownLatch(1);
			MyCompletionListener cl = new MyCompletionListener(countDownLatch);
			
			jmsContext.createProducer().setAsync(cl).send(queue, "Test Message");
			System.out.println("message sent");

			for (int i = 0; i < 5; i++) {
				System.out.println("Processing");
				Thread.sleep(1000);
			}
			
			countDownLatch.await();
			
			System.out.println("End processing");
		}

	}
	
	
}

class MyCompletionListener implements CompletionListener {
	public	CountDownLatch latch = null;
	
	public MyCompletionListener(CountDownLatch latch){
		this.latch = latch;
	}
	
	@Override
	public void onCompletion (Message message){
		latch.countDown();
		System.out.println("Message acked by server");
	}

	@Override
	public void onException(Message arg0, Exception arg1) {
		latch.countDown();
		System.out.println("unable to send message : " + arg1.getMessage());
		
	}
}