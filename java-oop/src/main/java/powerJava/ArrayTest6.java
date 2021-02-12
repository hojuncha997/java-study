/*2차원 배열에서의 length의 필드
 * 
 * 1차원 배열의 경우에는 하나의 length 필드가 존재하였다. 2차원 배열에서는 복잡하다.
 * 전체적으로 하나의 length 필드가 있고 이것은 행의 개수를 나타낸다.
 * 각 행마다 별도의 length 필드가 있고 이것은 각 행이 가지고 있는 열의 개수를 나타낸다.
 * 
*/
package powerJava;

import java.util.Scanner;

public class ArrayTest6 {

	public static void main(String[] args) {
		int[][] array = { 
				{ 10, 20, 30, 40 }, 
				{ 50, 60, 70, 80 }, 
				{ 90, 100, 110, 120 }
		};

		for (int r = 0; r < array.length; r++) { //행
			for (int c = 0; c < array.length; c++) { //열
				System.out.println(r + "행" + c + "열: " + array[r][c]);
			}
		}
	}
}
