
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node
{
    public int value;
    public int index;
    public Node left;
    public Node right;
    public Node(int i){
        
        value = i; 
    }public int getValue(){
        return value; 
    }public void setLeft(Node n){
        left = n;
    }public void setRight(Node n){
        right = n; 
    }public Node getLeft(){
        return left;
    }public Node getRight(){
        return right; 
    }
}
