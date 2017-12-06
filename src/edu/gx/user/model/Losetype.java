package edu.gx.user.model;

/**
 * Losetype entity. @author MyEclipse Persistence Tools
 */

public class Losetype implements java.io.Serializable {

	// Fields

	private Integer loseTypeId;
	private String loseName;

	// Constructors

	/** default constructor */
	public Losetype() {
	}

	/** full constructor */
	public Losetype(String loseName) {
		this.loseName = loseName;
	}

	// Property accessors

	public Integer getLoseTypeId() {
		return this.loseTypeId;
	}

	public void setLoseTypeId(Integer loseTypeId) {
		this.loseTypeId = loseTypeId;
	}

	public String getLoseName() {
		return this.loseName;
	}

	public void setLoseName(String loseName) {
		this.loseName = loseName;
	}

}