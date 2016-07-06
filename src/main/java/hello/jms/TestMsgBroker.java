package hello.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestMsgBroker implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(TestMsgBroker.class);
	
	@Autowired
	private Sender sender;

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			String string = "message " + i;
			send(string);
		}
	}

	private void send(String string) {
		sender.sendMessage(string);
	}
}