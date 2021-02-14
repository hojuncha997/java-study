package powerJava;
import java.util.*;

public class StudentTest {
	public static void main(String[] args) {
		Student2[] students = new Student2[3];
		students[0] = new Student2("홍길동", 3.39);
		students[1] = new Student2("임꺽정", 4.21);
		students[2] = new Student2("황진이", 2.19);
		
		Arrays.sort(students); // Array 클래스의 정적 메소드 sort()는 Comparable 인터페이스를 구현한 원소로 이루어진 배열을 정렬한다.
		for(Student2 s : students)
			System.out.println("이름= " + s.getName() + "평점= " + s.getGPA());
		
	}
}


class Student2 implements Comparable{
	private String name;
	private double gpa;
	
	public Student2(String n, double g) {
		this.name = n;
		this.gpa = g;
	}
	
	public String getName() {return this.name;}
	public double getGPA() {return this.gpa;}
	
	public int compareTo(Object obj) {
		Student2 other = (Student2) obj;
		if(gpa <other.gpa)
			return -1;
		else if(gpa > other.gpa)
			return 1;
		else
			return 0;
	}
}