package mongodb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import mongodb.config.MongoConfig;

public class MongoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
		MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);
		DBCollection collection = mongoTemplate.getCollection("col");
		DBCursor find = collection.find();
		while (find.hasNext()) {
			DBObject next = find.next();
			System.out.println(next.toString());
		}
		context.close();
	}
}
