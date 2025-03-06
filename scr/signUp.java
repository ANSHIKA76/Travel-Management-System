package MiniProject_TravelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class signUp extends JFrame implements ActionListener{
JButton create, back;JTextField tfusername, tfname, tfpassword, tfanswer;
Choice security;
signUp(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(224,197,238));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Times New Roman",Font.BOLD,20));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);
        tfusername = new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Times New Roman",Font.BOLD,20));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);
        tfname = new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Times New Roman",Font.BOLD,20));
        lblpassword.setBounds(50,100,125,25);
        p1.add(lblpassword);
        tfpassword = new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        JLabel lblsecurity = new JLabel("Security Questions");
        lblsecurity.setFont(new Font("Times New Roman",Font.BOLD,20));
        lblsecurity.setBounds(50,140,125,25);
        p1.add(lblsecurity);
        security = new Choice();
        security.add("What is your first Pet Name");
        security.add("You Childhood Superhero");
        security.add("What is your dream job as Child");
        security.add("What is your favourite subject in School");
        security.setBounds(190,140,180,25);
        p1.add(security);
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Times New Roman",Font.BOLD,20));
        lblanswer.setBounds(50,180,125,25);
        p1.add(lblanswer);
        tfanswer = new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(153,51,255));
        create.setFont(new Font("Times New Roman", Font.BOLD, 20));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(153,51,255));
        back.setFont(new Font("Times New Roman", Font.BOLD, 20));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,200,200);
        add(image);
        setVisible(true);
    }
public void  actionPerformed(ActionEvent ae){
      if(ae.getSource()==create){
          String username = tfusername.getText();
          String name = tfname.getText();
          String password = tfpassword.getText();
          String question = security.getSelectedItem();
          String answer = tfanswer.getText();
          String query = "insert into account values('"+username+" ', '"+name+"','"+password+"','"+question+"','"+answer+"')";
         try{
             connnectivity c = new connnectivity();
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Account Created Successfully");
             setVisible(false);
             new login();
             }catch(Exception e){
              e.printStackTrace();}
          } else if(ae.getSource()==back){
          setVisible(false);
          new login();}}
    public  static void main(String args[]){
        new signUp();
 }}


