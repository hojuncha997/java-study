package powerJava;

class ParentClass{
	int data = 100;
	public void print() {
		System.out.println("수퍼클래스의 print() 메소드");
	}
}

public class ChildClass extends ParentClass {
	int data = 200;
	
	@Override
	public void print() {
		super.print(); // 수퍼클래스의 메소드 호출
		System.out.println("서브 클래스의 print() 메소드");
		System.out.println(this.data);
		System.out.println(super.data); //수퍼클래스의 필드 접근
	}

	public static void main(String[] args) {
		ChildClass obj = new ChildClass();
		obj.print();
	}
}
/*
 *	super
 *
 * 키워드 super는 상속 관계에서 수퍼 클래스의 메소드나 필드를 명시적으로 참조하기 위하여 사용된다.
 * 만약 수퍼 클래스의 메소드나 필드를 재정의한 경우에 super를 사용하면 수퍼 클래스의 메소드나 필드를 호출할 수 있다.
 * 
 * 보통 메소드를 재정의할 때 수퍼 클래스의 메소드를 완전히 대체하는 경우보다 내용을 추가하는 경우가 많다.
 * 이러한 경우에는 super 키워드를 이용하여 super클래스의 메소드를 호출해준 후에 자신이 필요한 부분을 추가해 주는 것이 좋다.
 * 
 * 	필드 재정의
 * 
 * 만약 이 예제의 data 필드처럼 서브 클래스에서 수퍼 클래스와 동일한 이름의 필드를 정의하면 어떻게 될까?
 * 이런 경우에는 무조건 서브 클래스의 필드가 수퍼클래스의 필드를 "가리게" 된다. 타입이 다르더라도 마찬가지이다.
 * 이런 경우, 서브 클래스 안에서는 수퍼 클래스의 필드를 참조하려면 super라고 하는 키워드를 사용하여야 한다.
 * 
 * 일반적으로 수퍼클래스의 필드와 동일한 이름의 필드를 사용하는 것은 코드를 난해하게 하므로 피하는 것이 좋다.
 * 
 * 
 */