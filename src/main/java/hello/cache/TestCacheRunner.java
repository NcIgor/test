package hello.cache;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hello.BookRepository;

@Component
public class TestCacheRunner implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(TestCacheRunner.class);
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		log.info(".... Fetching books");
		log.info(test());
		log.info(test());
		log.info(test());
		log.info(test());

		waitIn();
		log.info(test());
		waitIn();
		log.info(test());
		waitIn();
		log.info(test());
		waitIn();
		log.info(test());
		waitIn();
	}

	private String test() {
		System.out.println(new Date());
		for (int i = 0; i < 10; i++) {
			bookRepository.getByIsbn("isbn-1234" + i);
		}
		return "isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234");
	}

	public static void waitIn() throws IOException {
		/*
		 * System.out.println("================================"); byte[] b =
		 * new byte[1000]; System.in.read(b, 0, 1000);
		 */
	}
}