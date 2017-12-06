package edu.gx.user.model;

import javax.persistence.*;
@Entity
@Table(name="overrecord")
public class Overrecord  {

	private Integer overDueId;
	private Integer userId;
	private Integer bookId;
	private Integer overDueNumber;
	private Integer borrowId;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="overDueID")
	public Integer getOverDueId() {
		return overDueId;
	}
	public void setOverDueId(Integer overDueId) {
		this.overDueId = overDueId;
	}
	@Column(name="userID")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name="bookID")
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}@Column(name="overDueNumber")
	public Integer getOverDueNumber() {
		return overDueNumber;
	}
	public void setOverDueNumber(Integer overDueNumber) {
		this.overDueNumber = overDueNumber;
	}@Column(name="borrowID")
	public Integer getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(Integer borrowId) {
		this.borrowId = borrowId;
	}
	@Override
	public String toString() {
		return "Overrecord [overDueId=" + overDueId + ", userId=" + userId
				+ ", bookId=" + bookId + ", overDueNumber=" + overDueNumber
				+ ", borrowId=" + borrowId + "]";
	}



}