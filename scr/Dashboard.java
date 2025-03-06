package MiniProject_TravelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Dashboard extends JFrame implements ActionListener {
    JButton  vpersonal ,addpersonal,check,uppersonal,book,vpackage,vhotels,dpersonal,bookhotel,vhbook,destination,pay,calculator,notepad,about;
    String username;
    Dashboard(String username ){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(162,210,223));
        p1.setBounds(0,0,1600,65);
        p1.setLayout(null);
        add(p1);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,70,70);
        p1.add(image);
        JLabel header = new JLabel("Dashboard");
        header.setFont(new Font("Times new Roman",Font.BOLD, 25));
        header.setForeground(Color.WHITE);
        header.setBounds(80,15,300,40);
        p1.add(header);
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(162, 210, 223));
        p2.setBounds(0,65,300,900);
        p2.setLayout(null);
        add(p2);
        addpersonal = new JButton("Add Personal Details");
        addpersonal.setBackground(Color.WHITE);
        addpersonal.setForeground(Color.BLACK);
        addpersonal.setBounds(0,0,300,50);
        addpersonal.setMargin(new Insets(0,0,0,60));
        addpersonal.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        addpersonal.addActionListener(this);
        p2.add(addpersonal);
        uppersonal = new JButton("Upadate Personal Details");
        uppersonal.setBackground(new Color(162, 210, 223));
        uppersonal.setForeground(Color.BLACK);
        uppersonal.setBounds(0,49,300,50);
        uppersonal.setMargin(new Insets(0,0,0,30));
        uppersonal.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        uppersonal.addActionListener(this);
        p2.add(uppersonal);
        vpersonal = new JButton("View Personal Details");
        vpersonal.setBackground(Color.WHITE);
        vpersonal.setForeground(Color.BLACK);
        vpersonal.setBounds(0,98,300,50);
        vpersonal.setMargin(new Insets(0,0,0,60));
        vpersonal.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        vpersonal.addActionListener(this);
        p2.add(vpersonal);
        dpersonal = new JButton("Delete Personal Details ");
        dpersonal.setBackground(new Color(162, 210, 223));
        dpersonal.setForeground(Color.BLACK);
        dpersonal.setBounds(0,147,300,50);
        dpersonal.setMargin(new Insets(0,0,0,50));
        dpersonal.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        dpersonal.addActionListener(this);
        p2.add(dpersonal);
        check = new JButton("Check Packages");
        check.setBackground(Color.WHITE);
        check.setForeground(Color.BLACK);
        check.setBounds(0,196,300,50);
        check.setMargin(new Insets(0,0,0,110));
        check.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        check.addActionListener(this);
        p2.add(check);
        book   = new JButton("Book Package");
        book.setBackground(new Color(162, 210, 223));
        book.setForeground(Color.BLACK);
        book.setBounds(0,245,300,50);
        book.setMargin(new Insets(0,0,0,120));
        book.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        book.addActionListener(this);
        p2.add(book);
        vpackage   = new JButton("View Package");
        vpackage.setBackground(Color.WHITE);
        vpackage.setForeground(Color.BLACK);
        vpackage.setBounds(0,294,300,50);
        vpackage.setMargin(new Insets(0,0,0,130));
        vpackage.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        vpackage.addActionListener(this);
        p2.add(vpackage);
        vhotels = new JButton("View Hotels ");
        vhotels.setBackground(new Color(162, 210, 223));
        vhotels.setForeground(Color.BLACK);
        vhotels.setBounds(0,343,300,50);
        vhotels.setMargin(new Insets(0,0,0,130));
        vhotels.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        vhotels.addActionListener(this);
        p2.add(vhotels);
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.WHITE);
        bookhotel.setForeground(Color.BLACK);
        bookhotel.setBounds(0,392,300,50);
        bookhotel.setMargin(new Insets(0,0,0,140));
        bookhotel.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);
        vhbook  = new JButton("View Booked Hotel");
        vhbook.setBackground(new Color(162, 210, 223));
        vhbook.setForeground(Color.BLACK);
        vhbook.setBounds(0,441,300,50);
        vhbook.setMargin(new Insets(0,0,0,80));
        vhbook.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        vhbook.addActionListener(this);
        p2.add(vhbook);
        destination  = new JButton("Destinations");
        destination .setBackground(Color.WHITE);
        destination .setForeground(Color.BLACK);
        destination .setBounds(0,490,300,50);
        destination .setMargin(new Insets(0,0,0,130));
        destination .setFont(new Font("Times new Roman",Font.PLAIN, 20));
        destination.addActionListener(this);
        p2.add(destination );
        pay  = new JButton("Payment");
        pay.setBackground(new Color(162, 210, 223));
        pay.setForeground(Color.BLACK);
        pay.setBounds(0,539,300,50);
        pay.setMargin(new Insets(0,0,0,150));
        pay.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        pay.addActionListener(this);
        p2.add(pay);        
        calculator = new JButton("Calculator");
        calculator .setBackground(Color.WHITE);
        calculator .setForeground(Color.BLACK);
        calculator .setBounds(0,588,300,50);
        calculator .setMargin(new Insets(0,0,0,140));
        calculator.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        calculator.addActionListener(this);
        p2.add(calculator );
        notepad = new JButton("Notepad");
        notepad .setBackground(new Color(162, 210, 223));
        notepad .setForeground(Color.BLACK);
        notepad.setBounds(0,637,300,50);
        notepad.setMargin(new Insets(0,0,0,150));
        notepad.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        notepad.addActionListener(this);
        p2.add(notepad );
        about = new JButton("About");
        about .setBackground(Color.WHITE);
        about .setForeground(Color.BLACK);
        about .setBounds(0,686,300,50);
        about .setMargin(new Insets(0,0,0,170));
        about.setFont(new Font("Times new Roman",Font.PLAIN, 20));
        about.addActionListener(this);
        p2.add(about );
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(0,0,1610,1000);
        add(image2);
        JLabel text =new JLabel("TRAVEL AND TOURISM MANAGEMENT SYSTEM");
        text.setBounds(400,70,1200,70);
        text.setForeground( Color.BLACK);
        text.setFont(new Font("Railway",Font.BOLD,40));
        image2.add(text);
        setVisible(true);}
public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addpersonal){
            new AddCustomer(username);
        }else if(ae.getSource() == vpersonal){
            new ViewCustomer(username);
        }else if(ae.getSource() == uppersonal){
            new UpdateCustomer(username);
        }else if(ae.getSource() == check){
            new checkPackages();
        }else if(ae.getSource() == book){
            new BookPackages(username);
        }else if(ae.getSource() == vpackage){
            new ViewPackage(username);
        }else if(ae.getSource() == vhotels){
            new CheckHotels();
        }else if(ae.getSource() == destination){
           new Destinations();
        }else if(ae.getSource()== bookhotel)   {
            new BookHotel(username);
        } else if(ae.getSource()== vhbook)   {
            new ViewHotelBooked(username);
        } else if(ae.getSource()== pay)   {
            new Payment();
        } else if(ae.getSource()== about)   {
            new About();
        } else if(ae.getSource()== dpersonal)   {
            new DeleteCustomer(username);
        } else if(ae.getSource()== calculator){
           try{
              Runtime.getRuntime().exec("calc.exe"); 
           }catch (Exception e){
               e.printStackTrace();
        }}else if(ae.getSource()== notepad){
           try{
             Runtime.getRuntime().exec("notepad.exe"); 
         }catch (Exception e){
                e.printStackTrace();}}}
public static void main(String[] args){
         new Dashboard("");}}
     

