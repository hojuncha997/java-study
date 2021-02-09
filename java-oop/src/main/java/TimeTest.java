class Time{
	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		this(0, 0, 0);
	}
	
	public Time(int h, int m, int s) {
		setTime(h, m, s);
	}
	
	public void setTime(int h, int m, int s) {
		this.hour = ((h >= 0 && h < 24) ? h : 0);
		this.minute = ((m >= 0 && m < 60) ? m : 0);
		this.second = ((s >=0 && s < 60) ? s : 0);
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
}

public class TimeTest {
	public static void main(String [] args) {
		Time time = new Time(); // 첫 번째 생성자를 호출한다. 그러면 그 생성자가 두 번째 생성자를 호출한다.
		System.out.println("기본 생성자 호출 후 시간: ");
		System.out.println(time.toString());
		
		Time time2 = new Time(13, 27, 6);
		System.out.println("두 번째 생성자 호출 후 시간: ");
		System.out.println(time2.toString());
		
		Time time3 = new Time(99, 66, 77);
		System.out.println("세 번째 생성자 호출 후 시간: ");
		System.out.println(time3.toString());
		
	}
}

