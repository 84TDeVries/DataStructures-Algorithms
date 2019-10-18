
/**
 * Write a description of class NodeP here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NodeP 
{
    private int val;
    private NodeP next;
    private NodeP prev;
    
    public NodeP (int i, NodeP n, NodeP p){
        val = i;
        prev = p;
        next = n; 
    }public int getValue(){
        return val; 
    }
}
