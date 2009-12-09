import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class PhotoHopp {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image srcImage = toolkit.getImage("river.gif");
	
        ImageFilter colorfilter = new TestFilter();
        Image filteredImage = toolkit.createImage(
            new FilteredImageSource(srcImage.getSource(),colorfilter));
        JFrame srcFrame = new DisplayFrame(srcImage,0,0,500,200);
        JFrame filteredFrame = new DisplayFrame(filteredImage,0, 200, 500, 200);
    
        filteredFrame.setBackground(Color.red);  


        Image srcImage2 = toolkit.getImage("farbenkreis_b.gif");
	
        Image filteredImage2 = toolkit.createImage(
            new FilteredImageSource(srcImage2.getSource(),colorfilter));
        JFrame srcFrame2 = new DisplayFrame(srcImage2, 500, 0, 200, 200);
        JFrame filteredFrame2 = new DisplayFrame(filteredImage2, 500, 200, 200, 200);

        filteredFrame2.setBackground(Color.red);              
     }
}

class DisplayFrame extends JFrame  {
    private Image image;
    int x,y,b,h;

    public DisplayFrame(Image image, int x, int y, int b, int h)  {
        this.image = image;
        this.x = x;
        this.y = y;
        this.b = b;
        this.h = h;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(x,y,b,h);
        this.setVisible(true);
    }
    
    public void paint(Graphics g) {    
        g.drawImage(image, 0, 0,b, h, this); 
    }
}
    
    

class TestFilter extends RGBImageFilter {
  
    public int filterRGB(int x, int y, int pixel) {
        int filteredPixel = 0;
    
        // enjoy working with pixels here    
        // as an example extract one color part
  	   
        // rgb 0xaarrggbb
        // a= alpha r=rot g=gr�n b=blau
        int alpha = (pixel & 0xff000000);
        int rot = (pixel & 0x00ff0000);
        int gr�n = (pixel & 0x0000ff00);
        int blau = (pixel & 0x000000ff);
        
        char auswahl = 'p';
        switch (auswahl) {
        	//rot herausfiltern
        	case('a'):
        		filteredPixel = (pixel & 0xff00ffff);	
        		break;
        	//gr�n herausfiltern
        	case('b'):
        		filteredPixel = (pixel & 0xffff00ff);
        		break;
    		//blau filtern
        	case('c'):
        		filteredPixel = (pixel & 0xffffff00);
    			break;
        	//alles blau f�rben
        	case('d'):
        		filteredPixel = (0xff0000ff);
        		break;
        	//rot und blau vertauschen mittels shift
        	case('e'):
        		rot = rot>>16;
        		blau = blau<<16;
        		//oder verkn�pfung der einzelnen farben
        		filteredPixel = alpha | rot | gr�n | blau;
        		break;
        	//nur dunkle stelle darstellen
        	case('f'):
        		rot = rot>>16;
        		gr�n = gr�n>>8;
        		if (rot<80 || gr�n<80 || blau<80)	
        			filteredPixel = pixel;
        		else filteredPixel = 0xff000000;
    		break;
        	//nur helle stellen darstellen
        	case('g'):
        		rot = rot>>16;
        		gr�n = gr�n>>8;
        		if (rot>180 || gr�n>180 || blau>180)	
        			filteredPixel = pixel;
        		else filteredPixel = 0xff000000;
    		break;
    		case('h'):
    		//was macht das erste byte??
    			filteredPixel = (pixel & 0x7affffff);
    			//antwort l�sst den hintergrund mehr, oder weniger hervortreten (transparenz)
    			break;
    		//ein bisschen aufhellen
    		case('i'):
    		
	    		rot = (rot>>16) + 40;
	    		if (rot > 255)
	    			rot = 255;
    			rot = rot<<16;
	    		gr�n = (gr�n>>8) + 40;
	    		if (gr�n > 255)
	    			gr�n = 255;
	    		gr�n = gr�n<<8;
	    		blau = blau + 40;
	    		if (blau > 255)
	    			blau = 255;
    	    		
	    		filteredPixel = alpha | rot | gr�n | blau;
    		break;
    		//graustufenbild
    		
    		case('j'):
    			rot = rot>>16;
        		gr�n = gr�n>>8;
    			int mittelwert = (rot+gr�n+blau)/3;
    			rot = gr�n = blau = mittelwert;
    			rot = rot<<16;
    			gr�n = gr�n<<8;
    			filteredPixel = alpha | rot | gr�n | blau;
			break;
			
			//schwarz wei�
    		case('k'):
    			rot = rot>>16;
        		gr�n = gr�n>>8;
        		if (rot>120 || gr�n>120 || blau>120)	
        			filteredPixel = 0xffffffff;
        		else filteredPixel = 0xff000000;
    		break;
    		
    		//invertierte farbdarstellung, alphawerte m�ssen wiederhergestellt werden
    		case('l'):
    			filteredPixel = (~pixel | 0xff000000);
    		break;
    		
    		//nur oberes rechtes Rechteck darstellen
    		// koordinatensystem beginnt oben links, warum auch immer :-)
    		case('m'):
    			if (x>=187 & x<=375 & y>=0 & y<=92)
    				filteredPixel = pixel;
    			else 
    				filteredPixel = 0xffffffff;
			break;
			
			//diagonalen, kreuzung
    		case('n'):
    			if (y == 0.5*x | (185-y) == 0.5*x)
    				filteredPixel = 0xff0000ff;
    			else
    				filteredPixel = pixel;
			break;
    		
			//wasserzeichen 
    		case('o'):
    			if (x>330 & x<360 & y>40 & y<80
    				&!(x>340 & x<350 & y>50 & y<70))
    				{
    				rot = (rot>>16) + 30;
    	    		rot = rot<<16;
    	    		gr�n = (gr�n>>8) + 30;
    	    		gr�n = gr�n<<8;
    	    		blau = blau + 30;
        	    		
    	    		filteredPixel = alpha | rot | gr�n | blau;
    				}
    			else
    				filteredPixel = pixel;
			break;
			
			//heller vom zentrum aus
    		case('p'):
    			int xmid = 187; 
	            int ymid = 92; 
	             
	            int distXmid = xmid - x; 
	            int distYmid = ymid - y; 
	             
	            int distmid = (int) Math.sqrt((Math.pow(distXmid, 2) + Math.pow(distYmid, 2))); 
	             
	            rot = (rot>>16) + distmid; 
	            if (rot > 0xFF) 
	                 rot = 0xFF; 
	            rot<<=16; 
	             
	            gr�n = (gr�n>>8) + distmid; 
	            if (gr�n > 0xFF) 
	                 gr�n = 0xFF; 
	            gr�n<<=8; 
	             
	            blau = (blau) + distmid; 
	            if (blau > 0xFF) 
	                 blau = 0xFF; 
	             
	            filteredPixel = alpha | rot  | gr�n | blau; 
            break;
    		default: filteredPixel = pixel;
           
			
        		
        		}
        
        return filteredPixel;     
        
    }
}