package edu.gx.user.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Borrowinfo  {


	private Integer borrowID;
	private Integer userID;
	private Integer bookID;
	private Timestamp borrowDate;
	private Boolean whetherReturn;
	private Timestamp actualReturnTime;
	private Integer renewNumber;
	private Boolean whetherExtended;
	private Boolean borrowingStatus;
	
	private String userName;
	private String libraryCard;
	private boolean borrow;
	private String bookName;
	private int borrowingAmount;
	private BigDecimal price; 
	private int  roleID;
	private String mail;
	public Integer getBorrowID() {
		return borrowID;
	}
	public void setBorrowID(Integer borrowID) {
		this.borrowID = borrowID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getBookID() {
		return bookID;
	}
	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}
	public Timestamp getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Timestamp borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Boolean getWhetherReturn() {
		return whetherReturn;
	}
	public void setWhetherReturn(Boolean whetherReturn) {
		this.whetherReturn = whetherReturn;
	}
	public Timestamp getActualReturnTime() {
		return actualReturnTime;
	}
	public void setActualReturnTime(Timestamp actualReturnTime) {
		this.actualReturnTime = actualReturnTime;
	}
	public Integer getRenewNumber() {
		return renewNumber;
	}
	public void setRenewNumber(Integer renewNumber) {
		this.renewNumber = renewNumber;
	}
	public Boolean getWhetherExtended() {
		return whetherExtended;
	}
	public void setWhetherExtended(Boolean whetherExtended) {
		this.whetherExtended = whetherExtended;
	}
	public Boolean getBorrowingStatus() {
		return borrowingStatus;
	}
	public void setBorrowingStatus(Boolean borrowingStatus) {
		this.borrowingStatus = borrowingStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLibraryCard() {
		return libraryCard;
	}
	public void setLibraryCard(String libraryCard) {
		this.libraryCard = libraryCard;
	}
	public boolean isBorrow() {
		return borrow;
	}
	public void setBorrow(boolean borrow) {
		this.borrow = borrow;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBorrowingAmount() {
		return borrowingAmount;
	}
	public void setBorrowingAmount(int borrowingAmount) {
		this.borrowingAmount = borrowingAmount;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Borrowinfo [borrowID=" + borrowID + ", userID=" + userID
				+ ", bookID=" + bookID + ", borrowDate=" + borrowDate
				+ ", whetherReturn=" + whetherReturn + ", actualReturnTime="
				+ actualReturnTime + ", renewNumber=" + renewNumber
				+ ", whetherExtended=" + whetherExtended + ", borrowingStatus="
				+ borrowingStatus + ", userName=" + userName + ", libraryCard="
				+ libraryCard + ", borrow=" + borrow + ", bookName=" + bookName
				+ ", borrowingAmount=" + borrowingAmount + ", price=" + price
				+ ", roleID=" + roleID + ", mail=" + mail + "]";
	}
	
}