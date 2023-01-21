//new student form 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Student implements ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
TextField t1,t2,t3,t4,t5,t6,t7;
Button b1,b2,b3;
Choice combo;
Font fnt;
Connection con=null;
PreparedStatement st=null;
Student()
{
f=new JFrame("New Student");
f.setSize(400,520);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setBackground(Color.GREEN);
l1=new JLabel("Name");
l2=new JLabel("Father name");
l3=new JLabel("Mother name");
l4=new JLabel("Email id");
l5=new JLabel("Address");
l6=new JLabel("College name");
l7=new JLabel("Mobile number");
l8=new JLabel("Room number");
t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();
t6=new TextField();
t7=new TextField();
combo=new Choice();
combo.add("--Select room number--");
combo.add("101");
combo.add("102");
combo.add("103");
combo.add("104");
combo.add("105");
combo.add("106");
combo.add("107");
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","");
String ss="select * from student";			
	
Statement st1=con.createStatement();
		System.out.println("query:"+ss);
		ResultSet rs=st1.executeQuery(ss);
		while(rs.next())
		{
				String s1=rs.getString("room_number");

			combo.add(s1);
					}

con.close();
}//try end
catch(Exception ex)
{
JOptionPane.showMessageDialog(null,ex);
System.out.println("Error:"+ex);
}//catch end







b1=new Button("Save");
b1.setBackground(Color.GREEN);
b2=new Button("Clear");
b2.addActionListener(this);
b2.setBackground(Color.BLUE);
b3=new Button("Back");
b3.addActionListener(this);
b3.setBackground(Color.RED);
fnt=new Font("Calibri",Font.BOLD,15);
f.setLayout(null);
l1.setBounds(30,40,100,30);
l2.setBounds(30,90,100,30);
l3.setBounds(30,140,100,30);
l4.setBounds(30,190,100,30);
l5.setBounds(30,240,100,30);
l6.setBounds(30,290,100,30);
l7.setBounds(30,340,100,30);
l8.setBounds(30,390,100,30);
t1.setBounds(160,40,200,30);
t2.setBounds(160,90,200,30);
t3.setBounds(160,140,200,30);
t4.setBounds(160,190,200,30);
t5.setBounds(160,240,200,30);
t6.setBounds(160,290,200,30);
t7.setBounds(160,340,200,30);
combo.setBounds(160,390,200,30);
b1.setBounds(150,430,60,30);
b1.addActionListener(this);
b2.setBounds(230,430,60,30);
b3.setBounds(310,430,60,30);
f.add(l1);
f.add(l2);
f.add(b3);
f.add(l3);
f.add(l4);
f.add(l5);
f.add(l6);
f.add(l7);
f.add(l8);
f.add(t1);
f.add(t2);
f.add(t3);
f.add(t4);
f.add(t5);
f.add(t6);
f.add(t7);
f.add(combo);
f.add(b1);
f.add(b2);
//for font style
l1.setFont(fnt);
l2.setFont(fnt);
l3.setFont(fnt);
l4.setFont(fnt);
l5.setFont(fnt);
l6.setFont(fnt);
l7.setFont(fnt);
l8.setFont(fnt);
t1.setFont(fnt);
t2.setFont(fnt);
t3.setFont(fnt);
t4.setFont(fnt);
t5.setFont(fnt);
t6.setFont(fnt);
t7.setFont(fnt);
b1.setFont(fnt);
b2.setFont(fnt);
b3.setFont(fnt);
combo.setFont(fnt);
f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
try
{
String name=t1.getText();
String fname=t2.getText();
String mname=t3.getText();
String email=t4.getText();
String add=t5.getText();
String clgname=t6.getText();
String mobilenumber=t7.getText();
String roomnumber=combo.getSelectedItem();
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","");



String ss="insert into student() values(?,?,?,?,?,?,?,?)";
st=con.prepareStatement(ss);
			st.setString(1,name);
			st.setString(2,fname);
			st.setString(3,mname);
			st.setString(4,email);
			st.setString(5,add);
			st.setString(6,clgname);
			st.setString(7,mobilenumber);
			st.setString(8,roomnumber);
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
else 
if(ae.getSource()==b2)
{
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
//combo.setText("");
}
else if(ae.getSource()==b3)
{
Menubar t=new Menubar();
f.dispose();
}
}//action performed end
}// class end
class Studentdemo
{
public static void main(String s[])
{
Student stu=new Student();
}
}