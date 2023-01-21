// for student fees
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
class Fee implements ActionListener
{
Frame f;
Label l1,l2,l3,l4,l5,l6;
TextField t1,t2,t3,t4,t5,t6;
Button b1,b2,b3;
Connection con;
PreparedStatement st;
Font fnt;
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b2)
{
try
{
String Mobile_number=t1.getText();
String Name=t2.getText();
String Email_id=t3.getText();
String Room_number=t4.getText();
String Month=t5.getText();
String Amount=t6.getText();
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","");



String ss="insert into fee() values(?,?,?,?,?,?)";
st=con.prepareStatement(ss);
			st.setString(1,Mobile_number);
			st.setString(2,Name);
			st.setString(3,Email_id);
			st.setString(4,Room_number);
			st.setString(5,Month);
			st.setString(6,Amount);
			System.out.println("query:"+ss);
			int rcnt=st.executeUpdate();
if(rcnt >=1)
{
JOptionPane.showMessageDialog(null," Data Stored Successfully");
}
else 
{
JOptionPane.showMessageDialog(null,"Please fill proper data");
}
con.close();
}//try end
catch(Exception ex)
{
JOptionPane.showMessageDialog(null,ex);
System.out.println("Error:"+ex);
}//catch end
}//if end
else if(ae.getSource()==b3)
{
f.dispose();
Menubar t=new Menubar();
}
else if(ae.getSource()==b1)
{
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
}
}
Fee()
{
f=new Frame("Student Fee");
f.setSize(500,430);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setBackground(Color.GRAY);
l1=new Label("Mobile number");
l2=new Label("Name");
l3=new Label("Email id");
l4=new Label("Room number");
l5=new Label("Month");
l6=new Label("Amount");
t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();
t6=new TextField();
b1=new Button("clear");
b1.setBackground(Color.GREEN);
b2=new Button("Done");
b2.addActionListener(this);
b1.addActionListener(this);
b2.setBackground(Color.BLUE);
b3=new Button("Cancel");
b3.addActionListener(this);
b3.setBackground(Color.RED);
fnt=new Font("Calibri",Font.BOLD,13);
f.setLayout(null);
l1.setBounds(30,40,100,30);
l2.setBounds(30,90,100,30);
l3.setBounds(30,140,100,30);
l4.setBounds(30,190,100,30);
l5.setBounds(30,240,100,30);
l6.setBounds(30,290,100,30);
t1.setBounds(160,40,200,30);
t2.setBounds(160,90,200,30);
t3.setBounds(160,140,200,30);
t4.setBounds(160,190,200,30);
t5.setBounds(160,240,200,30);
t6.setBounds(160,290,200,30);
b1.setBounds(390,40,70,30);
b2.setBounds(160,340,70,30);
b3.setBounds(290,340,70,30);
f.add(l1);
f.add(l2);
f.add(l3);
f.add(l4);
f.add(l5);
f.add(l6);
f.add(t1);
f.add(t2);
f.add(t3);
f.add(t4);
f.add(t5);
f.add(t6);
f.add(b1);
f.add(b2);
f.add(b3);
l1.setFont(fnt);
l2.setFont(fnt);
l3.setFont(fnt);
l4.setFont(fnt);
l5.setFont(fnt);
l6.setFont(fnt);
t1.setFont(fnt);
t2.setFont(fnt);
t3.setFont(fnt);
t4.setFont(fnt);
t5.setFont(fnt);
t6.setFont(fnt);
b1.setFont(fnt);
b2.setFont(fnt);
b3.setFont(fnt);
f.setVisible(true);
}}
class Feedemo
{
public static void main(String[] s)
{
Fee f=new Fee();
}
}