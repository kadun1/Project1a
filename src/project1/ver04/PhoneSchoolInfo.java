package project1.ver04;

public class PhoneSchoolInfo extends PhoneInfo{

	String major;
	int grade;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("전공: "+this.major);
		System.out.println("학년: "+this.grade);
	}
		
	
}
