// write a program to design login screen  in java
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*; 

class Login implements ActionListener

{
Frame f;
JLabel l1;
JLabel l2;
TextField t1;
final JPasswordField t2;
Button b1,b2,b3;
Connection con;
Statement st;
ResultSet rs;
ImageIcon im;
Font fnt;

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b3)
{
try
{
String Username=t1.getText();
String Password=t2.getText();


Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","");

st=con.createStatement();

String ss="select * from Login where Username='"+Username+"'and Password='"+Password+"'";


System.out.println("query:"+ss);
rs=st.executeQuery(ss);


if(rs.next())
{
String pswd=rs.getString("password");
if(Password.equals(pswd)){
JOptionPane.showMessageDialog(null,"successfully Login");
f.dispose();
Menubar t=new Menubar();
System.out.println("Login successfull");
}}


else 
{
JOptionPane.showMessageDialog(null,"wrong password or username");
System.out.printf("login does not successfull");
}

con.close();
}

catch(Exception ex)
{
JOptionPane.showMessageDialog(null,ex);
System.out.println("Error:"+ex);
}}

else
if(ae.getSource()==b2)
{
f.dispose();
}

else
if(ae.getSource()==b1)
{
t1.setText("");
t2.setText("");
}
}

Login()
{
f=new Frame("Login screen");
f.setSize(370,290);
f.setResizable(false);
f.setLocationRelativeTo(null);
// set a image  on frame 
im=new ImageIcon("the-tourist-rings-the-doorbell-to-check-in-to-the-room-he-has-booked-or-the-student-with-the-backpack-returns-home-after-classes-at-the-institute-or-on-vacation-PW6BXH.jpg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,390,370);
f.add(bg);


l1=new JLabel("Username");

l2=new JLabel("Password");
t1=new TextField(20);
t2=new JPasswordField(20);
l2.setLabelFor(t2);


b1=new Button("Reset");
b1.setBackground(Color.RED);

b2=new Button("Cancel");
b2.setBackground(Color.BLUE);

b3=new Button("Login");
b3.setBackground(Color.GREEN);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
fnt=new Font("Calibri",Font.BOLD,14);


f.setLayout(null);

l1.setBounds(50,50,100,30);
t1.setBounds(180,50,100,25);
l2.setBounds(50,100,100,30);
t2.setBounds(180,100,100,25);


b1.setBounds(60,150,80,20);
b2.setBounds(200,150,80,20);
b3.setBounds(140,190,80,20);



bg.add(l1);
bg.add(t1);
bg.add(l2);
bg.add(t2);
bg.add(b1);
bg.add(b2);
bg.add(b3);
b1.setFont(fnt);
b2.setFont(fnt);
b3.setFont(fnt);
l1.setFont(fnt);
l2.setFont(fnt);


f.setVisible(true);
}
}


class Logindemo
{
public static void main(String[] s)
{
Login lo=new Login();
}
}
