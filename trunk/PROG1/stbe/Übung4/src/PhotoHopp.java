

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;

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
  
    public int filterRGB(int x, int y, int pixel)
    {
        int filteredPixel = pixel;
        
        //Verteilung der Bits im Int filteredPixel
        // 00000000 00000000 00000000 00000000
        // alpha	rot		 grün	  blau
        
        final int A_RED = 1;			//a) Rot  herausfiltern
        final int A_GREEN = 2;			//a) Grün herausfiltern
        final int A_BLUE = 3;			//a) Blau herausfiltern
        final int B_RED = 4;  			//b) Bild komplett in Rot färben
        final int B_GREEN = 5;			//b) Bild komplett in Grün färben
        final int B_BLUE = 6;			//b) Bild komplett in Blau färben
        final int C_INVERT_BLUE_RED = 7;//c) Rot und Blau vertauschen
        final int D_BRIGHT = 8;			//d) Nur Helle anzeigen
        final int D_DARK = 9;			//d) Nur Dunkle anzeigen
        final int E_ALPHA = 10;			//e) Bedeutung des ersten Byte
        final int F_HELLER = 11;		//f) Bild heller machen
        final int G_GREY = 12;			//g) Bild in Graustufen
        final int G_SCHWARZ_WEIS = 13;	//g) SchwarzWeiß-Bild
        final int H_INVERTCOLORS = 14;	//h) Farben umkehren
        final int I_TEILRECHTECK = 15;  //i) Nur ein Teilrechteck anzeigen
        final int I_DIAGONALE = 16;		//i) Diagonale anzeigen - nicht implementiert!
        final int I_HELLER_ZENTRUM = 17;//i) Bild vom Zentrum her heller machen
        final int I_WASSERZEICHEN = 18; //i) Wasserzeichen erstellen
        final int J_SPIELEREI = 19;		//j) Quadrate erstellen
        
        int ausgewählteOperation = J_SPIELEREI;
        
        int pixelRed = (pixel & 0x00FF0000); 	//Nur die Bits für Rot
    	int pixelGreen = (pixel & 0x00FF00);	//Nur die Bits für Grün
    	int pixelBlue = (pixel & 0x000000FF);	//Nur die Bits für Blau
    	int pixelAlpha = (pixel & 0xFF000000);	//Nur die Bits für Alpha
        
        switch(ausgewählteOperation)
        {
	        case A_RED :
	        	filteredPixel = (pixel & 0xFF00FFFF); //Rotanteile herausfiltern
	        	break;
	        case A_GREEN :
	        	filteredPixel = (pixel & 0xFFFF00FF); //Grünanteile herausfiltern
	        	break;
	        case A_BLUE :
	        	filteredPixel = (pixel & 0xFFFFFF00); //Blauanteile herausfiltern
	        	break;
	        case B_RED :
	        	filteredPixel = 0xFFFF0000; //Komplett rot streichen
	        	break;
	        case B_GREEN :
	        	filteredPixel = 0xFF00FF00; //Komplett grün streichen
	        	break;
	        case B_BLUE :
	        	filteredPixel = 0xFF0000FF; //Komplett blau streichen
	        case C_INVERT_BLUE_RED :
	        	pixelRed >>= 16;					 		//Rot nach Blau verschieben
	        	pixelBlue<<= 16;					 		//Blau nach Rot verschieben
	        	int newPixelBR = pixelRed | pixelBlue;	//Blau und Rot vertauscht
	        	filteredPixel = pixelAlpha | pixelGreen | newPixelBR;//Alpha/Grün mit vertauschten Rot/Blau zusammensetzen
	        	break;
	        case D_BRIGHT :
	        	pixelRed = pixelRed >> 16;
	        	pixelGreen = pixelGreen >> 8;
	        	if(pixelRed   < 125 
	        	|| pixelGreen < 125 
	        	|| pixelBlue  < 125)
	        	{
	        		filteredPixel = 0xFFFFFFFF;				//Pixel weiß machen
	        	}
	        	break;
	        case D_DARK :
	        	pixelRed = pixelRed >> 16;
	        	pixelGreen = pixelGreen >> 8;
	        	if(pixelRed   > 125 
	        	|| pixelGreen > 125 
	        	|| pixelBlue  > 125)
	        	{
	        		filteredPixel = 0xFF000000;				//Pixel schwärzen
	        	}
	        	break;
	        case E_ALPHA :
	        	filteredPixel = 0x7000000 | (pixel & 0x00FFFFFF);
	        	//Das erste Byte bestimmt die Transparenz des Pixels
	        	break;
	        case F_HELLER :
	        	pixelRed = (pixelRed>>16) + 50;
	        	if (pixelRed > 0xFF)
	        		pixelRed = 0xFF;
	        	pixelRed<<=16;
	        	
	        	pixelGreen = (pixelGreen>>8) + 50;
	        	if (pixelGreen > 0xFF)
	        		pixelGreen = 0xFF;
	        	pixelGreen<<=8;
	        	
	        	pixelBlue = (pixelBlue) + 50;
	        	if (pixelBlue > 0xFF)
	        		pixelBlue = 0xFF;
	        	
	        	filteredPixel = pixelAlpha | pixelRed  | pixelGreen | pixelBlue;
	        	break;
	        case G_GREY :
	        	int tempGes = (pixelRed>>16) + (pixelGreen>>8) + pixelBlue; //Gesamtwert der Pixel
	        	pixelRed = pixelGreen = pixelBlue = tempGes / 3 ;//Mittelwert der Pixel
	        	filteredPixel = pixelAlpha | (pixelRed<<16) | (pixelGreen<<8) | pixelBlue;
	        	break;
	        case G_SCHWARZ_WEIS :
	        	pixelRed = pixelRed >> 16;
	        	pixelGreen = pixelGreen >> 8;
	        	if(pixelRed > 128 | pixelGreen > 128 | pixelBlue > 128)
	        		filteredPixel = 0xFFFFFFFF;
	        	else
	        		filteredPixel = 0xFF000000;
	        	break;
	        case H_INVERTCOLORS :
	        	filteredPixel = (~pixel) | 0xFF000000;	//Farben umkehren
	        	break;
	        case I_TEILRECHTECK :
	        	if((x > 75 && x < 300) && (y>50 && y<150))
	        	{
	        		filteredPixel = pixel;
	        	}
	        	break;
	        case I_DIAGONALE :
	        	if(x==y)
	        		filteredPixel = 0xFFFF0000;
	        	break;
	        case I_HELLER_ZENTRUM :
	        	int xmid = 187;
	        	int ymid = 92;
	        	
	        	int distXmid = xmid - x;
	        	int distYmid = ymid - y;
	        	
	        	int distmid = (int) Math.sqrt((Math.pow(distXmid, 2) + Math.pow(distYmid, 2)));
	        	
	        	pixelRed = (pixelRed>>16) + distmid + 20;
	        	if (pixelRed > 0xFF)
	        		pixelRed = 0xFF;
	        	pixelRed<<=16;
	        	
	        	pixelGreen = (pixelGreen>>8) + distmid + 20;
	        	if (pixelGreen > 0xFF)
	        		pixelGreen = 0xFF;
	        	pixelGreen<<=8;
	        	
	        	pixelBlue = (pixelBlue) + distmid + 20;
	        	if (pixelBlue > 0xFF)
	        		pixelBlue = 0xFF;
	        	
	        	filteredPixel = pixelAlpha | pixelRed  | pixelGreen | pixelBlue;
	        	break;
	        case I_WASSERZEICHEN :
	        	if( ((x > 169 && x < 200) && (y > 64 && y < 116))
	        	&& !((x > 179 && x < 200) && (y > 74 && y < 85))
	        	&& !((x > 169 && x < 190) && (y > 94 && y < 106)))
	        	{
	        		pixelRed = (pixelRed>>16) - 15;
		        	if (pixelRed < 0xFF)
		        		pixelRed = 0xFF;
		        	pixelRed<<=16;
		        	
		        	pixelGreen = (pixelGreen>>8) - 15;
		        	if (pixelGreen < 0xFF)
		        		pixelGreen = 0xFF;
		        	pixelGreen<<=8;
		        	
		        	pixelBlue = (pixelBlue) - 15;
		        	if (pixelBlue < 0xFF)
		        		pixelBlue = 0xFF;
		        	
		        	filteredPixel = pixelAlpha | pixelRed  | pixelGreen | pixelBlue;
	        	}
	        	break;
	        case J_SPIELEREI :
	        	int xmodolo = x % 20;
	        	int ymodolo = y % 10;
	        	
	        	if(xmodolo < 10 && ymodolo >= 5)
	        		filteredPixel = 0xBBFFFFFF & pixel;
	        	if(xmodolo >= 10 && ymodolo < 5)
	        		filteredPixel = 0xDDFFFFFF & pixel;;
	        	break;
	        default : 
	        	;	//Unbekannte Operation - nichts tun
        }
        
        return filteredPixel;
    }
}