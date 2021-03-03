package powerJava;

public class GenericAndCollection2 {

}


/*
 * 
 * 5. 컬렉션
 * 
 * 컬렉션은 자바에서 자료구조를 구현한 클래스들을 칭하는 용어이다. 자료구조(data structure)는 자료를
 * 저장하기 위한 구조이다. 대부분의 프로그램은 자료를 저장하여야 하고 따라서 어떤 자료 구조를 사용할 것인지를
 * 결정하여야 한다. 예를 들어서 전화 번호부 프로그램은 전화 번호를 저장하여야 하고 메일 프로그램은 수신된
 * 메일을 어딘가에 저장하여야 한다. 많이 사용되는 자료 구조로는 list, stack, queue, set, hash table 등이 있다.
 * 
 * 왜 이렇게 다양한 자료 구조들이 제공되는 것일까? 자료구조는 자료를 저장하는 기능만 중요한 것이 아니고 빠르게
 * 검색하거나 정렬할 수 있는 기능도 중요하기 때문이다. 따라서 자신이 구현하고 있는 응용 분야에 맞는 최선의 자료구조를
 * 선택하여야 한다.
 * 
 * 컬렉션의 예: Vector 클래스
 * :
 * 컬렉션에 대하여 본격적으로 학습하기 전에 컬렉션이 무엇인지를 vector클래스를 통하여 살펴보자.
 * vector클래스는 java.util 패키지에 있는 컬렉션의 일종으로 가변 크기의 배열(dynamic array)을 구현하고 있다.
 * 기존의 배열은 크기가 고정되어 있어서 사용하기 불편하다. 하지만 vector는 요소의 개수가 늘어나면 자동으로 배열의
 * 크기가 늘어난다. 또한 Vector에는 어떤 타입의 객체라도 저장할 수 있다. 또 정수와 같은 기초형 데이터도 오토박싱
 * 기능을 사용하여 객체로 변환되어 저장된다.
 * 
 * [0][1][2][3][4][5]...
 * 
 * [0] = "Hello World"
 * [1] = 10
 * [2] = 20
 * 
 * vector는 많은 유용한 메소드들을 가지고 있었다. Vector에 요소를 추가하려면 add() 메소드를 사용한다.
 * 정해진 위치에 요소를 추가하려면 add(index, object) 메소드를 사용하면 된다. Vector에서 값을 추출하려면
 * get()메소드를 사용한다. size()는 현재 vector안에 있는 요소들의 개수를 반환한다.
 * 
 * 
 * import java.util.Vector;
 * 
 * public class VectorTest {
 * 	public static void main(String[] args){
 * 		Vector vc = new Vector(); // 백터 객체를 생성할 때, 크기를 안 주어도 된다. 물론 크기를 줄 수도 있다.
 * 		
 * 		vc.add("Hello World");	 // 어떤 타입의 객체도 추가가 가능하다.
 * 		vc.add(new Integer(10)); 
 * 		vc.add(20);
 * 
 * 		System.out.println("vector size :" + vc.size()); 
 * 
 * 		for(int i = 0; i < vc.size(); i++) {
 * 			system.out.println("vector element" + i + " : " +vc.get(i));
 * 		}
 * 
 * 		String s = (String)vc.get(0);
 * 	}
 * }
 * ==========
 * 
 * vector size :3
 * vector element 0 : Hello World!
 * vector element 1 : 10
 * vector element 2 : 20
 * 
 * vector 클래스도 제네릭을 지원한다. 따라서 Vector 객체를 생성할 때 new Vector<String>이라고 하면 문자 객체만을
 * 저장하는 Vector를 생성할 수 있다.
 * 
 * 
 * 
 * 컬렉션의 종류
 * :
 * 자바는 컬렉션 인터페이스와 컬렉션 클래스로 나누어서 제공한다. 자바에서는 컬렉션 인터페이스를 구현한 클래스도 함께 제공하므로
 * 이것을 간단하게 사용할 수도 있고 아니면 각자 필요에 맞추어 인터페이스를 자신의 클래스로 구현할 수도 있다. 이들 인터페이스와
 * 클래스들은 모두 java.util 패키지에 포함되어 있다. 또 컬렉션 라이브러리들은 모두 제네릭 기능을 지원한다. 컬렉션 인터페이스에
 * 대한 간단한 설명은 아래와 같다.
 * 
 * ===========================================================
 * 인터페이스 	  |				설명								 
 * ===========================================================
 * Collection |모든 자료 구조의 부모 인터페이스로서 객체의 모임을 나타낸다.   
 * set		  |집합(중복된 원소를 가지지 않는)을 나타내는 자료 구조
 * List       |순서가 있는 자료 구조로 중복된 원소를 가질 수 있다.
 * Map 		  |키와 값들이 연관되어 있는 사전과 같은 자료 구조
 * Queue	  |극장에서의 대기줄과 같이 들어온 순서대로 나가는 자료구조
 *============================================================ 
 * 
 * 
 * 컬렉션의 역사
 * 
 * 여기서 잠깐 자바에서의 컬렉션 관련 라이브러리들의 변천사를 살펴보자. 초기버전에서는 가장 많이 사용되는 자료 구조들을 위한 클래스들만
 * 제공하였다. Vector, Stack, HashTable, Bitset, Enumeration이 그것이다. 버전1.2부터는 훨씬 풍부하고 완전한 컬렉션
 * 라이브러리가 제공되었다. 이것의 가장 큰 특징은 인터페이스와 구현을 분리하였다는 점이다. 예를 들어서 순서 있는 원소들의 모임인
 * List의 경우에도 List의 기본적인 동작은 인터페이스 List에 정의되어 있고, 이것을 실제로 구현한 ArrayList의 LinkedList 클래스가
 * 같이 제공된다.
 * 
 * 
 * 
 * 6. Collection 인터페이스
 * 
 * Collection은 거의 모든 컬렉션 인터페이스의 부모 인터페이스에 해당한다. 모든 컬렉션 클래스들이 Collection 인터페이스를 구현하고
 * 있기 때문에 Collection에 들어 있는 메소드들은 거의 대부분의 컬렉션 클래스에서 사용할 수 있다.
 * 
 * 인터페이스들의 계층구조
 * 
 * Collection 
 * 		|-set
 * 		|  |-SortedSet
 * 		|
 * 		|- List
 * 		|- Queue
 * 
 * 
 * Map
 * 	|-SortedMap
 * 
 * 
 * 컬렉션 인터페이스가 제공하는 메소드들
 * 
 * 기본연산
 * 
 * int size()						| 원소의 개수 반환
 * boolean isEmpty()				| 공백 상태이면 ture 반환
 * boolean contains(Object obj)		| obj를 포함하고 있으면 true 반환
 * boolean add(E element)			| 원소 추가
 * boolean remove(Object obj)		| 원소 삭세
 * Iterator<E> iterator()			| 원소 방문
 * 
 * 심화적인 메소드들은 p548 참조
 * 
 * 
 * 
 * 
 * 		7. ArrayList
 * :
 * List 인터페이스
 * 
 * 리스트(List)는 순서를 가지는 원소들의 모임으로 중복된 원소를 가질 수 있다. 리스트의 가장 큰 특징은
 * 위치를 사용하여 원소에 접근한다는 점이다. 리스트에 들어 있는 원소들의 인덱스는 0부터 시작한다.
 * 
 * 
 * 							 ArrayList클래스
 * 					==> 	[a][b][c][...][]
 * 	List 인터페이스					
 * 	  [a b c]				
 * 					==>		LinkedList 클래스
 * 						[a][]-->[b][]-->[c][NULL]
 * 
 * 
 * 자바에서 리스트는 인터페이스인 List에 의하여 정의된다. 인터페이스는 ArrayList, LinkedList, Vector 등의
 * 클래스에 의하여 구현된다. ArrayList와 Vector는 List를 배열로 구현한 것으로 리스트의 크기가 자동 조정된다.
 * LinkedList는 리스트를 연결 리스트로 구현한 것이다. Vector는 이전 버전에서도 있었던 것으로 멀티 스레드 환경에서도
 * 사용할 수 있도록 동기화 되어 있다.
 * 
 * 
 * 
 * 
 * 		ArrayList
 * 
 * ArrayList에서 원소들을 인덱스에 의하여 접근하여 사용하는 것은 배열과 유사하다. 왜 배열 대신에 ArrayList를 사용할까?
 * 배열의 문제점은 배열을 생성할 때 배열의 크기가 고정된다는 점이다. 만약 데이터의 개수가 배열의 크기보다 많아지게 되면
 * 저장이 불가능하다. 그렇다고 배열의 크기를 무작정 크게 한다면 많은 공간이 낭비될 것이다.
 * 
 * ArrayList의 기본 연산
 * 
 * ArrayList는 저장되는 데이터의 개수에 따라 자동적으로 크기가 변경된다. 즉, 원소가 가득 차게 되면 ArrayList의 크기를
 * 동적으로 증가시킨다. 반대로 원소가 삭제되면 그만큼 크기를 줄이게 된다. ArrayList를 배열의 향상된 버전 또는 가변 크기의
 * 배열이라고 생객하여도 좋다.
 * 
 * ArrayList의 기본 연산
 * 
 * ArrayList는 타입 매개변수를 가지는 제네릭 클래스로 제공된다. 따라서 ArrayList를 생성하려면 타입 매겨변수를 지정하여야
 * 한다. 만약 저장하려는 데이터의 타입이 문자열이라면 다음과 같이 생성한다.
 * 
 * ArrayList<String> list = new ArrayList<String>();
 * 
 * 생성된 ArrayList 객체에 데이터를 저장하려면 add() 메소드를 사용한다. add() 메소드는 Collection인터페이스에 정의된
 * 메소드로서 ArrayList 클래스가 구현한 메소드이다.
 * 
 * list.add("MILK");
 * list.add("BREAD");
 * list.add("BUTTER");
 * 
 * [BREAD][BREAD][BUTTER][...][...]
 * 	  0		 1		2	   3
 * 만약에 기존의 데이터가 들어 있는 위치를 지정하여서 add()를 호출하면 새로운 데이터는 중간에 삽입된다.
 * 
 * list.add(1, "APPLE"); //인덱스 1에 "APPLE"을 삽입
 * 
 * [MILK][APPLE][BREAD][BUTTER][...]
 * 	 0		1	   2	  3		 4
 *
 * 만약 특정한 위치에 있는 원소를 바꾸려면 set() 메소드를 사용한다.
 * list.set(2, "grape"); // 인덱스 2의 원소를 "GRAPE"로 대체
 * 
 * 데이터를 삭제하려면 remove()메소드를 사용한다.
 * list.remove(3); // 인덱스 3의 원소를 삭제한다. BUTTER가 사라짐.
 * 
 * ArrayList 객체에 저장된 객체를 가져오는 메소드는 get()이다. get()은 인덱스를 받아서 그 위치에
 * 저장된 원소를 반환한다. 예를 들어서 list.get(1)이라고 하면 인덱스 1에 저장된 데이터가 반환된다.
 * 
 * String s = list.get(1);
 * 
 * 만약 이때 범위를 벗어나는 인덱스를 사용하면 예외가 발생한다. size() 메소드를 이용하면 현제 저장된 원소의
 * 개수를 알 수 있다.
 * 
 * ArrayListTest.java
 * 
 * import java.util.*;
 * 
 * 
 * ArrayListTest.java
 * 
 * import java.util.*;
 * 
 * public class ArrayListTest {
 * 	public static void main(String[] args) {
 *		ArrayList<String> list = new ArrayList<String>();
 *
 *		list.add("MILK");
 *		list.add("BREAD");
 *		list.add("BUTTER");
 *		list.add(1, "APPLE");
 *		list.set(2, "GRAPE");
 *		list.remove(3);
 *
 *		for(int i=0; i<list.size(); i++)
 *			System.out.println(list.get(i));
 *	}
 * }
 * ================
 * MILK
 * APPLE
 * GRAPE
 * 
 * 위의 코드에서는 get()메소드의 사용을 보이기 위해 표준적인 for 루프를 사용했지만 사실 ArrayList에
 * 들어 있는 데이터를 모두 출력하려면 다음과 같은 for-each루프를 사용하는 것이 좋다.
 * 
 * for(String s : list)
 * 	System.out.println(s);
 * 
 * 
 * ArrayList의 추가 연산
 * :
 * 컬렉션 라이브러리가 좋은 점은 다양한 연산을 제공한다는 점이다. 예를 들어서 리스트에 저장된 데이터를 검색하는
 * 메소드도 제공한다. indexOf()를 사용하면 특정한 데이터가 저장된 위치를 알 수 있다. 다만 ArrayList는
 * 동일한 데이터도 여러 번 저장될 수 있으므로 맨 처음에 있는 데이터의 위치가 반환된다.
 * 
 * int index = list.indexOf("APPLE"); //1만 반환된다.
 * 
 * 검색을 반대 방향으로 하려면 lastIndexOf()를 사용한다.
 * 
 * int index = list.lastIndexOf("MILK"); //0이 반환된다.
 * 
 * 
 * 참고사항.
 * 
 * 자바에서는 배열, ArrayList, 문자열 객체의 크기를 알아내는 방법이 다르다
 * - 배열 : array.length
 * - ArrayList: arrayList.size()
 * - 문자열: string.length()
 * 
 * 
 * 
 * 
 * 반복자(iterator) 사용하기
 * :
 * ArrayList에 있는 원소에 접근하는 또 하나의 방법은 반복자(iterator)를 사용하는 것이다.
 *  "반복자는 특별한 타입의 객체로, 컬렉션의 원소들을 접근하는 것이 목적"이다. 
 *  ArrayList 뿐만 아니라 반복자는 모든 컬렉션에 적용할 수 있다.
 * 
 * 반복자는 java.util 패키지에 정의되어 있는 Iterator 인터페이스를 구현하는 객체이다.
 * Iterator 인터페이스에는 다음 3개의 메소드만 정의되어 있다. 이들 3개의 메소드를 이용하여
 * 컬렉션의 원소들을 하나씩 처리하게 된다.
 * 
 * Iterator 인터페이스의 메소드
 *  - hasNext()  | 아직 방문하지 않은 원소가 있으면 true를 반환
 *  - next()	 | 다음 원소를 반환
 *  - remove()	 | 최근에 반환된 원소를 삭제한다.
 * 
 * 
 * 반복자를 사용하기 위해서는 먼저 ArrayList의 iterator() 메소드를 호출하여서 반복자 객체를 얻는다.
 * 다음으로 반복자 객체의 hasNext()와 next() 메소드를 이용하여서 컬렉션의 각 원소들에 접근한다.
 * 
 * ArrayList<String> list = new ArrayList<String>();
 * list.add("하나");
 * list.add("둘");
 * list.add("셋");
 * list.add("넷");
 * 
 * String s;
 * Iterator e = list.iterator(); //list의 이터레이터
 * 
 * while(e.hasNext())
 * {
 * 	s = (String)e.next(); // 반복자는 object 타입을 반환
 * 	system.out.println(s);
 * }
 * 
 * 참고사항
 *  반복자 사용을 보다 간단하게 한 것이 버전 1.5부터 도입된 for-each루프이다. 반복자보다는 이것이 간단하지만
 *  아직도 반복자는 빈번히 사용되고 있다.
 *  
 *  
 *  
 *  
 *  		8.LinkedList
 *  
 *  많은 코드에서 배열의 향상된 버전인 ArrayList를 사용한다. 하지만 때에 따라서 ArrayList는 큰 단점을 가질 수 있다.
 *  ArrayList 중간에서 데이터의 삽입이나 삭제가 빈번하게 발생하는 경우에는 문제가 된다. 왜냐하면 삽입이나 삭제 위치 뒤에 
 *  있는 원소들을 이동하여야 하기 때문이다. 이런 경우에는 연결리스트로 구현된 LinkedList가 성능이 더 낫다. 
 *  
 *  연결 리스트는 각 원소를 링크로 연결한다. 각 원소들은 다음 원소를 가리키는 링크를 저장한다. 자바에서는 모든 연결리스트는
 *  이중 연결 리스트로 구현되어 있다. 즉 각 원소는 이전 원소를 가리키는 링크도 저장한다.
 *  
 *  연결 리스트에서는 중간에 원소를 삽입하거나 삭제하는 것이 어려운 작업이 아니다. 삽입이나 삭제되는 위치의 바로 앞에 있는
 *  원소의 링크값만을 변경하면 된다.
 *  
 *  LinkedList가 장점만 있는 것은 아니다. 위치(인덱스)를 가지고 원소를 접근하는 연산은 LinkedList가 ArrayList보다
 *  더 시간이 많이 걸린다. 따라서 위치적인 접근이 많다면 ArrayList가 낫다. LinkedList의 사용 방법은 ArrayList와
 *  완전히 같다.
 *  
 *  import java.util.*;
 *  
 *  public class LinkedListTest{
 *  	public static void main(String[] args) {
 *  		LinkedList<String> list = new LinkedList<String>();
 *  
 *  		list.add("MILK");
 *    		list.add("BREAD");
 *  		list.add("BUTTER");
 *    		list.add(1, "APPLE");
 *  		list.set(2, "GRAPE");
 *    		list.remove(3);
 *    
 *          for (int i =0; i < list.size(); i++)
 *          	System.out.println(list.get(i));
 *  	}
 *  }
 *=========================
 * Milk
 * APPLE
 * GRAPE
 * 
 * 반복자 사용하기
 * :
 * LinkedList도 반복자를 지원한다. 다음과 같은 형식으로 사용하면 된다.
 * 
 * Iterator e = list.iterator();
 * String first = e.next();
 * String second = e.next();
 * e.remove(); //최근 방문한 원소 삭제
 * 
 * ArrayList나 LinkedList와 같은 리스트에서 사용하기가 편리한 반복자는 다음과 같이 정의되는
 * ListIterator이다.
 * 
 * interface ListIterator<E> extends Iterator<E>
 * {
 * 	void add(E element);
 * 	E previous();
 * 	boolean hasPrevious();
 *  ...
 * }
 * 
 * ListIterator는 컬렉션의 Iterator와는 다르게 두 개의 메소드를 더 가지고 있다. 이들 메소드는
 * 리스트를 역순으로 방문하는 경우에 사용된다.
 * 
 * 
 * ArrayList vs. LinkedList
 * :
 * ArrayList는 인덱스를 가지고 원소에 접근할 경우, 항상 일정한 시간만 소요된다. ArrayList는 리스트의
 * 각각의 원소를 위하여 노드 객체를 할당할 필요가 없다. 또 동시에 많은 원소를 이동하여야 하는 경우에는
 * System.arraycopy()를 사용할 수 있다.
 * 
 * 만약 리스트의 처음에 빈번하게 원소를 추가하거나 내부의 원소 삭제를 반복하는 경우에는 LinkedList를
 * 사용하는 것이 낫다. 이들 연산들은 LinkedList에서는 일정한 시간만 걸리지만 ArrayList에서는
 * 원소의 개수에 비례하는 시간이 소요된다. 그러나 문제는 인덱스를 가지고 접근할 때는 반대가 된다.
 * 따라서 성능에서 손해를 보게 된다. 따라서 LinkedList를 사용하기 전에 응용 프로그램을 LinkedList와
 * ArrayList를 사용하여 구현한 후에 실제 시간을 측정하여 보는 것이 좋다. 일반적으로는 ArrayList가 빠르다.
 * 
 * ArrayList는 한 가지 튜닝 매개변수를 가지고 있따. 즉 초기 용량(initial capacity)이 그것으로 확장되기
 * 전에 ArrayList가 저장할 수 있는 원소의 개수를 말한다. LinkedList는 튜닝 매개변수가 없지만 대신 몇 가지의
 * 메소드를 가지고 있다.
 * addFirst(), getFirst(), removeFirst(), addLast(), getLast(), removeLast()들이 여기에 
 * 해당한다.
 * 
 * 
 * 
 * 배열을 리스트로 변경하기
 * :
 * Arrays.asList() 메소드는 배열을 받아서 리스트 형태로 반환한다. 리스트를 변경하면 배열도 변경된다.
 * 그 역도 성립한다. 리스트의 크기는 배열과 같고 변경이 불가능하다. 만약 리스트의 add()나 remove()가
 * 호출되면 UnsupportedOperationException이 발생한다.
 * 
 * 보통 이것은 배열-기반의 프로그램을 컬렉션-기반의 프로그램으로 변경할 때 다리와 같은 역할을 한다.
 * 이 메소드는 배열을 컬렉션이나 리스트를 받는 메소드에 매개변수로 넘긴느 것을 허용한다. 또한 고정된 크기의
 * 리스트를 원하는 경우에 이 메소드는 어떤 일반적인 리스트 구현보다도 효율적이다.
 * 
 * List<String> list = Arrays.asList(new String[size]);
 * 
 * 
 * 
 * 			9. Set 
 * 
 * 앞에서 학습한 리스트는 원소 간의 순서가 존재한다. 하지만 만약 순서에는 상관 없이 원소만 저장하고 싶은 경우도 존재한다.
 * 이 때 사용할 수 있는 자료 구조가 집합(set)이다. 수학적으로 집합(set)은 동일한 원소를 중복해서 가질 수 없다.
 * A = {1, 2, 3, 4, 5}는 집합이지만 B = {1, 2, 2, 3}은 집합이 아니다. Set 인터페이스는 Collection
 * 인터페이스를 제공하는 메소드만을 포함하며 다만 원소의 중복만을 막도록 설계되어 있다.
 * 
 * Set을 구현하는 가장 잘 알려진 방법이 해쉬테이블(hash table)이다.
 * 해쉬 테이블은 각각의 원소에 대하여 해쉬 코드라는 정수를 계산한다. 해쉬코드는 대개 객체의 인스턴스 필드로부터 계산된다.
 * 각 클래스마다 해쉬코드를 계산하는 메소드인 hashCode()를 가지고 있다. 예를 들어서 "Park" 문자열 객체에 대한
 * 해쉬코드는 2480138이다. 만약 클래스 작성자라면 반드시 hashCode()도 구현할 책임이 있다. 중요한 것은
 * 해쉬 코드 계산은 반드시 효율적이어야 한다.
 * 
 * 자바에서 해쉬 테이블은 LinkedList의 배열로 구현된다. 각 리스트는 버킷(bucket)이라고 불리운다. 테이블에서
 * 원하는 객체를 찾기 위해서는 먼저 객체의 해쉬 코드를 계산하고 테이블의 크기에 맞추어 나머지 연산을 수행한 후에
 * 결과로 나오는 숫자를 테이블의 인덱스로 사용하면 된다. 예를 들어서 테이블의 크기가 128이고 "Park" 문자열이
 * 원하는 객체라면 "Park" 의 해쉬코드인 2480138을 128로 나눈 나머지인 (2480138 % 128) = 10이 버킷의 번호가 된다.
 * 
 * p557 참고
 * 
 * 
 * 자바에서는 Set 인터페이스에 대하여 HashSet, TreeSet, LinkedHashSet의 3가지의 구현이 제공된다.
 * 
 * - HashSet:
 *  HashSet은 해쉬 테이블에 원소를 저장하기 때문에 성능면에서 가장 우수하다. 하지만 원소들의 순서가
 * 일정하지 않은 단점이 있다. 
 * 
 * - TreeSet:
 *  TreeSet은 레드-블랙 트리(red-black tree)에 원소를 저장한다. 따라서 값에 따라서 순서가 결정된다.
 * 하지만 HashSet보다는 느리다.
 * 
 * - LinkedHashSet:
 *  LinkedHashSet은 해쉬 테이블과 연결 리스트를 결합한 것으로 원소들의 순서는 삽입되었던 순서와 같다.
 * LinkedHashSet은 약간의 비용을 들여서 HashSet의 문제점인 순서의 불명확성을 제거한 방법이다.
 * 
 * 아래는 HashSet을 사용하는 간단한 예이다.
 * 
 * SetTest.java
 * 
 * import java.util.*;
 * 
 * public class SetTest{
 * 	public static void main(String[] args){
 * 		HashSet<String> set = new HashSet<String>();
 * 
 * 		set.add("Milk");
 * 		set.add("Bread");
 * 		set.add("Butter");
 * 		set.add("Cheese");
 * 		set.add("Ham");
 * 		set.add("Ham"); //중복
 * 
 * 		System.out.println(set);
 * 	}
 * }
 * 
 * ============
 * [Bread, Milk, Butter, Ham, Cheese] // 순서가 없으며, 햄은 한 번만 저장되었다.
 * 
 * 만약 LinkedHashSet을 사용한다면 다음과 같은 결과가 얻어진다. 입력된 순서대로 출력됨에 주의하라.
 * 
 * [Milk, Bread, Butter, Cheese, Ham]
 * 
 * 만약 TreeSet을 사용한다면 다음과 같은 결과가 얻어진다. 알파벳 순으로 정렬된느 것에 주의하자.
 * 
 * [Bread, Butter, Cheese, Ham, Milk]
 * 
 * 
 * 예제
 * 
 * Set은 우리가 잘 알다시피 중복을 허용하지 않는다. 이것을 이요하여서 전체 문장에서 중복된 단어를
 * 검출하는 프로그램을 작성할 수 있다.
 * 
 * FindDupplication.java
 * 
 * import java.util.*;
 * 
 * public class FindDupplication {
 * 	public static void main(String[] args) {
 * 		Set<String> s = new HashSet<String>();
 * 
 * 		String[] sample = {"단어", "중복", "구절", "중복"};
 *
 * 		for(String a :sample)
 * 			if(!s.add(a))
 * 				System.out.println("중복된 단어: " + a);
 * 			//만약 Set 안에 이미 이 원소가 있으면 Set을 변경하지 않고 false를 리턴한다.
 * 			//If this set already contains the element, the call leaves the setunchanged and returns false
 * 			System.out.println(s.size() + "중복되지 않은 단어: " + s);
 * 	}
 * }
 * ========
 * 중복된 단어: 중복
 * 중복되지 않은 단어: [구절, 단어, 중복]
 *  
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */