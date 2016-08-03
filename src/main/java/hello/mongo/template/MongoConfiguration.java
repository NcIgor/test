package hello.mongo.template;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
//@Profile("m")
//@EnableMongoRepositories
@ConfigurationProperties(prefix = "mongo")
public class MongoConfiguration extends AbstractMongoConfiguration {
	/*
	public @Bean MongoClient mongoClient() throws UnknownHostException{
		return new MongoClient("localhost");
	}
	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
//		UserCredentials userCredentials = new UserCredentials("joe", "secret");
		return new SimpleMongoDbFactory(mongoClient(), getDbName());
	}

	public @Bean MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}*/

//	@Override
	protected String getDatabaseName() {
		return "javadb";
	}

//	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost");
//		return mongoClient();
	}
}