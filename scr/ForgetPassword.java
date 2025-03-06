package MiniProject_TravelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class ForgetPassword extends JFrame implements ActionListener{

      JTextField tfusername, tfname, tfquestion, tfanswer,tfpassword;
      JButton search, retrieve,back;

    
    ForgetPassword(){
        setBounds(350,200,850,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
 //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgetPassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,200,200);
        add(image);
        
        
        JPanel p1 = new JPanel();
        p1.setBackground(Color.PINK);
        p1.setBounds(30,30,550,300);
        p1.setLayout(null);
        add(p1);
        
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,170,25);
        username.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        p1.add(username);        
        
        tfusername =  new JTextField();
        tfusername.setBounds(220,20,170,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        p1.add(tfusername);
       
        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(400,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40,60,170,25);
        name.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        p1.add(name);
        
        tfname =  new JTextField();
        tfname.setBounds(220,60,170,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        p1.add(tfname);
        
        
        JLabel question = new JLabel("Security Question");
        question.setBounds(40,100,170,25);
        question.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        p1.add(question);
        
        tfquestion =  new JTextField();
        tfquestion.setBounds(220,100,170,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        tfquestion.setFont(new Font("Times new Roman",Font.PLAIN, 15));
        p1.add(tfquestion);
        
        JLabel answer = new JLabel("Answer");
        answer.setBounds(40,140,170,25);
        answer.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        p1.add(answer);
        
        tfanswer =  new JTextField();
        tfanswer.setBounds(220,140,170,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        tfanswer.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        p1.add(tfanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.BLACK);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
//        
        
        JLabel password = new JLabel("Password");
        password.setBounds(40,180,100,25);
        password.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        p1.add(password);
        
        tfpassword =  new JTextField();
        tfpassword.setBounds(220,180,170,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);
       setVisible(true);
     
    }

    
  public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==search){
            try{
                String query="select * from account where username= '"+tfusername.getText()+" ' ";
                connnectivity c =new connnectivity();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("username"));
                    tfquestion.setText(rs.getString("security"));
  //                tfanswer.setText(rs.getString("answer"));
//                   tfpassword.setText(rs.getString("password"));}
                }
            }
        catch(Exception e){
              e.printStackTrace();
          }
 }
else if(ae.getSource()==retrieve){
try{
 String query=" select * from account where answer='"+tfanswer.getText()+"' ";
                connnectivity c =new connnectivity();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));}
            }
        catch(Exception e){
              e.printStackTrace();
          }
}
   else{
            setVisible(false);
            new login(); 
         }
    }
 public static void main(String[] args){
            new ForgetPassword();
        }
}
