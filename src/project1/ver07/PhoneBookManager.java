package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {

	Scanner scanner = new Scanner(System.in);
	HashSet<PhoneInfo> setphoneInfo;
	int numOfphone;
	
	public PhoneBookManager(int num) {
		setphoneInfo = new HashSet<PhoneInfo>(num);
		numOfphone=0;
	}
	
	public void printMenu() {
		System.out.println("선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
	}
	
	public void dataInput() {
		String name, phoneNumber, major, companyName;
		int grade, choice;
		
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반, 2.동창, 3.회사");
		choice = scanner.nextInt();
		scanner.nextLine(); //엔터키 제거용...
		
		System.out.print("이름:");name = scanner.nextLine();
		System.out.print("전화번호:");phoneNumber = scanner.nextLine();
		
		if(choice==SubMenuItem.BASIC) {
			PhoneInfo info = new PhoneInfo(name, phoneNumber);
			setphoneInfo.add(info);
			//phoneInfo[numOfphone++] = new PhoneInfo(name, phoneNumber);
		}
		else if(choice==SubMenuItem.SCHOOL) {
			System.out.print("전공:");major = scanner.nextLine();
			System.out.println("학년:");grade = scanner.nextInt();
			PhoneSchoolInfo school = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			setphoneInfo.add(school);
		}
		else if(choice==SubMenuItem.COMPANY) {
			System.out.print("회사명:");companyName = scanner.nextLine();
			PhoneCompanyInfo company = new PhoneCompanyInfo(name, phoneNumber, companyName);
			setphoneInfo.add(company);
		}
	}

	public void dataSearch() {
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름:");
		String searchName = scanner.nextLine();

		Iterator<PhoneInfo> itr = setphoneInfo.iterator();
		while(itr.hasNext()) {
			PhoneInfo phoneInfo = itr.next();
			if(searchName.equals(phoneInfo.name)) {
				phoneInfo.showPhoneInfo();
			}
			else {
				System.out.println("검색결과가 없습니다");
			}
		}
	}
	
	public void dataDelete(){
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.print("이름:");
		String deleteName = scanner.nextLine();
		Iterator<PhoneInfo> itr = setphoneInfo.iterator();
		while(itr.hasNext()) {
			if(deleteName.equals(itr.next().name)) {
				itr.remove();
				System.out.println("데이터 삭제가 완료되었습니다.");
			}
		}
	}
	
	public void dataAllShow() {
		for(PhoneInfo pI : setphoneInfo) {
			pI.showPhoneInfo();
		}
	}
}
