/*클래스를 사용하여 인스턴스를 만들면, 그 필드들, 즉 인스턴스 변수들은 제각각 값을 가진다.
따라서 동적으로 변화한다고 볼 수 있다. 그러나 모든 객체에 공통인 변수가 필요한 경우가 있다.
이때 사용하는 것이 정적변수(static variable)이다. 정적변수는 클래스 변수라고도하며,
하나의 클래스에 하나밖에 존재할 수 없다. 또한 정적변수는 속한 클래스의 인스턴스를 생성하지 않고서도
외부에서 사용될 수 있다. Car.numberOfCars;처럼

메소드도 정적 멤버로 만들 수 있다. 클래스 메소드라고도 한다. 정적 메소드의 좋은 예는
Math클래스에 들어 있는 각종 수학 메소드들이다. 이것들을 사용하기 위해서 인스턴스를
생성할 필요 없이 그냥 double value = Math.sqrt(9.0);처럼 사용하면 된다.

public static void main(String[] args){}의 경우도 마찬가지이다.
JVM이 클래스의 인스턴스를 생성할 필요 없이 main()메소드를 소출하여 실행할 수 있도록 하기 위함이다.

정적 메소드는 객체가 생성되지 않은 상태에서 호출되는 메소드이므로, 객체 안에서만 존재하는 인스턴스 변수들은
사용할 수 없고 정적 변수와 지역 변수만을 사용할 수 있다. 또한 정적 메소드에서 인스턴스 메소드를 호출하면
역시 오류가 된다. 인스턴스 메소드도 객체가 생성되어야만 사용할 수 있기 때문이다. 하지만
정적 메소드에서 정적 메소드를 호출하는 것은 가능하다. 또한 정적 메소드는 this 키워드를 사용할 수 없다.
왜냐하면 this가 참조할 인스턴스가 없기 때문이다.

*/
package powerJava;

class Car2 {
	private String color;
	private int speed;
	private int gear;
// 자동차의 시리얼 넘버
	private int id;
	private static int numberOfCars = 0;
	
//생성자
	public Car2(String c, int s, int g) {
		color = c;
		speed = s;
		gear = g;
		id = ++numberOfCars;
	}
	
	public static int getNumberOfCars() {
		return numberOfCars;
	}
}

public class CarTest3{
	public static void main(String[] args) {
		Car2 c1 = new Car2("blue", 100, 1);
		Car2 c2 = new Car2("White", 0, 1);
		
		int n = Car2.getNumberOfCars(); //정적 메소드 호출. 인스턴스 안 만들었음.
		System.out.println("지금까지 생성된 자동차 수 = " + n);
	}
}