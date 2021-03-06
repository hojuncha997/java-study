
/* 
 * 인터페이스와 다형성

 *  추상클래스(abstract class)는 추상적인 개념을 표현할 수 있는 클래스이다. 추상클래스는 상속 계층 구조에서
 *  유용하게 사용된다. 인터페이스는 두 개의 클래스 사이의 인터페이스를 나타낼 수 있다. 인터페이스는 다중 상속과 
 *  유사한 효과를 낼 수 있는 도구이다. 또한 다형성은 수퍼 클래스 타입 변수로 서브 클래스 타입의 객체를 참조할 수 있는 
 *  중요한 기법이다.
 *  
 *  */


package powerJava;

abstract class Shape2{ //추상클래스는 직접 객체를 생성할 수 없다.
	int x, y;
	
	public void move(int x, int y) { //추상클래스라고 해도 보통의 메소드를 가질 수 있다.
		this.x = x;
		this.y = y;
	}
	
	public abstract void draw();
	//추상메소드 선언. 추상 메소드를 하나라도 가지고 있으면 추상 클래스가 된다.
	//추상메소드를 가지고 있는데도 class 앞에 abstract를 붙이지 않으면 컴파일 오류가 발생한다.
};

public class Rectangle2 extends Shape2 { //추상클래스의 자식클래스에서는 부모가 가진 메소드를 반드시 구현해야 함. 아니면 오류발생
	int width, height;
	public void draw() { //추상 메소드 구현
		System.out.println("사각형 그리기 메소드");
	}

};

class Circle extends Shape2{
	int radius;
	public void draw() {
		System.out.println("원 그리기 메소드"); //서브클래스에서 실제 메소드로 구현.
	}
};



/* 
 * 추상 클래스:
 * 
 * 상속계층에서 추상적 개념을 표현함
 * 
 * 추상클래스는 완전하게 구현되어 있지 않은 메소드를 가지고 있는 클래스를 의미한다.
 * 메소드가 미완성 되어 있으므로 추상클래스로는 객체를 생성할 수 없다. 따라서
 * 주로 상속 계층에서 추상적인 개념을 나타내기 위한 용도로 사용된다.
 * 
 * 자바에서 추상클래스를 만들기 위해서는 클래스 선언 시 앞에 abstract를 붙여야 한다.
 * (추상 메소드를 가지고 있으면 추상클래스이다)
 * e.g.
 * 
 * public abstract class Animal{
 * 	public abstract void move(); //바디가 없고 ';'으로 종료된다.
 * };
 *  
 *  
 *  - 추상클래스라고 하더라도 추상 메소드가 아닌 보통의 메소드도 가질 수 있다.
 *  - 추상 메소드를 선언한다. 추상 메소드를 하나라도 가지면 추상 클래스가 된다.
 *  - 추상 메소드를 가지고 있는데도 abstract를 class 앞에 붙이지 않는다면 컴파일 오류가 발생한다.
 *  - 추상 클래스를 상속한 자식 클래스는 추상 메소드를 반드시 구현(implementaion)해야 한다.
 *  
 *  
 *  
 *  Q: 수퍼클래스에서 draw()를 void draw(){}와 같이 내용이 없는 일반 메소드로 정의한 후에
 *  서브 클래스에서 재정의(오버라이드) 하는 것과 추상 메소드와는 어떻게 다른가?
 *  
 *  A: 결과는 같다. 하지만 추상 메소드로 정의하면 서브 클래스에서는 반드시 구현하여야 하므로 
 *  구현(implementaion)을 강요하는 면에서 장점이 있다. 일반 메소드를 오버라이딩 하는 경우는
 *  의무가 아니기 때문에 재정의하지 않고 넘어갈 수도 있기 때문이다.
 *  
 *  
 *  
 *  
 *  */




