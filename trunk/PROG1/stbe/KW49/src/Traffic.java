import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class Traffic extends JFrame {  
    private Displayer displayer;
  
    public Traffic(Car car, Car car2){  
        setTitle("Traffic simulation");
        JPanel canvas = new DisplayArea(car, car2);
        getContentPane().add("Center", canvas);
        displayer = new Displayer(canvas);
        this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
        }
        );
        
    }
   
    public void start()  {
        displayer.start();
    }
   
   
    // interrupts work for the specified period (in milliseconds)
    public static void waitAWhile(long period)  {
        try { 
            Thread.sleep(period); 
        } catch(InterruptedException e) {};   
    } 
}

class DisplayArea extends JPanel  {
    private Car car;
    private Car car2;
    
    public DisplayArea(Car car, Car car2)  {
        this.car = car;
        this.car2 = car2;
    }
    
    public void paintComponent(Graphics g)  {
//    	super.paintComponent(g);
    	g.setColor(getBackground());
    	g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.blue);
        Dimension d = getSize();
        
        // get current location of the car and convert meters into pixels
        int x = (int) (car.getX()*8);
		x %= d.width;
        int y = (int) car.getY();
        
        // now paint the car
        g.fillOval(x, y, 10, 10);  
        g.fillOval(x+20, y, 10, 10); 
        g.fillRect(x-5,y-10,40,10);       
        g.drawRect(x+5,y-20,20,10);
        
        // if motor on show waste gas
        if (car.getMotorOn()) {
			g.setColor(Color.black);
			g.fillOval(x-30, y-10, 20, 10);
			g.fillOval(x-60, y-30, 25, 20);
        }
		
        
        final int scaleFactor = 4;
		g.setColor(Color.black);
		g.drawString("Speedometer:",0,140); 
		float maxSpeed = car.getMaxSpeed();
		g.drawRect(80,130,(int)(maxSpeed*scaleFactor),10); 
		g.setColor(Color.green); 
		float speed = car.getSpeed();
		if (speed < 0) {
			g.drawString("negative value",80,140);
		} else if (speed > maxSpeed) {
		    g.drawString("larger than max speed!!!!",80,140);
	    } else {
			g.fillRect(80,130,(int)(speed*scaleFactor),10);
	    }
		     
		g.setColor(Color.black);
		g.drawString("Fuel Gauge:",0,160);
		float maxFuel = car.getFuelTankCapacity(); 
		g.drawRect(80,150,(int)(maxFuel*scaleFactor),10);  
		g.setColor(Color.red);
		float fuel = car.getFuel(); 
		if (fuel < 0) {
		    g.drawString("negative value",80,160);
		} else if (fuel > maxFuel) {
			g.drawString("you are wasting gas filling in more than fuel tank capacity",80,160);
		} else {
			g.fillRect(80,150,(int)(fuel*scaleFactor),10);
		}
		
		// get current location of the car and convert meters into pixels
		g.setColor(Color.red);
        int x2 = (int) (car2.getX()*8);
		x2 %= d.width;
        int y2 = (int) car2.getY();
        
        // now paint the car
        g.fillOval(x2, y2, 10, 10);  
        g.fillOval(x2+20, y2, 10, 10); 
        g.fillRect(x2-5,y2-10,40,10);       
        g.drawRect(x2+5,y2-20,20,10);
        
        // if motor on show waste gas
        if (car2.getMotorOn()) {
			g.setColor(Color.black);
			g.fillOval(x2-30, y2-10, 20, 10);
			g.fillOval(x2-60, y2-30, 25, 20);
        }
		
        
        final int scaleFactor2 = 4;
		g.setColor(Color.black);
		g.drawString("Speedometer:",0,190); 
		float maxSpeed2 = car2.getMaxSpeed();
		g.drawRect(80,180,(int)(maxSpeed2*scaleFactor2),10); 
		g.setColor(Color.green); 
		float speed2 = car2.getSpeed();
		if (speed2 < 0) {
			g.drawString("negative value",80,190);
		} else if (speed2 > maxSpeed2) {
		    g.drawString("larger than max speed!!!!",80,190);
	    } else {
			g.fillRect(80,180,(int)(speed2*scaleFactor2),10);
	    }
		     
		g.setColor(Color.black);
		g.drawString("Fuel Gauge:",0,210);
		float maxFuel2 = car2.getFuelTankCapacity(); 
		g.drawRect(80,200,(int)(maxFuel2*scaleFactor2),10);  
		g.setColor(Color.red);
		float fuel2 = car2.getFuel(); 
		if (fuel2 < 0) {
		    g.drawString("negative value",80,210);
		} else if (fuel2 > maxFuel2) {
			g.drawString("you are wasting gas filling in more than fuel tank capacity",80,210);
		} else {
			g.fillRect(80,200,(int)(fuel2*scaleFactor2),10);
		}
    }
}


class Displayer extends Thread {  
    private JPanel panel;
  
    public Displayer(JPanel panel) { 
        this.panel = panel; 
    }
   
    public void run() {
        // the animation loop 
        while (true) {  
           panel.repaint(); // display a new animation frame
           Traffic.waitAWhile(20);
        }
    }
}
  

