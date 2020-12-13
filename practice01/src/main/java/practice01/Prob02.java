package practice01;


public class Prob02 {

	public static void main(String[] args) {
		/* 중첩 for문 */ 
		
		int s = 0;
	
		
		System.out.println("실행 결과:");
		for(int i = 0; i < 8 ; i++) {
			for(int k = 1; k <= 10; k++ ) {
				s = i + k;
				System.out.printf("%d ", s);
			}
		System.out.println();
		}
	}

}

/*
 
실행 결과: 
1 2 3 4 5 6 7 8 9 10
2 3 4 5 6 7 8 9 10 11
3 4 5 6 7 8 9 10 11 12
4 5 6 7 8 9 10 11 12 13
5 6 7 8 9 10 11 12 13 14
6 7 8 9 10 11 12 13 14 15
7 8 9 10 11 12 13 14 15 16
8 9 10 11 12 13 14 15 16 17
 
 
 */