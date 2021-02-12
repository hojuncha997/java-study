package powerJava;

class Car4 {
	int speed;
	int gear;
	public String color;
	
	public void sppedUp(int increment) {
		speed += increment;
	}
	
	public void speedDown (int decrement) {
		speed -= decrement;
	}

}


class SportsCar extends Car4{
	boolean turbo;
	public void setTurbo(boolean newValue) {
		turbo = newValue;
	}
}

public class ExtendsTest{
	public static void main(String [] args) {
		SportsCar c = new SportsCar();
		c.color ="red";
		c.sppedUp(100);
		c.speedDown(30);
		c.setTurbo(true);
		
		
	}
}