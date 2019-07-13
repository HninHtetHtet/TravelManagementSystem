package TMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class taunggyihotel extends JFrame implements ActionListener
{
	//private static final String DriveManager = null;
	TaunggyiSr s;
	TaunggyiDr p;
	TaunggyiFr f;
	TaunggyiVr v;
	int ser=0;
	JButton a1,a2,a3,a4,a5,a6;
	Font f1=new Font("Arno Pro Smbd",Font.PLAIN,30);
	Font ff1=new Font("Arno Pro Smbd",Font.ITALIC,30);
	Font f6=new Font("Algerian",Font.PLAIN,20);
	int singler,doubler,familyr,vipr;
	int total=0;
	Connection dbConnection=null;
	
	public taunggyihotel()
	{
		super("Taunggyi Hotel");
		this.getContentPane().setBackground(new Color(0,128,128));
		//this.getContentPane().setBackground(new Color(152,251,152));
    	this.setVisible(true);
    	this.setBounds(50,0,1280,768);
    	this.setLayout(null);
    	
    	JButton title=new JButton("Royal Taunggyi Hotel");
    	title.setBounds(450, 20, 460, 50);
    	title.setFont(f1);
    	//title.setBackground(new Color(144,238,144));
    	title.setBackground(new Color(32,178,170));
    	this.add(title);
    	
    	JLabel l1=new JLabel(new ImageIcon("hotelimage/tgn1.jpg"));
    	l1.setBounds(0, 30, 1300, 400);
    	this.add(l1);
    	
    	
    	JLabel t1=new JLabel("Book Your Stay");
    	t1.setBounds(300,490, 300, 30);
    	t1.setFont(ff1);
    	this.add(t1);
   // 	t1.setBorder(BorderFactory.createTitledBorder("Book Your Stay"));
    	
    	
    	a1=new JButton("Single Room");
    	a1.setBounds(110,550, 200, 37);
    	a1.setFont(f6);
    	a1.setBackground(Color.GRAY);
    	a1.addActionListener(this);
    	this.add(a1);
    	
    	a2=new JButton("Double Room");
    	a2.setBounds(500,550, 200, 37);
    	a2.setFont(f6);
    	a2.setBackground(Color.GRAY);
    	a2.addActionListener(this);
        this.add(a2);
  
    	a3=new JButton("Public Room");
    	a3.setBounds(110,650, 200, 37);
    	a3.setFont(f6);
    	a3.setBackground(Color.GRAY);
    	a3.addActionListener(this);
    	this.add(a3);
    	
    	a4=new JButton("VIP Room");
    	a4.setBounds(500,650, 200, 37);
    	a4.setFont(f6);
    	a4.setBackground(Color.GRAY);
    	a4.addActionListener(this);
    	this.add(a4);
    	
    	a5=new JButton("Book Now");
    	a5.setBounds(330,600, 150, 37);
    	a5.setFont(f6);
    	a5.setBackground(new Color(112,128,144));
    	a5.addActionListener(this);
    	this.add(a5);
    	
    	a6=new JButton("Back");
    	a6.setBounds(330,680, 150, 37);
    	a6.setFont(f6);
    	a6.setBackground(new Color(112,128,144));
    	a6.addActionListener(this);
    	this.add(a6);
    	
    	/*
    	JButton main=new JButton("Enjoy the comforts of Hotel");
    	main.setBounds(450,580, 400, 60);
    	main.setBackground(new Color(255,228,196));
    	main.setFont(f1);
    	this.add(main);
    	
    	JLabel t2=new JLabel("Contact Us");
    	t2.setBounds(1010,500, 300, 30);
    	t2.setFont(ff1);
    	this.add(t2);
    	*/
    	JLabel c1=new JLabel(new ImageIcon("hotelimage/ngsg2.png"));
    	c1.setBounds(830,310, 500, 550);
    	c1.setFont(ff1);
    	this.add(c1);
    	
    	DatabaseConnection();
    
    	this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	
	}

	public static void main(String[] args)
	{
		taunggyihotel t=new taunggyihotel();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==a1)
		{
			s=new TaunggyiSr();
			ser+=1;
		}
		else if(e.getSource()==a2)
		{
			p=new TaunggyiDr();
			ser+=2;
		}
		else if(e.getSource()==a3)
		{
			f=new TaunggyiFr();
			ser+=4;
		}
		else if(e.getSource()==a4)
		{
			v=new TaunggyiVr();
			ser+=8;
		}
		
		else if(e.getSource()==a6)
		{
			this.dispose();
			new WhereR();
			
		}
		else{
			switch(ser){
			case 0:{
				singler=0;
				doubler=0;
				familyr=0;
				vipr=0;
			}
			break;
			case 1:{
				singler=s.tot;
				doubler=0;
				familyr=0;
				vipr=0;
			}
			break;
			case 2:{
				singler=0;
				doubler=p.tot;
				familyr=0;
				vipr=0;
			}
			break;
			case 3:{
				singler=s.tot;
				doubler=p.tot;
				familyr=0;
				vipr=0;
			}
			break;
			case 4:{
				singler=0;
				doubler=0;
				familyr=f.tot;
				vipr=0;
			}
			break;
			case 5:{
				singler=s.tot;
				doubler=0;
				familyr=f.tot;
				vipr=0;
			}
			break;
			case 6:{
				singler=0;
				doubler=p.tot;
				familyr=f.tot;
				vipr=0;
			}
			break;
			case 7:{
				singler=s.tot;
				doubler=p.tot;
				familyr=f.tot;
				vipr=0;
			}
			break;
			case 8:{
				singler=0;
				doubler=0;
				familyr=0;
				vipr=v.tot;
			}
			break;
			case 9:{
				singler=s.tot;
				doubler=0;
				familyr=0;
				vipr=v.tot;
			}
			break;
			case 10:{
				singler=0;
				doubler=p.tot;
				familyr=0;
				vipr=v.tot;
			}
			break;
			case 11:{
				singler=s.tot;
				doubler=p.tot;
				familyr=0;
				vipr=v.tot;
			}
			break;
			case 12:{
				singler=0;
				doubler=0;
				familyr=f.tot;
				vipr=v.tot;
			}
			break;
			case 13:{
				singler=s.tot;
				doubler=0;
				familyr=f.tot;
				vipr=v.tot;
			}
			break;
			case 14:{
				singler=0;
				doubler=p.tot;
				familyr=f.tot;
				vipr=v.tot;
			}
			break;
			case 15:{
				singler=s.tot;
				doubler=p.tot;
				familyr=f.tot;
				vipr=v.tot;
			}
			break;
			}
			System.out.println(doubler);
			total=total+singler+doubler+familyr+vipr;
			{
				Statement stmt;
				try {
					 	PreparedStatement pstmt = dbConnection.prepareStatement("INSERT INTO Expenses  VALUES(?,?,?,?,?)");
					 	pstmt.setInt(1 , singler);
					 	pstmt.setInt(2 , doubler);
					 	pstmt.setInt(3 , familyr);
					 	pstmt.setInt(4 , vipr);	
					 	pstmt.setInt(5, total);
					 	int i = pstmt.executeUpdate();
					 	if (i>0) 
					 	{
					 		JOptionPane.showMessageDialog(this, "Serve your prefer date");
					 		new Calender_Update();
					 	}
					 	else
					 		JOptionPane.showMessageDialog(this, "Book fail");

					 	pstmt.close();

					} 
				catch (SQLException ee) 
					{
						ee.printStackTrace();
					}
			}
		}
	}
	public void DatabaseConnection(){
		String dbURL="jdbc:mysql://localhost:3306/tms";
		String username="root";
		String password="";
		try
		{
			dbConnection = DriverManager.getConnection(dbURL, username, password);
		}
		catch(SQLException e)
		{
			System.out.println("Unable to connect to database "+e.getMessage());
		}
	}
	public void closeConnection() {
		try 
		{
			dbConnection.close();
			System.out.println("The connection is closed.");
		} catch (SQLException e) 
		{

			e.printStackTrace();
		}

	}

}
