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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class date extends JFrame implements ActionListener{

	JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
	JButton b1,b2,b3;
	JTextField t1,t2,t3,t4,t5;
	Connection conn;
	Statement stmt;
	 Font f1=new Font("Myriad Pro Light",Font.CENTER_BASELINE,22);
	
	date()
	{
		super("Admin");
		this.setBounds(430, 140,500,450);
        this.setLayout(null);
        this.setTitle("Login");
		
		lbl3=new JLabel();
		lbl3.setIcon(new ImageIcon("images/pagoda7.jpg"));
		lbl3.setBounds(0,0,2300,350);
		this.add(lbl3);
		
		lbl2=new JLabel("Updating Date");
		lbl2.setBounds(170,10,160,50);
		//lbl2.setForeground(Color.white);
		lbl2.setFont(new Font("Serif",Font.BOLD,24));
		lbl3.add(lbl2);
		
		
		lbl4=new JLabel("Year  :");
	    lbl4.setBounds(44,68,100,50);
	    lbl4.setForeground(Color.white);
	    lbl4.setFont(f1);
		lbl3.add(lbl4);
		
		
		lbl5=new JLabel("Month  :");
		lbl5.setBounds(44,120,100,50);
		lbl5.setForeground(Color.white);
	    lbl5.setFont(f1);
	    lbl3.add(lbl5);
			
			
		JLabel	lbl6=new JLabel("Day:");
		lbl6.setBounds(44,180,100,50);
		lbl6.setForeground(Color.white);
	    lbl6.setFont(f1);
		lbl3.add(lbl6);
		
	t1=new JTextField();
	t1.setBounds(160,68,200,50);
	lbl3.add(t1);
	
	
	
	t2=new JTextField();
	t2.setBounds(160,125,200,50);
	lbl3.add(t2);
	
	
	t3=new JTextField();
	t3.setBounds(160,180,200,50);
	lbl3.add(t3);
	b1=new JButton("Update");
	b1.setBackground(Color.LIGHT_GRAY);
	b1.setBounds(24,280,100,50);
	lbl3.add(b1);


	b2=new JButton("Cancel");
	b2.setBounds(185,280,100,50);
	b2.setBackground(Color.LIGHT_GRAY);
	lbl3.add(b2);

	b3=new JButton("Back");
	b3.setBounds(355,280,100,50);
	b3.setBackground(Color.LIGHT_GRAY);
	lbl3.add(b3);

	 this.setVisible(true);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
//this.setResizable(false);
	 this.show();
	}
		public static void main(String[] args) {
		
	new date();
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
		{ String new_day="";
		  String new_month="";
		  String new_year="";
			{int i=0;
			new_year  =t1.getText();
			new_month=t2.getText();
			new_day=t3.getText();
			String name=update.nn;
			String journey=update.jj;
			int year=update.yy;
			String month=update.mm;
			int day  =update.d;
			System.out.println(name+" "+journey+" "+year+" "+month+" "+day+" "+new_day);
			createDB();
			
			try
			{stmt=conn.createStatement();
				i=stmt.executeUpdate("update up set Day='"+new_day+"',Month='"+new_month+"',Year='"+new_year+"' where name='"+name+"' and Place='"+journey+"' and Year='"+year+"' and Month='"+month+"' and Day='"+day+"'" );
				if(i>0)
					JOptionPane.showMessageDialog(this,"Successfully updated");
				if(i<0)
					JOptionPane.showMessageDialog(this,"Something wrong!");
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		
			
			
		}
			if(e.getSource()==b2)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
			}
			if(e.getSource()==b3)
			{
				this.dispose();
				new update();
			}
		}
}
