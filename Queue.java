
/**
 * Abstract class Queue - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Queue
{
    public static Object[] arr;
    public static int head; 
    public static int tail; 
    public Queue(int s){
        arr = new Object[s]; 
        head = 0;
        tail = 0; 
    }public Queue(Queue objects){
        arr = new Object[objects.size()]; 
        head = objects.getHead(); 
    }public void dequeue(){
         if (head - 1 >= 0){
             head--;
             arr[head] = null; 
         }else {
             head = arr.length-1; 
             arr[head] = null; 
         }
    }public void enqueue(Object i){
         if (tail+1 < arr.length){
             tail++; 
             arr[tail] = i; 
         }else {
             tail = 0; 
             arr[tail] = i; 
         }
    }public Object peek(){
        return arr[head]; 
    }public int getHead(){
        return head; 
    }public int getTail(){
        return tail; 
    }public int size(){
        return arr.length; 
    }
}
