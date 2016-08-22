package database;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.openjpa.persistence.Persistent;
import org.apache.openjpa.persistence.jdbc.Strategy;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAliasType;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
@Entity
@Table(name = "products")
public class Product  implements Serializable{
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY, generator = "products_SEQ ")
	private long id;
	@Persistent
	private SimpleStringProperty name = new SimpleStringProperty();
	@Persistent
	private SimpleDoubleProperty price = new SimpleDoubleProperty();
	@Persistent
	private SimpleIntegerProperty quantity = new SimpleIntegerProperty();
	
	protected Product(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id=id;
	}

	public double getPrice() {
		return price.get();
	}

	public void setPrice(double price) {
		this.price.set(price);
		
	}

	public int getQuantity() {
		return quantity.get();
	}

	public void setQuantity(int quantity) {
		this.quantity.set(quantity);
		
	}
	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public SimpleStringProperty nameProperty() {
		
		return name;
	}

	public SimpleDoubleProperty priceProperty() {
		return price;
	}

	public SimpleIntegerProperty quantityProperty() {
		return quantity;
	}

	

}
