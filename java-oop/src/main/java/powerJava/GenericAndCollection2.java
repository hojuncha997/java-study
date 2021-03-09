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
 * 			if(!s.add(a)) //Set에 들어가지 않는다면
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
 * 대량 연산 메소드
 * :
 * 대량 연산 메소드는 집합에는 유용하다. 이것들은 표준 집합 연산을 수행한다. s1과 s2가 Set이라고 하자.
 * 
 *  - s1.containsAll(s2) :만약 s2가 s1의 부분집합이면 참이다.
 *  - s2.addAll(s2) : s1을 s1과 s2의 합집합으로 만든다.
 *  - s1.retainAll(s2) : s1을 s1과 s2과의 교집합으로 만든다
 *  - s1.removeAll(s2) : s1을 s1과 s2의 차집합으로 만든다.
 *
 * 집합 연산을 할 때 중요한 점은 원집합이 파괴되면 안된다는 것이다. 따라서 집합 연산을 수행하기 전에
 * 복사본을 만들어야 한다. String 타입의 집합 s1과 s2를 합하려고 하면 먼저 s1을 가지고 새로운
 * 집합 union을 생성하고 여기에 s2를 더해야 한다.
 * 
 * Set<String> union = new HashSet<String>(s1);
 * 
 * 집합 연산을 이용하여서 간단한 예제를 작성하여 보면 다음과 같다.
 * 
 * 
 * import java.util.*;
 * 
 * public class setTest1 {
 * 	public static void main(String[] args) {
 * 		Set<String> s1 = new HashSet<String>();
 * 		Set<String> s2 = new HashSet<String>();
 * 
 * 		s1.add("A");
 * 		s1.add("B"); 
 * 		s1.add("C"); 
 *
 * 		s2.add("A"); 
 * 		s2.add("D"); 
 * 
 * 		Set<String> union = new HashSet<String>(s1);
 * 		union.addAll(s2); //s2와 합집합을 만든다
 * 
 * 		Set<String> intersection = new HashSet<String>(s1);
 * 		intersection.retainAll(s2);
 * 
 * 		System.out.println("합집합" + union);
 * 		System.out.println("교집합" + A);
 * 	}
 * }
 * 
 * =========
 * 합집합[D, A, B, C]
 * 교집합[A]
 * 
 *  
 *  
 *  
 * 			 10. Queue
 * 
 * 큐(Queue)는 데이터를 처리하기 전에 잠시 저장하고 있는 자료 구조이다. 큐는 후단(tail)에서 원소를 추가하고
 * 전단(head)에서 원소를 삭제한다.
 * 
 * 
 * 전단(front)  o <==[oooooooo]<== o  후단(rear)
 * 
 * 
 * 디큐(deque)는 전단과 후단에서 모두 원소를 추가하거나 삭제할 수 있다. 큐에서는 중간에 원소를 추가하는 것은
 * 허용되지 않는다. 디큐는 버전 1.6부터 Deque 인터페이스로 추가되었다.
 * Deque 인터페이스는 ArrayDeque와 LinkedList 클래스들로 구성되었다.
 *  
 * Queue 인터페이스
 * :
 * Queue인터페이스는 기본적인 Collection의 연산 외에 다음과 같은 삽입, 삭제, 검색 연산을 추가로 제공한다.
 * 
 * public interface Queue<E> extends Collection<E> {
 * 	E element(E e);
 * 	boolean offer(E e);
 * 	E peek();
 * 	E poll();
 * 	E remove();
 * }
 * 
 * 전형적인 큐는 원소들을 FIFO 형식으로 저장한다. FIFO 큐에서는 새로운 원소들이 큐의 끝에 추가된다. 예외적인 큐는
 * 우선순위 큐(priority queues)이다. 우선 순위 큐는 원소들을 우선순위에 따라서 저장한다. 기본적인 우선순위는
 * 원소들의 값이다.
 * 
 * add() 메소드는 새로운 원소의 추가가 큐의 용량을 넘어서지 않으면 원소를 추가한다. 만약 용량을 넘어가면 
 * IllegalStateException이 발생한다. offer() 메소드는 원소 추가에 실패하면 false가 반환되는 것만 다르다.
 * 
 * remove()와 poll()은 큐의 처음에 있는 원소를 제거하거나 가져온다. 정확히 어떤 원소가 제거되느냐는
 * 큐의 정렬 정책에 따라 달라진다. 만약 큐에 원소가 없으면 remove()는 NoSuchElementException을 발생하고
 * poll()는 null을 반환한다.
 * 
 * element()와 peek() 메소드는 큐의 처음에 있는 원소를 삭제하지 않고 가져온다. 만약 큐가 비어 있으면
 * element()는 NoSuchElementException을 발생하고, peek()는 null을 반환한다.
 * 
 * 
 * 예제
 * : 아래의 예에서 큐가 카운트 다운 타이머를 구현하기 위하여 사용되었따. 미리 큐에 정수들을 넣어 놓고 이들 값들이 차례대로
 * 큐에서 삭제되면서 1초에 하나씩 화면에 출력된다.
 * 
 * 
 * import java.util.*;
 * 
 * public class QueueTest {
 * 	public static void main(String[] args) throws InterruptedException {
 * 		int time = 10;
 * 
 * 		Queue<Integer> queue = new LinkedList<Integer>();
 *  	//Integer를 저장하는 큐를 생성한다. 실제로 링크드리스트 안에 뷰 인터페이스가 구현돼 있다.
 * 
 * 		for(int i = time; i >= 0; i--)
 * 			queue.add(i);
 *
 * 		while(!queue.isEmpty()) {
 * 			System.out.print(queue.remove() + " ");
 * 			Thread.sleep(1000); //현재의 스레드를 1초간 재운다.
 * 		}
 * 	}
 * }
 * ========
 * 10 9 8 7 6 5 4 3 2 1 0
 * 
 * 
 * 
 * 
 * 
 * 우선순위 큐
 * :
 * 우선순위 큐는 원소들이 무작위로 삽입되었더라도 정렬된 상태로 원소들을 추출한다. 즉, remove()를
 * 호출할 때마다 가장 작은 원소가 추출된다. 그러나 우선순위 큐가 항상 정렬될 상태로 원소들을 저장하고
 * 있는 것은 아니다. 우선순위 큐는 힙(heap)이라고 하는 자료 구조를 내부적으로 사용한다.
 * 힙은 이진트리의 일종으로서 add()와 remove()를 호출하면 가장 작은 원소가 효율적으로 트리의 루트로
 * 이동하게 된다.
 * 
 * 우선순위 큐의 가장 대표적인 예는 작업스케쥴링(job scheduling)이다. 각 작업은 우선순위를 가지고 있고
 * 가장 높은 우선순위의 작업이 큐에서 가장 먼저 추출되어서 시작된다.
 * 
 * PriorityQueueTest.java
 * 
 * import java.util.*;
 * 
 * public class PriorityQueueTest {
 * 	public static void main(String[] args) {
 * 		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); //우선순위 큐 생성
 *
 * 		pq.add(30);
 * 		pq.add(80);
 * 		pq.add(20);
 * 
 *	 	for(Integer o: pq)
 * 			System.out.println(o);
 * 		System.out.println("원소 삭제");
 * 		while(!pq.isEmpty())
 * 			System.out.println(pq.remove());
 * 	}
 * }
 * ========
 * 20 //가장 작은 원소?
 * 80
 * 30
 * 원소 삭제
 * 20
 * 30
 * 80
 * 
 * 
 * 
 * 
 * 
 * 			11. Map
 * 
 * Map은 많은 데이터 중에서 원하는 데이터를 빠르게 찾을 수 있는 자료구조이다. 맵은 사전과 같은
 * 자료 구조이다. 즉 사전처럼 단어가 있고(이것을 key라고 부른다) 단어에 대한 설명 이것을 (value라고 부른다)이 있다.
 * Map은 중복된 키를 가질 수 없다. 각 키는 오직 하나의 값에만 매핑할 수 있다. 키가 제시되면 Map은 값을 반환한다.
 * 예를 들어서 학생에 대한 정보를 Map에 저장할 수 있다. 여기서 키는 학번이 될 것이고 값은 학생이 될 것이다.
 * 
 * 자바에서는 Map이라는 이름의 인터페이스가 제공되고 이 인터페이스를 구현한 클래스로
 * HashMap, TreeMap, LinkedHashMap 등의 3가지 클래스가 제공된다. HashMap은 해싱 테이블에 데이터를 저장하고
 * TreeMap은 탐색 트리에 데이터를 저장한다.
 *  
 * HashMap과 TreeMap 중에서 어떤 것을 사용하여야 하는가? 만약 키들을 정렬된 순서로 방문할 필요가 있다면
 * HashMap이 약간 빠르다. 학생 정보를 저장하는 HashMap을 작성하여 보자. Student 클래스는 미리 정의되어 있다고 
 * 가정하자. 데이터를 저장하려면 put() 메소드를 사용한다.
 * 
 * Map<String, Student> freshman = new HashMap<String, Student>(); //생성
 * Student kim = new Student("김철수");
 * freshman.put("20090001", kim); //저장
 * 
 * 객체를 다시 추출하려면 get() 메소드를 사용하면 된다.
 * 
 * String s = "20090001";
 * st = freshman.get(s); // 키값을 넣어줌. 김철수를 반환
 * 
 * 
 * 예제
 * :
 * 학생들과 관련된 자료들을 맵에 저장하여 처리하는 코드
 * 
 * MapTest.java
 * 
 * import java.util.*;
 * 
 * class Student {
 * 
 * 	int number;
 * 	String name;
 * 
 * 	public Student(int number, String name) {
 * 		this.number = number;
 * 		this.name = name;
 * 	}
 * 
 * 	public String toString(){
 * 		return name;
 * 	}
 * }
 * 
 * public class MapTest {
 * 	public static void main(String[] args){
 * 		Map<String, String> st = new HashMap<String, Student>(); //맵 객체 생성, 해쉬맵 사용
 * 		st.put("20090001", new Student(20090001, "구준표"));
 * 		st.put("20090002", new Student(20090002, "금잔디"));
 * 		st.put("20090003", new Student(20090003, "윤지후"));
 * 
 *   	//모든 항목을 출력한다
 *   	System.out.println(st);
 *   
 *   	//하나의 항목을 출력한다.
 *   	System.out.println("20090002");
 *   
 *   	//하나의 항목을 삭제한다. 금잔디 삭제
 *   	st.remove("20090002");
 *   
 *   	//하나의 항목을 대치한다. 윤지후가 소이정으로
 *   	st.put("20090003", new Student(20090003, "소이정"));
 *   
 *   	//값을 참조한다
 *   	System.out.println(st.get("20090003"));
 *   
 *   	//모든 항목을 방문한다.
 *   	for(Map.Entry<String, Student> s : st.entrySet()) {
 *   		String Key = s.getKey();
 *   		Student Value = s.getValue();
 *   		System.out.println("key=" + key + ", value=" + value);
 *   	}
 * 	}
 * }
 * =====================
 * {20090001=구준표, 20090002=금잔디, 20090003=윤지후}
 * 소이정
 * key=20090001, value=구준표
 * key=20090003, vlaue=소이정
 * 
 *  프로그램 설명// 맵에 저장된 데이터를 방문할 때에는 Map.Entry라는 인터페이스를 사용한다.
 *  
 * 
 * 
 * 예제 2
 * :
 * 아래의 예제는 Map의 3가지 기본적인 연산인
 * put(), get(), containsKey(), containsValue(), size(), isEmpty()를 보여준다.
 * 
 * wordFreq.java
 * 
 * import java.util.*;
 * 
 * public class WordFreq {
 * 	public static void main(String[] args) {
 *		Map<String, Integer> m = new HashMap<String, Integer>(); //맵 객체 생성 
 *		
 *		String[] sample = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"}
 *		//문자열에 포함된 단어의 빈도를 계산한다.
 *
 *		for(String a : sample) {
 *			Integer freq = m.get(a);
 *			m.put(a, (freq == null) ? 1 : freq + 1);
 *		}
 * 
 * 		System.out.println(m.size() + "단어가 있습니다.");
 * 		System.out.println(m.containsKey("to"));
 * 		System.out.println(m.isEmpty());
 * 		System.out.println(m);		
 * 	}
 * }
 * ========
 * 7 단어가 있습니다.
 * true
 * false
 * {not=1, to=2, is=1, or=1, a=1, problem=1, be=2}
 * 
 * 
 * 
 * //먼저 String 배열에서 조건 연산자를 사용하여 만약 단어가 한 번도 등장한 적 없으면 1로 설정한다.
 * // 만약 한 번이라도 등장한다면 빈도를 나타내는 값을 하나 증가시킨다.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *			 12. Collection 클래스
 *
 * Collection 클래스는 여러 유용한 알고리즘을 구현할 메소드들을 제공한다. 이 메소드들은 제네릭 기술을 사용하여서
 * 작성되었으며 정적 메소드 형태로 되어 있다. 메소드의 첫 번째 매개변수는 알고리즘이 적용되는 컬렉션이 된다. 이중에서
 * 알고리즘만 살펴보자
 * 
 * - 정렬(Sorting)
 * - 섞기(Shuffleing)
 * - 탐색(Searching)
 * 
 * 
 * 정렬
 * :
 * 정렬은 가장 중요한 컴퓨터 알고리즘이라고 하여도 과언이 아니다. 정렬은 데이터를 어떤 기준에 의하여 순서대로 나열하는 것이다.
 * 정렬 알고리즘에는 퀵 정렬, 합병 정렬, 힙 정렬 등의 다양한 방법이 존재한다. Collections 클래스의 정렬은 속도가 비교적
 * 빠르고 안정성이 보장되는 합병 정렬을 이용한다. 합병 정렬은 시간 복잡도가 0(nlog(n))이며 특히 거의 정렬된 리스트에 대해서는
 * 상당히 빠르다.
 * 
 * 안정된 정렬
 * [56][9][67][앞12][26][뒤12][32]  ==정렬==> [9][앞12][뒤12][26][32][56][67]
 * 
 * 안정성이란 동일한 값을 가지는 원소를 다시 정렬하지 않는 것을 의미한다. 위의 예에서 12의 값을 가지는 두 개의 원소의 순서가
 * 정렬 후에도ㅗ 변경되지 않았다. 안정성은 같은 리스트를 반복하여 다른 기준에 따라 정렬할 때 중요하다. 만약 상품주문 리스트를
 * 날짜 기준으로 정렬한다면 사용자는 같은 주문처가 보낸 주문은 날짜별로 정렬된 것이라고 가정한다. 하지만 이것은 정렬이 안정성 있는
 * 경우에만 가능하다.
 * 
 * Collection 클래스와 sort() 메소드는 List 인터페이스를 구현하는 컬렉션에 대하여 정렬을 수행한다. 간단한 예를 들어보면
 * 다음과 같다.
 * 
 * List<String> list = new LinkedList<String>();
 * list.add("김철수");
 * list.add("김영희");
 * Collection.sort(list); //리스트 안의 문자열이 정렬된다.
 * 
 * 
 * 정렬의 예제
 * :
 * 문자열을 정렬하는 간단한 예
 * 
 * import java.util.*;
 * 
 * public class Sort {
 * 	public static void main(String[] args) {
 * 		String[] sample = {"i", "walk", "the", "line"};
 *
 * 		List<String> list = Array.asList(sample); //배열을 리스트로 변경
 * 		Collections.sort(list); //리스트를 정렬한다.
 * 
 * 		System.out.println(list);
 * 	}
 * }
 * ======
 * [i, line, the, walk]
 * 
 * 프로그램 설명:
 * 정렬 알고리즘을 실행하기 위하여 asList() 메소드를 이용하여 배열을 리스트로 변환한다. Collectiions 인터페이스가
 * 가지고 있는 정적 메소드인 sort()를 호출하여 정렬을 수행한다.
 * 
 */