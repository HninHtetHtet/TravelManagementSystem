package TMS;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class WhereR extends JFrame implements ActionListener{
	JRadioButton bagan = new JRadioButton("Bagan");
	JRadioButton bago = new JRadioButton("Bago");
	JRadioButton chaungtha = new JRadioButton("Chaung Tha");
	JRadioButton dawei = new JRadioButton("Dawei");
	JRadioButton hpaan = new JRadioButton("Hpa-An");
	JRadioButton inLay = new JRadioButton("InLay");
	JRadioButton kyaukphyu = new JRadioButton("Kyauk Phyu");
	JRadioButton lashio = new JRadioButton("Lashio");
	JRadioButton lykaw = new JRadioButton("Lykaw");
	JRadioButton mandalay = new JRadioButton("Mandalay");
	JRadioButton mawlamyaing = new JRadioButton("Mawalamyaing");
	JRadioButton myawaddy = new JRadioButton("Myawaddy");
	JRadioButton myeik = new JRadioButton("Myeik");
	JRadioButton naypyitaw = new JRadioButton("Nay Pyi Taw");
	JRadioButton ngapali = new JRadioButton("Ngapali");
	JRadioButton ngwesaung = new JRadioButton("Ngwe Saung");
	JRadioButton pathein = new JRadioButton("Pathein");
	JRadioButton pyinoolwin = new JRadioButton("Pyin Oo Lwin");
	JRadioButton sittwe = new JRadioButton("Sittwe");
	JRadioButton taunggyi = new JRadioButton("Taunggyi");
	ButtonGroup group=new ButtonGroup();
	JButton when=new JButton("View Hotel");
	Connection dbConnection=null;
	static String c;
	public WhereR()
	{
		super("Where");
		this.setSize(400,400);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();																
		int x=(int)((d.getWidth()-this.getWidth()))/2;																			
		int y=(int)((d.getHeight()-this.getHeight()))/2;																			
		setLocation(x,y);	
		this.setResizable(false);
		this.show();		
		this.setLayout(new GridLayout(7,3,8,8));
		bagan.addActionListener(this);
		bago.addActionListener(this);
		chaungtha.addActionListener(this);
		dawei.addActionListener(this);
		hpaan.addActionListener(this);
		inLay.addActionListener(this);
		kyaukphyu.addActionListener(this);
		lashio.addActionListener(this);
		lykaw.addActionListener(this);
		mandalay.addActionListener(this);
		mawlamyaing.addActionListener(this);
		myawaddy.addActionListener(this);
		myeik.addActionListener(this);
		naypyitaw.addActionListener(this);
		ngapali.addActionListener(this);
		ngwesaung.addActionListener(this);
		pathein.addActionListener(this);
		pyinoolwin.addActionListener(this);
		sittwe.addActionListener(this);
		taunggyi.addActionListener(this);
		when.addActionListener(this);

		group.add(bagan);
		group.add(bago);
		group.add(chaungtha);
		group.add(dawei);
		group.add(hpaan);
		group.add(inLay);
		group.add(kyaukphyu);
		group.add(lashio);
		group.add(lykaw);
		group.add(mandalay);
		group.add(mawlamyaing);
		group.add(myawaddy);
		group.add(myeik);
		group.add(naypyitaw);
		group.add(ngapali);
		group.add(ngwesaung);
		group.add(pathein);
		group.add(pyinoolwin);
		group.add(sittwe);
		group.add(taunggyi);
		
		this.add(bagan);
		this.add(bago);
		this.add(chaungtha);
		this.add(dawei);
		this.add(hpaan);
		this.add(inLay);
		this.add(kyaukphyu);
		this.add(lashio);
		this.add(lykaw);
		this.add(mandalay);
		this.add(mawlamyaing);
		this.add(myawaddy);
		this.add(naypyitaw);
		this.add(myeik);
		this.add(ngapali);
		this.add(ngwesaung);
		this.add(pathein);
		this.add(pyinoolwin);
		this.add(sittwe);
		this.add(taunggyi);
		this.add(when);
		

		when.setBackground(new Color(120,200,150));
		DatabaseConnection();
	}
	
	public static void main(String[] args)
	{     
		new WhereR();
	}
	public void actionPerformed(ActionEvent e)
	{
		
	    if(e.getSource()==when)	
		{   if(new_seat_2.CHANGEp==1)
			 new new_seat_2(); 
			if(group.isSelected(null))
			{
				JOptionPane.showMessageDialog(this, "Please choose one place at first!");
			}
			else
			   
				if(bagan.isSelected()==true)
				{  if(new_seat_2.CHANGEp==1)
					new new_seat_2();
				  else
				   new baganhotel();
				   c="Bagan";
			    }
			   
				if(bago.isSelected()==true)
				{  if(new_seat_2.CHANGEp==1)
					new new_seat_2();
				  else
					  new bagohotel();
				   c="Bago";
			    }
			   
					if(chaungtha.isSelected()==true)
					{	if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new chaungthahotel();
					  c="Chaung Tha";
				   }
			   
					if(dawei.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new daweihotel();
					 c="Dawei";
				   }
			   
					if(hpaan.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new hpaanhotel();
					 c="Hpa-an";
				   }
			   
					if(inLay.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new inlehotel();
					 c="Inlay";
				   }
			   
					if(kyaukphyu.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new kyaukphyuhotel();
					 c="Kyauk Phyu";
				   }
			   
					if(lashio.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new lashiohotel();
					 c="Lashio";
				   }
			   
					if(lykaw.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new loikawhotel();
					 c="Loikaw";
				   }
			   
					if(mandalay.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new mandalayhotel();
					 c="Mandaly";
				   }
			   
					if(mawlamyaing.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new mawlamyainghotel();
					 c="Mawlamyaing";
				   }
			   
					if(myawaddy.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new Myawaddyhotel();
					 c="Myawaddy";
				   }
			   
					if(myeik.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new myeikhotel();
					 c="Myeik";
				   }
			   
					if(naypyitaw.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new naypyitawhotel();
					 c="NayPyiTaw";
				   }
			   
					if(ngapali.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new ngapalihotel();
					 c="Ngapali";
				   }
			   
					if(ngwesaung.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new ngwesaunghotel();
					 c="NgweSaung";
				   }
			   
					if(pathein.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new patheinhotel();
					 c="Pathein";
				   }
			   
					if(pyinoolwin.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new pyinoolwinhotel();
					    c="PyinOoLwin";
				    }
			   
					if(sittwe.isSelected()==true)
					{	 if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new sittwehotel();
					     c="Sittwe";
				   }
			   
					if(taunggyi.isSelected()==true)
					{ if(new_seat_2.CHANGEp==1)
						new new_seat_2();
					  else
						  new taunggyihotel();
					  c="Taunggyi";
				    }
			
		}
	   
	       
		
		
	}
	public void DatabaseConnection()
	{
		String dbURL = "jdbc:mysql://localhost:3306/tms" ;
		String username = "root";
		String password = "";
		
		
		try
		{
			dbConnection = DriverManager.getConnection(dbURL, username, password);	
		}
		catch(SQLException e)
		{
			System.out.println("Unable to connect to database  " + e.getMessage());
		}
		
		
	}
	public void closeConnection()
	{
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
