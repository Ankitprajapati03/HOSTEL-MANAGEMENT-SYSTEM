// create  a frame for  ADD NEW ROOM
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

 class Room implements ActionListener
{ 
Frame f;
Label l1,l3;
TextField t1;
Checkbox c1;
Button b1,b2;
Font fnt;
    JTable jTable1;	
Connection con=null;
PreparedStatement st=null;
DefaultTableModel model ;
Room()
{
f=new Frame("Add new room");
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setSize(540,400);
f.setBackground(Color.GRAY);	
l1=new Label("Room Number");
//l2=new Label("Activate");
l3=new Label("ALL ROOMS");
t1=new TextField();
c1=new Checkbox("Activate");
b1=new Button("Save");
b2=new Button("Back");
fnt=new Font("Calibri",Font.BOLD,12);
b1.setBackground(Color.GREEN);
b2.setBackground(Color.RED);
b1.addActionListener(this);
b2.addActionListener(this);

f.setLayout(null);
l1.setBounds(30,40,90,30);
//l2.setBounds(230,30,130,30);
l3.setBounds(230,90,80,30);
t1.setBounds(130,40,80,30);
c1.setBounds(230,40,130,30);
b1.setBounds(420,40,70,30);
b2.setBounds(450,330,70,30);
f.add(l1);
f.add(b2);
//f.add(l2);
f.add(l3);
f.add(t1);
f.add(c1);
f.add(b1);
l1.setFont(fnt);
//l2.setFont(fnt);
l3.setFont(fnt);
b1.setFont(fnt);
b2.setFont(fnt);
c1.setFont(fnt);
t1.setFont(fnt);
		jTable1=new JTable();
		jTable1.setBounds(100,120,350,170);		
		f.add(jTable1);
        // used to initialize the components
			
	
          model = new DefaultTableModel();
                    jTable1.setModel(model);

                    model.addColumn("Room_Number");
                    model.addColumn("Activate");
                    model.addColumn("Room_Status");
		
        model.addRow(new Object[]{"Room_Number","Activate","Room_Status"});
	display();

	f.setVisible(true);
}

public void display() 
{ 
	try
	{
		Class.forName("com.mysql.jdbc.Driver");

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","");

		 Statement st=con.createStatement();

		String ss="select * from addroom";
		System.out.println("query:"+ss);
		ResultSet rs=st.executeQuery(ss);
		while(rs.next())
		{
			String s1=rs.getString("Room_Number");
			String s2=rs.getString("Activate");
			String s3=rs.getString("Room_Status");


		        model.addRow(new Object[]{s1,s2,s3});
		}
		con.close();
	}
	catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null,ex);
		System.out.println("Error 1:"+ex);
	}
}
public void clearall()
{
int  rowsToRemove=model.getRowCount();
for(int i =rowsToRemove - 1; i >=0; i--)

{
	model.removeRow(i);
}
}


public void actionPerformed(ActionEvent ae)
{
clearall();
if(ae.getSource()==b1)
	{
		try
		{
			String room=t1.getText();
			String activate=null;
			if (c1.getState())
				activate="Yes";
			else
			activate="No";

String Roomstatus=null;
if(c1.getState()==true)
{
Roomstatus="Booked";
}
else
{
Roomstatus="Not Booked";
}

		Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","");

			String ss="insert into addroom() values(?,?,?)";
			st=con.prepareStatement(ss);
			st.setString(1,room);
			st.setString(2,activate);
			st.setString(3,Roomstatus);
			System.out.println("query:"+ss);
			int rcnt=st.executeUpdate();
			if(rcnt >=1)
				{
				JOptionPane.showMessageDialog(null,"Details Stored successfully !");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Problem in  Storing Details");
				}
				con.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex);
			System.out.println("Error 2s:"+ex);
		}// catch ends


	}// if ends
else {

if(ae.getSource()==b2)
{ 
Menubar t=new Menubar();
f.dispose();
}
}
//display();

 }//  action method ends
}

class Roomdemo
{
	public static void main(String s[])
	{
		Room r=new Room();
	}
}
