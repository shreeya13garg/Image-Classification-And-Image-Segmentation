import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
  
public class green
{ 
    public static void main (String args[])throws IOException 
    { 
        BufferedImage img = null; 
        File f = null; 
  
        // read image 
        try
        { 
            f = new File("/home/dell/Desktop//plant004_rgb.png"); 
            img = ImageIO.read(f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
  
        // get width and height 
        int width = img.getWidth(); 
        int height = img.getHeight(); 
  
        // convert to green image 
        for (int y = 0; y < height; y++) 
        { 
            for (int x = 0; x < width; x++) 
            { 
                int p = img.getRGB(x,y); 
  
                int a = (p>>24)&0xff; 
                int g = (p>>8)&0xff; 
  
                // set new RGB 
                // keeping the g value same as in original 
                // image and setting r and b as 0. 
                p = (a<<24) | (0<<16) | (g<<8) | 0; 
  
                img.setRGB(x, y, p); 
            } 
        } 
        // write image 
        try
        { 
            f = new File("/home/dell/Desktop//plant007_rgb.png"); 
            ImageIO.write(img, "png", f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
    } 
} 