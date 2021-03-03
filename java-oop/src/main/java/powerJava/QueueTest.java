
package powerJava;

import java.util.*;

public class QueueTest {
	public static void main(String[] args) throws InterruptedException {

		int time = 10;

		Queue<Integer> queue = new LinkedList<Integer>(); // Integer를 저장하는 큐를 생성한다.
		// 실제로 링크드리스트 안에 뷰 인터페이스가 구현돼 있다.

		for (int i = time; i >= 0; i--)
			queue.add(i);

		while (!queue.isEmpty()) {
			System.out.print(queue.remove() + " ");
			Thread.sleep(1000); // 현재의 스레드를 1초간 재운다.
		}
	}
}
