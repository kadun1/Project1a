package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.MenuItem;
import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;
import project1.ver08.Qu3by3;

public class PhoneBookVer08 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		PhoneBookManager pbm = new PhoneBookManager();
		
		while(true) {
			try {
				pbm.printMenu();
				int select = scanner.nextInt();
				if(select>0 && select<=7) {
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
					case MenuItem.SAVE :
						pbm.threadPhone();
						break;
					case MenuItem.Q3BY3 :
						Qu3by3 q3 = new Qu3by3();
						break;
					case MenuItem.EXIT :
						pbm.savePhoneInfo();
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
