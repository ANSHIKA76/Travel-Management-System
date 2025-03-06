
package MiniProject_TravelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class loading  extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar; 
    String username;
    public void run(){
        try{
         for(int i=1;i<=101;i++){
                int max=bar.getMaximum();
                int value=bar.getValue();
                if(value<max){
                    bar.setValue(bar.getValue()+1);
                    }
                else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
                }
            
        }
        catch(Exception e){
              e.printStackTrace();
          }
 
    }
    
   
    loading( String username){
        this.username=username;
        t=new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text =new JLabel("TRAVEL AND TROURISM APPLICATION");
        text.setBounds(50,20,600,40);
        text.setForeground( Color.MAGENTA);
        text.setFont(new Font("Railway",Font.BOLD,25));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel load =new JLabel("Loading,Please Wait....");
        load.setBounds(230,130,150,30);
        load.setForeground( Color.GREEN);
        load.setFont(new Font("Railway",Font.BOLD,16));
        add(load);
        
        
        JLabel lusername =new JLabel("Welcome "+ username);
        lusername.setBounds(20,310,400,40);
        lusername.setForeground( Color.GREEN);
        lusername.setFont(new Font("Railway",Font.BOLD,16));
        add(lusername);
        
        t.start();
        

        setVisible(true);
        
        
  
    
    
    
}
    public static void main (String [] args){
        new loading("");
    }
}

    
