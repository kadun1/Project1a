package project1.ver08;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;

public class AutoSaverT extends Thread{

	PhoneBookManager pbm = new PhoneBookManager();
	PhoneInfo pInfo;
	HashSet<PhoneInfo> hashPhone;
	
	public AutoSaverT(HashSet<PhoneInfo> hashPhone) {
		
		this.hashPhone = hashPhone;
	}

	@Override
	public void run() {
		try {
			while(true) {
				BufferedWriter out = new BufferedWriter(new FileWriter("src/project1/ver08/AutoSaveBook.txt"));
				Iterator<PhoneInfo> itr = hashPhone.iterator();
				while(itr.hasNext()) {
					PhoneInfo pI = itr.next();
					String str = pI.getInfo();
					out.write(str);
					out.newLine();
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
	


