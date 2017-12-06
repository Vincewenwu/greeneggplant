package edu.gx.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="libraryType")
public class Librarytype  {


	private Integer libraryTypeId;
	private String libraryType;

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO) 
	 @Column(name="libraryTypeID") 
	public Integer getLibraryTypeId() {
		return this.libraryTypeId;
	}

	public void setLibraryTypeId(Integer libraryTypeId) {
		this.libraryTypeId = libraryTypeId;
	}
	 @Column(name="libraryType") 
	public String getLibraryType() {
		return this.libraryType;
	}

	public void setLibraryType(String libraryType) {
		this.libraryType = libraryType;
	}

	@Override
	public String toString() {
		return "Librarytype [libraryTypeId=" + libraryTypeId + ", libraryType="
				+ libraryType + "]";
	}
	

}