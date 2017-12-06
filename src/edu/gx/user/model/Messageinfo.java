package edu.gx.user.model;

import java.sql.Timestamp;

public class Messageinfo {
        private Integer EmailID;
        private Integer userID;
        private String remail;
        private String sendmail;
        private String mailtitle;
        private String userName;
        private Timestamp actualtime;
		public Integer getEmailID() {
			return EmailID;
		}
		public void setEmailID(Integer emailID) {
			EmailID = emailID;
		}
		public Integer getUserID() {
			return userID;
		}
		public void setUserID(Integer userID) {
			this.userID = userID;
		}
		public String getRemail() {
			return remail;
		}
		public void setRemail(String remail) {
			this.remail = remail;
		}
		public String getSendmail() {
			return sendmail;
		}
		public void setSendmail(String sendmail) {
			this.sendmail = sendmail;
		}
		public String getMailtitle() {
			return mailtitle;
		}
		public void setMailtitle(String mailtitle) {
			this.mailtitle = mailtitle;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public Timestamp getActualtime() {
			return actualtime;
		}
		public void setActualtime(Timestamp actualtime) {
			this.actualtime = actualtime;
		}
		@Override
		public String toString() {
			return "Messageinfo [EmailID=" + EmailID + ", userID=" + userID
					+ ", remail=" + remail + ", sendmail=" + sendmail
					+ ", mailtitle=" + mailtitle + ", userName=" + userName
					+ ", actualtime=" + actualtime + "]";
		}
	
}
