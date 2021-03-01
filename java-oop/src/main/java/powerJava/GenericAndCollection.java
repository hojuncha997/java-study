package powerJava;

public class GenericAndCollection {

}

/*
 *
 * 
 * 제네릭과 컬렉션
 * 
 * - 제네릭은 하나의 코드를 여러 타입에 대하여 재사용할 수 있도록 해주는 기술 중의 하나이다.
 * - 컬렉션이란 프로그래밍에 필요한 다양한 자료 구조들을 제네릭 형식으로 제공해주는 자바 라이브러리이다.
 * 
 * 
 * 1. 제네릭 클래스
 * 
 * 제네릭이란?
 * 
 * 제네릭 프로그래밍(generic programming)이란 일반적인 코드를 작성하고 이 코드를 다양한 타입의 객체에 대하여
 * 재사용하는 객체 지향 기법이다. 제네릭은 자바 버전 1.5부터 추가된 기능으로 이것을 사용하면 복잡한 애플리케이션을
 * 개발할 때 발생하는 여러 가지 버그들을 많이 줄일 수 있따. 제네릭도 안드로이드와 같은 애플리케이션을 개발할 때
 * 많이 사용되므로 정확하게 알고 있어야 한다. c++ 언어의 탬플레이트와 거의 유사한 기능이다.
 * 
 * 
 * 
 * class Box<T>{...}  // 제네릭 클래스
 * 		==> class Box<String>{...} //String을 저장하는 Box
 * 		==> class Box<Integer>{...} //Integer를 저장하는 Box
 * 
 * 
 * 제네릭을 한마디로 말하자면 "클래스를 정의할 때, 구체적인 타입(type)을 적지 않고 변수 형태로 적어 놓는 것"이다.
 * 클래스를 사용하여서 객체를 생성할 떄, 구체적인 타입을 적어주면 된다. 즉 타입을 클래스의 매개변수로 만든 것이다. 
 * 위의 선언에서 Box클래스는 데이터를 저장하는 클래스이다. Box 클래스 안에 저장되는 데이터의 타입을 구체적으로
 * 적지 않고 T라고 하는 타입 매개변수로 표시한다. Box에 저장되는 구체적인 타입은 Box의 객체를 생성할 때 
 * 적어주면 된다.
 * 
 * 기존의 방법
 * :
 * 
 * 자바 버전 1.5 이전에 제네릭 프로그래밍을 사용하려면 다형성을 이용하여야 했다. 즉 객체를 Object 타입으로 받아서
 * 처리하는 방법을 사용하였다. 간단한 예제를 들어서 설명해 보자. 먼저 단 하나의 데이터만을 저장할 수 있는 Box라는
 * 간단한 클래스를 작성하여 보자. 어떤 타입의 데이터라도 저장할 수 있게 하려면 앞에서 학습한 다형성을 사용하여서
 * Object 타입으로 받아서 내부에 저장하여야 한다.
 * 
 * public class Box{
 * 	private Object data;
 * 	public void set(Object data) {this.data = data;}
 * 	public Object get() {return data;}
 * }
 * 
 * 실제로 Box 클래스는 여러 가지 다양한 타입의 데이터를 지정할 수 있다.
 * 
 * Box b = new Box();
 * b.set(new Integer(10)); //Integer 객체 저장
 * b.set("Hello World!"); //정수 객체가 없어지고 String 객체를 저장
 * String s = (String)b.get(); /// Object  타입을 String 타입으로 형변환
 * 
 * 이렇게 다양한 형태의 데이터를 담을 수 있는 이유는 데이터를 Object 참조 변수로 받아서 저장하기 때문이다.
 * 모든 객체는 궁극적으로 Object의 자손이다. 따라서 다형성에 의하여 Object 참조 변수는 어떤 객체든지
 * 참조할 수 있는 것이다.
 * 
 * 이것은 상당히 편리한 기능이지만 몇 가지의 문제가 있다. 먼저 데이터를 꺼낼 때마다 항상 타입 변환을
 * 해야 한다는 점이다. 더 심각한 문제는 문자열을 저장하고서도 부주의하게 Integer 객체로 형변환을 할 수도 있으며
 * 이것은 실행 도중에 오류를 발생시킨다.
 * 
 * b.set("Hello World!");
 * Integer i = (Integer)b.get(); //오류! 문자열을 정수 객체로 형변환
 * 
 * 
 * 
 * 제네릭을 이용한 방법
 * :
 * 제네릭 기법을 이용학 되면 앞의 문제들을 모두 해결할 수 있다. 앞에서 기술한 Box라는 클래스를 제네릭 클래스로
 * 작성하여 보자. 제네릭 클래스(generic class)에서는 타입을 변수로 표시한다. 이것을 타입 매개변수(type parameter)라고
 * 하는데 타입 매개변수는 객체 생성 시에 프로그래머에 의하여 결정된다. 제네릭 클래스는 다음과 같은 형식을 사용한다.
 * 
 * class name<T1, T2, ..., Tn> {...}
 * 
 * 타입 매개변수는 < > 안에 표기된다. T1, T2, ..., Tn은 모두 타입 매개변수이다.
 * 
 * Box 클래스를 제네릭으로 다시 작성하여 보면 다음과 같다.
 * 
 * pubic class Box<T> { // T는 타입 매개변수이다..
 * 	private T data;
 * 	public void set(T data){this.data = data;}
 * 	public T get() {return data;}
 * }
 * 
 * 앞의 코드와 비교하여 보면 제네릭 클래스에서는 타입을 표시하는 자리에 Object 대신에 T가 사용되고 있음을 알 수 있다.
 * 타입 매개변수는 클래스 타입, 인터페이스 타입, 배열 타입 등을 나타낼 수 있다. 보통은 대문자를 이용하여 타입 변수를 표시한다.
 * 
 * 타입 매개변수의 값은 객체를 생성할 때에 구체적으로 결정된다. 예를 들어서 문자열을 저장하는 Box 클래스의 객체를 생성하려면
 * T 대신에 String을 사용하면 된다.
 * 
 * Box<String> b = new Box<String>();
 * 
 * 만약 정수를 저장하는 Box 클래스의 객체를 생성하려면 다음과 같이 T 대신에 <Integer>를 사용하면 된다.
 * 
 * Box<Integer> b = new Box<Ingeger>();
 * 
 * 하지만 int는 사용할 수 없는데, int는 기초 자료형이고 클래스가 아니기 때문이다.
 * 
 * 
 * 문자열을 저장하는 객체를 생성하여 사용하면 다음과 같다.
 * 
 * Box<String> b = new Box<String>();
 * b.set("Hello World");  //문자열 타입 저장
 * String s = Box.get();
 * 
 * 만약 Box<String>에 정수 타입을 추가하려고 하면 컴파일러가 컴파일 단계에서 오류를 감지할 수 있다.
 * 따라서 더욱 안적하게 프로그래밍할 수 있다.
 * 
 * Box<String> stringBox = new Box<String>();
 * stringBox.set(new Integer(10));  //정수ㅏ입을 저장하려고 하면 컴파일 오류!
 * 
 * ====
 * The method set(String) in the type Box<String> is not applicable for
 * the arguments(Integer) at GenericTest.main(GenericTest.java: 27)
 * 
 * 
 *
 * 타입 매개변수의 표기
 * :
 * 한 가지 주의할 점은 제네릭 클래스는 여러 개의 타입 매개변수를 가질 수 있으나 타입의 이름은
 * 클래스나 인터페이스 안에서 유일하여야 한다. 관례에 의하여 타입의 이름은 하나의 대문자로 한다.
 * 이것은 변수의 이름과 타입의 이름을 구별할 수 있게 하기 위함이다. 대게 많이 사용되는 이름은
 * 다음과 같다.
 * 
 * - E - Element(요소: 자바 컬렉션 라이브러리에서 많이 사용된다)
 * - K - Key
 * - N - Number
 * - T - Type
 * - V - Value
 * - S, U, V 등 - 2번째, 3번째, 4번째 타입
 * 
 * 
 * 
 * 다이아몬드:
 * 
 * 자바 SE7 버전부터는 제네릭 클래스의 생성자를 호출할 때, 타입 인수를 구체적으로 주지 않아도 된다.
 * 컴파일러는 문맥에서 타입을 추측한다. <>을 다이아몬드라고 한다. 예를 들어서 다음과 같이 쓸 수 있다.
 * 
 * Box<String> Box = new Box<>(); 
 * //생성 시 구체적인 타입을 주지 않아도 된다. 원래는 다이아몬드 안에 String이 들어갔어야 할 것이다.
 * 
 * 
 * 
 * 다중 타입 매개변수(Multiple Type Parameters)
 * : 제네릭 클래스는 다중 타입 매개변수를 가질 수 있다. 예를 들어서 2개의 데이터를 순서대로 저장하는
 * 클래스를 정의하여 보자.
 * 
 * public interface Pair<K, V> {
 * 	public K getKey();
 * 	public V getValue();
 * }
 * 
 * public class OrderedPair<K, V> implements Pair<K, V> {
 * 	private K key;
 * 	private V value;
 * 
 *	public OrderPair(K key, V value){
 *		this.key = key;
 *		this.value = value;
 *	}
 *
 *	public K getKey() {return key;}
 *	public V getValue() {return value;}
 * }
 * 
 * 위의 정의를 이용하여서 객체를 생성해 보면 다음과 같다.
 * 
 * Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
 * Pair<String, String> p2 = new OrderedPair<String, String>("hello", "world");
 *
 * 여기서 p1과 p2는 인터페이스 Pair 참조변수로 선언되었다. new OrderedPair<String, Integer>은
 * K를 String으로 실체화 하고 V를 Integer로 실체화 한다. 오토박싱(autoboxing)에 의하여 int가 
 * Integer 객체로 자동으로 변환된다. 오토박싱이란 기초 자료형을 대응되는 클래스 객체로 자동으로 변환해 주는 기능이다.
 * 
 * 
 * 
 * Raw 타입
 * :
 * Raw 타입은 타입 매개변수가 없는 제네릭 클래스의 이름이다. 예를 들어서 앞의 Box 클래스의 경우, 다음과 같이 
 * 객체를 생성하는 것이 원칙이다.
 * 
 * Box<Integer> intBox = new Box<>();
 * 
 * 위의 문장에서 만약에 타입 인수가 생략된다면 이것이 Raw 타입이 된다.
 * 
 * Box rawBox = new Box();
 * 
 * 즉 제네릭 클래스인 Box<T>에서 Box라고 적으면 이것이 Raw 타입이 된다. 그러나 혼동하지 않아야 될 것은
 * 처음부터 제네릭 클래스가 아니면 Raw 타입이라고 하지 않는다.
 * 
 * Raw 타입은 JDK 5.0 이전에는 제네릭이 없었기 때문에 이전 코드와 호환성을 유지하기 위하여 등장했다.
 * 즉 타입을 주지 않으면 무조건 Object 타입으로 간주하는 것이다.
 * 
 * Box<String> stringBox = new Box<>();
 * Box rawBox = stringBox; // ok - 타입이 오브젝트라고 가정한다.
 * 
 * 
 * 
 * ---------
 * 
 * 2. 제네릭 메소드
 * :
 * 지금까지 제네릭 클래스를 정의하는 방법을 학습하였다. 하지만 일반 클래스의 메소드에서도 타입 매개변수를
 * 사용하여서 제네릭 메소드를 정의할 수 있다. 이 경우에는 타입 매개변수의 범위가 메소드 내부로 제한된다.
 * 
 * 예를 들어서 주어진 배열에서 마지막 배열 원소를 반환하는 제네릭 메소드를 작성하여 보자.
 * 
 * public class Array
 * {
 * 	public static <T> T getLast(T[] a) // T타입 배열을 입력받고 T타입을 반환함
 * 	{
 * 		return a[a.length-1]; //배열의 가장 마지막 원소의 값을 반환
 * 	}
 * }
 * 
 * 메소드 getLast()는 일반 클래스 안에서 정의되어 있다. 그러나 <T>를 가지고 있으므로 제네릭 메소드이다.
 * 타입 매개변수는 반드시 메소드의 수식자와 반환형 사이에 위치되어야 한다.
 * 제네릭 메소드를 호출하기 위해서는 실제 타입을 꺽쇠 안에 넣어준다.
 * 
 * String[] language = {"C++", "C#", "JAVA"}; //String 타입의 배열 language.
 * String last = Array.<String>getLast(language); // last는  "JAVA"
 *
 * 이 특징을 사용하면 제네릭 메소드를 일반 메소드처럼 호출할 수 있다.
 * 
 * 
 * 
 * 한정된 타입 매개변수(bounded type parameter)
 * :
 * 때때로 타입 매개변수로 전달되는 타입의 종류를 제한하고 싶은 경우가 있다. 예를 들어서 특정한 종류의 
 * 객체들만을 받게 하고 싶은 경우가 있다. 이런 경우에 사용할 수 있는 것이 한정된 타입 매개변수이다.
 * 이 기능을 사용하기 위해서는 extends라는 키워드를 사용한다.
 * 
 * 예를 들어서 배열 원소 중에서 가장 큰 값을 반환하는 제네릭 메소드를 작성하여 보자.
 * 
 * public class Array
 * {
 * 	public static <T> t getManx(T[] a)
 * 	{
 * 		if(a == null || a.length == 0)
 * 			return null;
 * 		T largest = a[0];
 * 		for(int i = 1; i < a.length; i++)
 * 			if(largest.compareTo(a[i] > 0))
 * 			largest = a[i];
 * 		return largest;
 * 	}
 * }
 *
 * 여기서는 한 가지 문제가 있다. 만약 T가 compareTo()라고 하는 Comparable 인터페이스를
 * 구현하지 않은 클래스라면 어떻게 되는가? 틀림없이 오류가 발생할 것이다. 따라서 타입 매개변수 T가
 * 가리킬 수 있는 클래스의 범위를 Comparable 인터페이스를 구현한 클래스로 제한하는 것이 바람직하다.
 * 이것은 다음과 같이 한다.
 * 
 * public static <T extends Comparable> getMax(T[] a)
 * {
 * 	...	위와 같은 코드
 * }
 * 
 * 여기서 T extends Comparable은 타입 T가 Comparable 인터페이스를 구현한 클래스들
 * (String 클래스 등)에 대해서만 호출될 수 있음을 의미한다. 여기서 주의할 점은 implements라는
 * 키워드를 사용하지 않고 extends라는 키워드를 사용하였다는 점이다.
 * 
 * 
 * 
 * 3. 제네릭과 상속
 * :
 * 우리는 다형성에 의하여 Integer 객체를 Object 객체 변수로 가리키게 할 수 있음을 알 고 있다. 
 * Integer가 Object로부터 상속받았기 때문이다.
 * 
 * Object obj = new Object();
 * Integer i = new Integer(10);
 * obj = i //Ok
 * 
 * 제네릭도 마찬가지이다. 만약 Number를 타입 매개변수로 주어서 객체를 생성하였으면 Number의
 * 자식 클래스인 Integer, Double의 객체도 처리할 수 있다.
 * 
 * Box<Number> box = new Box<number>();
 * box.add(new Integer(10)); //ok
 * box.add(new Double(10.1);) //ok
 * 
 * 하지만 다음과 같은 제네릭 메소드를 고려해보자. 어떤 타입의 인수를 받을 수 있을까?
 * 
 * public void sub(Box<Number> n) { ... }
 *  
 * 물론 Box<Number> 타입은 받을 수 있을 것이다. Box<Integer>와 Box<Double>은 받을 수 있을까? 
 * 정답은 "no"이다. 왜냐하면 Box<Integer>와 Box<Double>은 Box<Number>의 자식 클래스가 아니기
 * 때문이다. Interger가 Number의 자식이기는 하지만, Box<Integer>는 Box<Number>의 자식은 아니다.
 * 
 * 
 * 제네릭 클래스의 상속
 * :
 * 그렇다면 제네릭 클래스들 간의 상속은 어떻게 표시하는가? extends나 implements를 사용하면 제네릭 클래스나
 * 제네릭 인터페이스 간의 상속을 표시할 수 있다. 우리가 잠시 후에 학습하게 되는 컬렉션 클래스들을 예로 들어서
 * 설명하여 보자.
 * 
 * ArrayList<E> implements List<E> { ... }
 * List<E> extends Collection<E> { ... }
 * 
 * 위의 문장에서 유추해 보면 ArrayList<String>는 List<String>의 자식 클래스가 된다.
 * 또, List<String>은 Collection<String>의 자식클래스가 된다.
 * 
 * Collection <== List<String> <== ArrayList<String>
 * 
 * 
 * 4. 와일드 카드
 * : 
 * 제네릭을 사용하는 코드에서 물음표(?)는 와일드 카드(wild card)라고 불린다. 와일드 카드는 카드 게임에서
 * 조커나 마찬가지의 역할을 한다. 즉 어떤 타입이든지 나타낼 수 있다. 와일드 카드는 다양하게 사용되는데,
 * 매개변수, 필드, 지역변수의 타입을 나타내는 데 사용된다.
 * 
 * 상한이 있는 와일드 카드
 * :
 * 상한이 있는 와일드 카드는 전체 타입을 나타내는 것이 아니고 일정한 상한이 있는 타입을 표시하는 데 사용된다.
 * 상한이 있는 와일드 카드는, ? 다음에 extends를 붙여서 나타낸다. extends 다음에는 상한이 온다.
 * 예를 들어서 List<Integer>, List<Double>, List<Number>에만 작동되는 메소드를 작성한다고 가정하자.
 * Integer나 Double은 모두 Number 클래스를 상속받기 때문에 다음과 같이 매개변수를 지정하면 된다.
 * 
 * public static void process(List<? extends Number> list) { ... }
 * 
 * List<? extends Number>의 의미는 Number를 상속받은 어떤 클래스도 ? 자리에 올 수 있다는 것이다.
 * 이렇게 표시하면 List<Number>보다는 더 적용 대상을 넓힌 것이다. 왜냐하면 List<Number>는
 * Number에 대해서만 매치되지만 List<? extends Number>은 Number 뿐만 아니라 Number의 자식클래스에 
 * 대해서도 매치된다.
 * 
 * 예를 들어서 리스트의 요소들에 대하여 합계를 구하는 정적 메소드를 작성하여 보면 다음과 같다.
 * 
 * public static double sumOfList(List<? extends Number> list) {
 * 		//Number 클래스의 모든 자식 클래스에 대하여 매치되는 와일드 카드이다.
 * 	double s = 0.0;
 * 
 * 	for (Number n : list)
 * 	s += n.doubleValue();
 * 
 * return s;
 * }
 * 
 * 
 * 위의 메소드는 다음과 같이 호출이 가능하다.
 * 
 * List<Integer> li = Arrays.asList(1, 2, 3)
 * System.out.println("sum = " + sumOfList(li))
 * 
 * 한도가 없는 와일드 카드
 * 
 * 한도가 없는 와일드 카드는 단순히 ?으로만 이루어진다. 예를 들면 List<?>와 같다. 이 와일드 카드는
 * 모든 타입에 매치된다. 얼핏 보면 List<?>와 List<Object>는 동일한 효과를 낼 것으로 보인다.
 * 하지만 약간 다르다. 예를 들어서 리스트 안의 모든 요소들을 출력하는 printList() 메소드를 
 * 다음과 같이 작성하여 보자.
 * 
 * public static void printList(List<Object> list) {
 * 	for(Object elem : list)
 * 		System.out.println(elem + " ")
 * 	System.out.println();
 * }
 * 
 * printList()의 목적은 모든 타입의 리스트를 출력하는 것이다. 그러나 printList()는 Object 객체의
 * 리스트만을 출력할 수 있다. 왜냐하면 List<Integer>, List<String>, List<Double>와 같은
 * 클래스들은 List<Object>의 자식이 아니기 때문이다.
 * 
 * 따라서 올바르게 작성된 printList()는 다음과 같다.
 * 
 * public static void printList(List<?> list) {
 * 	for(Object elem : list)
 * 		System.out.print(elem + " ")
 * 	System.out.println();
 * }
 * 
 * 어떤 타입 A에 대하여 List<A>의 자손 클래스가 되므로 다음과 같이 printList()를 이용하여서 다양한
 * 타입의 리스트들을 출력할 수 있다.
 * 
 * List<Integer> li = Arrays.asList(1,2,3)
 * List<String> ls = Arrays.asList("one", "two", "three")
 * printList(li);
 * printList(ls);
 * 
 * 여기서 Arrays.asList()는 정적 메소드로서 지정된 배열을 리스트로 변환하여서 반환한다.
 * 
 * 
 * 하한이 있는 와일드 카드
 * :
 * 이번에는 하한이 있는 와일드 카드를 살펴보자. 이것은 <? super A>와 같은 문법을 사용한다. 예를 들어서
 * Integer 객체를 리스트에 추가하는 메소드를 작성한다고 가정하자. List<Integer>, List<Number>,
 * List<Object>와 같은 Integer와 같은 Integer 값을 가지고 있는 모든 객체에 대하여 작동 하도록 한다.
 * 따라서 Integer 클래스의 조상 클래스들에 대하여 작동되어야 하므로 List<? super Integer>와 같이
 * 표기하면 된다.
 * 
 * public static void addNumbers(List<? super Integer> list) {
 * 	for(int i = 1; i<=10; i++) {
 * 		list.add(i);
 * 	}
 * }
 * 
 *	
 * 
 * 
 * 
 * 
 *
 */