package org.springframework.bean;

public class User {

	private UserClass userClass;

	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public UserClass getUserClass() {
		return userClass;
	}

	public void setUserClass(UserClass userClass) {
		this.userClass = userClass;
	}
}
