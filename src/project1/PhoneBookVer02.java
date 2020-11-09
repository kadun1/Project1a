package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String name, phoneNumber, birthday;
		int select;
		
		System.out.println("선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.프로그램 종료");
		select = scanner.nextInt();
		
		if(select==1) {
			while(true) {
				System.out.print("이름:"); name = scanner.nextLine();
				System.out.print("전화번호:"); phoneNumber = scanner.nextLine();
				System.out.print("생년월일:"); birthday = scanner.nextLine();
				
				PhoneInfo pInfo = new PhoneInfo(name, phoneNumber, birthday);
				
				pInfo.showPhoneInfo();
			}
		}
		else if(select==2) {
			System.out.println("프로그램을 종료합니다.");
		}
		
	}

}
