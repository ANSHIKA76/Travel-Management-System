package MiniProject_TravelManagementSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    About(){
        
   setBounds(500,200,500,550);
   setLayout(null);
   setBackground(Color.WHITE);
   getContentPane().setBackground(Color.WHITE);
   
   JLabel text = new JLabel("ABOUT");
   text.setBounds(200,10,100,40);
   text.setForeground(Color.RED);
   text.setFont(new Font("Times New Roman",Font.BOLD,25));
    add(text);
    
    String s="The main objective of the Tourism Management System is to manage the details of Customer, Hotel Booking, Cancellation and Tourism places. It manages all the information about Users, Hotel, Packages etc. The project is totally built at administrative end and thus only the administrator is guaranteed the access to the backend database. The purpose of this project is to build an application program to reduce the manual work for managing Tourists, Booking, Places etc.\n"+ 
"This application will help in accessing the information related to the travel to the particular destination with great ease. The users can track the information related to their tours with great ease through this application. The travel agency information can also be obtained through this application."+"Through this system, the propose system is highly automated and makes the travelling activities much easier and flexible. The user can get the very right information at the very right time.\n This system will include all the necessary fields which are required during online reservation time. This system will be easy to use and can be used by any person. The basic idea behind this project is to save data in a central database which can be accessed by any authorize person to get information and saves time and burden which are being faced by their customers. \n" +
"\n" +
" Administrator can access and modify the information stored in the database of this system, this includes adding and updating of details, and it will give accurate information and simplifies manual work and also it minimizes the documentation related work. Provides up to date information. Finally booking confirmation notification will be send to the users. \n" +
"Tourists can register by providing personal details, make new reservation and book only one hotel and package and can make cancellation.\n" +
"";

    
     
     TextArea area = new TextArea( s,10, 40 ,Scrollbar.VERTICAL);
     area.setEditable(false);
     area.setBounds(20, 100, 450, 300);
     add(area);
     
        JButton back = new JButton("back");
        back.setBounds(200,420,100,25);
        back.addActionListener(this);
        add(back);
       
     
      setVisible(true);

}
    public void actionPerformed(ActionEvent ae) {
                  setVisible(false);
       

        }
    
    
    public static void main (String[] args){
     new About();
            
        
   }
    }