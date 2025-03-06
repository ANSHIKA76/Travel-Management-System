package MiniProject_TravelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    
    ViewPackage(String username){
        setBounds(450,200,900,450);
         getContentPane().setBackground(new Color(162,210,223));
        setLayout(null);
        
        JLabel text = new JLabel("View Package Detail");
        text.setFont(new Font("Times New Roman ",Font.BOLD,25));
        text.setBounds(60,0,300,30);
        add(text);
        
        JLabel lusername = new JLabel("Username");
        lusername.setBounds(30,40,150,25);
        lusername.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lusername);
        
        JLabel lausername= new JLabel();
        lausername.setBounds(220,40,150,25);
        lausername.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lausername);
        
        JLabel packge = new JLabel("Package Name");
        packge.setBounds(30,90,150,25);
        packge.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(packge);
        
        JLabel lblpackage= new JLabel();
        lblpackage.setBounds(220,90,150,25);
        lblpackage.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblpackage);
        
        
        JLabel person = new JLabel("Total Persons");
        person.setBounds(30,130,150,25);
        person.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(person);
        
        JLabel lblperson= new JLabel();
        lblperson.setBounds(220,130,150,25);
        lblperson.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblperson);
        
        JLabel id = new JLabel("Id");
        id.setBounds(30,170,150,25);
        id.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(id);
        
        JLabel lblid = new JLabel();
        lblid.setBounds(220,170,150,25);
        lblid.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblid);
        
        
        JLabel number = new JLabel("Number");
        number.setBounds(30,210,150,25);
        number.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(number);
        
        JLabel lblnumber = new JLabel();
        lblnumber.setBounds(220,210,150,25);
        lblnumber.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblnumber);
        
        JLabel phnNumber = new JLabel("Phone Number");
        phnNumber.setBounds(30,250,150,25);
        phnNumber.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(phnNumber);
        
        JLabel lblphnNumber = new JLabel();
        lblphnNumber.setBounds(220,250,150,25);
        lblphnNumber.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblphnNumber);
        
        
        JLabel price  = new JLabel("Price");
        price.setBounds(30,290,150,25);
        price.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(price);
        
        JLabel lblprice = new JLabel();
        lblprice.setBounds(220,290,150,25);
        lblprice.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblprice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,360,100,25);
       back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);

        
        try{
         connnectivity c=new connnectivity();
         String query = "select * from bookpackage where username = '"+username+"'";
         ResultSet rs=c.s.executeQuery(query);
         while(rs.next()){
             lausername.setText(rs.getString("username"));
             lblid.setText(rs.getString("id"));
             lblnumber.setText(rs.getString("number"));
             lblpackage.setText(rs.getString("package"));
             lblprice.setText(rs.getString("price"));
             lblphnNumber.setText(rs.getString("phone"));
             lblperson.setText(rs.getString("persons"));
         }          
        }
        catch(Exception e){
            e.printStackTrace();
        } 
                  setVisible(true);
         }
     public void actionPerformed(ActionEvent ae) {
                 setVisible(false);

     }
    
    
    
    public static void main(String[] args) {
           
        new ViewPackage("");
    }
    
}
