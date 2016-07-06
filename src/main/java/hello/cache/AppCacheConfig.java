package hello.cache;
/*package hello;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

import org.springframework.cache.guava.GuavaCacheManager;

@Configuration
@EnableCaching
public class AppCacheConfig {
	@Bean
	public CacheManager cacheManager(){
       GuavaCacheManager cacheManager = new GuavaCacheManager("books");
       CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
	       .maximumSize(100)
	       .expireAfterWrite(10, TimeUnit.MINUTES);
	       cacheManager.setCacheBuilder(cacheBuilder);
       return cacheManager;
	}
}
*/