import javax.swing.*;
import java.awt.*;
import java.util.*; 
import javax.swing.event.*; 
import java.util.Scanner.*; 
import java.util.concurrent.TimeUnit; 
import java.lang.Math; 


public class Picture extends JFrame{
    public static int amount = -1; 
    static JSlider b;
    static JPanel p; 
    public static final StackA[] pegs = new StackA[3]; 
    public static int[][] shapes; 
    public static boolean solving = false; 
    public static int prev; 
    public Picture() {
        setVisible(true);
        setResizable(false);
        setSize(800,1000); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        validate();
        
    }public static void main(String[] args){
        Picture pict = new Picture(); 
        boolean cont = true; 
        Scanner console = new Scanner(System.in); 
        while (cont && console.hasNextInt()){
            int s = console.nextInt(); 
            if (s == 0){
                pegs[0] = new StackA(amount+2); 
                pegs[1] = new StackA(amount+2); 
                pegs[2] = new StackA(amount+2);
                solving = true; 
                
                solve(); 
                break; 
            }else{
                amount = s; 
                SwingUtilities.updateComponentTreeUI(pict);
                
            }
        }
         
        
        /*b = new JSlider(1, 50); 
        p = new JPanel();
        p.setPreferredSize(new Dimension(800, 100));
        p.add(b); 
        pict.add(p); 
        b.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent event) {
            amount = b.getValue(); 
            SwingUtilities.updateComponentTreeUI(pict); 
            p = new JPanel(); 
             
            p.add(b);
            pict.add(p); 
          }
        });*/
    }
    public void paint(Graphics g){
        /*g.setColor(Color.BLUE); 
        g.fillRect(100,100,100,100); 
        
        g.setColor(Color.RED); 
        g.drawLine(100,100, 400, 400); 
        
        g.setColor(Color.GREEN);
        g.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 13));
        g.drawString("Hello World", 100, 125); 
        */
       if (!solving){
           g.setColor(Color.WHITE);
           g.fillRect(0, 0, getWidth(), getHeight() - 100); 
           int pos = getWidth() / 4;
           if (amount == -1){
               amount = 5; 
            }
           
           int height = 600/amount; 
           int j = amount;
           int w = (int)(Math.ceil(150.0/amount)); 
           int c = 0; 
           int color = 255/amount; 
           int hallow = 165/amount; 
           g.setColor(Color.ORANGE); 
           g.fillRect(pos, 200, w, getHeight()-300); 
           g.fillRect(2*pos, 200, w, getHeight()-300); 
           g.fillRect(3*pos, 200, w, getHeight()-300); 
           for(int i = 0; i < amount; i++){
               j--; 
               g.setColor(new Color(255 - i*color, 165-i*hallow, 0)); 
               /*if (c == -2){
                   g.setColor(Color.MAGENTA); 
                   c++; 
                }else if (c == -1){
                    g.setColor(Color.RED); 
                    c++; 
                }else if (c == 0){
                    g.setColor(Color.ORANGE);
                    c++; 
                }else if(c == 1){
                   g.setColor(Color.YELLOW);  
                   c++;
                }else if(c == 2){
                    g.setColor(Color.GREEN); 
                    c++; 
                }else {
                    g.setColor(Color.BLUE); 
                    c = -2; 
                }*/
               int width = (amount-i)*(w); 
               g.fillRect(pos - (w/2)*(amount-i-1), getHeight() - 100 - (amount-j)*height, width, height);
               
            }
            prev = amount; 
       }else {
           g.setColor(Color.WHITE);
           g.fillRect(0, 0, getWidth(), getHeight() - 100); 
           int pos = getWidth() / 4;
           if (amount == -1){
               amount = 5; 
            }
           
           int height = 600/amount; 
           int j = amount;
           int w = (int)(Math.ceil(150.0/amount)); 
           int c = 0; 
           int color = 255/amount; 
           int hallow = 165/amount; 
           g.setColor(Color.ORANGE); 
           g.fillRect(pos, 200, w, getHeight()-300); 
           g.fillRect(2*pos, 200, w, getHeight()-300); 
           g.fillRect(3*pos, 200, w, getHeight()-300); 
           for(int i = 0; i < amount; i++){
               j--; 
               g.setColor(new Color(255 - i*color, 165-i*hallow, 0)); 
               /*if (c == -2){
                   g.setColor(Color.MAGENTA); 
                   c++; 
                }else if (c == -1){
                    g.setColor(Color.RED); 
                    c++; 
                }else if (c == 0){
                    g.setColor(Color.ORANGE);
                    c++; 
                }else if(c == 1){
                   g.setColor(Color.YELLOW);  
                   c++;
                }else if(c == 2){
                    g.setColor(Color.GREEN); 
                    c++; 
                }else {
                    g.setColor(Color.BLUE); 
                    c = -2; 
                }*/
               int width = (amount-i)*(w); 
               g.fillRect(pos - (w/2)*(amount-i-1), getHeight() - 100 - (amount-j)*height, width, height);
               
            
              }
        }
    }public static void solve(){
        
        //pegs[0].enqueue();  
        int temp = amount;  
        pegs[0].enqueue(amount); 
        for(int j = 1; j < pegs[0].getTop()-1; j ++){
            pegs[0].print(); 
            pegs[0].enqueue(temp - j); 
        }
        System.out.println((int)pegs[0].peek()); 
        solveHanoi(amount+2, 0, 2);
        pegs[2].print(); 
    }public static void swap(int a, int b){
        
        int temp = (int)pegs[a].peek(); 
        pegs[a].dequeue(); 
        pegs[a].enqueue(pegs[b].peek()); 
        pegs[b].dequeue();
        pegs[b].enqueue(temp); 
    }public static void mov(int a, int b){
        pegs[a].dequeue();
        
        System.out.println(pegs[a].peek() + " " + pegs[a].getTop()); 
        System.out.println(pegs[b].getTop());  
        pegs[b].enqueue(pegs[a].peek()); 
        pegs[a].dequeue(); 
    }public static void solveHanoi(int numDisks, int fromPeg, int toPeg){
        if (numDisks == 0){
             
        }else {
            int sparepeg = getSparePeg(fromPeg, toPeg);
            mov(fromPeg, sparepeg); 
            solveHanoi(numDisks-1,fromPeg, sparepeg); 
            
            moveDisk(fromPeg, toPeg);
            solveHanoi(numDisks-1, sparepeg, toPeg); 
            
        }
    }public static int getSparePeg(int from, int to){
        int disk = (int)pegs[from].peek();
        System.out.println(from + "," + to + "," + pegs[from].peek()); 
        int i = from;
        while (i != to){
            if (i >= pegs.length-1){
                i = 0; 
            }else {
              i++;   
            }
            if (pegs[i].getTop() == 0 || ((int)pegs[i].peek())>disk){
                return i; 
            }
            
        }return -1; 
        
    }public static void moveDisk(int from, int to){
        
        
    }
}