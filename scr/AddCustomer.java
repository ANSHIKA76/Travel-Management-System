
package MiniProject_TravelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class AddCustomer extends JFrame implements ActionListener {
    JLabel lusername,lname;
    JComboBox cid;
    JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail,tfusername,tfname;
    JRadioButton rmale,rfemale,rother;
    JButton add,back;
    AddCustomer( String username ){
       setBounds(450,200,850,550);
//      getContentPane().setBackground(new Color(51,204,255));v
        getContentPane().setBackground(new Color(162,210,223));
       setLayout(null);
        
        
        JLabel lausername = new JLabel("Username");
        lausername.setBounds(30,50,150,25);
        lausername.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lausername);
        
        
        lusername = new JLabel();
        lusername.setBounds(200,50,150,25);
        lusername.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lusername);

        tfusername =  new JTextField();
        tfusername.setBounds(200,50 ,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(tfusername);  
        
        
        JLabel id = new JLabel("Id");
        id.setBounds(30,90,150,25);
        id.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(id);
        
        cid =new JComboBox(new String[] {"Aadhar Card","Passport","Pan Card"});
        cid.setBounds(200,90,150,25);
        cid.setFont(new Font("Times new Roman",Font.PLAIN, 18));
        add(cid);
        
        JLabel number = new JLabel("Number");
        number.setBounds(30,130,150,25);
        number.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(number);
        
        tfnumber =  new JTextField();
        tfnumber.setBounds(200,130,150,25);
//      tfnumber.setBorder(BorderFactory.createEmptyBorder());
        tfnumber.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        add(tfnumber);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,170,150,25);
        name.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(name);
        
        lname = new JLabel();
        lname.setBounds(200,170,150,25);
        lname.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lname);
        
        
        
        
        tfname =  new JTextField();
        tfname.setBounds(200,170,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(tfname);
//        
//        

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,210,150,25);
        gender.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(gender);
        
        rmale=new JRadioButton("Male");
        rmale.setBounds(200,210,70,25);
        add(rmale);
        rfemale=new JRadioButton("Female");
        rfemale.setBounds(290,210,70,25);
        add(rfemale);
        rother=new JRadioButton("Other");
        rother.setBounds(380,210,70,25);
        add(rother);
        ButtonGroup bg =new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        bg.add(rother);
        
        JLabel country = new JLabel("Country");
        country.setBounds(30,250,150,25);
        country.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(country);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,250,150,25);
        tfcountry.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(tfcountry);
        
        JLabel address= new JLabel("Address");
        address.setBounds(30,290,150,25);
        address.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(address);
        
        tfaddress= new JTextField();
         tfaddress.setBounds(200,290,150,25);
         tfaddress.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add( tfaddress);
        
         JLabel phone = new JLabel("Phone No.");
        phone.setBounds(30,330,150,25);
        phone.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(phone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200,330,150,25);
        tfphone.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(tfphone);
        
        JLabel email= new JLabel("Email");
        email.setBounds(30,370,150,25);
        email.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(email);
        
        tfemail= new JTextField();
        tfemail.setBounds(200,370,150,25);
        tfemail.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add( tfemail);
            
        
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,410,100,25);
        add.addActionListener(this);
        add(add);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230,410,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(320,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,420);
        add(image);
        
        try{
            connnectivity c=new connnectivity();
           ResultSet rs= c.s.executeQuery("select * from account where username='anshika'");
           while(rs.next()){
               lusername.setText(rs.getString("username"));
               lname.setText(rs.getString("name"));
               
           }
            
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
   setVisible(true);
        
    }
      public void actionPerformed(ActionEvent ae) {
          if (ae.getSource()==add){
              String username =lusername.getText();
              String id=(String) cid.getSelectedItem();
              String number=tfnumber.getText();
              String name= lname.getText();
              String gender=null;
              if(rmale.isSelected()){
                  gender="Male";
              }
              else if(rfemale.isSelected()){
                  gender="Female";
              }
              else{
                  gender="Other";
              }
              String country =tfcountry.getText();
              String address=tfaddress.getText();
              String phone=tfphone.getText();
              String email=tfemail.getText();
         try{
             connnectivity c=new connnectivity();
    String query="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"' ,'"+phone+"','"+email+"')";
    
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            setVisible(false);
            
 }
        catch(Exception e){
            e.printStackTrace();
            
        }
} else{
                 setVisible(false);

          }
      }
     
     public static void main(String[] args) {
           
         new AddCustomer("username");
       }

  }
