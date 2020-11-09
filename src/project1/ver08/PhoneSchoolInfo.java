package project1.ver08;

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
		
	@Override
	public String getInfo() {
		return super.getInfo()+String.format("\n전공 : %s\n학년 : %s", major, grade);
	}
}
