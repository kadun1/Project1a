package project1.ver09;

import java.util.Scanner;

public class PhoneBookManager {

	public static IConnectImpl jdbc = new IConnectImpl();
	Scanner scanner = new Scanner(System.in);
	public PhoneInfo[] phoneInfo;
	int numOfphone;
	
	public PhoneBookManager(int num) {
		phoneInfo = new PhoneInfo[num];
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
		String name, phoneNumber, birthday;
		System.out.print("이름:");name = scanner.nextLine();
		System.out.print("전화번호:");phoneNumber = scanner.nextLine();
		System.out.print("생년월일:");birthday = scanner.nextLine();
		phoneInfo[numOfphone++] = new PhoneInfo(name, phoneNumber, birthday);
		jdbc.insert(name, phoneNumber, birthday);
	}

	public void dataSearch() {
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름:");
		String searchName = scanner.nextLine();

		for(int i=0 ; i<numOfphone ; i++) {			
			if(searchName.compareTo(phoneInfo[i].name)==0) {
				phoneInfo[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
			}
		}
		jdbc.search(searchName);
	}
	
	public void dataDelete(){
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.print("이름:");
		String deleteName = scanner.nextLine();
		int deleteIndex = -1;
		
		for(int i=0; i<numOfphone; i++) {
			if(deleteName.compareTo(phoneInfo[i].name)==0) {
				deleteIndex = i;
				numOfphone--;
			}
		}
		
		if(deleteIndex==-1) {
			System.out.println("삭제된 정보가 없습니다.");
		}
		else {
			for(int i=deleteIndex; i<numOfphone; i++) {
				phoneInfo[i]=phoneInfo[i+1];
				System.out.println("데이터 삭제가 완료되었습니다.");
			}
		}
		jdbc.delete(deleteName);
	}
	
	public void dataAllShow() {
		for(int i=0; i<numOfphone; i++) {
			phoneInfo[i].showPhoneInfo();
		}
	}
}
