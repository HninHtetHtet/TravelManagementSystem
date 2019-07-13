package TMS;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
public class TableEX extends JFrame implements ActionListener{
	private TableModel tmodel;
	JButton b1;
	private Swapdata sd;
	private Database db=new Database();
	public TableEX()
	{
		super("Table");
		this.setBounds(50,0,1280,768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setVisible(true);
		b1=new JButton("Back");

		tmodel=new TableModel();
		Container c=this.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(tablePanel());
				
		//b1.setBounds(0,700,10,10);
		b1.addActionListener(this);
		c.add(b1,BorderLayout.SOUTH);
		
		
	}
	public JPanel tablePanel()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		JTable table=new JTable(tmodel);
		panel.add(new JScrollPane(table));
		return panel;
	}
	public static void main(String args[])
	{
		TableEX t=new TableEX();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			this.dispose();
			new admin();
		}
		
	}

}
class TableModel extends AbstractTableModel
{
	private Database db=new Database();
	ArrayList<Swapdata> list;
    String col[]= {"Name","Phone No.","Journey","Date","Seat No."};
	@Override
	
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		try {
			return db.getSize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public Object getValueAt(int row, int col) 
	{
		list=new ArrayList<Swapdata>();
		Swapdata swapclass = null;
		try {
			list=db.execute();
			swapclass=list.get(row);
	        	} catch (SQLException e) {
			// TODO Auto-generated catch block
		     	e.printStackTrace();
		       }
	   switch(col)
	   {
	   case 0: return swapclass.getName();
	   case 1: return swapclass.getPhone();
	   case 2: return swapclass.getJourney();
	   case 3: return swapclass.getDate();
	   case 4:return swapclass.getSeat();
	   }
	   return null;
	  
	}

	@Override
	public String getColumnName(int a) {
		return col[a];
	}
	
	
}
