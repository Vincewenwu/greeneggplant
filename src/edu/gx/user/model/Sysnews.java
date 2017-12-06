package edu.gx.user.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sysnews")
public class Sysnews  {


	private Integer systeminformationId;
	private Integer senduserId;
	private Integer sendusertype;
	private Integer resuserId;
	private Integer resusertype;
	private String messagecontent;
	private Timestamp transmissiontime;
	private Boolean whetherornottoread;
	private Timestamp readtime;
	
	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO) 
  	@Column(name="systeminformationID") 
	public Integer getSysteminformationId() {
		return systeminformationId;
	}
	public void setSysteminformationId(Integer systeminformationId) {
		this.systeminformationId = systeminformationId;
	}	@Column(name="senduserID") 
	public Integer getSenduserId() {
		return senduserId;
	}
	public void setSenduserId(Integer senduserId) {
		this.senduserId = senduserId;
	}	@Column(name="sendusertype") 
	public Integer getSendusertype() {
		return sendusertype;
	}
	public void setSendusertype(Integer sendusertype) {
		this.sendusertype = sendusertype;
	}	@Column(name="resuserID") 
	public Integer getResuserId() {
		return resuserId;
	}
	public void setResuserId(Integer resuserId) {
		this.resuserId = resuserId;
	}	@Column(name="resusertype") 
	public Integer getResusertype() {
		return resusertype;
	}
	public void setResusertype(Integer resusertype) {
		this.resusertype = resusertype;
	}	@Column(name="messagecontent") 
	public String getMessagecontent() {
		return messagecontent;
	}
	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}	@Column(name="transmissiontime") 
	public Timestamp getTransmissiontime() {
		return transmissiontime;
	}
	public void setTransmissiontime(Timestamp transmissiontime) {
		this.transmissiontime = transmissiontime;
	}	@Column(name="Whetherornottoread") 
	public Boolean getWhetherornottoread() {
		return whetherornottoread;
	}
	public void setWhetherornottoread(Boolean whetherornottoread) {
		this.whetherornottoread = whetherornottoread;
	}	@Column(name="readtime") 
	public Timestamp getReadtime() {
		return readtime;
	}
	public void setReadtime(Timestamp readtime) {
		this.readtime = readtime;
	}
	@Override
	public String toString() {
		return "Sysnews [systeminformationId=" + systeminformationId
				+ ", senduserId=" + senduserId + ", sendusertype="
				+ sendusertype + ", resuserId=" + resuserId + ", resusertype="
				+ resusertype + ", messagecontent=" + messagecontent
				+ ", transmissiontime=" + transmissiontime
				+ ", whetherornottoread=" + whetherornottoread + ", readtime="
				+ readtime + "]";
	}

	
}