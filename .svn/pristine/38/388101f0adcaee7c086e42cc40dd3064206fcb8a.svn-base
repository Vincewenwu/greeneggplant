package edu.gx.user.model;
import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
         private Integer userID;
         private String userName;
         private String password;
         private String sex;
         private String libraryCard;
         private String mail;
         private String phone;
         private boolean borrow;
         private int borrowingAmount;
         private int roleID;
         
        @Id
     	@GeneratedValue(strategy=GenerationType.AUTO) 
     	@Column(name="userID") 
		public Integer getUserID() {
			return userID;
		}
		public void setUserID(Integer userID) {
			this.userID = userID;
		}
		@Column(name="userName")
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		@Column(name="password")
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Column(name="sex")
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		@Column(name="libraryCard")
		public String getLibraryCard() {
			return libraryCard;
		}
		public void setLibraryCard(String libraryCard) {
			this.libraryCard = libraryCard;
		}
		@Column(name="mail")
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		@Column(name="phone")
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		@Column(name="borrow")
		public boolean isBorrow() {
			return borrow;
		}
		public void setBorrow(boolean borrow) {
			this.borrow = borrow;
		}
		@Column(name="borrowingAmount")
		public int getBorrowingAmount() {
			return borrowingAmount;
		}
		public void setBorrowingAmount(int borrowingAmount) {
			this.borrowingAmount = borrowingAmount;
		}
		@Column(name="roleID")
		public int getRoleID() {
			return roleID;
		}
		public void setRoleID(int roleID) {
			this.roleID = roleID;
		}
		@Override
		public String toString() {
			return "User [userID=" + userID + ", userName=" + userName
					+ ", password=" + password + ", sex=" + sex
					+ ", libraryCard=" + libraryCard + ", mail=" + mail
					+ ", phone=" + phone + ", borrow=" + borrow
					+ ", borrowingAmount=" + borrowingAmount + ", roleID="
					+ roleID + "]";
		}
		
}
