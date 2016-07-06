package hello.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

@Configuration
@Profile("dev")
@EnableCaching()
public class CacheConfigDev extends CachingConfigurerSupport {
	@Bean
	public CacheManager concurrentMapCacheManager() {
		return new HazelcastCacheManager(hazelcastInstance());
	}
	
	@Bean
    HazelcastInstance hazelcastInstance() {
		Config config = new XmlConfigBuilder().build();
		return Hazelcast.newHazelcastInstance(config);
//		ClientConfig clientConfig = new XmlClientConfigBuilder().build();
//        return HazelcastClient.newHazelcastClient(clientConfig);
    }
	
	@Bean
	public CacheErrorHandler errorHandler(){
		return new CacheErrorHandler() {
			@Override
			public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
				exception.printStackTrace();
			}
			
			@Override
			public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
				exception.printStackTrace();
			}
			
			@Override
			public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
				exception.printStackTrace();
			}
			
			@Override
			public void handleCacheClearError(RuntimeException exception, Cache cache) {
				exception.printStackTrace();
			}
		};
	}
}
