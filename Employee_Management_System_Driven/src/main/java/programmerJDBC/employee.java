package programmerJDBC;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class employee {
	@Id
	public int sid;
	public String sname;
	public long sphone;
	public String gender;
	public double salary;
	public String email;

	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public long getSphone() {
		return sphone;
	}

	public void setSphone(long sphone) {
		this.sphone = sphone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public employee(int sid, String sname, long sphone, String gender, double salary, String email) {
		this.sid = sid;
		this.sname = sname;
		this.sphone = sphone;
		this.gender = gender;
		this.salary = salary;
		this.email = email;
	}

	public employee() {
	}

	@Override
	public String toString() {
		return "Employee [sid=" + sid + ", sname=" + sname + ", sphone=" + sphone +
				", gender=" + gender + ", salary=" + salary + ", email=" + email + "]";
	}
}
