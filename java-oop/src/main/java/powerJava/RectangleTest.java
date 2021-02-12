// 상속과 생성자

package powerJava;


class Shape{
	public Shape(String msg) {
		System.out.println("Shape 생성자() " + msg);
	}
}						// 3. 수퍼클래스 생성자 실행이 끝나면 서브 클래스 생성자로 다시 돌아옴

class Rectangle extends Shape{
	public Rectangle() { // 2.수퍼클래스 생성자 호출
		super("from Rectangle");
		//명시적 호출(explicit invoke(call))
		//이걸 Shape("from Rectangle");로 적어주면 오류 발생(정의되어 있지 않다는 내용으로)
	}
}

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle r = new Rectangle(); // 1.서브클래스 생성자 호출

	}

}

/*
 * 서브 클래스의 객체가 생성될 때, 생성자는 어떻게 호출될까? 서브클래스의 생성자만 호출될까?
 * 아니면 수퍼클래스의 생성자도 호출되는가? 서브클래스의 객체는 수퍼클래스에서 상속된 부분과 서브클래스가 추가한 부분이
 * 합쳐져 있다고 생각하여야 한다. 서브 클래스의 생성자가 먼저 호출되기는 하지만, 수퍼클래스에서 상속된 부분을 먼저
 * 초기화 하기 위하여 수퍼클래스의 생성자가 먼저 실행되어야 한다. 나중에 서브클래스가 추가한 부분을 초기화 하기 위하여
 * 서브클래스 생성자가 실행된다.
 * 
 * 서브클래스 객체 생성-서브클래스 생성자 호출- 초기화 전 이 안에서 수퍼클래스 생성자 호출 - 수퍼클래스 초기화 실행 - 서브클래스 초기화 실행
 * 
 * 
 * 수퍼 클래스 호출 방식에 따라 두가지로 나뉨.
 * 
 * - 명시적 호출(explicit invoke)
 * - 묵시적 호출(implicit invoke)
 * 
 *  명시적 호출:
 *  
 *  자바에서는 명시적으로 수퍼클래스의 생성자를 호출할 수 있다. 이 때 위의 예제처럼 super()라는 키워드가 사용된다.
 *  this() 때와 마찬가지로 수퍼클래스의 생성자를 호출할 떄에도 기존 생성자 메소드의 가장 첫 줄에 써 주어야 한다.
 *  그렇지 않으면 컴파일 오류가 발생한다. 항상 서브 클래스의 생성자가 수퍼클래스의 생성자를 소출하기 떄문에 결국은
 *  Object 클래스까지 거슬러 올라가는 생성자 호출의 체인을 생각할 수 있다.
 *  
 *  -----------------------------------------------------
 *  묵시적 호출:
 *  
 *  자바에서는 명시적으로 수퍼 클래스의 생성자를 호출해주지 않아도,
 *  서브 클래스의 객체가 생성될 때 자동적으로 수퍼클래스의 생성자가 호출된다.
 *  
 * class Shape{
 *  public Shape(){
 *  	System.out.println("Shape 생성자()");
 *  }
 * }
 * class Rectangle extends Shape{
 * 	public Rectangle(){
 * 		//Shape();가 생략되어 있다고 보면 됨.
 * 		System.out.println("Rectangle 생성자()");
 * 	}
 * }
 * 
 * 
 * 만약 수퍼 클래스에 매개변수가 없는 생성자가 "없는" 경우에는 자바가 자동적으로 수퍼클래스에 
 * 매개변수가 없는 생성자(디폴트 생성자)를 추가하고 그것을 서브클래스에서 호출한다. 이 때에도 묵시적 호출의 형태를 띈다.
 * 
 * class Shape{
 * 	
 * }
 * public class Rectangle extends Shape{
 * 	public Rectangle(){
 * 		//보이지 않지만 Shape();를 자동으로 넣어줌. 
 * 	}
 * }
 * 
 * 그러나 만약 수퍼 클래스에 생성자가 하나라도 정의되어 "있는" 경우에는 디폴트 생성자를 자동으로 추가하지 않는다.
 * 
 * class  shape{
 * 	public Shape(String msg){
 * 		System.out.println("Shape 생성자()" + msg);
 * 		//디폴트 생성자는 없음!!!
 * 	}
 * }
 * public class Rectangle extends Shape{
 * 	public Rectangle(){
 * 		//오류! Shape()를 호출할 수 없음!!
 * 		System.out.println("REctangle 생성자()")
 * 	}
 * }
 *  ->> Implicit super constructor Shape() is undefined. Must Explicitly invoke another constructor
 *  
 *  
 *  위의 오류를 해결하려면 Rectangle() 생서자에서 super("test");와 같이 수퍼 클래스의 생성자를 명시적으로 호출해야 한다.
 *  
 */