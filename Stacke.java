import java.util.*; 
/**
 * Abstract class Stack - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Stacke
{
    private static ArrayList<Object> arr; 
    private static int size = 0;
    public Stacke(){
        
    }public Stacke(Stacke objects){
        
    }public void dequeue(){
        if (size <= 0){}
        else {
            arr.remove(size); 
            size--; 
        }
    }public void enqueue(Object i){
        arr.add(size, i); 
        size++; 
    }public Object peek(){
        return arr.get(size); 
    }public int getTop(){
        return size; 
    }public void print(){
        if (size > 0){
            System.out.print((int)arr.get(0)); 
            for(int i = 1; i < size; i++){
               System.out.print("," + (int)arr.get(size)); 
            }System.out.println(); 
        }
    }
    
    
    
}
