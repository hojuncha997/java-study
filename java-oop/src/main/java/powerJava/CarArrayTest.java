/*배열 원소는 무조건 변수이다. 자바의 변수는 기초형와 참조형으로 나누어진다.
따라서 배열도 기초형 변수들의 모임이 될 수도 있고 참조형 변수들의 모임이 될 수도 있다.
예를 들어서 배열 int[] 타입이면 각 원소들은 정수를 저장할 수 있다. 만약 배열이
Car[] 타입이면 배열의 각 원소들은 무엇을 저장하고 있을까?

" !!!!! Car 객체가 배열 원소에 저장되는 것은 절대 아니다. !!!!"

참조 변수는 객체가 아니라 객체의 참조값을 저장하고 있기 때문에

"!!!! Car 배열에서도 각각의 원소들은 참조값만을 저장하게 된다. !!!!"

Car가 자동차를 나타내는 클래스라고 가정하고 배열을 작성해 보자

Car[] cars = new Car[5];

위의 문장이 실행되면

cars[0]|cars[1]|cars[2]|cars[3]|cars[4]

이 원소들은 각각 다른 객체를 가리키는 값을 가지고 있는 게 된다.

*/
package powerJava;

class Car3 {
	private int speed;
	private int gear;
	private String color;
	
	public Car3() {
		speed = 0;
		gear = 1;
		color = "red";
	}
	
	public void speedUp() {
		speed += 10;
	}
	
	public String toString() {
		return "속도:" + speed + " 기어: " + gear + "색상: " + color;
	}
	
}

public class CarArrayTest {
	public static void main(String[] args) {
	
		final int NUM_CARS = 5;
		
		Car3[] cars = new Car3[NUM_CARS]; //배열객체 생성
		
		
		for(int i = 0; i < cars.length; i++)
			cars[i] = new Car3(); //객체부터 5개 생성
		
		for(int i = 0; i < cars.length; i++) //그 뒤에 객체별로 speedUp 메소드 실행
			cars[i].speedUp();
			
		for(int i = 0; i < cars.length; i++) //
			System.out.println(cars[i]);
	}

}




















