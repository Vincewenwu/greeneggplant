package edu.gx.user.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {

	private Integer bookId;
	private String bookOnlyCoding;
	private String bookName;
	private String author;
	private String publishingCompany;
	private Timestamp publishTime;
	private Integer stock;
	private Double price;
	private String picture;
	private String abstruct;
	private Integer libraryTypeId;
	private Integer libraryPagination;
	private Timestamp buildTime;
	private Integer libraryId;
	 
    @Id
 	@GeneratedValue(strategy=GenerationType.AUTO) 
 	@Column(name="bookID")
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}@Column(name="bookOnlyCoding") 
	public String getBookOnlyCoding() {
		return bookOnlyCoding;
	}
	public void setBookOnlyCoding(String bookOnlyCoding) {
		this.bookOnlyCoding = bookOnlyCoding;
	}@Column(name="bookName") 
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}@Column(name="author") 
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}@Column(name="publishingCompany") 
	public String getPublishingCompany() {
		return publishingCompany;
	}
	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}@Column(name="publishTime") 
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}@Column(name="stock") 
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}@Column(name="price") 
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}@Column(name="picture") 
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}@Column(name="abstruct") 
	public String getAbstruct() {
		return abstruct;
	}
	public void setAbstruct(String abstruct) {
		this.abstruct = abstruct;
	}@Column(name="libraryTypeID") 
	public Integer getLibraryTypeId() {
		return libraryTypeId;
	}
	public void setLibraryTypeId(Integer libraryTypeId) {
		this.libraryTypeId = libraryTypeId;
	}@Column(name="libraryPagination") 
	public Integer getLibraryPagination() {
		return libraryPagination;
	}
	public void setLibraryPagination(Integer libraryPagination) {
		this.libraryPagination = libraryPagination;
	}@Column(name="buildTime") 
	public Timestamp getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Timestamp buildTime) {
		this.buildTime = buildTime;
	}@Column(name="libraryID") 
	public Integer getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookOnlyCoding=" + bookOnlyCoding
				+ ", bookName=" + bookName + ", author=" + author
				+ ", publishingCompany=" + publishingCompany + ", publishTime="
				+ publishTime + ", stock=" + stock + ", price=" + price
				+ ", picture=" + picture + ", abstruct=" + abstruct
				+ ", libraryTypeId=" + libraryTypeId + ", libraryPagination="
				+ libraryPagination + ", buildTime=" + buildTime
				+ ", libraryId=" + libraryId + "]";
	}
}