
/**
 * Write a description of class Hanoi here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hanoi
{
    public static void main(String[] args){
        
    }public static void solve(int numDisks, int fromPeg, int toPeg){
        if (numDisks == 0){
             
        }else {
            int sparepeg = hanoi.getSparePeg(fromPeg, toPeg);
            solve(numDisks-1,fromPeg, sparepeg); 
            hanoi.moveDisk(fromPeg, toPeg);
            solve(numDisks-1, sparepeg, toPeg); 
        }
    }
}
