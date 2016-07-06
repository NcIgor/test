package hello;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

@SpringBootApplication
@Configuration

@EnableConfigurationProperties
@ComponentScan(basePackages = {
//	"hello.cache", 
	"hello.jms" 
})
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
    @Bean // Strictly speaking this bean is not necessary as boot creates a default
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
    	SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
    	factory.setConnectionFactory(connectionFactory);
    	return factory;
    }

    public static void main(String[] args) throws Exception {
		//FileSystemResourceLoader resourceLoader = new FileSystemResourceLoader();
		SpringApplication app = new SpringApplication(Application.class);
		String profile = System.getProperty("spring.profiles.active");
		if(null == profile){
			app.setAdditionalProfiles("dev");
		}
		ConfigurableApplicationContext context = app.run(args);

//		// Clean out any ActiveMQ data from a previous run
//        FileSystemUtils.deleteRecursively(new File("activemq-data"));

        // Send a message
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("ping!");
            }
        };
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        System.out.println("Sending a new message.");
        jmsTemplate.send("mailbox-destination", messageCreator);
    }
}