package edu.gx.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="library")
public class Library  {

	private Integer libraryId;
	private String libraryName;


	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO) 
	 @Column(name="libraryId") 
	public Integer getLibraryId() {
		return this.libraryId;
	}
	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}
	@Column(name="libraryName") 
	public String getLibraryName() {
		return this.libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", libraryName="
				+ libraryName + "]";
	}
}