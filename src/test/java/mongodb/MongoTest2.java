package mongodb;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import mongodb.config.MongoConfig2;
import mongodb.model.Order;

public class MongoTest2 {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig2.class);
		MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);
		query(mongoTemplate);
		context.close();
	}

	/**
	 * 增
	 * @param mongoTemplate
	 */
	static void save(MongoTemplate mongoTemplate) {
		Order order = new Order();
		order.setCustomer("yuan");
		order.setType("sanbai");
		mongoTemplate.save(order, "order");
	}

	/**
	 * 改
	 * @param mongoTemplate
	 */
	static void update(MongoTemplate mongoTemplate) {

		mongoTemplate.updateFirst(Query.query(Criteria.where("type").is("sanbai")), Update.update("type", "yuan"),
				Order.class);
	}

	/**
	 * 删
	 * @param mongoTemplate
	 */
	static void delete(MongoTemplate mongoTemplate) {
		mongoTemplate.remove(Query.query(Criteria.where("type").is("sanbai")), Order.class);
	}

	/**
	 * 查
	 * @param mongoTemplate
	 */
	static void query(MongoTemplate mongoTemplate) {
		List<Order> list = mongoTemplate.find(Query.query(Criteria.where("type").is("yuan")), Order.class);
		for (Order order : list) {
			System.out.println(order);
		}
	}

}
