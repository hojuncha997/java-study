/* 메소드의 매개변수로 배열 전달
 * 
 * 배열을 받아서 처리하는 메소드는 상당히 자주 등장한다. 예를 들어 배열의 원소들을
 * 출력하는 메소드나 배열 원소들의 평균을 구하는 메소드가 있을 수 있다. 이들 메소드는 모두
 * 배열을 매개변수로 받아야 한다. 만약 배열 원소가 메소드로 전달된다면 이것은 다른 변수들과 다르지 않다.
 * 즉 복사된 값으로 전달된다.
 * 그러나 배열 전체가 전달된다면 상황은 달라진다. 배열도 객체이기 때문에 배열을 전달하는 것은
 * 배열 참조 변수를 복사하는 것이다
*/
package powerJava;

import java.util.Scanner;

public class ArrayTest5 {
	
	final static int STUDENTS = 5; //상수
	
	public static void main(String[] args) {
		int[] scores = new int[STUDENTS];
		getValues(scores);
		getAverage(scores);
	}
	
	private static void getValues(int[] array) { //scores 배열이 참조값으로 넘어감
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < array.length; i++) {
			System.out.println("성적을 입력하시오: ");
			array[i] = scan.nextInt();
		}
	}
	
	private static void getAverage(int[] array) {
		int total = 0;
		for(int i = 0; i < array.length; i++)
			total += array[i];
		System.out.println("평균 성적은" + total / array.length + "입니다.");
	}
}
