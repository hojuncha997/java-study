//인터페이스 설명

package powerJava;

public class InterfaceExplanation {

}

/*
 * 인터페이스란?
 * 
 * 인터페이스란 추상클래스의 극단적인 경우이다. 인터페이스는 추상 메소드들로만 이루어진다.
 * 이들 추상 메소드는 특정 인터페이스를 따르는 클래스들을 위한 요구 조건(Requirements)의
 * 역할을 한다. 흔히 서비스를 제공하는 클래스는 서비스를 받는 클래스가 특정 인터페이스를 따르는 경우에만
 * 서비스를 제공할 수 있다.
 * 
 * 현실세계의 예로, 고속도로 톨게이트에서 하이패스 서비스를 받으려면 하이패스 규격을 따르는 단말기를
 * 가지고 있어야 한다. 자바에서도 마찬가지이다. 예를 들어, 객체가 정렬되려면 객체를 다른 객체와
 * 비교할 수 있는 인터페이스를 가지고 있어야 한다.
 * 
 * 자바에서의 인터페이스는 객체와 객체 사이의 상호 작용이 이루어지는 인터페이스를 의미한다.
 * 인터페이스를 정의하는 것은 클래스를 정의하는 것과 유사하다. 인터페이스는
 * 
 * - 추상 메소드
 * - 상수
 * 
 * 로 이루어진다. 인터페이스 안의 모든 메소드는 추상메소드로 간주되기 때문에, 
 * abstract 예약어를 반드시 사용할 필요는 없다.
 * 인터페이스 안에서 필드는 선언될 수 "없다".
 * 
 * e.g.
 * 
 * public interface 인터페이스_이름 {
 * 	반환형 추상메소드1(...);
 * 	반환형 추상메소드2(...);
 * }
 * 
 * 
 * 추상클래스처럼 인터페이스도 인스턴스를 생성할 수 없다. 다만 다른 클래스에 의하여
 * 구현(implementaion)될 수는 있다. 이것은 인터페이스에 정의된 추상메소드의 
 * 몸체{}를 정의한다는 의미이다.
 * 
 * e.g.
 * 
 * public class 클래스_이름 implements 인터페이스_이름 {
 * 	반환형 추상메소드1(...){
 * 		...
 * 	}
 * 	
 * 	반황형 추상메소드2(...){
 * 		...
 * 	}
 * }
 * 
 * 
 *	인터페이스의 필요성과 예
 *
 * 홈네트워크 시스템을 생각하여 보자. 홈네트워크 시스템은 가정에서 쓰이는 모든 가전 제품들이
 * 유무선 하나의 시스템으로 연결, 쌍방향 통신이 가능한 시스템을 말한다. 가전 제품과 홈네트워크
 * 서버 사이에는 가전 제품을 제어할 수 있는 일종의 표준 규격이 필요하다. 자바로 작성한다면
 * 이 표준 규격은 바로 인터페이스로 구현된다.
 * 
 * 가전제조사들은 가전 제품을 원격 제어할 수 있도록 제품을 제어할 수 있는 소프트웨어를 내장하여 제공한다.
 * 반면 홈네트워크 서버에서는 모든 가전 제품을 제어할 수 있는 통일된 방법이 필요하다.
 * 따라서 둘 사이에는 어떤 약속이 필요하게 되고 구체적으로 원격으로 제어하는 데 필요한
 * 메소드들에 대하여 합의하여야 한다. 가전제품 안에서 메소드가 어떻게 구현되는가는
 * 전혀 필요가 없다. 외부에서 메소드를 호출하여 사용할 수 있으면 그것으로 충분하다.
 * 이것이 인터페이스의 개념이다.
 * 
 * 일단 인터페이스가 디자인되면, 클래스 간의 통합에 대하여 걱정할 필요 없이 각 클래스들은 별도의
 * 팀에 의해 병렬적으로 작성될 수 있다.
 * 
 * e.g.
 * public interface RemoteControl {
 * 	public void turnOn();
 * 	public void turnOff();
 * }
 * 
 * 여기서 메소드들은 모두 시그니처만 존재하고, 몸체가 없으며 세미콜론으로 종료된다는 점에 유의해야 한다.
 * 인터페이스는 안에서 선언되는 메소드들은 모두 묵시적으로 public abstract이다. 따라서 public이나
 * abstract 수식어는 없어도 된다.
 * 
 * 클래스가 인터페이스를 구현하기 위해서는 implements 키워드를 사용한다.
 * 
 * e.g.
 * 
 * public class Television implements RemoteControl{
 * 	public void turnOn(){
 * 		...
 * 	}
 * 	public void turnOff(){
 * 		...
 * 	}
 * }
 * 
 * 
 * TV 생산 업체마다 인터페이스를 다르게 구현할 것이다. 하지만 여전히 동일한 제어 인터페이스인
 * RemoteControl 인터페이스를 지원한다. 따라서 홈네트워크 서버에서는 이들 인터페이스들을
 * 호출하여 가전제품을 원격 조정할 수 있다.
 * 
 * 
 * Television t = new Television();
 * t.turnOn();
 * t.turnOff()
 * 
 * 냉장고도 마찬가지이다.
 * 
 * Refrigerator r = new Refrigerator();
 * r.turnOn();
 * r.turnOff();
 * 
 * @@인터페이스를 어떤 클래스가 사용하기 위해서는 인터페이스에 포함된 모든 추상 메소드를 구현하여야 한다.
 * 클래스가 인터페이스에 있는 하나의 메소드라도 빠뜨린다면 컴파일러는 그 클래스가 추상클래스로
 * 정의되어야 한다고 지적할 것이다. 추상클래스와 마찬가지로 인터페이스는 인터페이스와 같은 이름을 가진
 * 확장자가 .java인 파일에 단독으로 저장된다.
 * 
 * 
 * 		인터페이스와 타입
 * 
 * 인터페이스는 하나의 타입(type)으로 보아야 한다. 이 타입은 인터페이스를 구현한 클래스들을 하나로 묶는
 * 역할을 한다. 인터페이스의 이름은 클래스의 이름과 마찬가지로 참조변수를 정의하는 데 사용될 수 있다.
 * 만약 인터페이스 타입의 참조 변수를 정의하였다면 이 변수에 대입할 수 있는 값은 반드시 그 인터페이스를
 * 구현한 클래스의 객체이어야 한다.
 * 
 * RemoteControl obj = new Television();
 * obj.turnOn();
 * obj.turnOff();
 * 
 * 
 * - Television 객체이지만 RemoteControl 인터페이스를 구현하기 때문에 RemoteControl타입의
 * 변수를 가리킬 수 있다. (Television 객체를 생성하였지만 Television 참조변수로 가리키지 않고
 *  RemoteControl 참조변수로 가리키고 있다.)
 * 
 * - obj.를 통해서는 RemoteControl인터페이에 정의된 메소드만을 호출할 수 있다. 
 * (인터페이스 참조 변수를 통해서는 그 인터페이스 안에 정의된 메소드만을 호출할 수 있다.
 * 다른 메소드나 필드에는 접근할 수 없다.
 * 
 * 
 * 		여러 개의 인터페이스 동시 구현
 * 
 * 하나의 클래스는 하나 이상의 인터페이스를 구현할 수도 있다. 텔레비젼이 시리얼 통신을 할 수 있는
 * 인터페이스도 가지고 있다고 가정하자. 시리얼 통신을 위한 인터페이스를 SerialCommunication이라 하자.
 * 
 * public interface SerialCommunication {
 * 	void send(byte[] data);
 * 	byte[] receive();
 * }
 * 
 * Television 클래스에서 RemoteControl과 SerialCommunication이라는 두 개의 인터페이스를 동시에 구현할 수 있다.
 * 
 * public class Television implements RemoteControl, SerialCommunication {
 * 	//RemoteControl과 SerialCommunication의 메소드를 동시에 구현하여야 한다.
 * 
 * 	public void turnOn() { ... }
 * 	public void turnOff() { ... }
 * 	public void send(byte[] data) { ... }
 * 	public byte[] receive { ... }
 * 
 * }
 * 
 * 		인터페이스 상속하기
 * 
 * 기존에 다른 클래스에서 상속하여 사용하던 인터페이스를 수정하면 어떻게 될까?
 * 
 * public interface RemoteControl {
 * 	public void turnOn();
 * 	public void turnOff();
 * }
 * 
 * 여기에 새로운 메소드를 추가하면 어떻게 될까?
 * 	public void volumeUp(); 
 * 	public void volumeDown();
 *
 *  그러면 이 인터페이스를 구현하였던 모든 클래스가 동작하지 않게 된다.
 *  이런 경우를 대비하여 인터페이스도 상속을 받아 확장시킬 수 있도록 되어 있다.
 *  
 *  public interface AdvanceRemoteControl extends RemoteControl	{
 *  	public void volume();
 *  	public void volumeDown();
 *  }
 *  
 *  이 경우 인터페이스의 사용자들은 예전의 인터페이스를 계속 사용할 것인지 아니면 새로운
 *  버전으로 업그레이드 할 것인지를 선택할 수 있다. 클래스와는 다르게 인터페이스는 여러 개의
 *  인터페이스로부터 상속을 동시에 받을 수 있다. 콤마로 분리하여서 부모 인터페이스를 적어주면 된다.
 *  클래스는 하나의 부모로부터만 상속받을 수 있음을 유의해야 한다. (구현은 여러 개 가능하다.)
 *  
 *  
 *  
 *  		인터페이스의 활용
 *  
 *  인터페이스의 다중상속: 인터페이스는 일반적인 인스턴스 변수(=멤버번수=필드)와 메소드를 가지지 않기 때문에
 *  다중상속에서 나타나는 복잡한 문제들이 나타나지 않음.
 *  
 *  class SuperA {int x;}
 *  class SuperB {int x;}
 *  class Sub extends SuperA, SuperB //이게 된다면.
 *  {
 *  	...
 *  }
 *  Sub obj = new Sub();
 *  obj.x = 10; //어떤 수퍼클래스의 x를 참조할까?
 *  
 * 이런 복잡한 문제 때문에 자바에서는 하나의 클래스는 오직 하나의 클래스부터만 상속을 받을 수 있다.
 * 하지만 클래스는 상속과 동시에 여러 개의 인터페이스를 구현할 수 있다. 이것이 다중 상속의 효과를 낸다.
 * 
 *  class Sub extends Super implements Interface1, Interface2 {
 *  
 *  }
 * 
 * 아럐의 Rectangle은 Shape로부터 상속을 받고 동시에 Drawable 인터페이스를 구현하고 있다.
 * 
 * class Shape {
 * 	protected int x, y;
 * }
 *
 * interface Drawable {
 * 	void draw();
 * };
 * 
 * public class Rectangle extends Shape implements Drawable {
 * 	int width, height;
 * public void draw(){
 * 		System.out.println("Rectangle Draw");
 * 	}
 * };
 * 
 * 
 * 		인터페이스와 추상클래스
 * 
 * 인터페이스는 추상클래스와도 비슷하다. 추상클래스는 추상 메소드 때문에 부분적으로 미완성된
 * 클래스라고 했다. 인터페이스는 완전히 미완성된 채로 남겨진 추상클래스이다.
 * 
 * 인터페이스와는 다르게 추상클래스는 일반적인 필드나 메소드를 가질 수 있다. 그러한 추상 클래스는
 * 일부의 구현을 제공한다는 점에서만 인터페이스와 차이가 있다. 왜 인터페이스라는 개념을 귀찮게
 * 도입하는 것일까? 그냥 추상 클래스로 처리하면 안되는가? 그 이유는 자바가 다중 상속을 지원하지
 * 않는다는 점에 있다.
 * 
 * 		상수정의
 * 
 * 인터페이스의 또 다른 용도는 여러 클래스에서 사용되는 상수들을 정의하는 것이다. 상수는 대개
 * 정적 변수로 선언된다.
 * 
 * interface Days{
 * 	public static final int SUNDAY=1, MONDAY=2, TUESDAY=3, WEDNESDAY=4,
 * 		THURSDAY=5, FRIDAY=6, SATURDAY=7;
 *
 * }
 * 
 * 인터페이스 Days를 구현하는 클래스들은 자동적으로 인터페이스에 정의된 상수들을 사용할 수 있다.
 * 
 * public class DayTest implements Days{
 * 	public static void main(String[] args){
 * 		System.out.println("일요일" + SUNDAY);
 * 	}
 * }
 * 
 * 
 *
 * 			다형성(Polymorphism)
 * 
 * 다형성이란 객체들의 타입이 다르면 똑같은 메시지가 전달되더라도 서로 다른 동작을 하는 것을 말한다.
 * 메시지를 보내는 측에서는 객체가 어떤 타입인지 알 필요가 없다. 실행 시간에 객체의 타입에 따라
 * 자동적으로 적합한 동작이 결정된다. 다형성은 객체지향 기법에서 하나의 코드로 다양한 타입의 객체를 처리하는
 * 중요한 기술이다. 
 * 
 * 			상향 형변환(upcasting)
 * 
 * 서브 클래스의 객체는 수퍼 클래스의 객체처럼 취급될 수 있다. 왜냐하면 서브 클래스 객체 안에는
 * 수퍼 클래스 객체가 포함되어 있다고 생각할 수 있기 때문이다. 반대로 수퍼클래스의 객체는 분명히
 * 서브클래스의 객체가 아니다. 자바에서는 수퍼 클래스 객체가 있는 곳을 서브클래스 객체로 대치하는 것이
 * 가능하다. 이를 상향 형변환이라고 한다.
 * 
 * 하나의 예로 Rectangle, Triangle, Circle 등의 도형클래스가 수퍼 클래스인 Shape 클래스로부터
 * 상속되었다고 가정하자.
 * 
 * Shape s;
 * s = new Shape(); 	// 당연함
 * s = new Rectangle();	// OK, Rectangle 객체도 가리킬 수 있다.
 * 
 * Rectangle 타입의 객체가 생성되어서 Shape 타입의 참조변수에 대입되는 문장은 오류처럼 보인다.
 * 그러나 서브클래스 객체는 수퍼 클래스 객체처럼 취급을 받을 수 있기 때문에 위의 문장은 적법하다.
 * 즉 수퍼클래스 참조 변수로 서브 클래스 객체를 참조할 수 있다. 위의 문장은 다형성의 핵심이 되므로
 * 잘 이해해야 한다.
 * 
 * 그렇다면 수퍼클래스 참조변수로 서브 클래스 객체를 참조하였을 경우에 s를 통하여 서브 클래스의
 * 모든 필드와 메소드를 사용할 수 있을까? 그렇지는 않다. 서브클래스 중에서 수퍼클래스로부터
 * 상속받은 부분만을 s를 통해서 사용할 수 있고 나머지는 사용하지 못한다. 즉 Rectangle 객체 중에서
 * Shape로부터 상속받은 부분은 s를 통해서 사용할 수 있지만 Rectangle 객체의 다른 부분은
 * s를 통햇 사용할 수 없는 것이다. s는 Shape 타입의 참조변수이기 때문이다.
 * 
 * class Shape {
 * 		int x, y;
 * }
 * 
 * class Rectangle extends Shape {
 * 		int width, height;
 * }
 * 
 * public class ShapeTest{
 * 	public static void main(String[] args){
 * 		Shape s;
 * 
 * 		Rectangle r = new Rectangle();
 * 		s = r; // 수퍼클래스의 참조변수로 서브클래스의 객체를 가리키는 것은 합법적이다.
 * 		s.x = 0;
 * 		s.y = 0;
 * 		s.width = 100; //오류발생:width cannot be resolved or is not a field
 * 		s.height = 100;//오류발생:height cannot be resolved or is not a field
 * 	}
 * }
 *
 * 			하향 형변환(downcasting)
 * 
 * 상향 형변환의 반대가 하향 형변환이다. 이것은 서브클래스 참조변수로 수퍼 클래스 객체를 참조하는 것으로
 * 일반적인 상황에서는 컴파일 오류이다.
 * 
 *  Rectangle r;
 *  r = new Shape(); // NOT OK!
 *  결과:  Type mismatch : cannot convert from Shape to Rectangle 
 * 
 * 그러나 만약 서브클래스 객체인데 형변환에 의하여 일시적으로 수퍼클래스 참조변수에 의하여
 * 참조되고 있는 경우에는 하향 형변환을 통해 원래 상태로 되돌릴 수 있다. 이 때에는 반드시
 * 명시적으로 형변환 연산자를 적어주어야 한다.
 * 
 * Rectangle r;
 * Shape s;
 * s = new Rectangle();
 * 
 * r = (Rectangle)s;
 *  //하향 형변환: r을 통하여 다시 Rectangle 클래스의 모든 멤버에 대한 접근이 가능해짐.
 * 
 * r->width = 100;
 * r->height = 100;
 * 
 * 
 * 			객체의 타입을 알아내는 방법
 * 
 * 때로는 참조 변수가 현재 실제로 어떤 객체를 참조하고 있는지를 알아야 하는 경우도 있다.
 * 상향 형변환 때문에 참조 변수가 가리키는 객체의 실제 타입을 알기가 어려운 경우도 있다.
 * 
 * Shape s = getShape();
 * 이 경우 s가 가리키는 객체의 실제타입은 Shape가 될 수도 있지만, REctangle 또는 Circle일 수도 있다.
 * 
 * 이 경우 상요할 수 있는 연산자가 instanceof이다. (A instanceof B)는 객체 A가 타입 B이면 
 * true를 반환한다.
 * 
 * Shape s = getShape(); //getShape()가 반환한 객체가 무엇인지 아직 모름.
 * if(s instanceof Rectangle){
 * 		System.out.println("Rectangle이 생성되었습니다.")
 * }else{
 * 		System.out.println("Rectangle이 아닌 다른 객체가 생성되었습니다.");
 * }
 * 
 * 			다형성의 이용
 * 
 * 단순히 서브 클래스 객체를 수퍼 클래스 객체로 취급하는 것이 어디에 쓸모가 있을까?
 * 몇 가지의 용도가 있다.
 * 첫 번째로 메소드의 매개변수를 선언할 때, 다형성을 많이 이용한다. 일반적으로
 * 메소드 매개변수는 서브 클래스보다는 수퍼 클래스 타입으로 선언하는 것이 좋다.
 * 예를 들어 Shape와 Rectangle 객체를 받는 메소드를 별도로 선언하는 것보다
 * Shape 객체만을 받는 메소드를 선언하는 것이 좋다. shape타입으로 선언하면
 * Shape에서 파생된 모든 객체를 받을 수 있기 때문이다. 필요하면 메소드 안에서
 * 객체의 타입은 instanceof 연산자를 사용하여 쉽게 알 수 있다.  
 * 
 * 아래의 코드에서는 Shape타입으로 정의된 매개변수를 이용해 도형의 면적을 구한다.
 * 
 * public static double calArea(Shape s){ //Shape에서 파생된 모든 클래스의 객체를 받을 수 있다.
 * 	double area = 0.0;
 * 	if(s instanceof Rectangle){ //만약 s가 Rectangle객체이면 면적을 구한다.
 * 		int w = ((Rectangle) s).getWidth();
 * 		int h = ((Rectangle) s).getHeight();
 * 		area = (double) (w*h);
 * 	}
 * ... // 다른 도형들의 면적을 구하는 코드를 작성한다.
 * return area;
 * }
 * 
 * 
 * 만약 자바에서 생성되는 모든 객체를 전부 받는 메소드를 선언한다면 어떻게 해야 하는가?
 * 모든 객체는 Object 클래스를 상속 받는다. 따라서 다음과 같이 정의하면 된다.
 * 
 * public void print(Object obj){
 * ... //모든 타입의 객체를 전부 받을 수 있다. 필요하면 다른 타입으로 형변환해서 사용한다.
 * }
 * 
 * 두 번째 용도는 다형성을 메소드 오버라이딩과 연결시켜서 객체들이 동일한 메시지를 받더라도
 * 각 객체의 타입에 따라서 서로 다른 동작을 하게 할 수 있다.
 * 모든 도형 클래스는 화면에 자신을 그리기 위한 메소드를 포함하고 있다. 이 메소드의 이름을
 * draw()라고 하자. 이 도형을 그리는 방법은 당연히 도형에 따라 다르다. 따라서 도형의
 * 종류에 따라 서로 다른 draw()를 호출해야 한다. Shape가 draw() 메소드를 가지고 있고
 * Rectangle, Triangle, circle 클래스들이 이 draw() 메소드를 오버라이딩하였을 경우,
 * Shape 참조 변수를 통하여 각 객체들의 draw() 메소드를 호출한다면
 * 
 * Shape  s = new Rectangle(); //OK
 * s.draw; //Shape이 아닌 Rectangle의 draw()가 호출된다.
 * 
 * s의 타입은 Shape이지만 실제로 가리키고 있는 객체의 타입이 Rectangle이기 때문이다.
 * 
 * 자바에서는 메소드 호출 시에 참조 변수가 실제로 가리키는 객체에 따라 메소드가 자동적으로 선택된다.
 * 따라서 도형을 그릴 때 모든 도형을 수퍼 클래스인 Shape의 참조로 가리키고 각 객체의 draw()
 * 메소드를 호출하면 도형에 따라서 서로 다른 draw()가 동적으로 선택된다.
 * 
 * 그렇다면 어떻게 Rectangle의 draw()가 호출되는 것일까? 메소드 호출을 실제 메소드의
 * 몸체와 연결하는 것을 바인딩(binding)이라고 한다. C언어에서는 컴파일 단계에서 모든 바인딩이
 * 완료되지만 자바에서는 바인딩이 실행 시까지 연기된다. 자바에서는 실행 단계에서 타입을 보고
 * 적절한 메소드를 호출하게 된다. 이것을 동적바인딩(Dynamic Binding)이라고 한다.
 * 
 *  p286
 * 
 * 
 * 			내부클래스(inner class)
 * 
 * 자바에서는 하나의 클래스 안에 다른 클래스를 정의할 수 있다. 이것을 내부 클래스라고도 한다.
 * 
 * public class OuterClass{
 * 	...
 * 		private class InnerClass{
 * 			... //외부 클래스의 모든 멤버를 자유롭게사용할 수 있다.
 * 		}
 * }
 * 
 * 필드나 메소드와 마찬가지로 내부 클래스도 멤버이다. 내부 클래스의 정의는 클래스의 어떤 위치에서도 가능하다.
 * 내부 클래스는 클래스의 모든 멤버를 참조할 수 있다. private로 선언되어 있는 맴버도 내부 클래스는
 * 참조할 수 있다.
 * 
 * 내부 클래스는 반드시 private일 필요는 없지만 많은 경우 private으로 정의된다. 만약 private으로
 * 정의되면 정의된 클래스 안에서만 사용이 가능하다. 내부 클래스 객체도 정의된 클래스의 객체 안에 위치한다.
 * 
 * 왜 내부 클래스를 사용하는가?
 * 
 * - 특정 멤버변수를 외부에서 자주 사용한다고 할 때 이것을 효율적으로 구현하기가 상당히 어렵다. 하지만
 * 특정 멤버 변수를 public으로 선언하는 것은 캡슐화의 개념에 어긋난다. 이런 경우에 내부 클래스를
 * 사용하게 되면 특정한 멤버 변수를 private으로 유지하면서 자유롭게 사용할 수 있다. 특히
 * 그래픽 이벤트 처리기를 구현할 때 많이 사용된다.
 * 
 * - 하나의 장소에서만 사용되는 클래스들을 한곳에 모을 수 있다. 만약 클래스가 하나의 장소에서만
 * 필요하다면 클래스를 분리하는 것보다 클래스 내부에 위치시키는 것이 가독력이 좋아진다.
 * 
 * - 보다 읽기 쉽고 유지보수가 쉬운 코드가 된다. 작은 클래스를 내장시키는 것은 클래스가 사용되는
 * 위치에 더 가깝게 두는 것이다.
 * 
 * class OuterClass{
 * 	private String secret = "Time is money";
 * 
 * 	public OuterClass(){
 * 		InnerClass obj = new InnerClass();
 * 		obj.print();
 * 	}
 * 
 * 	private class InnerClass {
 * 		public InnerClass(){
 * 			System.out.println("내부클래스 생성자입니다.");
 * 		}
 * 
 * 		public void print(){
 * 			System.out.println(secret);
 * 		}
 * 	}
 * }
 * 
 * public class OuterClassTest{
 * 	public static void main(String[] args){
 * 		new OuterClass();
 * 	}
 * }
 * 
 * : 내부클래스 생성자입니다.
 * : Time is money
 * 
 * 
 * 
 * 			무명 클래스(anonymous class)
 * 
 * 무명 클래스는 클래스 몸체는 정의되지만 이름이 없는 클래스이다.
 * 무명클래스는 클래스를 정의하면서 동시에 객체를 생성하게 된다. 이름이 없기 때문에 한 번만 사용이 가능하다.
 * 무명 클래스는 코드의 양을 줄일 수 있는 장점도 있지만 반면에 표기법이 상당히 난해하다.
 * 무명 클래스는 하나의 객체만 생성하면 되는 경우에 많이 사용된다.
 * 
 * new ClassOrInterface{클래스 몸체}
 * 			↑상속받고자 하는 수퍼클래스의 이름이나 구현하고자 하는 인터페이스의 이름을 적어준다.
 * 
 * 무명 클래스는 수퍼 클래스에서 상속을 받아 작성하거나 인터페이스를 구현하여 작성할 수 있다.
 * new 키워드 다음에 수퍼 클래스 이름이나 인터페이스 이름을 적어주면 된다. 수퍼클래스 이름을 적으면
 * 그 수퍼 클래스에서 상속을
 * 
 * 
 * 
 */