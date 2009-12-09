public class CarTest  {  
    public static void main(String[] args) { 
        Car car = new Car(200, 100);     
        car.tanken(20);
        car.setMotorOn();
        car.setSpeed(10);
        
        Car car2 = new Car(200, 100);
        car2.tanken(80);
        car2.setMotorOn();
        car2.setSpeed(50);
        
        Traffic traffic = new Traffic(car, car2);
        traffic.setSize(1000, 300);
        traffic.setVisible(true);  
     
        // start animation
        traffic.start();
        
        // put your code for car state manipulation here
        Traffic.waitAWhile(2000);
        
        //Motor abwürgen
        car.setMotorOff();
        
        Traffic.waitAWhile(2000);
        
        //Voll tanken
        car.tanken(10);
        
        car.setMotorOn();
        
        //Auf 150 Beschleunigen
        for(int i = 0;i <= 150; i += 2){
        	Traffic.waitAWhile(50);
        	car.setSpeed(i);
        }

        Traffic.waitAWhile(2000);
        
        //Auf 0 runterbremsen
        for(int i = 150;i > -1; i -= 2){
        	Traffic.waitAWhile(50);
        	car.setSpeed(i);
        }
        
        Traffic.waitAWhile(1000);
        
        car.setMotorOff();
    } 
}