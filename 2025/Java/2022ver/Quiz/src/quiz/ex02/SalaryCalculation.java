package quiz.ex02;

class Employee {
	String name;
	int id;
	int basicPay;
	int com;
	int totalPay;

	public Employee(int id, String name, int basicPay, int com) {
		this.id = id;
		this.name = name;
		this.basicPay = basicPay;
		this.com = com;
	}

	void calcPay() {
		totalPay = basicPay + com;
	}

}

class Manager extends Employee {

	int managerCom;

	public Manager(int id, String name, int basicPay, int com, int managerCom) {
		super(id, name, basicPay, com);
		this.managerCom = managerCom;
	}

	void calcPay() {
		totalPay = basicPay + com + managerCom;
	}

}

public class SalaryCalculation {
	public static void main(String[] args) {
		Employee e[] = new Employee[4];
		e[0] = new Employee(1000, "�̻��", 10000, 5000);
		e[1] = new Manager(2000, "�谣��", 10000, 10000, 10000);
		e[2] = new Employee(3000, "�ڱ��", 10000, 7000);
		e[3] = new Manager(4000, "���ӿ�", 10000, 11000, 11000);

		/*
		 * for(int i =0;i<e.length;i++){ e[i].calcPay();
		 * System.out.printf("��� %d�� %s �� %d �� �ѱ޿��� �޽��ϴ�.\n",e[i].id,e[i].name,e
		 * [i].totalPay);
		 * 
		 * }
		 */
		for (int i = 0; i < e.length; i++) {
			System.out.println("��� " + e[i].id + " �� " + e[i].name + " ��" + e[i].calcPay(e[2]));
		}
	}

}