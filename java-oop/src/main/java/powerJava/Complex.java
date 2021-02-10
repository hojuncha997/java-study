/*클래스 간의 관계

* 1. 사용관계(use)
* 
* 사용관계에서는 클래스 A의 메소드에서 클래스 B의 메소드를 호출한다.
* 클래스 B의 메소드를 호출하려면 클래스 B의 객체에 대한 참조를 가져야 한다.
* CarTest 클래스에서 Car클래스의 객체를 생성하여 사용하는 경우가 바로 사용관계이다.
* 
* 사용관계에서 특히 흥미로운 형태는 하나의 클래스가 자기 자신을 사용하는 경우이다.
* 이것은 주로 객체 참조를 매개변수로 받는 형태로 나타난다. 예를 들어 String 클래스의 경우
* 두 개의 문자열을 비교하는 메소드 compareTo()는 String 객체 참조 변수를 매개변수로 받는다.
* 
*  int result = s1.compareTo(s2);
* 
* 예를 들어 복소수를 나타내는 클래스 Complex를 작성하여 보면 다음과 같다.
* 복소수끼리 덧셈을 나타내는 메소드인 add() 메소드는 Complex 객체를 매개변수로 받아서
* 덧셓만 결과를 새로운 객체를 생성하여 반환하게 된다.
*/

package powerJava;

public class Complex {
	private double real; //실수
	private double imag; //허수
	
	public Complex(double r, double i) {
		this.real = r;
		this.imag = i;
	}
	
	double getReal() {
		return this.real;
	}

	double getImag() {
		return this.imag;
	}

	public Complex add(Complex c) {
	//add라는 이름을 가진 Complex 타입의 메소드. 이것은 Complex c를 매개변수로 받는다.
	// 그리고 Complex 타입으로 반환한다.
		double resultReal = this.real + c.getReal();
		double resultImag = this.real + c.getImag();
		
		return new Complex(resultReal, resultImag);
		//객체가 생성되고 객체의 참조값이 반환.
	}
}