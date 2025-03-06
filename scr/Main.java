package MiniProject_TravelManagementSystem;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame implements Runnable{
    Thread thread;
    Main(){
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/mainImage.jpg"));
         Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         add(image);
         setVisible(true);
         thread = new Thread(this);
         thread.start();    
    }
    
    public void run(){
        try{
            thread.sleep(7000);
            setVisible(false);
//            new login();
        }catch(Exception e){
            
        }
        
    }
    public static void main(String[] args) {
     Main frame = new Main();
     int x = 1;
     for( int i=1;i<=500;x+=7, i+=6){
         frame.setLocation(750-(x+i)/2,400-(i/2));
         frame.setSize(x+i,i);
         try{
             Thread.sleep(20);
         }catch(Exception e){
             
         }
     }
    }
}
