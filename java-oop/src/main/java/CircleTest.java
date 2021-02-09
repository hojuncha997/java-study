//원의 속성을 정의하는 Circle클래스에 대한 실습이다.
// 필드들은 원래 모두 private이었지만 visible하게 하기 위해 public으로 접근제한자를 바꿨다.

class Point{
	public int x, y;
	
	public Point(int a, int b) {
		this.x = a;
		this.y = b;
	}
}

class Circle{
	public int radius = 0; //반지름
	public Point center; // 원의 중심을 표현. circle 객체가 point 객체를 포함하고 있음
	
	//생성자
	public Circle(Point p, int r) {
		this.center = p;
		this.radius = r;
	}
}

public class CircleTest {
	public static void main(String[] args) {
		//circle 객체를 생성하고 초기화
		
		Point p = new Point(25, 78);
		Circle c = new Circle(p, 10); //x=25, y=78인 좌표에 반지름 10인 원이 표현됨.
		
		System.out.println("C는 반지름이 " + c.radius + "이고"
		+ " x좌표가 " + c.center.x + "이고"
		+ " y좌표가 " + c.center.y + "인 원이다");
		
	}
}
