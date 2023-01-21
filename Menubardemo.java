//create a menubar in java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
class Menubar implements ActionListener
{
Frame f;
Font fnt;
MenuBar m;
Menu m1,m2,m3,m4,m5;
ImageIcon im;
MenuItem addroom,updroom,newstd,fee,upstd,livingstd,exit;
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==addroom)
{
f.dispose();
Room r=new Room();
new Add().setVisible(true);

}
else if(ae.getSource()==updroom)
{
f.dispose();
Deleteroom dr=new Deleteroom();

}
else if(ae.getSource()==newstd)
{
f.dispose();
Student stu=new Student();
}
else if(ae.getSource()==fee)
{
f.dispose();
Fee f=new Fee();
}
else if(ae.getSource()==upstd){
f.dispose();
Updatestudent up=new Updatestudent();
}
else if(ae.getSource()==exit)
{
f.dispose();
}
else if(ae.getSource()==livingstd)
{
f.dispose();
new DynRowAdd().setVisible(true);
}
}
Menubar()
{
f=new Frame("HOSTEL MANAGEMENT SYSTEM");
f.setSize(600,650);
f.setResizable(false);
f.setLocationRelativeTo(null);

im=new ImageIcon("valencia-spain-november-15-2021-nest-hostels-is-a-spanish-chain-of-hostels-for-young-travelers-2H7X3G3.jpg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,600,650);
f.add(bg);
f.setIconImage(im.getImage());

m=new MenuBar();
m1=new Menu("Manage room");
m2=new Menu("New Student");
m3=new Menu("Student Fees");
m4=new Menu("Manage Students");
m5=new Menu("Exit");
addroom=new MenuItem("ADD NEW ROOM");
addroom.addActionListener(this);
updroom=new MenuItem("UPDATE AND DELETE ROOM");
updroom.addActionListener(this);

newstd=new MenuItem("ONE STUDENT");
fee=new MenuItem(" PAY FOR ONE STUDENT");
newstd.addActionListener(this);
fee.addActionListener(this);

upstd=new MenuItem("UPDATE & DELETE");
upstd.addActionListener(this);
livingstd=new MenuItem("LIVING STUDENTS");
livingstd.addActionListener(this);
exit=new MenuItem("EXIT");
exit.addActionListener(this);
fnt=new Font("Calibri",Font.BOLD,12);
f.setLayout(null);
f.setMenuBar(m);
m1.setFont(fnt);
m2.setFont(fnt);
m3.setFont(fnt);
m4.setFont(fnt);
m5.setFont(fnt);
addroom.setFont(fnt);
updroom.setFont(fnt);
newstd.setFont(fnt);
fee.setFont(fnt);
upstd.setFont(fnt);
livingstd.setFont(fnt);
exit.setFont(fnt);
m.add(m1);
m.add(m2);
m.add(m3);
m.add(m4);
m.add(m5);
m1.add(addroom);
m1.add(updroom);
m2.add(newstd);
m3.add(fee);
m4.add(upstd);
m4.add(livingstd);
m5.add(exit);

f.setVisible(true);
}}
class Menubardemo
{
public static void main(String[] s)
{
Menubar t=new Menubar();
}
}
