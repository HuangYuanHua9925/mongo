package mongodb.model;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Order {
	@Id
	private String id;

	@Field("client")
	private String customer;

	private String type;

	private Collection<Item> items = new LinkedHashSet<Item>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", type=" + type + ", items=" + items + "]";
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}

}
