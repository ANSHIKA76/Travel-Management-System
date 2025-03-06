package MiniProject_TravelManagementSystem;

import MiniProject_TravelManagementSystem.connnectivity;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;


public class BookPackages extends JFrame implements ActionListener{
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel lusername,lblphone,lausername,lblid,lblprice,lblnumber,labelprice,labelphone,labelid,labelnumber;
    JButton checkprice, bookpackage,back;
    
    BookPackages(String username){
        this.username = username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(new Color(162,210,223));
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,250,30);
        text.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(text);
        
        lusername = new JLabel("Username");
        lusername.setBounds(40,70,130,20);
        lusername.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lusername);
        
        lausername= new JLabel();
        lausername.setBounds(250,70,200,25);
        lausername.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lausername);
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40,110,130,20);
        lblpackage.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,25);
        add(cpackage);
        
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40,150,150,20);
        lblpersons.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
        
        
        lblid = new JLabel("Id");
        lblid.setBounds(40,190,150,20);
        lblid.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblid);
        
        labelid= new JLabel();
        labelid.setBounds(250,190,200,25);
        labelid.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(labelid);
        
        
       lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,230,150,20);
        lblnumber.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblnumber);
        
        labelnumber= new JLabel();
        labelnumber.setBounds(250,230,200,25);
        labelnumber.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(labelnumber);
        
        lblphone = new JLabel("Phone");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblphone);
        
        labelphone= new JLabel();
        labelphone.setBounds(250,270,200,25);
        labelphone.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(labelphone);
        
        lblprice = new JLabel("Total Price");
        lblprice.setBounds(40,310,150,20);
        lblprice.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(lblprice);
        
        labelprice= new JLabel();
        labelprice.setBounds(250,310,200,25);
        labelprice.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(labelprice);
        try{
         connnectivity c = new connnectivity();
       String query = "SELECT * FROM customer WHERE username = '" + username + "'";

         ResultSet rs=c.s.executeQuery(query);
         while(rs.next()){
             lausername.setText(rs.getString("username"));
             lblid.setText(rs.getString("id"));
             lblnumber.setText(rs.getString("number"));
             lblphone.setText(rs.getString("phone"));
         }    
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel ll2 = new JLabel(i3);
        ll2.setBounds(550,50,500,300);
        add(ll2);
         
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
             cost+=12000;   
            }else if(pack.equals("Silver Package")){
                cost+=25000;
            }else{
                cost+=32000;
            }
            int person = Integer.parseInt(tfpersons.getText());
            cost*=person;
            labelprice.setText("Rs "+ cost);
        }
        else if(ae.getSource()== bookpackage){
            try{
            connnectivity c = new connnectivity();
            c.s.executeUpdate("insert into bookpackage values('"+lausername.getText()+"', '"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+ labelphone.getText()+"','"+labelprice.getText()+"')");
            
            JOptionPane.showMessageDialog(null, "Package Booked Successfullt");
            setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
           setVisible(false);
        }
    }
    public static void main(String args[]){
        new BookPackages("Askhita");
    }
}
