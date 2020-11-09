package project1;

import java.util.Scanner;

import project1.ver05.PhoneInfo;
import project1.ver05.MenuItem;
import project1.ver05.PhoneBookManager;

public class PhoneBookVer05 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		PhoneBookManager pbm = new PhoneBookManager(100);
		
		while(true) {
		pbm.printMenu();
		int select = scanner.nextInt();
			switch(select) {
			case MenuItem.INPUT:
				pbm.dataInput();
				break;
			case MenuItem.SEARCH :
				pbm.dataSearch();
				break;
			case MenuItem.DELETE :
				pbm.dataDelete();
				break;
			case MenuItem.SHOW :
				pbm.dataAllShow();
				break;
			case MenuItem.EXIT :
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
		
	}
}
