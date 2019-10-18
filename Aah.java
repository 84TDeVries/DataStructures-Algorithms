
/**
 * Write a description of class Aah here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*; 
public class Aah
{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in); 
        String jon = console.next(); 
        String required = console.next(); 
        if (jon.length() >= required.length()){
            System.out.println("go"); 
        }else
            System.out.print("no"); 
    }
}
