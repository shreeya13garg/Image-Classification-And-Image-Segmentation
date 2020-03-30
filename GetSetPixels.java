import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
import javax.swing.*;
import java.awt.event.*;
  
public class GetSetPixels 
{ 
    private static void resizeImage(BufferedImage image)
         {
            JLabel imageLabel = new JLabel();

            int imageWidth = image.getWidth(null);
            int imageHeight = image.getHeight(null);
            System.out.println("Width:" + imageWidth);
            System.out.println("Height:" + imageHeight);
         }

    public static void main(String args[])throws IOException 
    { 
        //System.out.println("Hello");
        
       
        BufferedImage img = ImageIO.read(new File("/home/dell/Desktop//plant004_rgb.png"));
        //read image 
        
        //get image width and height 
        //int width = img.getWidth(null); 
        //int height = img.getHeight(null); 
  
        /*  Since, Inp.jpg is a single pixel image so, we 
            will not be using the width and height variable */
  
        /* get pixel value (the arguments in the getRGB method 
         denotes the  cordinates of the image from which the 
         pixel values need to be extracted) */
        //System.out.println(img); 
        resizeImage(img);
        int p = img.getRGB(0,0); 
  
        /* We, have seen that the components of pixel occupy 
           8 bits. To get the bits we have to first right shift 
           the 32 bits of the pixels by bit position(such as 24 
           in case of alpha) and then bitwise ADD it with 0xFF. 
           0xFF is the hexadecimal representation of the decimal 
           value 255.  */
  
        // get alpha 
        System.out.println(p);   
        int a = (p>>24) & 0xff; 
        System.out.println(a);
        // get red 
        int r = (p>>16) & 0xff; 
        System.out.println(r);
  
        // get green 
        int g = (p>>8) & 0xff; 
        System.out.println(g);
        // get blue 
        int b = p & 0xff; 
        System.out.println(b);
        /* 
        for simplicity we will set the ARGB 
        value to 255, 100, 150 and 200 respectively. 
        */
        a = 255; 
        r = 0; 
        g = 0; 
        b = 0; 
  
        //set the pixel value 
        p = (a<<24) | (r<<16) | (g<<8) | b;
        System.out.println(p); 
        img.setRGB(0, 0, p); 
  
        //write image 
        try
        { 
            
            File f = new File("/home/dell/Desktop//plant005_rgb.png"); 
            ImageIO.write(img, "png", f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
    } 
} 