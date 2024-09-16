package helloworld.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//khai bao cac truong trong DB
	
	private int id;
	private String username;
	private String email;
	private String password;
	private String fullname;
	private String avatar;
	private int roleid;
	private String phone;
	private Date createdate;
	
	// tao contructor
	public UserModel() {
		super();
	}

	public int getId() {
		return id;
	}
	
	// tao getter setter
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	// overide
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", fullname=" + fullname + ", avatar=" + avatar + ", roleid=" + roleid + ", phone=" + phone
				+ ", createdate=" + createdate + "]";
	}

	
}
