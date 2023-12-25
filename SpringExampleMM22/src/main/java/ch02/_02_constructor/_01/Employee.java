package ch02._02_constructor._01;

public class Employee {
	String name;
	String address;
	String deptCode;
	Integer salary;
	
	public Employee(String name, String address, String deptCode) {
		super();
		this.name = name;
		this.address = address;
		this.deptCode = deptCode;
	}

	public Employee(String name, String address, Integer salary) {
		super();
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", deptCode=" + deptCode + ", salary=" + salary
				+ "]";
	}

}
