package hello.mongo.template;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class TestMongo implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(TestMongo.class);
	
	@Autowired(required=false)
	private MongoOperations template;
//	private MongoOperations template;
	
	@Override
	public void run(String... args) throws Exception {
//	    MongoOperations template = new MongoTemplate(new Mongo(), "database");
		String x = Math.random() + "a";
	    template.insert(new Person(x, 34));
	    template.insert(new Person("Jo2e", 314));
	    template.insert(new Person("Jo23e", 34));
	    template.insert(new Person("Jo4243e", 34));
	    template.insert(new Person("Joe", 342344));
	    template.insert(new Person("Joe", 34));
	    template.insert(new Person("Joe", 34));
	    template.insert(new Person("Joe", 34));

	    Person person = template.findOne(new Query(where("name").is(x)), Person.class);
		log.info(person.toString());

	    template.dropCollection("person");
	}
}