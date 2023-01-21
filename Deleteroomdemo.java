// update and delete room 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Deleteroom implements ActionListener
{
Frame f;
Label l1,l2,l3,l4;
TextField t1,t2;
Button b1,b2,b3;
Checkbox c1;
JTable jTable1;
Connection con;
Font fnt;
DefaultTableModel model ;
PreparedStatement st;
Deleteroom()
{
f=new Frame("Update & Delete Room");
f.setResizable(false);
f.setSize(550,400);
f.setLocationRelativeTo(null);
f.setBackground(Color.GRAY);
l1=new Label("Room Number");
t1=new TextField();
t2=new TextField();
l4=new Label("new rno.");
b1=new Button("Back");
b1.setBackground(Color.YELLOW);
//l2=new Label("Activate");
c1=new Checkbox("Activate");
b2=new Button("Update");
b2.setBackground(Color.GREEN);
b3=new Button("Delete");
b2.addActionListener(this);
b1.addActionListener(this);
b3.addActionListener(this);
l3=new Label("All Rooms");
b3.setBackground(Color.RED);
fnt=new Font("Calibri",Font.BOLD,15);
f.setLayout(null);
l1.setBounds(20,30,90,30);
t1.setBounds(120,30,90,30);
b1.setBounds(230,30,90,30);
//l2.setBounds(350,30,130,30);
c1.setBounds(350,30,130,30);
b2.setBounds(300,90,80,30);
b3.setBounds(410,90,80,30);
l3.setBounds(225,130,80,30);
l4.setBounds(30,90,100,30);
t2.setBounds(120,90,90,30);
f.add(l1);
//f.add(l2);
f.add(l3);
f.add(t1);
f.add(c1);
f.add(b1);
f.add(b2);
f.add(b3);
f.add(t2);
f.add(l4);
l1.setFont(fnt);
//l2.setFont(fnt);
l3.setFont(fnt);
t1.setFont(fnt);
c1.setFont(fnt);
b1.setFont(fnt);
b2.setFont(fnt);
b3.setFont(fnt);
l4.setFont(fnt);
t2.setFont(fnt);



jTable1=new JTable();
		jTable1.setBounds(100,180,350,170);		
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
		System.out.println("Error:"+ex);
	}
}




public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b2)
	{
		try{
			//System.out.println("Hi");
			String old_room=t1.getText();
			String new_room=t2.getText();
			String Activate=c1.getLabel();

			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","");

			//String ss="insert into addroom() values(?,?,?)";
			String query="UPDATE addroom SET Room_number=? WHERE Room_number=?";
			st=con.prepareStatement(query);
			st.setString(1,new_room);
			st.setString(2,old_room);
			int rcnt=st.executeUpdate();
			if(rcnt>0)
			{
				JOptionPane.showMessageDialog(null,"Details Updated successfully !");
			}
			else{
			JOptionPane.showMessageDialog(null,"Problem in  Storing Details");
			}
			con.close();
			
		}//End of try

		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex);
			System.out.println("Error:"+ex);
		} //catch ends




	}// if ends
   




	if(ae.getSource()==b3)
	{
		try
		{
			String Room=t1.getText();
						
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","");

			String del_query = "DELETE FROM addroom Where Room_Number = ?";
			st=con.prepareStatement(del_query);
			st.setString(1,Room);			
			
			//System.out.println("query:"+del_query);
			int rcnt=st.executeUpdate();
			if(rcnt >0)
				{
					JOptionPane.showMessageDialog(null,"Details Deleted successfully !");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Problem in  Deleting Details");
				}
				con.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex);
			System.out.println("Error:"+ex);
		} //catch ends
	} //if ends
if(ae.getSource()==b1)
{
f.dispose();
Menubar t=new Menubar();

}
   }//  action method ends






}




 class Deleteroomdemo
{
public static void main(String s[])
{
Deleteroom dr=new Deleteroom();
}
}