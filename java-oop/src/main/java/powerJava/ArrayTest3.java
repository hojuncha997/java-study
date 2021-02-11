package powerJava;

public class ArrayTest3 {
	public static void main(String[] args) {
		int[] numbers = {10, 20, 30};
		/*
		 * numbers라는 이름의 배열참조 변수를 선언하고, 배열을 생성하며, 주어진 초기값을 배열 원소에 저장한다. 이 경우 new를 사용하여
		 * 생성하지 않아도 주어진 초기 값 개수만큼의 배열이 자동적으로 생성된다.
		 */
		for(int value : numbers)
			System.out.println(value);
		
		/*
		 * 배열의 첫 번째 원소부터 마지막 원소까지 꺼내서 처리하는 경우라면 for-each 루프가 훨씬 사용하기 쉽다. 배열의 크기에 신경쓰지
		 * 않아도 되고 인덱스 변수를 생성할 필요도 없다. 그러나, 아래의 경우는 전통적인 for문의 사용이 적합하다.
		 * 
		 * - 배열의 원소값을 변경하는 경우 
		 * - 역순으로 배열원소를 처리하는 경우 
		 * - 전체가 아니고 일부 원소만을 처리하는 경우 
		 * - 하나의 반복 루프에서 두 개 이상의 배열을 처리하는 경우
		 */	
		
	}
}
