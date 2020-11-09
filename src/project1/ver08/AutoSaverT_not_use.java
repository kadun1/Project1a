package project1.ver08;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class AutoSaverT_not_use extends Thread{

	@Override
	public void run() {
		PhoneBookManager pbm = new PhoneBookManager();
		try {
			while(true) {
				PrintWriter out = new PrintWriter(new FileWriter("src/project1/ver08/AutoSaveBook.txt"));
				Iterator<PhoneInfo> itr = pbm.set.iterator();
				while(itr.hasNext()) {
					PhoneInfo pI = itr.next();
					if(pI instanceof PhoneSchoolInfo) {
						out.println("이름 : "+pI.name);
						out.println("전화번호 : "+pI.phoneNumber);
						out.println("전공 : "+((PhoneSchoolInfo) pI).major);
						out.println("학년 : "+((PhoneSchoolInfo) pI).grade);
					}
					else if(pI instanceof PhoneCompanyInfo) {
						out.println("이름 : "+pI.name);
						out.println("전화번호 : "+pI.phoneNumber);
						out.println("회사명 : "+((PhoneCompanyInfo) pI).companyName);
					}
					else if(pI instanceof PhoneInfo) {
						out.println("이름 : "+pI.name);
						out.println("전화번호 : "+pI.phoneNumber);
					}
				}
				out.close();
				System.out.println("주소록이 텍스트로 자동저장 되었습니다.");
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("자동저장을 종료합니다.");
					break;
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	


