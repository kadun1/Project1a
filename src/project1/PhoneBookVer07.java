package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver07.PhoneInfo;
import project1.ver07.MenuItem;
import project1.ver07.MenuSelectException;
import project1.ver07.PhoneBookManager;

public class PhoneBookVer07 {

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
						System.out.println("====주소록을 입력함====");
						pbm.dataInput();
						System.out.println("==입력이 완료되었습니다==");
						break;
					case MenuItem.SEARCH :
						pbm.dataSearch();
						break;
					case MenuItem.DELETE :
						pbm.dataDelete();
						break;
					case MenuItem.SHOW :
						System.out.println("======주소록을 출력함======");
						pbm.dataAllShow();
						System.out.println("==주소록 출력이 완료되었습니다==");
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
