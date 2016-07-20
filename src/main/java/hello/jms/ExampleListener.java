package hello.jms;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQBytesMessage;
import org.springframework.stereotype.Component;

@Component
public class ExampleListener implements MessageListener {

    public void onMessage(Message message) {
    	System.out.println("=========");
    	System.out.println("msg:\t" + message);
    	System.out.println("class: " +message.getClass());
    	if (message instanceof TextMessage) {
    		try {
    			System.out.println(((TextMessage) message).getText());
    		}
    		catch (JMSException ex) {
    			ex.printStackTrace();
    		}
    	} else if (message instanceof ActiveMQBytesMessage) {
    		ActiveMQBytesMessage msg = (ActiveMQBytesMessage)message;
    		try {
    			new String(msg.getContent().getData());
    			
    			System.out.println(
				msg.getBodyLength()
    					);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

}