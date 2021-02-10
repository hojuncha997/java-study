/*집합관계(has-a)
 * 
 * 집합관계에서는 하나의 객체 안에 다른 객체들이 포함된다. 엄밀하게 이야기 하면
 * 하나의 객체 안에 객체들에 대한 참조를 포함하고 있다. 예를 들어서 사람을 나타내는
 * Person 객체에는 이름을 나타내는 String 객체에 대한 참조가 포함될 수 있다.
 * 클래스는 다른 클래스의 객체에 대한 참조를 멤버로서 가질 수 있다.
 * 이것은 흔히 has-a 관계로 불린다. 클래스 AlarmClock의 경우,
 * 현재 시각과 알람을 울려야 하는 시각을 가지고 있어야 한다. 이러한 경우에는
 * Time 객체에 대한 참조를 멤버로서 포함하는 것이 논리적이다.
*/

package powerJava;

class Time2 {
	private int time;
	private int minute;
	private int second;
	
	public Time2(int t, int m, int s) {
		this.time = t;
		this.minute = m;
		this.second = s;
	}
}

class AlarmClock {
	private Time2 currentTime;
	private Time2 alarmTime;
	
	public AlarmClock(Time2 a, Time2 c) {
		this.alarmTime = a;
		this.currentTime = c;
	}
}


public class AlarmClockTest {
	public static void main(String[] args) {
		Time2 alarm = new Time2(6, 0, 0);
		Time2 current = new Time2(12, 56, 34);
		AlarmClock c = new AlarmClock(alarm, current);
		
		System.out.println(c);
	}
}
