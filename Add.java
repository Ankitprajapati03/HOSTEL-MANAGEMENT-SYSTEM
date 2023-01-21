import javax.swing.table.DefaultTableModel;
 import java.sql.*;
import javax.swing.*;
public class Add extends javax.swing.JFrame {
         DefaultTableModel model ;
    // Variables declaration 
    JTable jTable1;	
	ResultSet rs;
	Statement st;
	Connection con;
    // End of variables declaration

    /** Creates new form DynRowAdd */
    public Add() {
		jTable1=new JTable();
		add(jTable1);
		setVisible(true);
		setSize(400,500);
        // used to initialize the components
	
	
          model = new DefaultTableModel();
                    jTable1.setModel(model);

                    model.addColumn("Room_Number");
                    model.addColumn("Activate");
                    model.addColumn("Room_Status");
		
        model.addRow(new Object[]{"Room_Number","Activate","Room_Status"});
                	display();
    }
public void display() { 
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","");

st=con.createStatement();

String ss="select * from student";
System.out.println("query:"+ss);
 rs=st.executeQuery(ss);
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
                     
                                      
public static void main(String args[]) 
            {
                new Add().setVisible(true);
            }
        
}