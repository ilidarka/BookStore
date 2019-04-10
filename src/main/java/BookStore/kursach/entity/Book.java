package BookStore.kursach.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String bookName;
	private String author;
	private String category;
	private String genre;
	private float price;
	private float amount;
	private float popularity;
	private String publisher;
	private Date graduate;
	private int onStore;
	private int solded;
	
	public Book() {
		
	}

	public Book(String bookName, String author, String category, String genre, float price, float amount, float popularity, String publisher, Date graduate, int onStore , int solded) {
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.genre = genre;
		this.price = price;
		this.amount = amount;
		this.popularity = popularity;
		this.publisher = publisher;
		this.graduate = graduate;
		this.onStore = onStore;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getGraduate() {
		return graduate;
	}
	public void setGraduate(Date graduate) {
		this.graduate = graduate;
	}
	public float getPopularity() {
		return popularity;
	}
	public void setPopularity(float popularity) {
		this.popularity = popularity;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getOnStore() {
		return onStore;
	}
	public void setOnStore(int onStore) {
		this.onStore = onStore;
	}
	public int getSolded() {
		return solded;
	}
	public void setSolded(int solded) {
		this.solded = solded;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
}
