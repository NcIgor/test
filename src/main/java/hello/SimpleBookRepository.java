package hello;

import javax.cache.annotation.CacheResult;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
//import javax.persistence.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {
	@Override
    @CacheResult(cacheName = "books"/*, keyGenerator="myKeyGenerator"*/)
//    @Cacheable(cacheNames = "books"/*, keyGenerator="myKeyGenerator"*/)
    public Book getByIsbn(String isbn) {
    	System.out.println("get from cache " + isbn);
        simulateSlowService();
        isbn += Math.random();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
    	long time = 2000L;
    	System.out.println("wait " + time + "ms");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}