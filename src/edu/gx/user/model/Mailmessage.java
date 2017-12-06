package edu.gx.user.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="mailmessage")
public class Mailmessage  {

	private Integer emailId;
	private Integer userId;
	private String remail;
	private String sendmail;
	private String mailtitle;
	private String contextType;
	private String filename;
	private String filename1;
	private Timestamp creationtime;
	private Timestamp expecttosendtime;
	private Integer numberofretries;
	private Timestamp actualtime;
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO) 
	 @Column(name="EmailID")
	public Integer getEmailId() {
		return emailId;
	}
	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}@Column(name="userID")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}@Column(name="remail")
	public String getRemail() {
		return remail;
	}
	public void setRemail(String remail) {
		this.remail = remail;
	}@Column(name="sendmail")
	public String getSendmail() {
		return sendmail;
	}
	public void setSendmail(String sendmail) {
		this.sendmail = sendmail;
	}@Column(name="mailtitle")
	public String getMailtitle() {
		return mailtitle;
	}
	public void setMailtitle(String mailtitle) {
		this.mailtitle = mailtitle;
	}@Column(name="ContextType")
	public String getContextType() {
		return contextType;
	}
	public void setContextType(String contextType) {
		this.contextType = contextType;
	}@Column(name="filename")
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}@Column(name="filename1")
	public String getFilename1() {
		return filename1;
	}
	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}@Column(name="creationtime")
	public Timestamp getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(Timestamp creationtime) {
		this.creationtime = creationtime;
	}@Column(name="Expecttosendtime")
	public Timestamp getExpecttosendtime() {
		return expecttosendtime;
	}
	public void setExpecttosendtime(Timestamp expecttosendtime) {
		this.expecttosendtime = expecttosendtime;
	}@Column(name="numberofretries")
	public Integer getNumberofretries() {
		return numberofretries;
	}
	public void setNumberofretries(Integer numberofretries) {
		this.numberofretries = numberofretries;
	}@Column(name="actualtime")
	public Timestamp getActualtime() {
		return actualtime;
	}
	public void setActualtime(Timestamp actualtime) {
		this.actualtime = actualtime;
	}
	@Override
	public String toString() {
		return "Mailmessage [emailId=" + emailId + ", userId=" + userId
				+ ", remail=" + remail + ", sendmail=" + sendmail
				+ ", mailtitle=" + mailtitle + ", contextType=" + contextType
				+ ", filename=" + filename + ", filename1=" + filename1
				+ ", creationtime=" + creationtime + ", expecttosendtime="
				+ expecttosendtime + ", numberofretries=" + numberofretries
				+ ", actualtime=" + actualtime + "]";
	}



}