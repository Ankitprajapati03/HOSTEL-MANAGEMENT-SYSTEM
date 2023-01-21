// Packages to import
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Activatetable
	{
	
	JFrame f;
	
	JTable j;

	
	Activatetable()
	{
		
		f = new JFrame();
       f.setResizable(false);
	   f.setLocationRelativeTo(null);
	
		
	

		
		String[][] data = {
					{ "    ", "    ", "    "},
           		 { "    ", "    ", "    "},
	{"    ","    ","    "},
				{"    ","    ","    "},
            { "    ", "    ", "    "},
				{"    ","    ","    "},
		{"    ","    ","    "},

		};	
		
		String[] columnNames = { "Room Number","Activate","Room Status" };

		
		j = new JTable(data, columnNames);
		j.setBounds(150,200, 300, 300);

		
		JScrollPane sp = new JScrollPane(j);
		f.add(sp);
		
		f.setSize(350,250);
		
		f.setVisible(true);
	}

	// Driver method
	public static void main(String[] args)
	{
		new Activatetable();
	}
}
