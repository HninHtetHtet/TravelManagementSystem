package TMS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class deletion extends JFrame implements ActionListener{
JLabel  lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11;
JTextField t1,t2,t3;
JButton b1,b2,b3;
Connection conn;
Statement st;
String sql;
ResultSet rs;
String[] p;
String[] n;
deletion()
{
	super("Admin");
	this.setSize(430,300);	
	
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();																
	int x=(int)((d.getWidth()-this.getWidth()))/2;																			
	int y=(int)((d.getHeight()-this.getHeight()))/2;																			
	setLocation(x,y);	
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	lbl3=new JLabel(new ImageIcon("images/Myanmar.jpg"));
	lbl1=new JLabel("Passenger Name:");
	lbl1.setBounds(10, 20, 200, 50);
	lbl1.setFont(new Font("Serif",Font.BOLD,15));
	lbl3.add(lbl1);
	lbl2=new JLabel("Phone No:");
	lbl2.setBounds(20, 100, 200, 50);
	lbl2.setFont(new Font("Serif",Font.BOLD,15));
	lbl3.add(lbl2);
	lbl4=new JLabel();
	lbl5=new JLabel();
	lbl6=new JLabel();
	lbl7=new JLabel();
	lbl8=new JLabel();
	lbl9=new JLabel();
	lbl10=new JLabel();
	lbl11=new JLabel();
	
	t1=new JTextField();
	t1.setBounds(170, 20, 200, 50);
	lbl3.add(t1);
	t2=new JTextField();
	t2.setBounds(170, 100, 200, 50);
	lbl3.add(t2);
	
	b1=new JButton("Delete");
	b1.setBounds(14, 200, 100, 50);
	b1.setBackground(Color.LIGHT_GRAY);
	lbl3.add(b1);
	b2=new JButton("Cancel");
	b2.setBackground(Color.LIGHT_GRAY);
	b2.setBounds(153, 200,100,50);
	lbl3.add(b2);
	b3=new JButton("Back");
	b3.setBackground(Color.LIGHT_GRAY);
	b3.setBounds(295, 200,100,50);
	lbl3.add(b3);
	//btn color
//btnsetup(b1);

//btnsetup(b2);
//btnsetup(b3);
	/*JPanel bp=new JPanel();
	
	bp.add(b1);
	bp.add(b2);
	bp.add(b3);*/

	
	//lbl3.add(lbl4);
	//lbl3.add(lbl6);
	//lbl3.add(lbl8);

	
	
	
	//lbl3.add(lbl11);
	
	
	this.add(lbl3);
	
//c.add(bp,BorderLayout.SOUTH);
	lbl1.setHorizontalAlignment(0);
	lbl2.setHorizontalAlignment(0);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	t1.setSelectionStart(0);
	this.setResizable(false);
	this.show();
}

	public static void main(String[] args) {
	deletion d=	new deletion();
	}
	public void btnsetup(JButton button)
	{
		LineBorder roundborder=new LineBorder(Color.BLACK,1,true);
		button.setFocusPainted(true);
		button.setBorder(roundborder);
		button.setPreferredSize(new Dimension(23,14));
		button.setBackground(new Color(153,255,153));
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
	if(e.getSource()==b1)
	{String n=t1.getText();
	String  p=t2.getText();
		createDB();
		try {
			st=conn.createStatement();				
			 if(t1.getText().isEmpty()||t2.getText().isEmpty())				
				JOptionPane.showMessageDialog(this, "Please fill information..");			
			else
			{		
				int i=st.executeUpdate("delete from up where name='"+n+"' and phone='"+p+"'");			
				if(i>0)
					JOptionPane.showMessageDialog(this, "Successfully Deleted.");
				else JOptionPane.showMessageDialog(this, "Record Not Found");
			}			
			st.close();
			conn.close();
			
		}
		catch(SQLException e1)
		{	
			//e1.printStackTrace();
		}
		
		
	
			t1.setText("");
			t2.setText("");
		
	}
	if(e.getSource()==b2)
	{
		t1.setText("");
		t2.setText("");
	}
	if(e.getSource()==b3)
	{
		this.dispose();
	new admin();
	}
		
	}
}
