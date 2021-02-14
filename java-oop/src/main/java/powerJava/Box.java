package powerJava;

/*
public interface Comparable{
	int compareTo(Object other); //오브젝트 타입을 파라미터로 받고, 인트 값을 반환하는 메소드
}
*/
public class Box implements Comparable{
	private double volume = 0;
	public Box(double v) {
		volume = v;
	}
	//Box가 Comparable 인터페이스를 구현하기 때문에, 두 개의 Box객체의 크기가 비교될 수 있다.
	
	//인터페이스의 메소드 구현↓ 구현 안하면 오류. otherObject를 형변환하여 Box 참조 변수로 바꾼다.
	//CompareTo()는 인터페이스 안에서는 public으로 선언할 필요가 없다. (자동적으로 public이 된다).
	//하지만 구현할 때는 반드시 public을 붙여야 한다. 붙이지 않으면 디폴트로 패키지 범위가 된다.
	
	public int compareTo(Object otherObject) { 
		Box other = (Box) otherObject;
		if(this.volume < other.volume) return -1;
		else if (this.volume > other.volume) return 1;
		else return 0;
	}
	
	public static void main(String[] args) {
		Box b1 = new Box(100);
		Box b2 = new Box(85.1);
		if(b1.compareTo(b2) > 0)
			System.out.println("b1이 b2b보다 더 크다");
		else
			System.out.println("b1가 b2와 같거나 작다");
	}

}
