package practice02;

import java.util.Scanner;

public class Prob05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("두 정수와 연산자를 입력하시오 >>");
		String line = scanner.nextLine();
		String[] tokens = line.split(" ");
		
		int lValue = Integer.parseInt(tokens[0]);
		int rValue = Integer.parseInt(tokens[2]);
		String operator = tokens[2];
		
		switch(operator) {
			case "+": {
				Add add = new Add();
				add.setValue(lValue, rValue);
				int result = add.calculate();
				break;
			}
			case "-": {
				break;
			}
			case "*": {
				break;
			}
			case "/": {
				break;
			}
			default : {
				System.out.println("지원하지 않는 계산입니다.");
			}
		}
		
		scanner.close();

	}
}
