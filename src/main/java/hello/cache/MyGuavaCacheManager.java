package hello.cache;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.guava.GuavaCacheManager;

public class MyGuavaCacheManager extends GuavaCacheManager{
	public MyGuavaCacheManager() {
		super();
	}
	
	public MyGuavaCacheManager(String... cacheNames) {
		super(cacheNames);
	}

	/**
	 * Return the cache associated with the given name.
	 * @param name the cache identifier (must not be {@code null})
	 * @return the associated cache, or {@code null} if none found
	 */
	public Cache getCache(String name){
		System.out.println("getCache :: " + name);
		return super.getCache(name);
	};

	/**
	 * Return a collection of the cache names known by this manager.
	 * @return the names of all caches known by the cache manager
	 */
	public Collection<String> getCacheNames(){
		System.out.println("getCacheNames :: ");
		return super.getCacheNames();
	}
}
