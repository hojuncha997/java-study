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
 *  
 *  
 *  중복정의(오버로딩)와 재정의(오버라이딩)의 차이.
 *  
 *  - 중복정의(오버로딩): 같은 이름의 메소드를 여러 개 정의하는 것.
 *  - 재정의: 수퍼클래스에 있던 상속받은 메소드를 다시 정의해서 내용을 변경하는 것.
 *  
 *  참고사항.
 *  
 *  서브클래스에서 수퍼클래스의 메소드를 중복 정의할 수 있을까?
 *  즉, 오버라이딩한 메소드를 오버로딩도 할 수 있을까?
 *  
 *  sound()를 재정의해 놓고 다시 sound(int i)를 또 작성한다면,
 *  sound(int i) 메소드는 서브클래스가 작성한 새로운 메소드로 취급된다.(오버로딩 안됨.)
 *  
 *  
 */