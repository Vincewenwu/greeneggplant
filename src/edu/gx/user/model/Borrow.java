package edu.gx.user.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="borrow")
public class Borrow  {


	private Integer borrowId;
	private Integer userId;
	private Integer bookId;
	private Timestamp borrowDate;
	private Boolean whetherReturn;
	private Timestamp actualReturnTime;
	private Integer renewNumber;
	private Boolean whetherExtended;
	private Boolean borrowingStatus;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="borrowID")
	public Integer getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(Integer borrowId) {
		this.borrowId = borrowId;
	}@Column(name="userID")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}@Column(name="bookID")
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}@Column(name="borrowDate")
	public Timestamp getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Timestamp borrowDate) {
		this.borrowDate = borrowDate;
	}@Column(name="whetherReturn")
	public Boolean getWhetherReturn() {
		return whetherReturn;
	}
	public void setWhetherReturn(Boolean whetherReturn) {
		this.whetherReturn = whetherReturn;
	}@Column(name="actualReturnTime")
	public Timestamp getActualReturnTime() {
		return actualReturnTime;
	}
	public void setActualReturnTime(Timestamp actualReturnTime) {
		this.actualReturnTime = actualReturnTime;
	}@Column(name="renewNumber")
	public Integer getRenewNumber() {
		return renewNumber;
	}
	public void setRenewNumber(Integer renewNumber) {
		this.renewNumber = renewNumber;
	}@Column(name="whetherExtended")
	public Boolean getWhetherExtended() {
		return whetherExtended;
	}
	public void setWhetherExtended(Boolean whetherExtended) {
		this.whetherExtended = whetherExtended;
	}@Column(name="borrowingStatus")
	public Boolean getBorrowingStatus() {
		return borrowingStatus;
	}
	public void setBorrowingStatus(Boolean borrowingStatus) {
		this.borrowingStatus = borrowingStatus;
	}
	@Override
	public String toString() {
		return "Borrow [borrowId=" + borrowId + ", userId=" + userId
				+ ", bookId=" + bookId + ", borrowDate=" + borrowDate
				+ ", whetherReturn=" + whetherReturn + ", actualReturnTime="
				+ actualReturnTime + ", renewNumber=" + renewNumber
				+ ", whetherExtended=" + whetherExtended + ", borrowingStatus="
				+ borrowingStatus + "]";
	}

    
}