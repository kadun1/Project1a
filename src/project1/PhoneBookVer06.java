package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.PhoneInfo;
import project1.ver06.MenuItem;
import project1.ver06.MenuSelectException;
import project1.ver06.PhoneBookManager;

public class PhoneBookVer06 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		PhoneBookManager pbm = new PhoneBookManager(100);
		while(true) {
			try {
				pbm.printMenu();
				int select = scanner.nextInt();
				if(select>0 && select<=5) {
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
				else {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
			}
			catch(MenuSelectException e) {
			System.out.println(e.getMessage());
			}
			catch(InputMismatchException e) {
				System.out.println("숫자만 입력해야 합니다.");
				scanner.nextLine();
			}
		}
	}
}
