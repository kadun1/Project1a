package project1.ver01;

public class PhoneInfo {

	String name;
	String phoneNumber;
	String birthday;
	
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo() {
		
		System.out.println("이름:"+this.name);
		System.out.println("전화번호:"+this.phoneNumber);
		if(this.birthday==null) {
			System.out.println("생년월일 : 입력되지않음");
		}
		else {
			System.out.println("생년월일 :"+this.birthday);
		}
	}
	
	
}
