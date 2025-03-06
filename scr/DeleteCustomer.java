
package MiniProject_TravelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class DeleteCustomer extends JFrame implements ActionListener{
    JButton back;
    String username;
    
    DeleteCustomer(String username){
        setBounds(450,150,870,650);
//        getContentPane().setBackground(new Color( 102,255,102));
         getContentPane().setBackground(new Color(162,210,223));
        setLayout(null);
        
        JLabel lusername = new JLabel("Username");
        lusername.setBounds(30,40,150,25);
        lusername.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lusername);
        
        JLabel lausername= new JLabel();
        lausername.setBounds(220,40,150,25);
        lausername.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lausername);
        
        JLabel id = new JLabel("Id");
        id.setBounds(30,100,150,25);
        id.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(id);
        
        JLabel lid= new JLabel();
        lid.setBounds(220,100,150,25);
        lid.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lid);
        
        
        JLabel number = new JLabel("Number");
        number.setBounds(30,160,150,25);
        number.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(number);
        
        JLabel lnumber= new JLabel();
        lnumber.setBounds(220,160,150,25);
        lnumber.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lnumber);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,220,150,25);
        name.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(name);
        
        JLabel lname= new JLabel();
        lname.setBounds(220,220,150,25);
        lname.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lname);
        
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,280,150,25);
        gender.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(gender);
        
        JLabel lgender= new JLabel();
        lgender.setBounds(220,280,150,25);
        lgender.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lgender);
        
        JLabel country = new JLabel("Country");
        country.setBounds(500,40,150,25);
        country.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(country);
        
        JLabel lcountry= new JLabel();
        lcountry.setBounds(690,40,150,25);
        lcountry.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lcountry);
        
        
        JLabel address  = new JLabel("Address");
        address.setBounds(500,100,150,25);
        address.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(address);
        
        JLabel laddress= new JLabel();
        laddress.setBounds(690,100,150,25);
        laddress.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(laddress);
        
        JLabel phone = new JLabel("Phone No");
        phone.setBounds(500,160,150,25);
        phone.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(phone);
        
        JLabel lphone= new JLabel();
        lphone.setBounds(690,160,150,25);
        lphone.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lphone);
        
        
        JLabel  email = new JLabel("Email");
        email.setBounds(500,220,150,25);
        email.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(email);
        
        JLabel lemail= new JLabel();
        lemail.setBounds(690,220,150,25);
        lemail.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        add(lemail);
        
        back = new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350,350,100,25);
       back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,400,600,200);
        add(image);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600,400,600,200);
        add(image2);
        
        try{
         connnectivity c=new connnectivity();
         String query="select * from customer where username'"+username+"'";
         ResultSet rs=c.s.executeQuery(query);
         while(rs.next()){
             lausername.setText(rs.getString("username"));
             lid.setText(rs.getString("id"));
             lnumber.setText(rs.getString("number"));
             lname.setText(rs.getString("name"));
             lgender.setText(rs.getString("gender"));
             lcountry.setText(rs.getString("country"));
             laddress.setText(rs.getString("address"));
             lphone.setText(rs.getString("phone"));
             lemail.setText(rs.getString("email"));


         }


            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae) {
               try{
                  connnectivity c=new connnectivity();
                  c.s.executeUpdate("delete from account where username ='" +username+"'");
                  c.s.executeUpdate("delete from customer where username ='" +username+"'");
                  c.s.executeUpdate("delete from  boolpackage where username ='" +username+"'");
                 c.s.executeUpdate("delete from bookhotel where username ='" +username+"'");

                 JOptionPane.showMessageDialog(null,"Data Deleted Sucessfully");
                    System.exit(0);
               }
               catch(Exception e){
            e.printStackTrace();
        }
        

     }
    
    
    
    public static void main(String[] args) {
           
        new DeleteCustomer("username");
    }
    
}
