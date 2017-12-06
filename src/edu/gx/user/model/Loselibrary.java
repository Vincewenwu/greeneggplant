package edu.gx.user.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loselibrary")
public class Loselibrary {
	private Integer libraryLoseId;
	private Integer userId;
	private Integer libraryId;
	private Integer borrowId;
	private Timestamp createTime;
	private Integer loseTypeId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="libraryLoseID")
	public Integer getLibraryLoseId() {
		return libraryLoseId;
	}
	public void setLibraryLoseId(Integer libraryLoseId) {
		this.libraryLoseId = libraryLoseId;
	}@Column(name="userID")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}@Column(name="libraryID")
	public Integer getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}@Column(name="borrowID")
	public Integer getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(Integer borrowId) {
		this.borrowId = borrowId;
	}@Column(name="createTime")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}@Column(name="loseTypeID")
	public Integer getLoseTypeId() {
		return loseTypeId;
	}
	public void setLoseTypeId(Integer loseTypeId) {
		this.loseTypeId = loseTypeId;
	}
	@Override
	public String toString() {
		return "Loselibrary [libraryLoseId=" + libraryLoseId + ", userId="
				+ userId + ", libraryId=" + libraryId + ", borrowId="
				+ borrowId + ", createTime=" + createTime + ", loseTypeId="
				+ loseTypeId + "]";
	}


}