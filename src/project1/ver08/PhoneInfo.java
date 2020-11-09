package project1.ver08;

import java.io.Serializable;
import java.util.Scanner;

public class PhoneInfo implements Serializable{

	transient Scanner scanner = new Scanner(System.in);
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

	public String getInfo() {
		return String.format("이름 : %s\n전화번호 : %s", name, phoneNumber);
	}
	@Override
	public int hashCode() {
		
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		PhoneInfo phoneinfo = (PhoneInfo)obj;
		if(this.name.equals(phoneinfo.name)) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
