package MiniProject_TravelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Paytm extends JFrame implements ActionListener {
    JButton back;
    Paytm(){
        setBounds(500,200,800,600);
        
        
         JEditorPane pane =new JEditorPane();
         pane.setEditable(false);
         
         
         try{
             
             pane.setPage("https://www.phonepe.com/");
             
         }
         catch( Exception e){
             pane.setContentType("text/html");
             pane.setText("<html> Could Not Load, Error 404<html>");
             
     }
       JScrollPane sc= new JScrollPane( pane);
       getContentPane().add(sc);
       
        back = new JButton("back");
        back.setBounds(520,0,80,40);
        back.addActionListener(this);
        pane.add(back);
       
       setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae) {
                  setVisible(false);
        new Payment();

        }
    
  public static void main (String [] args){
    new Paytm();
    }

}