package powerJava;

class Animal{
	public void sound() {
		
	}
}


class Dog extends Animal{
	public void sound() {
		System.out.println("멍멍");
	}
}



public class DogTest {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.sound();
	}
}

//sound()를 오버라이딩 했기 때문에 Dog 클래스의 sound()가 호출된다.

/*
 * 오버라이딩 시 주의사항
 * 
 * 오버라이딩(재정의)는 메소드의 헤더는 그대로 두고 메소드의 몸체만을 교체하는 것이다.
 * 따라서 메소드의 헤덛 부분은 수퍼 클래스의 헤더와 동일하여야 한다.
 * 즉 수퍼 클래스의 메소드와 동일한 시그니처를 가져야 한다.
 *  즉 메소드의 이름, 반환형, 매개변수의 개수, 데이터 타입이 일치하여야 한다.
 *  
 *  또한 수퍼클래스의 메소드를 재정의 하라면 메소드가 public으로 선언되어야 한다.
 *  private메소드는 재정의할 수 없다. 또, 접근 지정자의 경우, 수퍼클래스의 메소드보다
 *  더 좁은 범위로 변경할 수 없다. 예를 들어 수퍼클래스의 메소드가  protected로 선언되어 있는
 *  경우에 서브 클래스의 메소드는 protected나 public으로만 변경이 가능하다.
 */