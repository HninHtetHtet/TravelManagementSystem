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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class seats extends JFrame implements ActionListener {

	
		JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
		JButton b1,b2,b3;
		JTextField t1,t2,t3,t4,t5;
		Connection conn;
		Statement stmt;
		JLabel lb;
		JRadioButton r1,r2;
		ButtonGroup gp;
		seats()
		{
			super("Admin");
			this.setSize(500,380);	
			
			Dimension d=Toolkit.getDefaultToolkit().getScreenSize();																
			int x=(int)((d.getWidth()-this.getWidth()))/2;																			
			int y=(int)((d.getHeight()-this.getHeight()))/2;																			
			setLocation(x,y);	
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			lbl3=new JLabel(new ImageIcon("images/pagoda7.jpg"));
		
			
		 lb=new JLabel("Updating Seats");
		lb.setBounds(174,20,200,50);
		lb.setFont(new Font("Serif",Font.BOLD,24));
		lbl3.add(lb);
			
		
		t1=new JTextField();
		t1.setBounds(156,170,200,50);
		lbl3.add(t1);

		
		lbl1=new JLabel("New Seat:");
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Myriad Pro Light",Font.BOLD,18));
		lbl1.setBounds(45,170,100,50);
		lbl3.add(lbl1);
		
		r1=new JRadioButton("Car1");
		r1.setBounds(154,100,100,50);
		lbl3.add(r1);
		
		r2=new JRadioButton("Car2");
		r2.setBounds(274,100,100,50);
		lbl3.add(r2);
		gp=new ButtonGroup();
		gp.add(r1);
		gp.add(r2);
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
			
		new seats();			}
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
			
			String new_seat="";
			public void actionPerformed(ActionEvent e) 
			{ 
				if(e.getSource()==b2)
				{
					t1.setText(null);
					r1.setSelected(false);
					r2.setSelected(false);
		       }
				if(e.getSource()==b3)
				{
					this.dispose();
					new update();
				}
				if(e.getSource()==b1)
				{int i=0;
				new_seat=t1.getText();
				String name=update.nn;
				String journey=update.jj;
				int year=update.yy;
				String month=update.mm;
				int day  =update.d;
				System.out.println(name+" "+journey+" "+year+" "+month+" "+day+" "+new_seat);
				createDB();
				if(r1.isSelected() )
				{
					try
					{stmt=conn.createStatement();
						i=stmt.executeUpdate("update up set car1='"+new_seat+"' where name='"+name+"'and Place='"+journey+"' and Year='"+year+"' and Month='"+month+"' and Day='"+day+"' ");
						if(i>0)
							JOptionPane.showMessageDialog(this,"Successfully updated");
						else
							JOptionPane.showMessageDialog(this,"Something wrong!");
					}
					catch(SQLException e1)
					{
						e1.printStackTrace();
					}
					
				}
				if(r2.isSelected() )
				{
					try
					{stmt=conn.createStatement();
						i=stmt.executeUpdate("update up set car2='"+new_seat+"' where name='"+name+"' ");
						if(i>0)
							JOptionPane.showMessageDialog(this,"Successfully updated");
						else
							JOptionPane.showMessageDialog(this,"Something wrong!");
					}
					catch(SQLException e1)
					{
						e1.printStackTrace();
					}
					
				}
				}
				
			}

	}


