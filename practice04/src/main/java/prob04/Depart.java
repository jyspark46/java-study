package prob04;

public class Depart extends Employee {

	String department;
	
	public Depart(String name, int salary, String department) {
		// TODO Auto-generated constructor stub
		setName(name);
		setSalary(salary);
		this.department = department;
	}

	@Override
	public void getInformation() {
		// TODO Auto-generated method stub
		super.getInformation();
		System.out.println(", 부서: " + department);
	}
	
	

}
