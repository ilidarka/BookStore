package BookStore.kursach.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int orderNumber;
	private String bookToOrder;
	private String customerName;
	private String customerSurname;
	private String customerAdres;
	private String customerPhone;
	
	public Order() {
		
	}
	
	public Order(int orderNumber, String bookToOrder, String customerName, String customerSurname, String customerAdres, String customerPhone) {
		this.orderNumber = orderNumber;
		this.bookToOrder = bookToOrder;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.customerAdres = customerAdres;
		this.customerPhone = customerPhone;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getBookToOrder() {
		return bookToOrder;
	}
	public void setBookToOrder(String bookToOrder) {
		this.bookToOrder = bookToOrder;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerSurname() {
		return customerSurname;
	}
	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}
	public String getCustomerAdres() {
		return customerAdres;
	}
	public void setCustomerAdres(String customerAdres) {
		this.customerAdres = customerAdres;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
}
