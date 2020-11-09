package project1;

import java.util.Scanner;

import project1.ver09.PhoneInfo;
import project1.ver09.PhoneBookManager;

public class PhoneBookVer09 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		PhoneBookManager pbm = new PhoneBookManager(100);
		
		while(true) {
		pbm.printMenu();
		int select = scanner.nextInt();
			switch(select) {
			case 1 :
				pbm.dataInput();
				break;
			case 2 :
				pbm.dataSearch();
				break;
			case 3 :
				pbm.dataDelete();
				break;
			case 4 :
				pbm.dataAllShow();
				break;
			case 5 :
				pbm.jdbc.close();
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
