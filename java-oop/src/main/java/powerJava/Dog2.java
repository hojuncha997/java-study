package powerJava;
class Animal2{
	public void sound() {
		
	}
}

/*
 * 
 public class Dog2 extends Animal2 {
	void saund() { System.out.println("멍멍")
 	}
 }
 이 경우 saund는 sound의 오타이다. 그러나 컴파일러는 이를 새로운 메소드로 인식하기 떄문에 오류가 나지 않는다.
 이를 방지하기 위해 @Override라는 주해(annotation)을 사용하여 컴파일러에게, 이 클래스가
 수퍼 클래스의 메소드를 오버라이드 할려고 한다는 것을 알려주면 좋다. 만약 컴파일러가 수퍼클래스에 그러한
 메소드가 존재하지 않는다는 사실을 감지하면 오류가 발생하게 된다.
 
 따라서 아래와 같이 하라.
 
 */

public class Dog2 extends Animal2 {
	
	@Override
	
	void saund() { // 수퍼클래스에 saund()가 없기 때문에 오류 발생.
		System.out.println("멍멍");
		
	// 결과:
	// The method saund() of type Dog must override or implement a supertype method.
	// 그러나 컴파일러가 자동으로 오류를 수정해 주었는지 결과는 "멍멍"이 나온다...
	}

}
