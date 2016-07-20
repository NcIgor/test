package hello.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	void sendMessage(String destination, String message){
		// Send a message
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        };
        System.out.println("Sending a new message. : " + message);
		jmsTemplate.send(destination, messageCreator);
	}
}