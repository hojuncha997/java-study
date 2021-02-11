package powerJava;

import java.util.Scanner;

public class ArrayTest1 {
	public static void main(String[] args) {
		final int STUDENTS = 5; //상수
		int total = 0;
		
		Scanner scan = new Scanner(System.in);
		int[] scores = new int[STUDENTS]; // 크기가 STUDENTS(= 5)인 배열 생성
		
		for(int i =0; i < STUDENTS; i++) {
			System.out.println("성적을 입력하시오");
			scores[i] = scan.nextInt();
			total += scores[i];
		}
		
		/*
		 * for(int i = 0; i < STUDENTS; i++) total += scores[i];
		 */
		
		System.out.println("평균 성적은" + total / STUDENTS + "입니다!");
	}
}
