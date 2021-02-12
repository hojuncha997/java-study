/*극장예약시스템.
먼저 좌석 배치표 보여줌.
예약 끝난 좌석은 1, 빈 좌석은 0*/

//IntStream.of(seats).anyMatch(x -> x != 0)

package powerJava;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayTheater {
	// private static final int chair = 10; 굳이 이럴 필요가 있을까

	public static void main(String[] args) {
		final int chair = 10;
		int[] seats = new int[chair];
		int sum=0;
		
		/*
		 * int sum = seats[0] + seats[1] + seats[2] + seats[3] + seats[4] + seats[5]+
		 * seats[6]+ seats[7]+ seats[8]+ seats[9];
		 */
		

		while (true) {
			
			for (int i = 0; i < seats.length; i++) {
				sum += seats[i];
			}
			System.out.println();
			System.out.println("남은 좌석은 " + (10-sum));
			
			System.out.println("좌석을 예약하시겠습니까? (1 또는 0)");

			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();

			if (input == 1) {
				System.out.println("현재의 좌석상태는 다음과 같습니다.");
				System.out.println("------------------------");
				System.out.println("1 2 3 4 5 6 7 8 9 10");
				System.out.println("------------------------");

				for (int i = 0; i < seats.length; i++) {
					System.out.print(seats[i] + " ");
					
				}

				System.out.println();

				System.out.println("좌석을 선택하십시오. 1~10 : ");
				int seatChoice = scan.nextInt();
				if (seatChoice >= 1 && seatChoice <= 10 && seats[seatChoice - 1] == 0) {
					seats[seatChoice - 1] = 1;
					System.out.println(seatChoice + "번 자리로 예약되었습니다.");
					
					

					
				}else if (seatChoice >= 1 && seatChoice <= 10 && seats[seatChoice - 1] == 1) {
					System.out.println("해당 좌석은 사용하실 수 없습니다.");
				}

				for (int i = 0; i < seats.length; i++) {
					System.out.print(seats[i] + " ");
				}
			
			} else if (input == 0) {
				System.out.println("예약을 취소하셨습니다.");
				break;

			} else if (!(input == 1 && input == 0)) {
				System.out.println("처읍부터 다시 하십시오");
			}

		}
	}
}
