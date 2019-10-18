import javax.swing.*; 
import java.util.*;
import java.awt.*; 

public class Fractal extends JFrame {
    public static Scanner console = new Scanner(System.in); 
    public static int n = 3; 
    public static int r = 900;
    public static double scale = 1.05;
    public static int col = 0; 
    public static char shape; 
    public Fractal() {
        setVisible(true);
        setResizable(false);
        setSize(1000,1000); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        validate();
        
    }
    public static void main(String[] args){
        Fractal f = new Fractal();
        
        while(console.hasNextInt()){
            n = console.nextInt(); 
            //scale = console.nextDouble(); 
            col = 0; 
            if (n == -1)
                break; 
            SwingUtilities.updateComponentTreeUI(f);
        }
    }public void paint(Graphics g, int num){
        if (n <= 0){
            
        }else {
            if (col == 1){
                g.setColor(Color.RED); 
                col = 2;
            }else if (col == 2){
                g.setColor(Color.GREEN); 
                col = 0; 
            }else {
                g.setColor(Color.BLUE); 
                col =1; 
            }
            g.drawOval((getWidth()/2 - num/2), (getHeight()/2 - num/2), num, num);
            n--; 
            paint(g, (int)(num/scale));
        }
        /*else {
            if (col == 1){
                g.setColor(Color.RED); 
                col = 2;
            }else if (col == 2){
                g.setColor(Color.GREEN); 
                col = 0; 
            }else {
                g.setColor(Color.BLUE); 
                col =1; 
            }
            int height = (int)(Math.sqrt(3.0)*(num)); 
            
            int initialHeight = (int)(Math.sqrt(3.0)*(r/2)); 
            
            g.fillPolygon(new int[]{getWidth()/2-num/2, getWidth()/2+num/2, getWidth()/2},new int[]{getHeight()-initialHeight/2-height/2,getHeight()-initialHeight/2-height/2,getHeight()/2-initialHeight/2},3);
            n--;
            paint(g, num/2); 
        }*/
    }public void paint(Graphics g){
        g.setColor(Color.BLACK); 
        g.fillRect(0,0,getWidth(),getHeight()); 
        if (n <= 0){
            
        }else {
            if (col == 1){
                g.setColor(Color.RED); 
                col = 0;
            }else {
                g.setColor(Color.BLUE); 
                col =1; 
            }
            g.drawOval(getWidth()/2 - r/2, getHeight()/2-r/2, r, r);
            n--; 
            paint(g, (int)(r/scale));
        }
        /*else {
            if (col == 0){
                g.setColor(Color.RED); 
                col = 2;
            }else if (col == 1){
                g.setColor(Color.GREEN); 
                col = 0; 
            }else {
                g.setColor(Color.BLUE); 
                col =1; 
            }
            int height = (int)(Math.sqrt(3.0)*(r/2)); 
            
            
            
            g.fillPolygon(new int[]{getWidth()/2-r/2, getWidth()/2+r/2, getWidth()/2},new int[]{getHeight()-height/2,getHeight()-height/2,getHeight()/2+height/2},3);
            paint(g, r/2); 
        }*/
    }
}