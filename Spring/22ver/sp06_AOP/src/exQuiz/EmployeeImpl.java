package exQuiz;

public class EmployeeImpl implements iPrint {

	private String depart, jikup;
	
	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getJikup() {
		return jikup;
	}

	public void setJikup(String jikup) {
		this.jikup = jikup;
	}

	@Override
	public void show() {
		
	}

}
