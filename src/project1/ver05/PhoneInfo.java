package project1.ver05;

public class PhoneInfo {

	String name;
	String phoneNumber;
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo() {
		
		System.out.println("이름: "+this.name);
		System.out.println("전화번호: "+this.phoneNumber);
		
	}
}
