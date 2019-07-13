package TMS;



import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

//import com.mysql.jdbc.Statement;

public class new_seat_2 extends JFrame implements ActionListener
{ 
     static int CHANGEd=0; 
     static int CHANGEp=0;
     static int num_seat=0;
     public static int Seat_price=0;
	static JButton[] A=new JButton[45];
	static JButton[] B=new JButton[45];
	static String sno1[]=new String[45];  
    static String sno2[]=new String[45];
    static int sno11[]=new int [100];
	static int sno22[]=new int [100];
	
    
	JLabel extraL[]=new JLabel[21];
	JLabel L[]=new JLabel[21];
	JLabel L2[]=new JLabel[21];
	
	JButton bb1=new JButton("");
	JButton bb2=new JButton("");
	JButton bb3=new JButton("");
	JButton bb4=new JButton("");
    JButton bb5=new JButton("");
    
    JLabel c1=new JLabel ("Car 1");
    JLabel c2=new JLabel ("Car 2");   
   	JPanel title =new JPanel();
    JPanel nav=new JPanel();
    JPanel innernav=new JPanel();
    JPanel ps=new JPanel();
	JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JScrollPane sp=new JScrollPane(ps);
    
    JLabel lbl1=new JLabel("Available Seat");
    JLabel lbl2=new JLabel("Purchased Seat");
    JTextArea  s=new JTextArea(2,10);
    
    JButton change1=new JButton("Change");
    JButton change2=new JButton("Change");
    JButton change3=new JButton("Change");
    
	JButton lblC1=new JButton("  ");
	JButton lblC2=new JButton("  ");
	Panel PnlC1=new Panel();
	Panel PnlC2=new Panel();
		
	JPanel seatC=new JPanel();
	Connection dbConnection=null;
    
      public new_seat_2()
    {     
    	  
      c1.setToolTipText("Available Cars");
      c2.setToolTipText("Available CArs");
      c1.setFont(new Font("Times new Roman", Font.BOLD,25));
      c2.setFont(new Font("Times new Roman", Font.BOLD,25)); 
      this.add(nav,BorderLayout.NORTH);
     
      nav.setLayout(new GridLayout(2,1));
      nav.add(title);
      JLabel titleLabel=new JLabel("Tip To Tour");
      titleLabel.setFont(new Font("Times new Roman",Font.BOLD,50));
      title.add(titleLabel);
      nav.add(innernav);
      
        innernav.setLayout(new GridLayout(1,5));
	    innernav.add(bb1);
	    innernav.add(bb2);
	    innernav.add(bb3);
	    innernav.add(bb4);
	    innernav.add(bb5);
	    bb1.setBackground(new Color(233,20,147));
	    bb2.setBackground(new Color(233,20,147));
	    bb3.setBackground(new Color(233,20,147));
	    bb4.setBackground(new Color(233,20,147));
	    bb5.setBackground(new Color(233,20,147));
	    
	    bb1.setIcon(new ImageIcon(toolbar_btn_image("Image/back.png")));
	    bb2.setIcon(new ImageIcon(toolbar_btn_image1("Image/booking4.jpg")));
        bb3.setIcon(new ImageIcon(toolbar_btn_image("Image/Home1.jpg")));
        bb4.setIcon(new ImageIcon(toolbar_btn_image("cancel1.jpg")));
        bb5.setIcon(new ImageIcon(toolbar_btn_image("Image/Next.png")));
       
      this.add(ps);
      ps.setLayout(null);
      Border inner =BorderFactory.createEmptyBorder(5,2,5,5);
      Border colour=BorderFactory.createLineBorder(Color.black); 
      Border outer =BorderFactory.createTitledBorder(colour, "Select the Seat ");
     // Border outer2 =BorderFactory.createTitledBorder(colour, "Select the Seat From Car(2)");
      ps. setBorder(BorderFactory.createCompoundBorder(inner,outer));
     // p2.setBorder(BorderFactory.createCompoundBorder(inner,outer2));
    ps.add(p1);
    p1.setBounds(45,30,350,560);
//    p1.setBackground(new Color(233,20,147));
    p1.setLayout(new GridLayout(12,6));
	ps.add(p2);
	p2.setBounds(425,30,350,560);
//	p2.setBackground(new Color(233,20,147));
    p2.setLayout(new GridLayout(12,7));
    
  //Descriptions
    lblC1.setBackground(Color.GREEN);
 	lblC2.setBackground(Color.RED);
 	lblC1.setEnabled(false);
 	lblC2.setEnabled(false);
 	
    PnlC1.add(lblC1);
 	PnlC2.add(lblC2);
 		
 	JPanel seatC=new JPanel();
 	seatC.setLayout(new GridLayout(2,2));
 	seatC.add(PnlC1);
 	seatC.add(lbl1);
 	seatC.add(PnlC2);
 	seatC.add(lbl2);
 	
 	String city =WhereR.c;
 	String arrt1="";
 	String arrt2="";
 	if(city=="Bagan")
 	{
 	  arrt1="5:20 PM";
 	  arrt2="4:20 AM";
 	}
 	if(city=="Chaung Tha")
 	{
 	  arrt1="2:00 PM";
 	  arrt2="1:00 AM";
 	}
 	if(city=="Dawei")
 	{
 	  arrt1="11:46 AM";
 	  arrt2="10:46 PM";
 	}
 	if(city=="Gwa")
 	{
 	  arrt1="2:20 PM";
 	  arrt2="1:20 AM";
 	}
 	if(city=="Hpa-An")
 	{
 	  arrt1="1:35 PM";
 	  arrt2="12:35 PM";
 	}
 	if(city=="Inlay")
 	{
 	  arrt1="5:58 AM";
 	  arrt2="4:58 PM";
 	}
 	if(city=="Lashio")
 	{
 	  arrt1="10:49 PM";
 	  arrt2="9:49 AM";
 	}
 	if(city=="Loikaw")
 	{
 	  arrt1="5:00 PM";
 	  arrt2="4:00 AM";
 	}
 	if(city=="Mandalay")
 	{
 	  arrt1="4:25 PM";
 	  arrt2="3:25 AM";
 	}
 	if(city=="Myawaddy")
 	{
 	  arrt1="4:57 PM";
 	  arrt2="3:57 AM";
 	}
 	if(city=="Myeik")
 	{
 	  arrt1="1:23 AM";
 	  arrt2="12:23 AM";
 	}
 	if(city=="Ngapali")
 	{
 	  arrt1="5:55 PM";
 	  arrt2="4:55 AM";
 	}
 	if(city=="Ngwe Saung")
 	{
 	  arrt1="1:57 PM";
 	  arrt2="12:57 PM";
 	}
 	if(city=="Pa Thein")
 	{
 	  arrt1="12:41 AM";
 	  arrt2="11:41 PM";
 	}
 	if(city=="Pyin Oo Lwin")
 	{
 	  arrt1="5:43 PM";
 	  arrt2="4:13 AM";
 	}
 	if(city=="Shwebo")
 	{
 	  arrt1="5:52 PM";
 	  arrt2="4:52 AM";
 	}
 	if(city=="Sittwe")
 	{
 	  arrt1="4:05 AM";
 	  arrt2="3:05 PM";
 	}
 	if(city=="Taung Gyi")
 	{
 	  arrt1="6:47 PM";
 	  arrt2="5:47 AM";
 	}
 	if(city=="Than Dwe")
 	{
 	  arrt1="5:33 PM";
 	  arrt2="4:33 AM";
 	}
 	else
 	{
 		arrt1="1:30 PM";
 		arrt2="12:30 PM";
 	}
 		
 	
   // this.add(seatC,BorderLayout.NORTH);
    JPanel mseatC=new JPanel();
    JPanel mseat =new JPanel();
    JLabel info=new JLabel("YOUR BOOKING INFORMATION");
    JLabel place=new JLabel("PLACE");
    JLabel Date =new JLabel("DATE");
    JLabel Seat =new JLabel("Price of Seat");
    JTextArea  p=new JTextArea(2,10);
    JTextArea  d=new JTextArea(2,10);
    JLabel schedule =new JLabel("SCHEDULE");
    JLabel departure=new JLabel("DEPARTURE");
    JLabel arrival  =new JLabel("ARRIVAL");
    JLabel cara     =new JLabel("Car( 1 )");
    JLabel carb     =new JLabel("Car( 2 )");
    JLabel depp     =new JLabel("Yangon");
    JLabel deppp    =new JLabel("Yangon");
    String pla1=WhereR.c;
    JLabel arrp     =new JLabel(pla1);
    String pla2=WhereR.c;
    JLabel arrpp    =new JLabel(pla2);
    JLabel dept    =new JLabel("8:00 AM");
    JLabel deptt    =new JLabel("7:00 PM");
    JLabel arrt    =new JLabel(arrt1);
    JLabel arrtt    =new JLabel(arrt2);
    String pla=WhereR.c;
    int Seat_price=0;
    if(pla=="Bagan" || pla=="Lashio" || pla=="In Lay" || pla=="Kyauk Phyu" || pla=="Loikaw" || pla=="Myawadday" || pla=="Taunggyi" )
    {
      Seat_price+=10000*num_seat;	
    }
    if(pla=="Chaung Tha" || pla=="Dawei"  || pla=="Hpa-An" || pla=="Mandalay"  || pla=="Myeik"  || pla=="Ngapali" || pla=="Sittwe")
    {
    	Seat_price+=7000*num_seat;
    }
    else
    	Seat_price+=5000*num_seat;
    	
    s.setText("   "+Integer.toString (Seat_price));
    
    String pp="   "+WhereR.c;
    p.setText(pp);
    p.setAlignmentY(CENTER_ALIGNMENT);
    String date="   "+Calender_Update.DAY+" "+Calender_Update.MONTH+" "+Calender_Update.YEAR;
    d.setText(date);
    d.setAlignmentX(CENTER_ALIGNMENT);
    
    
    JPanel show=new JPanel();
    mseatC.add(seatC); 	

    show.setLayout(null);
    show.add(info);
    info.setBounds(110,10,400,20);
    info.setFont(new Font("Times New Roman",Font.BOLD,20));
    
    show.add(place);
    place.setBounds(50,50,100,50);
    place.setFont(new Font("Times New Roman", Font.BOLD,14));
    show.add(p);
    p.setBounds(170,60,200,35);
    p.setFont(new Font("Times New Roman", Font.BOLD,20));
    show.add(change1);
    change1.setBounds(390,62,100,30);  
    
    show.add(Date);
    Date.setBounds(50,100,100,50);
    Date.setFont(new Font("Times New Roman", Font.BOLD,14));
    show.add(d);
    d.setBounds(170,110,200,35);
    d.setFont(new Font("Times New Roman", Font.BOLD,20));
    show.add(change2);
    change2.setBounds(390,112,100,30);
    
    show.add(Seat);
    Seat.setBounds(50,150,100,50);
    Seat.setFont(new Font("Times New Roman", Font.BOLD,17));
    show.add(s);
    s.setBounds(170,160,200,35);
    s.setFont(new Font("Times New Roman", Font.BOLD,20));
   
    show.add(schedule);
    schedule.setBounds(200,180,150,100);
    schedule.setFont(new Font("Times New Roman",Font.BOLD,20));
    show.add(departure);
    departure.setBounds(130,210,150,100);
    departure.setFont(new Font("Times New Roman",Font.BOLD,14));
    show.add(arrival);
    arrival.setBounds(300,210,150,100);
    arrival.setFont(new Font("Times New Roman",Font.BOLD,14));
    show.add(cara);
    cara.setBounds(30,230,150,100);
    cara.setFont(new Font("Times New Roman",Font.BOLD,16));
    show.add(depp);
    depp.setBounds(30,260,150,100);
    depp.setFont(new Font("Times New Roman",Font.BOLD,16));
    show.add(dept);
    dept.setBounds(130,260,150,100);
    dept.setFont(new Font("Times New Roman",Font.BOLD,16));
    show.add(arrt);
    arrt.setBounds(300,260,150,100);
    arrt.setFont(new Font("Times New Roman",Font.BOLD,16));
    show.add(arrp);
    arrp.setBounds(400,260,150,100);
    arrp.setFont(new Font("Times New Roman",Font.BOLD,16));
    show.add(carb);
    carb.setBounds(30,300,150,100);
    carb.setFont(new Font("Times New Roman",Font.BOLD,16));
    show.add(deppp);
    deppp.setBounds(30,330,150,100);
    deppp.setFont(new Font("Times New Roman",Font.BOLD,16));
    show.add(deptt);
    deptt.setBounds(130,330,150,100);
    deptt.setFont(new Font("Times New Roman",Font.BOLD,16));
    show.add(arrtt);
    arrtt.setBounds(300,330,150,100);
    arrtt.setFont(new Font("Times New Roman",Font.BOLD,16));
    show.add(arrpp);
    arrpp.setBounds(400,330,150,100);
    arrpp.setFont(new Font("Times New Roman",Font.BOLD,16));
    
    mseat.setLayout(null);
    mseat.add(mseatC);
    mseatC.setBounds(200,30,300,100);
    mseat.add(show);
    show.setBounds(105,160,500,400);
   // mseat.setBorder(BorderFactory.createTitledBorder("Description"));
    Border inner1 =BorderFactory.createEmptyBorder(5,100,5,5);
    Border colour1=BorderFactory.createLineBorder(Color.black); 
    Border outer1 =BorderFactory.createTitledBorder(colour, "Description");
    mseat. setBorder(BorderFactory.createCompoundBorder(inner1,outer1));
       
     JPanel main=new JPanel();
     main.add(ps);
     ps.setBounds(10,5,815,600);
    // ps.setBackground(new Color(233,20,147));
     main.add(mseat);
     mseat.setBounds(730,5,630,600);
     this.add(main); 
     main.setLayout(null);
     
    change1.addActionListener(this);
    change2.addActionListener(this);
    change3.addActionListener(this);
    bb1.addActionListener(this);
    bb2.addActionListener(this);
	bb3.addActionListener(this);
	bb4.addActionListener(this);
	bb5.addActionListener(this);
           for(int i=0;i<45;i++) 
		{   
   	  		A[i]=new JButton("Seat "+(i+1));
   	  	    A[i].setFont(new Font("Times new Roman",0, 12));
    	 	B[i]=new JButton("Seat "+(i+1));
    	 	B[i].setFont(new Font("Times new Roman",0, 12));
    	 	A[i].setBackground(Color.GREEN);
			A[i].setForeground(Color.black);
			
			B[i].setBackground(Color.GREEN);
			B[i].setForeground(Color.black);
			A[i].addActionListener(this);
			B[i].addActionListener(this);
		}
          
            for(int i=0;i<45;i++)
            {
            	if(sno1[i]!=null)
            	{ A[i].setBackground(Color.red);	
            	  A[i].setForeground(Color.WHITE);
            	}  
            	if(sno2[i]!=null)
            	{ B[i].setBackground(Color.red);
            	  B[i].setForeground(Color.WHITE);
            	}
            }
            
            for(int i=0;i<21;i++)
           {
        	   extraL[i]=new JLabel("");
           }
		for(int i=0;i<21;i++)
		{
			L[i]=new JLabel("");
            L2[i]=new JLabel("");		
		}
         
		title.add(extraL[10]);
		title.add(extraL[11]);
		title.add(extraL[12]);
            

		for(int i=0;i<=6;i++)
		{
			 if(i<3)
				{ //  p1.add(extraL[0]);
				    p1.add(extraL[1]);
					p1.add(extraL[2]);
				//	p2.add(extraL[3]);
					p2.add(extraL[4]);
					p2.add(extraL[20]);
					
				}
			 if(i==4)
			 {
				 p1.add(c1);
				 p2.add(c2);
			 }
			 if(i>4)
			 {
				 p1.add(extraL[5]);
				 p1.add(extraL[6]);
				 p2.add(extraL[7]);
				 p2.add(extraL[8]);
				 
			 }
		}
		int j=0;int k=9;
		for(int i=0;i<45;i++)
		{  
			if(i%2==0 && i!=0 && i%4!=0 && j<10)
			   {  p1.add(L[j]);
			      p2.add(L2[j]); 
			      j++; 
			   }
			
		 
			p1.add(A[i]);
			p2.add(B[i]); 
			
			
		}
		   
	   this.setLocation(0,0);
 	   this.setSize(1600,900);
 	   this.setVisible(true);
 	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	  DisplayFromDatabase();
    }

	public Image toolbar_btn_image(String image) 
	{
		ImageIcon icon=new ImageIcon(image);
		Image imageicon=icon.getImage();
		Image newImage =imageicon.getScaledInstance(75,65,Image.SCALE_DEFAULT);
		return newImage;
	}

	public Image toolbar_btn_image1(String image) 
	{
		ImageIcon icon=new ImageIcon(image);
		Image imageicon=icon.getImage();
		Image newImage =imageicon.getScaledInstance(75,65,Image.SCALE_DEFAULT);
		return newImage;
	}

	public static void main(String[] args) 
	{
		new new_seat_2();
		
		
	}

    public static void DisplayFromDatabase()
    {
		String dbURL="jdbc:mysql://localhost:3306/"+"tms";
		String username="root";
		String password="";
		Connection dbConnection=null;
		try
		{
			dbConnection=DriverManager.getConnection(dbURL,username,password);
			java.sql.Statement stmt=dbConnection.createStatement();
			
			int result=stmt.executeUpdate("update booking set car1=0,car2=0 where car3=0");
			
			for(int i=0;i<100;i++)
			{
				sno11[i]=0;
				sno22[i]=0;
			}
			String p=WhereR.c;
			String month=Calender_Update.MONTH;
			int day=Calender_Update.DAY;
			System.out.println(month+" "+Calender_Update.DAY);
		   // ResultSet r=stmt.executeQuery("select * from Calender where Place='"+p+"' ");
		   // while(r.next())
		 {  //
			ResultSet rs1=stmt.executeQuery("Select * From up where Place='"+p+"' and Month='"+month+"' and Day="+(day)+"  ");   
	// **************************************************************************************************************
			
			while(rs1.next())

 			{    System.out.println(rs1.getString("Place"));
				String car1=rs1.getString("car1");  String car11;
				String car2=rs1.getString("car2");  String car22; 
				int j=0;int k=1; int count=0;
				//System.out.println(car1+"\n"+car2);
			
			         while(k<=car1.length())
					{ car11=car1.substring(j, k); j+=2;k+=2;
				//	  System.out.println(car11);
					  sno11[count]=Integer.parseInt(car11); count++;
					}
			      int z=0;
			      while(sno11[z]!=0)
			      {
			        //	  System.out.println(sno11[z]); 
			    	  A[sno11[z]-1].setBackground(Color.red);
					  A[sno11[z]-1].setForeground(Color.white);
					  z++;
			      }
			      
			      int a=0,b=1,count2=0;
				  while (b<=car2.length())
				  {   
					  car22=car2.substring(a, b); a+=2; b+=2;
					  System.out.println(car22);
					  sno22[count2]=Integer.parseInt(car22); count2++;
				  }
				  int c=0;
				  while(sno22[c]!=0)
				  {    System.out.println(sno22[c]); 
					  B[sno22[c]-1].setBackground(Color.red);
					  B[sno22[c]-1].setForeground(Color.white);
					  c++;
				  }
			
 			}		  
			}
			stmt.close();
			dbConnection.close();
		}
		catch(SQLException e1)
		{
			System.out.println("Unable to connect to database "+e1.getMessage());
					
		}


    }
    public void actionPerformed1(ActionEvent e1)
    {
    	
    }
	
	public void actionPerformed(ActionEvent e) 
	{   
		String dbURL="jdbc:mysql://localhost:3306/"+"tms";
		String username="root";
		String password="";
		
		try
		{
			dbConnection=DriverManager.getConnection(dbURL,username,password);
			java.sql.Statement stmt=dbConnection.createStatement();
		    
			 if(e.getSource()==bb1)
	        {   int result=stmt.executeUpdate("update booking set car1=0,car2=0 where car3=0");
			
	            this.dispose();
	            new Calender_Update();
	            
	         }
       
	  	if(e.getSource()==bb2)
	  	{  int s,j;
	  	s=JOptionPane.showConfirmDialog(this, "Are you sure to book seat ?", "Confirm Booking", JOptionPane.OK_CANCEL_OPTION);
	       
	  		for(int i=0;i<45;i++)
 	  	   { if(sno1[i]!=null)
 	  		
 	  	     { System.out.println(sno1[i]); 
 	 	          if(s==JOptionPane.OK_OPTION)
 	 	           j = stmt.executeUpdate("update  booking set car1=1   where number='"+(i+1)+"' ");     	
 	 	          else
 	 	          {
 	 	           A[i].setBackground(Color.GREEN);
 	 	           A[i].setForeground(Color.BLACK);
 	 	           A[i].setText("Seat "+(i+1));
 	 	          }
 	  	     } 	  	   
 	  	   }
 	  	   for(int i=0;i<45;i++)
 	  	 { if(sno2[i]!=null)
 	  	   {   System.out.println(sno2[i]);
 	  	      if(s==JOptionPane.OK_OPTION)
 	  	       j=stmt.executeUpdate("update  booking set car2=1   where number='"+(i+1)+"' ");
 	  	      else
 	  	      {
 	  	    	  B[i].setBackground(Color.GREEN);
 	  	    	  B[i].setForeground(Color.BLACK);
 	  	    	  B[i].setText("Seat "+(i+1));
 	  	      }
  	       }
 	  	 } 
	  		 
	  	}
	  	if(e.getSource()==bb3)
	  	{
	       System.out.println("Success \n This is main Frame");
	  	}
	  	
	  	if(e.getSource()==bb4)
	  	{   System.out.println(" ");
	  	    num_seat=0;
	  	    s.setText(Integer.toString(num_seat));
	  		for(int i=0;i<45;i++)
	  		{
	  			if(A[i].getBackground()==Color.red)
	  			{
	  				A[i].setBackground(Color.GREEN);
	  				A[i].setForeground(Color.black);
	  				A[i].setText("Seat "+(i+1));
	  		    }
	  			if(B[i].getBackground()==Color.red)
	  			{
	  				B[i].setBackground(Color.GREEN);
	  				B[i].setForeground(Color.black);
	  				B[i].setText("Seat "+(i+1));
	  			}
	  			String month =Calender_Update.MONTH;
	  			int    day=   Calender_Update.DAY;
                String p=WhereR.c;
	  			ResultSet rs1=stmt.executeQuery("Select * From up where Place='"+p+"' and Month='"+month+"' and Day="+(day)+" ");
	  			System.out.println(month +"\n\n"+day);
				while(rs1.next())
			//	rs1.next();
	  			/*{
					int k =rs1.getInt("number");
					int c1=rs1.getInt("car1");
					int c2=rs1.getInt("car2");
					if(c1!=0 )
					{   A[k-1].setBackground(Color.red);
					    A[k-1].setForeground(Color.white);
					}
					    if(c2!=0)
					{   B[k-1].setBackground(Color.red);
					    B[k-1].setForeground(Color.white);
					}
				
				}*/
				{  //System.out.println("check");
					String car1=rs1.getString("car1");  String car11;
					String car2=rs1.getString("car2");  String car22; 
					int j=0;int k=1; int count=0;
					//System.out.println(car1+"\n"+car2);
				
				         while(k<=car1.length())
						{ car11=car1.substring(j, k); j+=2;k+=2;
						//  System.out.println(car11);
						  sno11[count]=Integer.parseInt(car11); count++;
						}
				      int z=0;
				      while(sno11[z]!=0)
				      {
				    	//  System.out.println(sno11[z]); 
				    	  A[sno11[z]-1].setBackground(Color.red);
						  A[sno11[z]-1].setForeground(Color.white);
						  z++;
				      }
				      
				      int a=0,b=1,count2=0;
					  while (b<=car2.length())
					  {   
						  car22=car2.substring(a, b); a+=2; b+=2;
						 // System.out.println(car22);
						  sno22[count2]=Integer.parseInt(car22); count2++;
					  }
					  int c=0;
					  while(sno22[c]!=0)
					  {  //  System.out.println(sno22[c]); 
						  B[sno22[c]-1].setBackground(Color.red);
						  B[sno22[c]-1].setForeground(Color.white);
						  c++;
					  }
				}  
				
	  			sno1[i]=null;
	  			sno2[i]=null;
	  		}
	  	}
	  	
	  	if(e.getSource()==bb5)
	  	{
	  		this.setVisible(false);
	  	}
	  	 
	  	for(int i=0;i<45;i++)
	 { 	if(e.getSource()==A[i])
	  	{   
		  if(A[i].getBackground()!=Color.red)  			  	  
	  	 	{
			 A[i].setBackground(Color.red);
	  		 A[i].setForeground(Color.white);
	  		 sno1[i]="1 >> "+(i+1);
	  		 A[i].setText("$$$");
	 
	  		 num_seat++;
	  		 String price="   "+Integer.toString(5000*num_seat);
	  		 s.setText((price));
	  		 //f1.append("Seat "+(i+1)+'\n');
	  		}
		  
	  	  else 
	  	  {	  int flag=0;
	 	      {  A[i].setBackground(Color.green);
	             A[i].setForeground(Color.black);
	  	         A[i].setText("Seat "+(i+1));
	  	    
	  	         sno1[i]=null;
              }
	  	     
		      
	  		  String p=WhereR.c;
	  		  String month=Calender_Update.MONTH;
	  	      int    day  =Calender_Update.DAY;
	  		  ResultSet j=stmt.executeQuery(" select * from up where Month='"+month+"' and Day='"+day+"'  ");
	  	    	for(int k=0;k<100;k++)
			   {
				 sno11[k]=0;
				 sno22[k]=0;
		       }
	  		  while(j.next())
			    {    	
			    	  String car1=j.getString("car1");  String car11;
			    	  int jj=0;int k=1; int count=0;
				//System.out.println(car1+"\n"+car2);
					
				         while(k<=car1.length())
						{ car11=car1.substring(jj, k);
					//	  System.out.println(car11);
						  sno11[count]=Integer.parseInt(car11); count++; jj+=2;k+=2;
						}
				      int z=0;  int r=0;
				      while(sno11[z]!=0)
				      {
				    	 System.out.println(sno11[z]+"  "+(i+1)); 
				    	 if(sno11[z]==(i+1))
				    	 {   
				    	   JOptionPane.showMessageDialog(this," This seat is already Purchased!");
				    	 
				    	   A[i].setBackground(Color.red);
					  	   A[i].setForeground(Color.white);				  	
					  	   break;
					  	     
				    	 }
				    
				    	 z++;
		 		      }		            
			    }
	  		 if(A[i].getBackground()==Color.RED)
		            
       	      {   
	  			  String price="   "+Integer.toString(5000*num_seat);
		    	  s.setText(price);
 	          
 		      }
            else if(A[i].getBackground()==Color.GREEN)
             {    
           	      num_seat--;
 		    	  String price="   "+Integer.toString(5000*num_seat);
 		    	  s.setText(price);
             }
       	
	  	        }
 
	  	}
	 }
		
		  
	    	for(int i1=0;i1<45;i1++)
	  	{
	  		if(e.getSource()==B[i1])
	  	   
	  		{   if(B[i1].getBackground()!=Color.red)
	  	         {  
	  	    	    B[i1].setBackground(Color.red);
	  	    	    B[i1].setForeground(Color.white);
	  	            B[i1].setText("$$$");
	  	    	    sno2[i1]="2 >> "+(i1+1);
	  	    	    
	  	    	   num_seat++;
	 	  		   String price="   "+Integer.toString(5000*num_seat);
	 	  		   s.setText((price));
  	             } 
	  	        else
	  	         {    
 	    	            {
	  	    	         	B[i1].setBackground(Color.GREEN);
	  	    	        	B[i1].setForeground(Color.BLACK);
	  	    	         	B[i1].setText("Seat "+(i1+1));
	  	    	        	sno2[i1]=null;
	  	    	         }
	  	        	
	  	        	String month=Calender_Update.MONTH;
		  	           int    day  =Calender_Update.DAY;
		  		     ResultSet j=stmt.executeQuery(" select * from up where Month='"+month+"' and Day="+day+" ");
		  	    	for(int k=0;k<100;k++)
				   {
					 sno11[k]=0;
					 sno22[k]=0;
			       }
		  		  while(j.next())
				    {    	
				    	
				    	  String car2=j.getString("car2");  String car22; 
						int jj=0;int k=1; int count=0;
					//System.out.println(car1+"\n"+car2);
						
					         while(k<=car2.length())
					       {  car22=car2.substring(jj, k);
						//	  System.out.println(car11);
							  sno11[count]=Integer.parseInt(car22); count++; jj+=2;k+=2;
							}
					      int z=0;
					      while(sno22[z]!=0)
					    {
					    	 System.out.println(sno22[z]+"  "+(i1+1)); 
				            if(sno22[z]==(i1+1))
					     {
					  		JOptionPane.showMessageDialog(this, "This seat is already purchased! ");
				  	      	B[i1].setBackground(Color.red);
						  	B[i1].setForeground(Color.white);
						  	break;
				         }
	  	    	         
	  	    	          z++;
	  	               }
				    }   
		  		if(B[i1].getBackground()==Color.RED)
		            
	       	      {   
		  			  String price="   "+Integer.toString(5000*num_seat);
			    	  s.setText(price);
	 	          
	 		      }
	            else if(B[i1].getBackground()==Color.GREEN)
	             {    
	           	      num_seat--;
	 		    	  String price="   "+Integer.toString(5000*num_seat);
	 		    	  s.setText(price);
	             }
	  	         }
	  	}
	 
	  	}
		
	    	if(e.getSource()==change2)
	    	{ this.dispose();
	    	  new Calender_Update();
	    	 
	    	  CHANGEd=1;
	    	}
	    	if(e.getSource()==change1)
	    	{
	    		this.dispose();
	    		new WhereR();
	    	    CHANGEp=1;
	    	}
	    	
	  		}
	catch(SQLException e1)
	{
		System.out.println("Unable to connect to database "+e1.getMessage());
				
	}

		}
	
}
