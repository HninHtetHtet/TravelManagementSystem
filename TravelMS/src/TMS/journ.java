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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class journ extends JFrame implements ActionListener{

	JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
	JButton b1,b2,b3;
	JTextField t1,t2,t3,t4,t5;
	Connection conn;
	Statement stmt;
	 //Font f1=new Font("Myriad Pro Light",Font.BOLD,28);
	
	journ()
	{
		super("Admin");
		this.setSize(500,380);	
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();																
		int x=(int)((d.getWidth()-this.getWidth()))/2;																			
		int y=(int)((d.getHeight()-this.getHeight()))/2;																			
		setLocation(x,y);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lbl3=new JLabel(new ImageIcon("images/pagoda7.jpg"));
	lbl1=new JLabel("New Journey:");
	lbl1.setForeground(Color.white);
	lbl1.setFont(new Font("Myriad Pro Light",Font.BOLD,18));
	lbl1.setBounds(46,150,150,50);
	//lbl1.setFont(new Font("Serif",Font.BOLD,15));
	lbl3.add(lbl1);
		lbl2=new JLabel("Updating Journey");
		//lbl2.setForeground(Color.white);
		lbl2.setBounds(140,18,200,50);
		lbl2.setFont(new Font("Serif",Font.BOLD,24));
		lbl3.add(lbl2);
		
	t1=new JTextField();
	t1.setBounds(160,150,200,50);
	lbl3.add(t1);
	b1=new JButton("Update");
	b1.setBounds(24,280,100,50);
	b1.setBackground(Color.LIGHT_GRAY);
	lbl3.add(b1);


	b2=new JButton("Cancel");
	b2.setBounds(185,280,100,50);
	b2.setBackground(Color.LIGHT_GRAY);
	lbl3.add(b2);
	

	b3=new JButton("Back");
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
		
	new journ();
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
		public void actionPerformed(ActionEvent e)
		{ 
			if(e.getSource()==b2)
			{
				t1.setText(null);
			}
			if(e.getSource()==b3)
			{
				this.dispose();
				new update();
			}
			
			String new_place="";
			{int i=0;
			new_place=t1.getText();
			String name=update.nn;
			String journey=update.jj;
			int year=update.yy;
			String month=update.mm;
			int day  =update.d;
			System.out.println(name+" "+journey+" "+year+" "+month+" "+day+" "+new_place);
			createDB();
			
			try
			{stmt=conn.createStatement();
				i=stmt.executeUpdate("update up set Place='"+new_place+"' where name='"+name+"' and Place='"+journey+"' and Year='"+year+"' and Month='"+month+"' and Day='"+day+"'" );
				if(i>0)
					JOptionPane.showMessageDialog(this,"Successfully updated");
				else if(i<0)
					JOptionPane.showMessageDialog(this,"Something wrong!");
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			
		}}

}
