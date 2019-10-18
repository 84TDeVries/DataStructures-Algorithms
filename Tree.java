
/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree
{
    private static Node start; 
    
    public Tree(Node n){
        start = n; 
    }public Tree(){
        
    }public void add(Node n){
        if (start == null)
           start = n; 
        else{
            compare(start, n); 
        }
    }public void compare(Node n,Node temp){
        if(n.getValue() == temp.getValue()){}
        else if(n.getValue() > temp.getValue()){
            
            if (start.getRight() != null){
                compare(start.getRight(), temp);
            }else {
                n.setRight(temp); 
            }
        }else {
            if (start.getLeft() != null){
                compare(start.getLeft(), temp);
            }else {
                n.setLeft(temp); 
            }
        }
    }public void print(){
        
    }
}
