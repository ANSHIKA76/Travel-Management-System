package MiniProject_TravelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
   JButton login, signup, passwordbtn;
   JTextField tfusername,tfpassword;
    login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(224,197,238));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(90,100,200,200);
        p1.add(image);
        
        JPanel p2 =  new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,40,450,300);
        add(p2);
        
        JLabel username = new JLabel("Username");
        username.setBounds(60,20,100,25);
        username.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        p2.add(username);
        
        tfusername =  new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        p2.add(tfusername);
        
        
        JLabel password = new JLabel("Password");
        password.setBounds(60,110,100,25);
        password.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        p2.add(password);
        
        tfpassword =  new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.setFont(new Font("Times new Roman",Font.PLAIN, 25));
        p2.add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(224,197,238));
        login.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("SignUp");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(224,197,238));
        signup.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        signup.setBorder(BorderFactory.createEmptyBorder());login.addActionListener(this);
        signup.addActionListener(this);
        p2.add(signup);
        
        passwordbtn = new JButton("Forget Password");
        passwordbtn.setBounds(130,250,130,30);
        passwordbtn.setBackground(new Color(224,197,238));
        passwordbtn.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        passwordbtn.setBorder(BorderFactory.createEmptyBorder());
        passwordbtn.addActionListener(this);
        p2.add(passwordbtn);
        
        JLabel  text = new JLabel("Trouble in Login...");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        setVisible(true);
    }
    
   public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == login) {
        String username = tfusername.getText().trim();
        String password = tfpassword.getText().trim();
        String query = "select * from account where username='" + username + "' and password='" + password + "'";

        try {
            connnectivity c = new connnectivity();
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                setVisible(false);
                new loading(username).setVisible(true); 
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect username and password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }


         else if(ae.getSource()==signup){
             setVisible(false);
             new signUp();
         }
         else{
             setVisible(false);
            new ForgetPassword();
            
         }
    }
    public static void main(String args[]){
        new login();
    }
}