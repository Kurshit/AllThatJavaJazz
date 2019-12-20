package com.kurshit.DesignPatterns.Builder;

public class BuilderSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class User {

	private String firstName,lastName;

	private int age, mobile;
	private boolean isGay;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public int getMobile() {
		return mobile;
	}

	public boolean isGay() {
		return isGay;
	}


	private User(UserBuilder builder) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age  = builder.age;
		this.isGay = builder.isGay;
		this.mobile = builder.mobile;
	}

	public static class UserBuilder {

		private String firstName,lastName;

		private int age, mobile;
		private boolean isGay;
		
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public UserBuilder setAge(int age) {
			this.age = age;
			return this;
		}
		
		public UserBuilder setIsGay(boolean isGay) {
			this.isGay = isGay;
			return this;
		}
		
		public UserBuilder setMobile(int mobile) {
			this.mobile = mobile;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
		

	}


}
