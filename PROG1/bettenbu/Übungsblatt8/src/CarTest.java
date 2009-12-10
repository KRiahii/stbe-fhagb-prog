import java.io.IOException;

public class CarTest  {  
    public static void main(String[] args) throws IOException { 
        //car constructor maxspeed, fueltankcap
    	Car car = new Car(200, 100);  
        
        Traffic traffic = new Traffic(car);
        traffic.setSize(1000, 200);
        traffic.setVisible(true);  
     
        // start animation
        traffic.start();
        
        // put your code for car state manipulation here
        
//		  nur ein test
//        car.setMotorOn();
//        car.setSpeed(200);
//        Traffic.waitAWhile(5000);        
//        car.setMotorOff();
//        Traffic.waitAWhile(100);   
//        car.setMotorOn();
//        Traffic.waitAWhile(1000); 
//        car.setSpeed(100);
//        Traffic.waitAWhile(2000);
//        car.setMotorOff();
        

        
        
        
        
        
        
//        // 7 Sekunden fahren
//        Traffic.waitAWhile(7000);
//        // Tanken und 2 Sekunden warten
//        car.tanken(30);
//        Traffic.waitAWhile(2000);
//        //nach dem Tanken weiter fahren mit speed = 50
//        car.setMotorOn();
//        car.setSpeed(50);
//        // 5 Sekunden weiter fahren dann Motor aus
//        Traffic.waitAWhile(5000);
//        car.setMotorOff();
        
       
        //Motor anlassen
        car.setMotorOn();
        
        // auf 180 beschleunigen
        for (int i = 20; i < 180; i+=3){
        	Traffic.waitAWhile(100);
        	car.setSpeed(i);
        }
        // bremsen
        for (int j = 180; j >= 0; j -= 10){
        	Traffic.waitAWhile(100);
        	car.setSpeed(j);
        }
        // 50 l tanken, 2 sek warten und mit 50 weiter fahren
        car.tanken(50);
        Traffic.waitAWhile(2000);
        car.setMotorOn();
        car.setSpeed(50);   
        
    } 
}