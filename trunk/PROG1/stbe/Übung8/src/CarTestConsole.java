public class CarTestConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car(180, 40);
		
		System.out.println("Motorstatus: " + car.getMotorOn());
		
		System.out.println("Motor des Fahrzeugs starten!");
		car.setMotorOn();
		System.out.println("Motorstatus: " + car.getMotorOn());
		
		System.out.println("Tank muss gefüllt werden!");
		System.out.println("Tankfüllstand: " + car.getFuel());
		System.out.println("Tanken!");
		car.tanken(40);
		System.out.println("Tankfüllstand: " + car.getFuel());
		
		System.out.println("Motor des Fahrzeugs starten!");
		car.setMotorOn();
		System.out.println("Motorstatus: " + car.getMotorOn());
		
		System.out.println("##Aktuelle Position: " + car.getX());
		System.out.println("##Aktuelle Geschwindigkeit: " + car.getSpeed());
		System.out.println("##Aktuelle Spritmenge: " + car.getFuel());
		System.out.println("##Aktueller Motorstatus: " + car.getMotorOn());
		
		System.out.println("Geschwindigkeit auf 50 ändern!");
		car.setSpeed(50);
		
		System.out.println("Wait for 5 Seconds!");
		Traffic.waitAWhile(5000);
		
		System.out.println("##Aktuelle Position: " + car.getX());
		System.out.println("##Aktuelle Geschwindigkeit: " + car.getSpeed());
		System.out.println("##Aktuelle Spritmenge: " + car.getFuel());
		System.out.println("##Aktueller Motorstatus: " + car.getMotorOn());
		
		car.setMotorOff();
		
		System.out.println("Wait for 10 Seconds!");
		Traffic.waitAWhile(10000);
		
		car.setMotorOn();
		car.setSpeed(50);
		
		System.out.println("##Aktuelle Position: " + car.getX());
		System.out.println("##Aktuelle Geschwindigkeit: " + car.getSpeed());
		System.out.println("##Aktuelle Spritmenge: " + car.getFuel());
		System.out.println("##Aktueller Motorstatus: " + car.getMotorOn());
		
		System.out.println("Zur Tankstelle fahren und wieder volltanken!");
		car.tanken(40);
		
		System.out.println("Wait for 2 Seconds!");
		Traffic.waitAWhile(2000);
		
		System.out.println("##Aktuelle Position: " + car.getX());
		System.out.println("##Aktuelle Geschwindigkeit: " + car.getSpeed());
		System.out.println("##Aktuelle Spritmenge: " + car.getFuel());
		System.out.println("##Aktueller Motorstatus: " + car.getMotorOn());
		
		System.out.println("Motor starten udn Geschwindigkeit auf 120 setzten!");
		car.setMotorOn();
		car.setSpeed(120);
		
		System.out.println("Wait for 2 Seconds!");
		Traffic.waitAWhile(2000);
		
		System.out.println("##Aktuelle Position: " + car.getX());
		System.out.println("##Aktuelle Geschwindigkeit: " + car.getSpeed());
		System.out.println("##Aktuelle Spritmenge: " + car.getFuel());
		System.out.println("##Aktueller Motorstatus: " + car.getMotorOn());
		
		System.out.println("Wait for 15 Seconds!");
		Traffic.waitAWhile(15000);
		
		System.out.println("##Aktuelle Position: " + car.getX());
		System.out.println("##Aktuelle Geschwindigkeit: " + car.getSpeed());
		System.out.println("##Aktuelle Spritmenge: " + car.getFuel());
		System.out.println("##Aktueller Motorstatus: " + car.getMotorOn());
	}

}
