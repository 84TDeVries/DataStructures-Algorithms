import javax.swing.*; 
import java.util.*;
import java.awt.*; 

public class Sierpinski extends JFrame {
    public static Scanner console = new Scanner(System.in); 
    public static int n = 3; 
    public static int r = 1000;
    public static double scale = 1.05;
    public static int col = 0; 
    public static char shape; 
    public static int temp; 
    public static Color[] cols = new Color[]{new Color(255,165,0),new Color(240,150,0),new Color(225,130,0),new Color(210,105,0),new Color(195,95,0),new Color(180,90,0),new Color(165,85,0),new Color(150,75,0),new Color(135,65,0),new Color(120,60,0), new Color(110,55,0), new Color(95,45,0), new Color(80,40,0), new Color(50,25,0)};
    public Sierpinski() {
        setVisible(true);
        setResizable(false);
        setSize(1000,1000); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        validate();
        
    }public static void main(String[] args){
        Sierpinski f = new Sierpinski();
        
        while(console.hasNextInt()){
            n = console.nextInt(); 
            //scale = console.nextDouble(); 
            col = 0; 
            if (n == -1)
                break; 
            SwingUtilities.updateComponentTreeUI(f);
        }
    }public void paint(int time, Graphics g, int[][] points){
        if (time <= 0){
            
        }
        else {
            /*if (col == 0){
                g.setColor(Color.RED); 
                col = 2;
            }else if (col == 1){
                g.setColor(Color.GREEN); 
                col = 0; 
            }else if (col == 3){
                g.setColor(Color.YELLOW); 
                col =1; 
            }else if (col == 4){
                g.setColor(Color.MAGENTA); 
                col =3; 
            }else {
                g.setColor(Color.BLUE); 
                col =4; 
            }*/
            g.setColor(cols[col]); 
            col++; 
            if (col == cols.length)
                col = 0; 
            
            int[][] triangle = new int[][]{{(points[0][0] + points[0][1])/2, (points[0][1] + points[0][2])/2, (points[0][2] + points[0][0])/2},{(points[1][1] + points[1][0])/2, (points[1][2] + points[1][1])/2, (points[1][2] + points[1][0])/2}}; 
            
            g.fillPolygon(triangle[0],triangle[1],3);
            time--;
            paint(time, g, new int[][]{{points[0][0], triangle[0][0], triangle[0][2]}, {points[1][0], triangle[1][0], triangle[1][2]}}); 
            
            paint(time, g, new int[][]{{triangle[0][0], points[0][1], triangle[0][1]}, {triangle[1][0], points[1][1], triangle[1][1]}}); 
            paint(time, g, new int[][]{{triangle[0][2], triangle[0][1], points[0][2]},{triangle[1][2], triangle[1][1], points[1][2]}}); 
        }
    }public void paint(Graphics g){
        g.setColor(Color.BLACK); 
        g.fillRect(0,0,getWidth(),getHeight()); 
        g.setColor(Color.RED); 
        int wid = getWidth();
        int hi = getHeight(); 
        
        int height = (int)(Math.sqrt(3.0)*(r/2)); 
        int[][]points = new int[][]{{wid/2, wid/2 - r/2, wid/2 + r/2},{hi/2 - height/2, hi/2 + height/2, hi/2 + height/2, hi/2 + height/2}}; 
        g.drawPolygon(points[0], points[1], 3);
        
        if (n <= 0){
            
        }
        else {
            n-=1; 
            g.setColor(cols[col]); 
            col++; 
            if (col == cols.length)
                col = 0; 
             
            
            int[][] triangle = new int[][]{{(points[0][0] + points[0][1])/2, (points[0][1] + points[0][2])/2, (points[0][2] + points[0][0])/2},{(points[1][1] + points[1][0])/2, (points[1][2] + points[1][1])/2, (points[1][2] + points[1][0])/2}}; 
            g.fillPolygon(triangle[0],triangle[1],3);
            /*for(int i= 1; i <= n; i++){
                paint(i,g, new int[][]{{points[0][0], triangle[0][0], triangle[0][2]}, {points[1][0], triangle[1][0], triangle[1][2]}}); 
                paint(i,g, new int[][]{{triangle[0][0], points[0][1], triangle[0][1]}, {triangle[1][0], points[1][1], triangle[1][1]}}); 
                paint(i,g, new int[][]{{triangle[0][2], triangle[0][1], points[0][2]},{triangle[1][2], triangle[1][1], points[1][2]}}); 
            }*/
            paint(n,g, new int[][]{{points[0][0], triangle[0][0], triangle[0][2]}, {points[1][0], triangle[1][0], triangle[1][2]}}); 
            paint(n,g, new int[][]{{triangle[0][0], points[0][1], triangle[0][1]}, {triangle[1][0], points[1][1], triangle[1][1]}}); 
            paint(n,g, new int[][]{{triangle[0][2], triangle[0][1], points[0][2]},{triangle[1][2], triangle[1][1], points[1][2]}}); 
        }
    }
}