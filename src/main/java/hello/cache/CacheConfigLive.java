package hello.cache;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.google.common.cache.CacheBuilder;

@Configuration
@Profile("live")
@EnableCaching
public class CacheConfigLive {
	private static final Logger log = LoggerFactory.getLogger(CacheConfigLive.class);
	@Bean
	public CacheManager cacheManager(){
		System.out.println("====================================================");
		System.out.println("Cache manager is concurrentMapCacheManager - live");
		
       GuavaCacheManager cacheManager = new GuavaCacheManager("books");
       CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
	       .maximumSize(100)
	       .expireAfterWrite(10, TimeUnit.MINUTES);
	       cacheManager.setCacheBuilder(cacheBuilder);
       return cacheManager;
	}
}
