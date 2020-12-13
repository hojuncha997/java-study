package practice01;

public class Prob03 {
	public static void main(String[] args) {

		for (int i = 1; i < 100; i++) {

			String s = String.valueOf(i);
			char c0 = s.charAt(0);

			// String.valueOf(i) : primitive type i 값을 스트링으로 변환함
			// s.CharAt(n) : 문자열s 의 n번째 문자를 반환함. 가장왼쪽이 0

			if (i < 10) {
				if (c0 == '3' || c0 == '6' || c0 == '9')
					System.out.println(i + "  : 짝");
			}

			if (i >= 10) {
				char c1 = s.charAt(1);
				if (c1 == '3' || c1 == '6' || c1 == '9' || c0 == '3' || c0 == '6' || c0 == '9') {
					if (c1 == c0)
						System.out.println(i + " : 짝짝");
					else
						System.out.println(i + " : 짝");
				}
			}

		}

	}

}
