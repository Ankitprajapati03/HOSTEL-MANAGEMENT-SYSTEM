import javax.swing.table.DefaultTableModel;
 import java.sql.*;
import javax.swing.*;
public class DynRowAdd extends javax.swing.JFrame {
         DefaultTableModel model ;
    // Variables declaration 
    JTable jTable1;	
	ResultSet rs;
	Statement st;
	Connection con;
    // End of variables declaration

    /** Creates new form DynRowAdd */
    public DynRowAdd() {
		jTable1=new JTable();
		add(jTable1);
		setVisible(true);
		setSize(400,500);
        // used to initialize the components
	
	
          model = new DefaultTableModel();
                    jTable1.setModel(model);
    model.addColumn("Name");
                    model.addColumn("Father_name");
                    model.addColumn("Mother_name");
                    model.addColumn("Email_Id");
			model.addColumn("Address");
	       	model.addColumn("Mobile_number");
		model.addColumn("College_name");
		 model.addColumn("Room_number");

        model.addRow(new Object[]{"name","Father_name","Mother_name","Email_id","Address","Mobile_number","College_name","Room_number"});
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
String s1=rs.getString("Name");
String s2=rs.getString("Father_name");
String s3=rs.getString("Mother_name");
String s4=rs.getString("Email_Id");
String s5=rs.getString("Address");
String s6=rs.getString("Mobile_number");
String s7=rs.getString("College_name");
String s8=rs.getString("Room_number");

        model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,s8});
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
                new DynRowAdd().setVisible(true);
            }
        
}