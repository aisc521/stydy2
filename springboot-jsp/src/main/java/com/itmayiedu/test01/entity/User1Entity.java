
package com.itmayiedu.test01.entity;

public class User1Entity {

	private Integer id;
	private String userName;
	private String passWord;

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {

		this.id = id;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

	public String getPassWord() {

		return passWord;
	}

	public void setPassWord(String passWord) {

		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "User1Entity [id=" + id + ", userName=" + userName + ", passWord=" + passWord + "]";
	}

}
