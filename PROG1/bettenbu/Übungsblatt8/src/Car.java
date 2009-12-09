public class Car  {
   private float x;
   private boolean motorOn;
   private float speed;
   
   final private float maxSpeed; 
   private long t1 = 0;
   final private float fuelTankCapacity;
   private float fuel; 
   private float[] fuel_consumption = {0.1f,1,2,3,4,5,6,7,8,9,13};
  
   
   
    
   // dummy implementations, change it !!!
   public float getX()  {
      return updateCar(); 
   }
    
   public float getY()  {
      return 50;
   }    
    
   public boolean getMotorOn() {
      return motorOn;
   }
   
   public void setMotorOn(){
	   if (fuel > 0){
		   motorOn = true;
		   t1 = System.currentTimeMillis();
	   }
	   else
		   motorOn = false;
   		}
   
   public void setMotorOff(){
	   // vermeidung von endlosschleife weil aufruf durch update_car
	   if (fuel >0)
	   updateCar();
	   motorOn = false;
	   speed = 0;	   
   }
   
   public float getFuelTankCapacity() {
      return fuelTankCapacity;
   }
   
   
   public void tanken(float fuelAmount){
	   if (motorOn) 
		   setMotorOff();
	   if (fuel+fuelAmount <= fuelTankCapacity)
		   fuel += fuelAmount;
	   else
		   fuel = fuelTankCapacity;
		   
   }
    
   public float getFuel() {
      return fuel;
   }
    
   public float getMaxSpeed() {
      return maxSpeed;
   }
    
   public float getSpeed() {
	return speed;
   }
   
   public void setSpeed(float speed){
	   updateCar();
	   if (motorOn){
		   if (speed >= maxSpeed)
			   this.speed = maxSpeed;
		   else if (speed < maxSpeed)
			   this.speed = speed;			   
	   }	   
   }
   
private float updateCar(){	
	if (t1 != 0){
		float deltatime = System.currentTimeMillis() - t1;
		// ohne grafische oberfläche muss, sichergestellt werden, dass das auto stehen bleibt wenn der tank leer ist!
		if ((deltatime/1000) > (fuel/fuel_consumption[(int)((speed/maxSpeed)*10)]))
			deltatime = (fuel/fuel_consumption[(int)((speed/maxSpeed)*10)])*1000;
		
		x += speed*(deltatime/1000);		
		if (motorOn)
		fuel -= (deltatime/1000)*fuel_consumption[(int)((speed/maxSpeed)*10)]; 
		if (fuel <= 0){
			fuel = 0;
			setMotorOff();
		}		
	}	
	t1 = System.currentTimeMillis();
	System.out.println("Aktuelles X " + x);
	return x;
}

public Car(float maxSpeed, float fuelTankCapacity){
	this.maxSpeed = maxSpeed;
	this.fuelTankCapacity = fuelTankCapacity;
	this.fuel = fuelTankCapacity;
}
    
}