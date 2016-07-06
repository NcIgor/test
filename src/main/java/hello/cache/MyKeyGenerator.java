package hello.cache;

import java.lang.reflect.Method;
import java.util.Objects;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component
public class MyKeyGenerator implements KeyGenerator {

	@Override
	public Object generate(Object target, Method method, Object... params) {
		System.out.println("generate");
		return Objects.hashCode(Math.random());
	}

}
