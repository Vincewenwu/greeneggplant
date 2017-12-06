package edu.gx.user.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Snewsinfo  {


	private Integer systeminformationID;
	private Integer senduserID;
	private Integer sendusertype;
	private Integer resuserID;
	private Integer resusertype;
	private String messagecontent;
	private Timestamp transmissiontime;
	private Boolean whetherornottoread;
	private Timestamp readtime;
	
	private String userName;
	private String roleName;
	public Integer getSysteminformationID() {
		return systeminformationID;
	}
	public void setSysteminformationID(Integer systeminformationID) {
		this.systeminformationID = systeminformationID;
	}
	public Integer getSenduserID() {
		return senduserID;
	}
	public void setSenduserID(Integer senduserID) {
		this.senduserID = senduserID;
	}
	public Integer getSendusertype() {
		return sendusertype;
	}
	public void setSendusertype(Integer sendusertype) {
		this.sendusertype = sendusertype;
	}
	public Integer getResuserID() {
		return resuserID;
	}
	public void setResuserID(Integer resuserID) {
		this.resuserID = resuserID;
	}
	public Integer getResusertype() {
		return resusertype;
	}
	public void setResusertype(Integer resusertype) {
		this.resusertype = resusertype;
	}
	public String getMessagecontent() {
		return messagecontent;
	}
	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}
	public Timestamp getTransmissiontime() {
		return transmissiontime;
	}
	public void setTransmissiontime(Timestamp transmissiontime) {
		this.transmissiontime = transmissiontime;
	}
	public Boolean getWhetherornottoread() {
		return whetherornottoread;
	}
	public void setWhetherornottoread(Boolean whetherornottoread) {
		this.whetherornottoread = whetherornottoread;
	}
	public Timestamp getReadtime() {
		return readtime;
	}
	public void setReadtime(Timestamp readtime) {
		this.readtime = readtime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Snewsinfo [systeminformationID=" + systeminformationID
				+ ", senduserID=" + senduserID + ", sendusertype="
				+ sendusertype + ", resuserID=" + resuserID + ", resusertype="
				+ resusertype + ", messagecontent=" + messagecontent
				+ ", transmissiontime=" + transmissiontime
				+ ", whetherornottoread=" + whetherornottoread + ", readtime="
				+ readtime + ", userName=" + userName + ", roleName="
				+ roleName + "]";
	}
	
	
}