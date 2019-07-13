package TMS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class udate extends JFrame implements ActionListener{

	JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
	JButton b1,b2,b3;
	JTextField t1,t2,t3,t4,t5;
	Connection conn;
	Statement stmt;
	JComboBox cb;
	String[] s= {"Seat","Journey","Date"};
	udate()
	{
		super("Admin");
		this.setSize(500,380);	
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();																
		int x=(int)((d.getWidth()-this.getWidth()))/2;																			
		int y=(int)((d.getHeight()-this.getHeight()))/2;																			
		setLocation(x,y);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lbl3=new JLabel(new ImageIcon("images/pagoda7.jpg"));
	    cb=new JComboBox(s);
		cb.setBounds(134,160,200,50);
	    lbl3.add(cb);
		
		
		
	b1=new JButton("Back");
	b1.setBounds(24,280,100,50);
	b1.setBackground(Color.LIGHT_GRAY);
	lbl3.add(b1);


	b2=new JButton("Cancel");
	b2.setBounds(185,280,100,50);
	b2.setBackground(Color.LIGHT_GRAY);
	lbl3.add(b2);

	b3=new JButton("Next");
	b3.setBounds(355,280,100,50);
	b3.setBackground(Color.LIGHT_GRAY);
	lbl3.add(b3);

	this.add(lbl3);

	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
this.setResizable(false);
	 this.show();
	}
		public static void main(String[] args) {
		
	new udate();
		}
		void createDB()
		{String url="jdbc:mysql://localhost:3306/tms";
		String name="root";
		String pwd="";
			try {
				conn=DriverManager.getConnection(url,name,pwd);
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==b3)
			{ 
				 if(cb.getSelectedItem()=="Seat")
				 { this.dispose();
					  new seats();
				 }
				 
				 if(cb.getSelectedItem()=="Journey")
				 { this.dispose();
					  new journ();
				 }
				 
				 if(cb.getSelectedItem()=="Date")
				 { this.dispose();
					  new date();
				 }
				/*String j="";
			   j=t1.getText();
			  String d="";
			   d=t2.getText();
			  String s="";
			   s=t3.getText();
		      String name="";
		       name=update.nn;
		      
			String journey=update.jj;
			String date=update.dd;
			String seat=update.ss;
			int i=0;
			/*createDB();
			try {
				stmt=conn.createStatement();
				if(journey=="")
					i=stmt.executeUpdate("update up set seat='"+s+"' ,journey='"+j+"',date='"+d+"' where  name='"+name+"'and seat='"+seat+"'  and date='"+date+"' ");
				if(date=="")	
				 i=stmt.executeUpdate("update up set seat='"+s+"' ,journey='"+j+"',date='"+d+"' where  name='"+name+"'and seat='"+seat+"' and journey='"+journey+"'  ");
				if(seat=="")
				 i=stmt.executeUpdate("update up set seat='"+s+"' ,journey='"+j+"',date='"+d+"' where  name='"+name+"' and journey='"+journey+"' and date='"+date+"' ");
				
				if(i>0)
					JOptionPane.showMessageDialog(this, "Update seat successfully.");
				//else
					//JOptionPane.showMessageDialog(this, "Sorry, "+s+" is already booked");
			}catch(SQLException e1)
			{
				e1.printStackTrace();
			}
				*/
				
			}
			if(e.getSource()==b2)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				
			}
			if(e.getSource()==b1)
			{ 
				this.dispose();
				new update();
			}
			
		}

	}


