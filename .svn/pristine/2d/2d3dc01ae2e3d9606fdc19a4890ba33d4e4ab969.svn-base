package edu.gx.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="fine")
public class Fine  {

	private Integer fineId;
	private Integer userId;
	private Integer bookId;
	private Integer borrowId;
	private Double forfeit;
	private Integer fineTypeId;
	private boolean payment;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fineID")
	public Integer getFineId() {
		return fineId;
	}
	public void setFineId(Integer fineId) {
		this.fineId = fineId;
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
	}@Column(name="borrowID")
	public Integer getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(Integer borrowId) {
		this.borrowId = borrowId;
	}@Column(name="forfeit")
	public Double getForfeit() {
		return forfeit;
	}
	public void setForfeit(Double forfeit) {
		this.forfeit = forfeit;
	}@Column(name="fineTypeID")
	public Integer getFineTypeId() {
		return fineTypeId;
	}
	public void setFineTypeId(Integer fineTypeId) {
		this.fineTypeId = fineTypeId;
	}
	
	public boolean isPayment() {
		return payment;
	}
	public void setPayment(boolean payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Fine [fineId=" + fineId + ", userId=" + userId + ", bookId="
				+ bookId + ", borrowId=" + borrowId + ", forfeit=" + forfeit
				+ ", fineTypeId=" + fineTypeId + ", payment=" + payment + "]";
	}
   	
}