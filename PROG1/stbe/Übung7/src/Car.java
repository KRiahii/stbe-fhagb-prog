public class Car  {
   private float x;
   private boolean motorOn;
   private float fuel;
   private final float maxSpeed;
   private final float maxFuel;
   private float speed;
   private long time = 0;
   private float[] spritVerbrauch;

   /**
    * Gibt die aktuelle Position des Fahrzeugs in X-Richtung zurück
    * @return Aktuelle X-Position des Fahrzeugs
    */
   public float getX()  {
	   updateCar();
	   return x;       
   }
   
   /**
    * Gibt die aktuelle Position des Fahrzeugs in Y-Richtung zurück
    * @return Aktuelle Y-Position des Fahrzeugs
    */
   public float getY()  {
      return 50;
   }
    
   /**
    * Gibt den Status des Motos zurück
    * @return Aktueller Motorstatus
    */
   public boolean getMotorOn() {
	   updateCar();
	   return motorOn;
   }
   
   /**
    * Startet den Motor des Fahzeugs, aber nur wenn Sprit vorhanden ist
    */
   public void setMotorOn(){
	   if(fuel > 0){
		   motorOn = true;
		   time = System.nanoTime();
	   }
	   else
		   motorOn = false;
   }

   /**
    * Stopt den Motor des Fahrzeugs und aktualisiert die Position des Fahrzeugs.
    */
   public void setMotorOff(){
	   updateCar();
	   motorOn = false;
	   speed = 0;
   }
   
   /**
    * Gibt die maximale Füllmenge des Tanks zurück
    * @return maximale Füllmenge des Tanks
    */
   public float getFuelTankCapacity() {
      return maxFuel;
   }
   
   /**
    * Gibt die aktuelle Füllmenge des Tanks zurück
    * @return Aktuelle Füllmenge des Tanks
    */ 
   public float getFuel() {
      updateCar();
	  return fuel;
   }
   
   /**
    * Fügt dem Tank neuen Sprit hinzu. 
    * Spritmenge die aufgetankt werden kann ist maximal so groß wie die maximale Füllmenge des Tanks
    * Fals nicht geschehen wird der Motor gestoppt bevor aufgetankt wird
    * @param fuel Menge des getankten Sprit
    */
   public void tanken(float fuel){
	   updateCar();
	   if(motorOn)
		   setMotorOff();
	   if(fuel > 0)
		   if(this.fuel + fuel < this.maxFuel)
			   this.fuel += fuel;
		   else
			   this.fuel = this.maxFuel;
   }
   
   /**
    * Gibt die Höchstgeschwindigkeit des Fahrzeugs zurück
    * @return Höchstgeschwindigkeit
    */
   public float getMaxSpeed() {
      return maxSpeed;
   }
    
   /**
    * Gibt die aktuelle Geschwindigkeit des Fahrzeugs zurück
    * @return Aktuelle Geschwindigkeit
    */
   public float getSpeed() {
	   updateCar();
	   return speed;
   }
   
   /**
    * Methode zur Veränderung der aktuellen Geschwindigkeit des Fahrzeugs
    * Maximal mögliche Geschwindigkeit ist die Höchstgeschwindigkeit.
    * Der Motor muss an sein um die Geschwindkeit verändern zu können.
    * @param speed Zu setzende Geschwindigkeit
    */
   public void setSpeed(int speed){
	   updateCar();
	   if(speed >= 0 && motorOn)
		   if(speed < maxSpeed){
			   this.speed = speed;
		   }
		   else{
			   this.speed = this.maxSpeed;
		   }
   }
   
   /**
    * Konstruktor zur Erstellung eines Fahrzeugs.
    * Setzt Höchstgeschwindigkeit, maximale Kapazität des Tanks und den Verbrauch.
    * @param maxSpeed Höchstgeschwindigkeit
    * @param maxFuel Maximale Kapazität des Tanks
    */
   public Car(float maxSpeed, float maxFuel){
	   this.maxSpeed = maxSpeed;
	   this.maxFuel = maxFuel;
	   this.time = System.nanoTime();
	   
	   spritVerbrauch = new float[(int)maxSpeed / 10 + 1];
	   float startVerbrauch = 1.0f;
	   float stepVerbauch = 0.2f;
	   for(int i = 0;i < spritVerbrauch.length; i++){
		   spritVerbrauch[i] = startVerbrauch + i * stepVerbauch;
	   }
   }
   
   /**
    * Methode zur Aktualisierung von Position und Tankfüllstand des Fahrzeugs in Abhängigkeit der vergangenen Zeit.
    * Tankfüllstand ändert sich nur wenn der Motor des Fahrzeugs gestartet ist.
    * Fals der Tank leer stirbt der Motor ab und das Auto bleibt stehen.
    */
   private void updateCar(){
	   float timeold = time;
	   time = System.nanoTime();
	   float deltaTime = time - timeold;
	   

	   if((fuel / spritVerbrauch[(int) (speed / 10)]) < (deltaTime / 1000000000)){
		   deltaTime = fuel / spritVerbrauch[(int) (speed / 10)] * 1000000000;
//			   fuel = 0;
	   }
	   
	   x += (deltaTime / 1000000000) * speed;
	   if(motorOn)
		   fuel -= (deltaTime / 1000000000) * spritVerbrauch[(int) (speed / 10)];
	   
	   if(tankleer()){
		   fuel = 0;
		   motorOn = true;
		   speed = 0;
	   }
   }
   
   private boolean tankleer(){
	   if(fuel < 0.000001)
		   return true;
	   else
		   return false;
   }
}