
/**
 * Write a description of class Quadrant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*; 
public class Quadrant
{
    public static void main(String []args){
        Scanner console = new Scanner(System.in); 
        int x = console.nextInt(); 
        int y = console.nextInt(); 
        if (x > 0 && y > 0 ){
            System.out.print("1"); 
        }else if (x < 0 && y > 0 ){
            System.out.print("2"); 
        }else if (x < 0 && y < 0 ){
            System.out.print("3"); 
        }else {
            System.out.print("4"); 
        }
    }
}
