import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
  
public class MirrorImage 
{ 
    public static void main(String args[])throws IOException
    { 
        // BufferedImage for source image 
        BufferedImage simg = null; 
  
        // File object 
        File f = null; 
        
        // Read source image file 
        try
        { 
            f = new File("/home/dell/Desktop//input.png"); 
            simg = ImageIO.read(f); 
        } 
  
        catch(IOException e) 
        { 
            System.out.println("Error: " + e); 
        } 
  
        // Read source image file 
       
  
        // Get source image dimension 
        int width = simg.getWidth(); 
        int height = simg.getHeight(); 
        System.out.println(width);
        System.out.println(height);
  
        // BufferedImage for mirror image 
        BufferedImage mimg = new BufferedImage(width, height, 
                                        BufferedImage.TYPE_INT_ARGB); 
  
        // Create mirror image pixel by pixel 
        for (int y = 0; y < height; y++) 
        { 
            for (int lx = 0, rx = width - 1; lx < width; lx++, rx--) 
            { 
                int p = simg.getRGB(lx, y);  
                mimg.setRGB(rx, y, p); 
            } 
        } 
        int width1 = mimg.getWidth(); 
        int height1 = mimg.getHeight(); 
        System.out.println(width1);
        System.out.println(height1);
  
        try
        { 
            f = new File("/home/dell/Desktop//output.png"); 
            ImageIO.write(mimg, "png", f); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Error: " + e); 
        } 
        
    } 
} 