package powerJava;

class Student{
	String name = "";
	int student_id = 0;
	String division ="";
	int level=0;
	
	public Student(String name, int student_id, String division, int level) {
		this.name = name;
		this.student_id = student_id;
		this.division = division;
		this.level = level;
	}
	
	public void returValue() {
		System.out.println("이름: " + this.name + " 학번: " + student_id
				+ " 학부: " + " 학년: "+ level);
	}
}

class Graduate extends Student{
	public Graduate() {
		super("차호준", 123, "경영정보", 3);
	}
	Student s = new Student("차호준", 123, "경영정보", 3);
		
}

class UnderGraduate{
	
}



public class StudentTestClass extends Graduate{

	public static void main(String[] args) {
		
		
		System.out.println();
	}

}
