
package ocv; 
  
import org.opencv.core.*;  
import org.opencv.imgcodecs.Imgcodecs; 
import org.opencv.imgproc.Imgproc; 
  
public class Watershed { 
   public static void main( String[] args ) 
   { 
      try{ 
         // For proper execution of native libraries 
         // Core.NATIVE_LIBRARY_NAME must be loaded before 
            // calling any of the opencv methods 
         //this code used watershed algorithm to segment out images
         System.loadLibrary( Core.NATIVE_LIBRARY_NAME ); 
  
         Mat source = 
         Imgcodecs.imread("/home/dell/Desktop//plant004_rgb.png", Imgcodecs.CV_LOAD_IMAGE_COLOR); 
         Mat destination = new Mat(source.rows(), source.cols(), source.type()); 
 
         Imgproc.GaussianBlur(source, destination, new Size(0, 0), 10); 
         Core.addWeighted(source, 1.5, destination, -0.5, 0, destination); 

         Imgcodecs.imwrite("/home/dell/Desktop//plant008_rgb.png", destination); 
      }catch (Exception e) { 
      } 
   } 
} 
