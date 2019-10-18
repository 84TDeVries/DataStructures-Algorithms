import java.util.*; 
/**
 * Abstract class Stack - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Stack
{
    public static Object[] arr;
    public static int top; 
    public Stack(int i){
        arr = new Object[i]; 
        top = 0; 
        arr[0] = 0; 
    }public Stack(Stack objects){
        top = objects.getTop(); 
    }public void dequeue(){
        if (top > 0){
            arr[top] = null;
            top--;
        }else
            throw new IllegalArgumentException(); 
    }public void enqueue(Object i){
        if (top == arr.length-1){
            throw new IllegalArgumentException(); 
        }
        arr[top] = i; 
        top++;
    }public Object peek(){
        if (top > 0)
            return arr[top-1]; 
        return null; 
    }public int getTop(){
        return top; 
    }public int size(){
        return arr.length; 
    }public void print(){
        if (top > 0){
            System.out.print(arr[0]); 
            for(int i = 1; i < top; i++){
               System.out.print("," + (int)arr[i]); 
            }System.out.println(); 
        }
    }
    
    
    
}
