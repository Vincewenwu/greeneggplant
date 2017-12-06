package edu.gx.user.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="datails")
public class Datails{

	private Integer detailsId;
	private Integer detailsTypeId;
	private String title;
	private String thepicture;
	private String article;
	private String source;
	private String publishcontent;
	private Timestamp expectthereleasedate;
	private Integer createrId;
	private Timestamp creatertime;
	private Integer changedbyId;
	private Boolean changedbystate;
	private Timestamp approvaltime;
	private Integer approvalId;
	private Timestamp changedbytime;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="detailsID")
	public Integer getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}	@Column(name="detailsTypeID")
	public Integer getDetailsTypeId() {
		return detailsTypeId;
	}
	public void setDetailsTypeId(Integer detailsTypeId) {
		this.detailsTypeId = detailsTypeId;
	}	@Column(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	@Column(name="thepicture")
	public String getThepicture() {
		return thepicture;
	}
	public void setThepicture(String thepicture) {
		this.thepicture = thepicture;
	}	@Column(name="article")
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}	@Column(name="source")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}	@Column(name="publishcontent")
	public String getPublishcontent() {
		return publishcontent;
	}
	public void setPublishcontent(String publishcontent) {
		this.publishcontent = publishcontent;
	}	@Column(name="expectthereleasedate")
	public Timestamp getExpectthereleasedate() {
		return expectthereleasedate;
	}
	public void setExpectthereleasedate(Timestamp expectthereleasedate) {
		this.expectthereleasedate = expectthereleasedate;
	}	@Column(name="createrID")
	public Integer getCreaterId() {
		return createrId;
	}
	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}	@Column(name="creatertime")
	public Timestamp getCreatertime() {
		return creatertime;
	}
	public void setCreatertime(Timestamp creatertime) {
		this.creatertime = creatertime;
	}	@Column(name="changedbyID")
	public Integer getChangedbyId() {
		return changedbyId;
	}
	public void setChangedbyId(Integer changedbyId) {
		this.changedbyId = changedbyId;
	}	@Column(name="changedbystate")
	public Boolean getChangedbystate() {
		return changedbystate;
	}
	public void setChangedbystate(Boolean changedbystate) {
		this.changedbystate = changedbystate;
	}	@Column(name="approvaltime")
	public Timestamp getApprovaltime() {
		return approvaltime;
	}
	public void setApprovaltime(Timestamp approvaltime) {
		this.approvaltime = approvaltime;
	}	@Column(name="approvalID")
	public Integer getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(Integer approvalId) {
		this.approvalId = approvalId;
	}	@Column(name="changedbytime")
	public Timestamp getChangedbytime() {
		return changedbytime;
	}
	public void setChangedbytime(Timestamp changedbytime) {
		this.changedbytime = changedbytime;
	}
	@Override
	public String toString() {
		return "Datails [detailsId=" + detailsId + ", detailsTypeId="
				+ detailsTypeId + ", title=" + title + ", thepicture="
				+ thepicture + ", article=" + article + ", source=" + source
				+ ", publishcontent=" + publishcontent
				+ ", expectthereleasedate=" + expectthereleasedate
				+ ", createrId=" + createrId + ", creatertime=" + creatertime
				+ ", changedbyId=" + changedbyId + ", changedbystate="
				+ changedbystate + ", approvaltime=" + approvaltime
				+ ", approvalId=" + approvalId + ", changedbytime="
				+ changedbytime + "]";
	}

	
}