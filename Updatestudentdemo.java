// for update and delete  student
import java.awt.*;
import java.awt.event.*;
class Updatestudent implements ActionListener
{
Frame f;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
TextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
Button b1,b2,b3,b4;
Updatestudent()
{
f=new Frame("Update & Delete Student");
f.setSize(540,570);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setBackground(Color.GRAY);
l1=new Label("Mobile number");
l2=new Label("Name");
l3=new Label("Father name");
l4=new Label("Mother name");
l5=new Label("Email id");
l6=new Label("Address");
l7=new Label("College name");
l8=new Label("Room number");
l9=new Label("Living status");
t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();
t6=new TextField();
t7=new TextField();
t8=new TextField();
t9=new TextField();

b1=new Button("Back");
b1.setBackground(Color.GREEN);
b2=new Button("Update");
b2.setBackground(Color.BLUE);
b3=new Button("Delete");
b3.setBackground(Color.RED);
b4=new Button("Clear");
b4.setBackground(Color.YELLOW);
f.setLayout(null);
l1.setBounds(30,40,100,30);
l2.setBounds(30,90,100,30);
l3.setBounds(30,140,100,30);
l4.setBounds(30,190,100,30);
l5.setBounds(30,240,100,30);
l6.setBounds(30,290,100,30);
l7.setBounds(30,340,100,30);
l8.setBounds(30,390,100,30);
l9.setBounds(30,440,100,30);

t1.setBounds(160,40,110,30);
t2.setBounds(160,90,215,30);
t3.setBounds(160,140,215,30);
t4.setBounds(160,190,215,30);
t5.setBounds(160,240,215,30);
t6.setBounds(160,290,215,30);
t7.setBounds(160,340,215,30);
t8.setBounds(160,390,215,30);
t9.setBounds(160,440,215,30);
b1.setBounds(300,40,70,30);
b2.setBounds(160,500,60,30);
b3.setBounds(240,500,60,30);
b4.setBounds(320,500,60,30);
b1.addActionListener(this);
f.add(l1);
f.add(l2);
f.add(l3);
f.add(l4);
f.add(l5);
f.add(l6);
f.add(l7);
f.add(l8);
f.add(l9);
f.add(t1);
f.add(t2);
f.add(t3);
f.add(t4);
f.add(t5);
f.add(t6);
f.add(t7);
f.add(t8);
f.add(t9);
f.add(b1);
f.add(b2);
f.add(b3);
f.add(b4);
f.setVisible(true);
}
public void actionPerformed(ActionEvent a)
{
if(a.getSource()==b1)
{
f.dispose();
Menubar t=new Menubar();
}
}



}
class Updatestudentdemo
{
public static void main(String[] s)
{
Updatestudent up=new Updatestudent();
}
}