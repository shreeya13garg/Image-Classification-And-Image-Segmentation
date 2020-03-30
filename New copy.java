import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
  
public class New
{ 
    public static void main(String args[])throws IOException 
    { 
        BufferedImage img = null; 
        File f = null; 
  
        // read image 
        try
        { 
            f = new File("/Users/shreeyagarg/Desktop/plant.jpg"); 
            img = ImageIO.read(f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
        //System.out.println("Hello");
        // get image's width and height 
        int width = img.getWidth(); 
        System.out.println(width);
        int height = img.getHeight(); 
  
        // convert to greyscale 
        for (int y = 0; y < height; y++) 
        { 
            for (int x = 0; x < width; x++) 
            { 
                // Here (x,y)denotes the coordinate of image  
                // for modifying the pixel value. 
                int p = img.getRGB(x,y); 
  
                int a = (p>>24)&0xff; 
                int r = (p>>16)&0xff; 
                int g = (p>>8)&0xff; 
                int b = p&0xff; 
  
                // calculate average 
                int avg=0;
                if(g>135)
                    avg = 0;
                else
                    avg=255; 

                // replace RGB value with avg 
                p = (a<<24) | (avg<<16) | (avg<<8) | avg; 
  
                img.setRGB(x, y, p); 
            } 
        } 
  
        // write image 
        try
        { 
            f = new File("/Users/shreeyagarg/Desktop/plant007_rgb.png"); 
            ImageIO.write(img, "png", f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
    } 
} 