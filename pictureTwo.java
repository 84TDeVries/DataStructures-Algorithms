import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.Color; 
//from   w w  w . j  a v a 2s .  c o m
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
class pictureTwo extends JFrame{
    
    public pictureTwo (){
        JPanel panel = new JPanel();
        getContentPane().add(panel); 
        setSize(450,450); 
        panel.add(new JButton("press")); 
    }public pictureTwo (Color c, int width){
        JPanel panel = new JPanel();
        getContentPane().add(panel); 
        setSize(450,450); 
        panel.add(new JButton("press"));
        paint(null, c, width); 
    }
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        Line2D lin = new Line2D.Float(100, 100, 250, 260); 
        
        g2.draw(lin); 
        g2.fillOval(100,100,200,100); 
        g2.setColor(Color.white); 
        g2.fillOval(150,125,100,50); 
    }public void paint(Graphics g, Color c, int width){
        Graphics2D g2 = (Graphics2D)g;
        Line2D lin = new Line2D.Float(100, 100, 250, 260); 
        g2.setColor(c); 
        g2.draw(lin); 
        g2.fillOval(100,100,width,width/2); 
        g2.setColor(Color.white); 
        g2.fillOval(150,125,100,50); 
    }
    public static void main(String[] args){
        pictureTwo s = new pictureTwo();
        pictureTwo towers = new pictureTwo(Color.red, 400);
        s.setVisible(true); 
        
    }
}