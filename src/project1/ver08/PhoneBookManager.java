package project1.ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class PhoneBookManager {

	Scanner scanner = new Scanner(System.in);
	static HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	static AutoSaverT as = new AutoSaverT(set);
	
	public PhoneBookManager() {
		try {
			ObjectInputStream in =
				new ObjectInputStream(
					new FileInputStream("src/project1/ver08/Phonebook.obj")
				);
			while(true) {
				PhoneInfo phoneInfo = (PhoneInfo)in.readObject();
				set.add(phoneInfo);
			}
		}
		catch (Exception e) {
			return;
		}
	}
	
	public void printMenu() {
		System.out.println("====================메뉴를 선택하세요====================");
		System.out.println("1.주소록 입력 2.검색 3.삭제 4.출력 5.저장옵션 6.3by3퍼즐  7.종료");
		System.out.println("=====================================================");
	}
	
	public void dataInput() {
		String name, phoneNumber, major, companyName;
		String yn;
		int grade, choice;
		System.out.println("====주소록을 입력함====");
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반, 2.동창, 3.회사");
		choice = scanner.nextInt();
		scanner.nextLine(); //엔터키 제거용...
		
		System.out.print("이름:");name = scanner.nextLine();
		System.out.print("전화번호:");phoneNumber = scanner.nextLine();
		PhoneInfo pInfo = new PhoneInfo(name, phoneNumber);
		
		if(choice==SubMenuItem.BASIC) {
			if(set.add(pInfo)==false) {
				System.out.println("중복발견 덮어쓸까요?(Y/N)");
				yn = scanner.nextLine();
				if(yn.equalsIgnoreCase("y")) {
					set.remove(pInfo);
					set.add(new PhoneInfo(name, phoneNumber));
				}
				else if(yn.equalsIgnoreCase("n")) {
					System.out.println("저장에 실패했습니다.");
				}
			}
		}
		if(choice==SubMenuItem.SCHOOL) {
			System.out.print("전공:");major = scanner.nextLine();
			System.out.print("학년:");grade = scanner.nextInt();
			scanner.nextLine();
			PhoneSchoolInfo school = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			if(set.add(school)==false) {
				System.out.print("중복발견 덮어쓸까요?(Y/N)");
				yn = scanner.nextLine();
				if(yn.equalsIgnoreCase("y")) {
					set.remove(school);
					set.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));
				}
				else if(yn.equalsIgnoreCase("n")) {
					System.out.println("저장에 실패했습니다.");
				}
			}
		}
		if(choice==SubMenuItem.COMPANY) {
			System.out.print("회사명:");companyName = scanner.nextLine();
			PhoneCompanyInfo company = new PhoneCompanyInfo(name, phoneNumber, companyName);
			if(set.add(company)==false) {
				System.out.print("중복발견 덮어쓸까요?(Y/N)");
				yn = scanner.nextLine();
				if(yn.equalsIgnoreCase("y")) {
					set.remove(company);
					set.add(new PhoneCompanyInfo(name, phoneNumber, companyName));
			}
				else if(yn.equalsIgnoreCase("n")) {
					System.out.println("저장에 실패했습니다.");
				}
			}
		}
	}

	public void dataSearch() {
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름:");
		String searchName = scanner.nextLine();
		boolean search = false;
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo phoneInfo = itr.next();
			if(searchName.equals(phoneInfo.name)) {
				phoneInfo.showPhoneInfo();
				search = true;
			}
		}
		if(search==false) {
			System.out.println("검색결과가 없습니다");
		}
	}
	
	public void dataDelete(){
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.print("이름:");
		String deleteName = scanner.nextLine();
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			if(deleteName.equals(itr.next().name)) {
				itr.remove();
				System.out.println("데이터 삭제가 완료되었습니다.");
			}
		}
	}
	
	public void dataAllShow() {
		System.out.println("======주소록을 출력함======");
		for(PhoneInfo pI : set) {
			pI.showPhoneInfo();
		}
		System.out.println("==주소록 출력이 완료되었습니다==");
	}
	
	public void savePhoneInfo() {
		
		try {
			ObjectOutputStream out =
				new ObjectOutputStream(
					new FileOutputStream("src/project1/ver08/Phonebook.obj")
				);
				
			Iterator<PhoneInfo> itr = set.iterator();
			while(itr.hasNext()) {
				out.writeObject(itr.next());
			}
			System.out.println("obj파일로 저장되었습니다.");
		}
		catch (Exception e) {
			System.out.println("정보저장 예외발생");
			e.printStackTrace();
		}
	}
	
	public void threadPhone() {
		System.out.println("저장옵션을 선택하세요");
		System.out.println("1.자동저장On, 2.자동저장Off");
		int select = scanner.nextInt();
		if(select==1) {
			if(as.isAlive()) {
				System.out.println("이미 자동저장이 실행중입니다.");
			}
			else {
				as = new AutoSaverT(set);
				as.setDaemon(true);
				as.start();
			}
		}
		else if(select==2) {
			as.interrupt();
		}
	}
}
