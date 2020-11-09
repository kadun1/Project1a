package project1.ver07;

import java.util.Scanner;

public class PhoneInfo {

	String name;
	String phoneNumber;
	Scanner scanner = new Scanner(System.in);
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo() {
		
		System.out.println("이름: "+this.name);
		System.out.println("전화번호: "+this.phoneNumber);
		
	}

	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		return hc1;
	}

	@Override
	public boolean equals(Object obj) {
		PhoneInfo phoneinfo = (PhoneInfo)obj;
		System.out.println("이미 저장된 데이터입니다.");
		System.out.println("덮어쓸까요? Y(y) or N(n)");
		String select = scanner.nextLine();
		if(this.name.equals(phoneinfo.name)&&select.equalsIgnoreCase("n")) {
			return true;
		}
		else if(select.equalsIgnoreCase("y")){
			return false;
		}
		else {
			System.out.println("잘못 입력했습니다.");
			return true;
		}
		
	}
}
