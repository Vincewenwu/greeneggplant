package edu.gx.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



public class Librarytypeinfo  {


	private Integer libraryTypeID;
	private String libraryType;
	public Integer getLibraryTypeID() {
		return libraryTypeID;
	}
	public void setLibraryTypeID(Integer libraryTypeID) {
		this.libraryTypeID = libraryTypeID;
	}
	public String getLibraryType() {
		return libraryType;
	}
	public void setLibraryType(String libraryType) {
		this.libraryType = libraryType;
	}
	@Override
	public String toString() {
		return "Librarytypeinfo [libraryTypeID=" + libraryTypeID
				+ ", libraryType=" + libraryType + "]";
	}
	

}