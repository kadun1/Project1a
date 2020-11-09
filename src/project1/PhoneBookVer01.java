package project1;

import project1.ver01.PhoneInfo;

public class PhoneBookVer01 {

	public static void main(String[] args) {

		PhoneInfo pInfo1 = new PhoneInfo("자바맨", "010-0123-4567");
		PhoneInfo pInfo2 = new PhoneInfo("너구리", "010-0123-4567", "76/01/27");
		
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();
	}

}
