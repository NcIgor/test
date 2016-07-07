package hello.jms;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

//@Component
@Configuration
public class ActiveMQConfig {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ConnectionFactory connectionFactory;

	private MessageListenerContainer registerMessageListener(String destinationName, MessageListener listener) {
		log.info("registerMessageListener(" + destinationName + ", " + listener + ")");
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setDestinationName(destinationName);
		container.setMessageListener(listener);
		container.setSessionTransacted(true);
		container.afterPropertiesSet();
		container.start();
		return container;
	}

	@Bean
	public MessageListenerContainer queueMessageListener() {
		return registerMessageListener(JmsConstant.DESTINATION, new ExampleListener());
	}
}
