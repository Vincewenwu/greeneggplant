package edu.gx.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role {


	private Integer roleId;
	private String roleName;
	private Boolean orAdmin;
	private int borrowBooksLength;
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO) 
	 @Column(name="roleID") 
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}	
	@Column(name="roleName") 
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Column(name="orAdmin") 
	public Boolean getOrAdmin() {
		return orAdmin;
	}
	public void setOrAdmin(Boolean orAdmin) {
		this.orAdmin = orAdmin;
	}
	@Column(name="borrowBooksLength") 
	public int getBorrowBooksLength() {
		return borrowBooksLength;
	}
	public void setBorrowBooksLength(int borrowBooksLength) {
		this.borrowBooksLength = borrowBooksLength;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", orAdmin=" + orAdmin + ", borrowBooksLength="
				+ borrowBooksLength + "]";
	}

}