package TMS;




import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Calender_Update extends JFrame implements ActionListener
{    public static int YEAR=0;
public static String MONTH="a";
     public static int DAY=0;
    
	JLabel title,one1,one2,one3,one4,one5,one6,one7,two1,two2,two3,two4,two5,two6,two7,three1,three2,three3,three4,three5,three6,three7,four1,four2,four3,four4,four5,four6,four7,five1,five2,five3,five4,five5,five6,five7,six1,six2,six3,six4,six5,six6,six7,seven1,seven2,seven3,seven4,seven5,seven6,seven7,eight1,eight2,eight3,eight4,eight5,eight6,eight7,nine1,nine2,nine3,nine4,nine5,nine6,nine7,ten1,ten2,ten3,ten4,ten5,ten6,ten7,eleven1,eleven2,eleven3,eleven4,eleven5,eleven6,eleven7,twelve1,twelve2,twelve3,twelve4,twelve5,twelve6,twelve7;
	JPanel OK,OK1,jp,onee,twoo,threee,fourr,fivee,sixx,sevenn,eightt,ninee,tenn,elevenn,twelvee;
	int day[]= {31,28,31,30,31,30,31,31,30,31,30,31};
	String month[]= {"January","February","March","April","May","June", "July","August","September","October","November", "December"};
	String week_day[]={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	int y0,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10,y11,dd,wd,mon,m0,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,st0,st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11;
	int d,m,y,D,M,Y,r,ne=0;
	String p1,p2,p3,p4,p5,p6,pp;
	JButton one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve;
	JLabel j,jj;
	JButton[] J=new JButton[31];
	JLabel[] em=new JLabel[12];
	
	JLabel o=new JLabel(" ");
	JLabel o1=new JLabel(" ");
	JButton em13=new JButton("Back");
	JButton em14=new JButton("Book");
	
	Connection dbConnection = null;
	public static void main(String[] args) 
	{
		//new Calender_Update();
		
	}
	public Calender_Update() 
	{
		Date now=new Date();
		SimpleDateFormat dateFormatter=new SimpleDateFormat("d");
		d=Integer.parseInt(dateFormatter.format(now));
		
		SimpleDateFormat dateFormatter1=new SimpleDateFormat("M");
		m=Integer.parseInt(dateFormatter1.format(now));
		
		SimpleDateFormat dateFormatter2=new SimpleDateFormat("y");
		y=Integer.parseInt(dateFormatter2.format(now));
		
		SimpleDateFormat dateFormatter3=new SimpleDateFormat("E");
		String e=String.valueOf(dateFormatter3.format(now));
		
		for(int i=0;i<31;i++)
		{
			if(i<9)
				J[i]=new JButton("0"+(i+1));
			else
				J[i]=new JButton(""+(i+1));
		}
		
		for(int i=0;i<12;i++)
		{
			em[i]=new JLabel(" ");
		}
		
		DatabaseConnection();
		
		
		switch(e)
		{
		case "Sun":wd=0;break;
		case "Mon":wd=1;break;
		case "Tue":wd=2;break;
		case "Wed":wd=3;break;
		case "Thu":wd=4;break;
		case "Fri":wd=5;break;
		case "Sat":wd=6;break;
		}		
		
		
		if(d>day[m-1]-1)
		{
			mon=m;
			r=day[m-1]-d;
			if (wd>=r)
				wd=wd-(7-r)+1;
			else 
				wd=wd+r+1;
			if(wd>=7)
				wd%=7;			
		}
		else 
		{
			mon=m-1;
			if(d>1)
			{
				r=d%7-1;
				if(wd>=r)
					wd=wd-r;
				else 
					wd=7-r;
				if(wd>=7)
					wd%=7;			
			}
		}
		
		st0=wd;
		for(int i=0;i<12;i++)
		{
			if(y%4==0)
				day[1]=29;
			else 
				day[1]=28;
			int w=0;
				pp="";
					for(int space=0;space<wd;space++)
						pp=pp+"              ";
			
			
			for(int daysDisplay=1;daysDisplay<=day[mon];daysDisplay++)
			{
				switch(daysDisplay)
				{
				case 1:pp=pp+"         "+"01";break;
				case 2:pp=pp+"         "+"02";break;
				case 3:pp=pp+"         "+"03";break;
				case 4:pp=pp+"         "+"04";break;
				case 5:pp=pp+"         "+"05";break;
				case 6:pp=pp+"         "+"06";break;
				case 7:pp=pp+"         "+"07";break;
				case 8:pp=pp+"         "+"08";break;
				case 9:pp=pp+"         "+"09";break;
				default:pp=pp+"         "+daysDisplay;break;
				}
				wd++;
				if(wd>=7)
				{	wd%=7;
					w++;
					switch(w)
					{
					case 1:p1=pp;break;
					case 2:p2=pp;break;
					case 3:p3=pp;break;
					case 4:p4=pp;break;
					case 5:p5=pp;break;
					case 6:p6=pp;break;
					}					
					pp=" ";
				}	
				if(daysDisplay==day[mon])
				{
					w++;
					int a=wd;
					while(a<7)
					{
						pp=pp+"           ";
						a++;
					}
					
					switch(w)
					{
					case 5:p5=pp;break;
					case 6:p6=pp;break;
					}
					pp=" ";
				}
			}
			switch(i)
			{
			case 0:{
				one=new JButton("    "+month[mon]+" 	 "+y);
				one.setBackground(new Color(120,110,150));
				one.setForeground(new Color(250,250,250));
				onee=new JPanel();
				onee.setLayout(new GridLayout(7,1,1,1));
				onee.setBackground(new Color(220,200,250));
				one1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				one2=new JLabel(p1);
				one3=new JLabel(p2);
				one4=new JLabel(p3);
				one5=new JLabel(p4);
				one6=new JLabel(p5);
				one7=new JLabel(p6);
				st1=wd;
				m0=mon;
				y0=y;
			}break;
			case 1:{
				two=new JButton("    "+month[mon]+" 	 "+y);
				two.setBackground(new Color(120,110,150));
				two.setForeground(new Color(250,250,250));
				twoo=new JPanel();
				twoo.setLayout(new GridLayout(7,1,1,1));
				twoo.setBackground(new Color(220,200,250));
				two1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				two2=new JLabel(p1);
				two3=new JLabel(p2);
				two4=new JLabel(p3);
				two5=new JLabel(p4);
				two6=new JLabel(p5);
				two7=new JLabel(p6);
				st2=wd;
				m1=mon;
				y1=y;
			}break;
			case 2:{
				three=new JButton("    "+month[mon]+" 	 "+y);
				three.setBackground(new Color(120,110,150));
				three.setForeground(new Color(250,250,250));
				threee=new JPanel();
				threee.setLayout(new GridLayout(7,1,1,1));
				threee.setBackground(new Color(220,200,250));
				three1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				three2=new JLabel(p1);
				three3=new JLabel(p2);
				three4=new JLabel(p3);
				three5=new JLabel(p4);
				three6=new JLabel(p5);
				three7=new JLabel(p6);
				st3=wd;
				m2=mon;
				y2=y;
			}break;
			case 3:{
				four=new JButton("    "+month[mon]+" 	 "+y);
				four.setBackground(new Color(120,110,150));
				four.setForeground(new Color(250,250,250));
				fourr=new JPanel();
				fourr.setLayout(new GridLayout(7,1,1,1));
				fourr.setBackground(new Color(220,200,250));
				four1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				four2=new JLabel(p1);
				four3=new JLabel(p2);
				four4=new JLabel(p3);
				four5=new JLabel(p4);
				four6=new JLabel(p5);
				four7=new JLabel(p6);
				st4=wd;
				m3=mon;
				y3=y;
			}break;
			case 4:{
				five=new JButton("    "+month[mon]+" 	 "+y);
				five.setBackground(new Color(120,110,150));
				five.setForeground(new Color(250,250,250));
				fivee=new JPanel();
				fivee.setLayout(new GridLayout(7,1,1,1));
				fivee.setBackground(new Color(220,200,250));
				five1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				five2=new JLabel(p1);
				five3=new JLabel(p2);
				five4=new JLabel(p3);
				five5=new JLabel(p4);
				five6=new JLabel(p5);
				five7=new JLabel(p6);
				st5=wd;
				m4=mon;
				y4=y;
			}break;
			case 5:{
				six=new JButton("    "+month[mon]+" 	 "+y);
				six.setBackground(new Color(120,110,150));
				six.setForeground(new Color(250,250,250));
				sixx=new JPanel();
				sixx.setLayout(new GridLayout(7,1,1,1));
				sixx.setBackground(new Color(220,200,250));
				six1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				six2=new JLabel(p1);
				six3=new JLabel(p2);
				six4=new JLabel(p3);
				six5=new JLabel(p4);
				six6=new JLabel(p5);
				six7=new JLabel(p6);
				st6=wd;
				m5=mon;
				y5=y;
			}break;
			case 6:{
				seven=new JButton("    "+month[mon]+" 	 "+y);
				seven.setBackground(new Color(120,110,150));
				seven.setForeground(new Color(250,250,250));
				sevenn=new JPanel();
				sevenn.setLayout(new GridLayout(7,1,1,1));
				sevenn.setBackground(new Color(220,200,250));
				seven1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				seven2=new JLabel(p1);
				seven3=new JLabel(p2);
				seven4=new JLabel(p3);
				seven5=new JLabel(p4);
				seven6=new JLabel(p5);
				seven7=new JLabel(p6);
				st7=wd;
				m6=mon;
				y6=y;
			}break;
			case 7:{
				eight=new JButton("    "+month[mon]+" 	 "+y);
				eight.setBackground(new Color(120,110,150));
				eight.setForeground(new Color(250,250,250));
				eightt=new JPanel();
				eightt.setLayout(new GridLayout(7,1,1,1));
				eightt.setBackground(new Color(220,200,250));
				eight1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				eight2=new JLabel(p1);
				eight3=new JLabel(p2);
				eight4=new JLabel(p3);
				eight5=new JLabel(p4);
				eight6=new JLabel(p5);
				eight7=new JLabel(p6);
				st8=wd;
				m7=mon;
				y7=y;
			}break;
			case 8:{
				nine=new JButton("    "+month[mon]+" 	 "+y);
				nine.setBackground(new Color(120,110,150));
				nine.setForeground(new Color(250,250,250));
				ninee=new JPanel();
				ninee.setLayout(new GridLayout(7,1,1,1));
				ninee.setBackground(new Color(220,200,250));
				nine1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				nine2=new JLabel(p1);
				nine3=new JLabel(p2);
				nine4=new JLabel(p3);
				nine5=new JLabel(p4);
				nine6=new JLabel(p5);
				nine7=new JLabel(p6);
				st9=wd;
				m8=mon;
				y8=y;
			}break;
			case 9:{
				ten=new JButton("    "+month[mon]+" 	 "+y);
				ten.setBackground(new Color(120,110,150));
				ten.setForeground(new Color(250,250,250));
				tenn=new JPanel();
				tenn.setLayout(new GridLayout(7,1,1,1));
				tenn.setBackground(new Color(220,200,250));
				ten1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				ten2=new JLabel(p1);
				ten3=new JLabel(p2);
				ten4=new JLabel(p3);
				ten5=new JLabel(p4);
				ten6=new JLabel(p5);
				ten7=new JLabel(p6);
				st10=wd;
				m9=mon;
				y9=y;
			}break;
			case 10:{
				eleven=new JButton("    "+month[mon]+" 	 "+y);
				eleven.setBackground(new Color(120,110,150));
				eleven.setForeground(new Color(250,250,250));
				elevenn=new JPanel();
				elevenn.setLayout(new GridLayout(7,1,1,1));
				elevenn.setBackground(new Color(220,200,250));
				eleven1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				eleven2=new JLabel(p1);
				eleven3=new JLabel(p2);
				eleven4=new JLabel(p3);
				eleven5=new JLabel(p4);
				eleven6=new JLabel(p5);
				eleven7=new JLabel(p6);
				st11=wd;
				m10=mon;
				y10=y;
			}break;
			case 11:{
				twelve=new JButton("    "+month[mon]+" 	 "+y);
				twelve.setBackground(new Color(120,110,150));
				twelve.setForeground(new Color(250,250,250));
				twelvee=new JPanel();
				twelvee.setLayout(new GridLayout(7,1,1,1));
				twelvee.setBackground(new Color(220,200,250));
				twelve1=new JLabel("        Sun      Mon      Tue      Wed      Thu       Fri       Sat");
				twelve2=new JLabel(p1);
				twelve3=new JLabel(p2);
				twelve4=new JLabel(p3);
				twelve5=new JLabel(p4);
				twelve6=new JLabel(p5);
				twelve7=new JLabel(p6);
				m11=mon;
				y11=y;
			}break;
			}
			p1=" ";
			p2=" ";
			p3=" ";
			p4=" ";
			p5=" ";
			p6=" ";
			mon++;
			if(mon>=12)
			{
				mon%=12;
				y++;
			}
			pp=pp+"\n";
		}
	
		
		this.pack();
		this.setVisible(true);
    	this.setBounds(150,-7,1110,790);
        this.setLayout(null);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font f6=new Font("Lucida handwriting",Font.ITALIC,20);
        
        title=new JLabel("Select The Date You want to travel");
        title.setFont(f6);
        title.setBounds(330,3,500,30);
        this.add(title);
        
        one.setBounds(60,30,320,25);
        onee.setBounds(60,55,320,142);
        this.add(one);
        this.add(onee);
        onee.add(one1);
        onee.add(one2);
        onee.add(one3);
        onee.add(one4);
        onee.add(one5);
        onee.add(one6);
        onee.add(one7);
        one.setFont(f6);
        
        two.setBounds(385,30, 320, 25);
        twoo.setBounds(385,55, 320, 142);
        this.add(two);
        this.add(twoo);
        twoo.add(two1);
        twoo.add(two2);
        twoo.add(two3);
        twoo.add(two4);
        twoo.add(two5);
        twoo.add(two6);
        twoo.add(two7);
        two.setFont(f6);
        
        three.setBounds(710,30, 320, 25);
        threee.setBounds(710,55, 320, 142);
        this.add(three);
        this.add(threee);
        threee.add(three1);
        threee.add(three2);
        threee.add(three3);
        threee.add(three4);
        threee.add(three5);
        threee.add(three6);
        threee.add(three7);
        three.setFont(f6);
        
        four.setBounds(60,200, 320, 25);
        fourr.setBounds(60,225, 320, 142);
        this.add(four);
        this.add(fourr);
        fourr.add(four1);
        fourr.add(four2);
        fourr.add(four3);
        fourr.add(four4);
        fourr.add(four5);
        fourr.add(four6);
        fourr.add(four7);
        four.setFont(f6);        

        five.setBounds(385,200, 320, 25);
        fivee.setBounds(385,225, 320, 142);
        this.add(five);
        this.add(fivee);
        fivee.add(five1);
        fivee.add(five2);
        fivee.add(five3);
        fivee.add(five4);
        fivee.add(five5);
        fivee.add(five6);
        fivee.add(five7);
        five.setFont(f6);          
        
        six.setBounds(710,200, 320, 25);
        sixx.setBounds(710,225, 320, 142);
        this.add(six);
        this.add(sixx);
        sixx.add(six1);
        sixx.add(six2);
        sixx.add(six3);
        sixx.add(six4);
        sixx.add(six5);
        sixx.add(six6);
        sixx.add(six7);
        six.setFont(f6);        
 
        seven.setBounds(60,370, 320, 25);
        sevenn.setBounds(60,395, 320, 142);
        this.add(seven);
        this.add(sevenn);
        sevenn.add(seven1);
        sevenn.add(seven2);
        sevenn.add(seven3);
        sevenn.add(seven4);
        sevenn.add(seven5);
        sevenn.add(seven6);
        sevenn.add(seven7);
        seven.setFont(f6);

        eight.setBounds(385,370, 320, 25);
        eightt.setBounds(385,395, 320, 142);
        this.add(eight);
        this.add(eightt);
        eightt.add(eight1);
        eightt.add(eight2);
        eightt.add(eight3);
        eightt.add(eight4);
        eightt.add(eight5);
        eightt.add(eight6);
        eightt.add(eight7);
        eight.setFont(f6);

        nine.setBounds(710,370, 320, 25);
        ninee.setBounds(710,395, 320, 142);
        this.add(nine);
        this.add(ninee);
        ninee.add(nine1);
        ninee.add(nine2);
        ninee.add(nine3);
        ninee.add(nine4);
        ninee.add(nine5);
        ninee.add(nine6);
        ninee.add(nine7);
        nine.setFont(f6);

        ten.setBounds(60,540, 320, 25);
        tenn.setBounds(60,565, 320, 142);
        this.add(ten);
        this.add(tenn);
        tenn.add(ten1);
        tenn.add(ten2);
        tenn.add(ten3);
        tenn.add(ten4);
        tenn.add(ten5);
        tenn.add(ten6);
        tenn.add(ten7);
        ten.setFont(f6);      
        
        eleven.setBounds(385,540, 320, 25);
        elevenn.setBounds(385,565, 320, 142);
        this.add(eleven);
        this.add(elevenn);
        elevenn.add(eleven1);
        elevenn.add(eleven2);
        elevenn.add(eleven3);
        elevenn.add(eleven4);
        elevenn.add(eleven5);
        elevenn.add(eleven6);
        elevenn.add(eleven7);
        eleven.setFont(f6);       
        
        twelve.setBounds(710,540, 320, 25);
        twelvee.setBounds(710,565, 320, 142);
        this.add(twelve);
        this.add(twelvee);
        twelvee.add(twelve1);
        twelvee.add(twelve2);
        twelvee.add(twelve3);
        twelvee.add(twelve4);
        twelvee.add(twelve5);
        twelvee.add(twelve6);
        twelvee.add(twelve7);
        twelve.setFont(f6);    
        
        em13.setBounds(880,708,150,30);
        this.add(em13);
        
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        ten.addActionListener(this);
        eleven.addActionListener(this);
        twelve.addActionListener(this);
        
        for(int i=0;i<31;i++)
        {
        	J[i].addActionListener(this);
        	J[i].setFont(f6);
        }
        em13.addActionListener(this);
        em13.setFont(f6);
        em14.addActionListener(this);
        em14.setFont(f6);
        
  	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==one)
		{this.dispose();
			Month(st0,m0,y0);
			M=m0;
			Y=y0;
			if(mon==m)
			{
				for(int i=0;i<(2-r-1);i++)
					J[i].setBackground(Color.WHITE);
				for(int i=(2-r-1);i<31;i++)
					 J[i].setBackground(Color.CYAN);
			}
			else
			{
				for(int i=0;i<d+1;i++)
					J[i].setBackground(Color.WHITE);
				for(int i=d+1;i<31;i++)
					 J[i].setBackground(Color.CYAN);
			}
			
		}
		else if(e.getSource()==two)
		{this.dispose();
			Month(st1,m1,y1);
			M=m1;
			Y=y1;
			for(int i=0;i<31;i++)
			 J[i].setBackground(Color.CYAN);
		}
		else if(e.getSource()==three)
		{this.dispose();
			Month(st2,m2,y2);
			M=m2;
			Y=y2;
			for(int i=0;i<31;i++)
				 J[i].setBackground(Color.CYAN);
		}
		else if(e.getSource()==four)
		{this.dispose();
			Month(st3,m3,y3);
			M=m3;
			Y=y3;
			for(int i=0;i<31;i++)
				 J[i].setBackground(Color.CYAN);
		}
		else if(e.getSource()==five)
		{this.dispose();
			Month(st4,m4,y4);
			M=m4;
			Y=y4;
			for(int i=0;i<31;i++)
				 J[i].setBackground(Color.CYAN);
		}
		else if(e.getSource()==six)
		{this.dispose();
			Month(st5,m5,y5);
			M=m5;
			Y=y5;
			for(int i=0;i<31;i++)
				 J[i].setBackground(Color.CYAN);
		}
		else if(e.getSource()==seven)
		{this.dispose();
			Month(st6,m6,y6);
			M=m6;
			Y=y6;
			for(int i=0;i<31;i++)
				 J[i].setBackground(Color.CYAN);
		}
		else if(e.getSource()==eight)
		{this.dispose();
			Month(st7,m7,y7);
			M=m7;
			Y=y7;
			for(int i=0;i<31;i++)
				 J[i].setBackground(Color.CYAN);
		}
		else if(e.getSource()==nine)
		{this.dispose();
			Month(st8,m8,y8);
			M=m8;
			Y=y8;
			for(int i=0;i<31;i++)
				 J[i].setBackground(Color.CYAN);
		}
		else if(e.getSource()==ten)
		{this.dispose();
			Month(st9,m9,y9);
			M=m9;
			Y=y9;
			for(int i=0;i<31;i++)
				 J[i].setBackground(Color.CYAN);
		}
		else if(e.getSource()==eleven)
		{this.dispose();
			Month(st10,m10,y10);
			M=m10;
			Y=y10;
			for(int i=0;i<31;i++)
				 J[i].setBackground(Color.CYAN);
		}
		else if(e.getSource()==twelve)
		{this.dispose();
			Month(st11,m11,y11);
			M=m11;
			Y=y11;
			for(int i=0;i<31;i++)
				 J[i].setBackground(Color.CYAN);
		}
		
		else if(e.getSource()==J[0])
		{
			if(J[0].getBackground()==Color.CYAN)
			{	J[0].setBackground(Color.gray);
	        MONTH=month[M];DAY=D+1;  YEAR=Y;
			//MONTH=month[M];
			 DAY=1;
			 int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	            new new_seat_2();
	          }
	        else
	        	 J[0].setBackground(Color.CYAN);
			 } 
	       
		    }
			else if(J[0].getBackground()==Color.WHITE)
				J[0].setBackground(Color.WHITE);
			else
				J[0].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[1])
		{
			if(J[1].getBackground()==Color.CYAN)
			{	J[1].setBackground(Color.gray);
	        MONTH=month[M];DAY=2;    YEAR=Y;  
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			 
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	        if(i==JOptionPane.OK_OPTION)
	        {
	        	new new_seat_2();
	        }
	        else
	        	 J[1].setBackground(Color.CYAN);
		    }
			}
			else if(J[1].getBackground()==Color.WHITE)
				J[1].setBackground(Color.WHITE);
			else
				J[1].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[2])
		{
			if(J[2].getBackground()==Color.CYAN)
			{	J[2].setBackground(Color.gray);
	        MONTH=month[M];DAY=3;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			 
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	       if(i==JOptionPane.OK_OPTION)
	       {
			 new new_seat_2();
	       }
	       else
	        	 J[2].setBackground(Color.CYAN);
		    }
			}
			else if(J[2].getBackground()==Color.WHITE)
				J[2].setBackground(Color.WHITE);
			else
				J[2].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[3])
		{
			if(J[3].getBackground()==Color.CYAN)
			{	J[3].setBackground(Color.gray);
	        MONTH=month[M];DAY=4;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			 
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	        if(i==JOptionPane.OK_OPTION)
	        {
				 new new_seat_2();
		       }
	        else
	        	 J[3].setBackground(Color.CYAN);
		    }
			}
			else if(J[3].getBackground()==Color.WHITE)
				J[3].setBackground(Color.WHITE);
			else
				J[3].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[4])
		{
			if(J[4].getBackground()==Color.CYAN)
			{	J[4].setBackground(Color.gray);
	        MONTH=month[M];DAY=5;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	      if(i==JOptionPane.OK_OPTION)
	      {
				 new new_seat_2();
		       }
	      else
	        	 J[4].setBackground(Color.CYAN);
		    }
			}
			else if(J[4].getBackground()==Color.WHITE)
				J[4].setBackground(Color.WHITE);
			else
				J[4].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[5])
		{
			if(J[5].getBackground()==Color.CYAN)
			{	J[5].setBackground(Color.gray);
	        MONTH=month[M];DAY=6;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[5].setBackground(Color.CYAN);
		    }
			}
			else if(J[5].getBackground()==Color.WHITE)
				J[5].setBackground(Color.WHITE);
			else
				J[5].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[6])
		{
			if(J[6].getBackground()==Color.CYAN)
			{	J[6].setBackground(Color.gray);
	        MONTH=month[M];DAY=7;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[6].setBackground(Color.CYAN);
		    }
			}
			else if(J[6].getBackground()==Color.WHITE)
				J[6].setBackground(Color.WHITE);
			else
				J[6].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[7])
		{
			if(J[7].getBackground()==Color.CYAN)
			{	J[7].setBackground(Color.gray);
	        MONTH=month[M];DAY=8;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			 
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	        if(i==JOptionPane.OK_OPTION)
	        {
				 new new_seat_2();
		       }
	        else
	        	 J[7].setBackground(Color.CYAN);
		    }
			}
			else if(J[7].getBackground()==Color.WHITE)
				J[7].setBackground(Color.WHITE);
			else
				J[7].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[8])
		{
			if(J[8].getBackground()==Color.CYAN)
			{	J[8].setBackground(Color.gray);
	        MONTH=month[M];DAY=9;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			 
	          i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			new new_seat_2();
	 	       }
	         else
	        	 J[8].setBackground(Color.CYAN);
		    }
			}
			else if(J[8].getBackground()==Color.WHITE)
				J[8].setBackground(Color.WHITE);
			else
				J[8].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[9])
		{
			if(J[9].getBackground()==Color.CYAN)
			{	J[9].setBackground(Color.gray);
	        MONTH=month[M];DAY=10;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[9].setBackground(Color.CYAN);
		    }
			}
			else if(J[9].getBackground()==Color.WHITE)
				J[9].setBackground(Color.WHITE);
			else
				J[9].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[10])
		{
			if(J[10].getBackground()==Color.CYAN)
			{	J[10].setBackground(Color.gray);
	        MONTH=month[M];DAY=11;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			 
	         i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[10].setBackground(Color.CYAN);
		    }
			}
			else if(J[10].getBackground()==Color.WHITE)
				J[10].setBackground(Color.WHITE);
			else
				J[10].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[11])
		{
			if(J[11].getBackground()==Color.CYAN)
			{	J[11].setBackground(Color.gray);
	        MONTH=month[M];DAY=12;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[11].setBackground(Color.CYAN);
		    }
			}
			else if(J[11].getBackground()==Color.WHITE)
				J[11].setBackground(Color.WHITE);
			else
				J[11].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[12])
		{
			if(J[12].getBackground()==Color.CYAN)
			{	J[12].setBackground(Color.gray);
	        MONTH=month[M];DAY=13;   YEAR=Y; 
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[12].setBackground(Color.CYAN);
		    }
			}
			else if(J[12].getBackground()==Color.WHITE)
				J[12].setBackground(Color.WHITE);
			else
				J[12].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[13])
		{
			if(J[13].getBackground()==Color.CYAN)
			{	J[13].setBackground(Color.gray);
	        MONTH=month[M];DAY=14;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[13].setBackground(Color.CYAN);
		    }
			}
			else if(J[13].getBackground()==Color.WHITE)
				J[13].setBackground(Color.WHITE);
			else
				J[13].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[14])
		{
			if(J[14].getBackground()==Color.CYAN)
			{	J[14].setBackground(Color.gray);
	        MONTH=month[M];DAY=15;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[14].setBackground(Color.CYAN);
		    }}
			 
			else if(J[14].getBackground()==Color.WHITE)
				J[14].setBackground(Color.WHITE);
			else
				J[14].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[15])
		{
			if(J[15].getBackground()==Color.CYAN)
			{	J[15].setBackground(Color.gray);
	        MONTH=month[M];DAY=16;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[15].setBackground(Color.CYAN);
		    }
			}
			else if(J[15].getBackground()==Color.WHITE)
				J[15].setBackground(Color.WHITE);
			else
				J[15].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[16])
		{
			if(J[16].getBackground()==Color.CYAN)
			{	J[16].setBackground(Color.gray);
	        MONTH=month[M];DAY=17;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[16].setBackground(Color.CYAN);
		    }
			}
			else if(J[16].getBackground()==Color.WHITE)
				J[16].setBackground(Color.WHITE);
			else
				J[16].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[17])
		{
			if(J[17].getBackground()==Color.CYAN)
			{	J[17].setBackground(Color.gray);
	        MONTH=month[M];DAY=18;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			 
	          i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[17].setBackground(Color.CYAN);
		    }
			}
			else if(J[17].getBackground()==Color.WHITE)
				J[17].setBackground(Color.WHITE);
			else
				J[17].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[18])
		{
			if(J[18].getBackground()==Color.CYAN)
			{	J[18].setBackground(Color.gray);
	        MONTH=month[M];DAY=19;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			 
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[18].setBackground(Color.CYAN);
		    }
			}
			else if(J[18].getBackground()==Color.WHITE)
				J[18].setBackground(Color.WHITE);
			else
				J[18].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[19])
		{
			if(J[19].getBackground()==Color.CYAN)
			{	J[19].setBackground(Color.gray);
	        MONTH=month[M];DAY=20;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[19].setBackground(Color.CYAN);
		    }
			}
			else if(J[19].getBackground()==Color.WHITE)
				J[19].setBackground(Color.WHITE);
			else
				J[19].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[20])
		{
			if(J[20].getBackground()==Color.CYAN)
			{	J[20].setBackground(Color.gray);
	        MONTH=month[M];DAY=21;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			new new_seat_2();
	 	       }
	         else
	        	 J[20].setBackground(Color.CYAN);
		    }
			}
			else if(J[20].getBackground()==Color.WHITE)
				J[20].setBackground(Color.WHITE);
			else
				J[20].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[21])
		{
			if(J[21].getBackground()==Color.CYAN)
			{	J[21].setBackground(Color.gray);
	        MONTH=month[M];DAY=22;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[21].setBackground(Color.CYAN);
		    }
			}
			else if(J[21].getBackground()==Color.WHITE)
				J[21].setBackground(Color.WHITE);
			else
				J[21].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[22])
		{
			if(J[22].getBackground()==Color.CYAN)
			{	J[22].setBackground(Color.gray);
	        MONTH=month[M];DAY=23;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[22].setBackground(Color.CYAN);
		    }
			}
			else if(J[22].getBackground()==Color.WHITE)
				J[22].setBackground(Color.WHITE);
			else
				J[22].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[23])
		{
			if(J[23].getBackground()==Color.CYAN)
			{	J[23].setBackground(Color.gray);
	        MONTH=month[M];DAY=24;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[23].setBackground(Color.CYAN);
		    }
			}
			else if(J[23].getBackground()==Color.WHITE)
				J[23].setBackground(Color.WHITE);
			else
				J[23].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[24])
		{
			if(J[24].getBackground()==Color.CYAN)
			{	J[24].setBackground(Color.gray);
	        MONTH=month[M];DAY=25;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[24].setBackground(Color.CYAN);
		    }
			}
			else if(J[24].getBackground()==Color.WHITE)
				J[24].setBackground(Color.WHITE);
			else
				J[24].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[25])
		{
			if(J[25].getBackground()==Color.CYAN)
			{	J[25].setBackground(Color.gray);
	        MONTH=month[M];DAY=26;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[25].setBackground(Color.CYAN);
		    }
			}
			else if(J[25].getBackground()==Color.WHITE)
				J[25].setBackground(Color.WHITE);
			else
				J[25].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[26])
		{
			if(J[26].getBackground()==Color.CYAN)
			{	J[26].setBackground(Color.gray);
	        MONTH=month[M];DAY=27;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[26].setBackground(Color.CYAN);
		    }
			}
			else if(J[26].getBackground()==Color.WHITE)
				J[26].setBackground(Color.WHITE);
			else
				J[26].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[27])
		{
			if(J[27].getBackground()==Color.CYAN)
			{	J[27].setBackground(Color.gray);
	        MONTH=month[M];DAY=28;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			 
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[27].setBackground(Color.CYAN);
		    }
			}
			else if(J[27].getBackground()==Color.WHITE)
				J[27].setBackground(Color.WHITE);
			else
				J[27].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[28])
		{
			if(J[28].getBackground()==Color.CYAN)
			{	J[28].setBackground(Color.gray);
	        MONTH=month[M];DAY=29;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[28].setBackground(Color.CYAN);
		    }
			}
			else if(J[28].getBackground()==Color.WHITE)
				J[28].setBackground(Color.WHITE);
			else
				J[28].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[29])
		{			
			if(J[29].getBackground()==Color.CYAN)
			{	J[29].setBackground(Color.gray);
	        MONTH=month[M];DAY=30;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[29].setBackground(Color.CYAN);
		    }
			}
			else if(J[29].getBackground()==Color.WHITE)
				J[29].setBackground(Color.WHITE);
			else
				J[29].setBackground(Color.CYAN);
		}
		else if(e.getSource()==J[30])
		{
			if(J[30].getBackground()==Color.CYAN)
			{	J[30].setBackground(Color.gray);
	        MONTH=month[M];DAY=31;    YEAR=Y;
	        int i=0;
			 if(new_seat_2.CHANGEd==1)
	           new new_seat_2();
			 else
			 {		 
			  
	        i=  JOptionPane.showConfirmDialog(this, "Serve your prefer seats.","Choose", JOptionPane.OK_CANCEL_OPTION);
	         if(i==JOptionPane.OK_OPTION)
	         {
	 			 new new_seat_2();
	 	       }
	         else
	        	 J[30].setBackground(Color.CYAN);
		    }
			}
			else if(J[30].getBackground()==Color.WHITE)
				J[30].setBackground(Color.WHITE);
			else
				J[30].setBackground(Color.CYAN);
		}
		
		if(e.getSource()==em13)
		{
			this.dispose();
			new WhereR();
			//new B(); 
		}
		
		
		if(e.getSource()==em14) {	
			int count=0;
			
			for(int n=0;n<31;n++)
			{  
				if(J[n].getBackground()==Color.gray)
				{
					D=n;
			    
					count++;
				}
			}
			int i = 0;
			try{
				System.out.println("Success");
				Statement stmt= dbConnection.createStatement();
				if(count==1) 
				{	/*	
					 	int result=JOptionPane.showConfirmDialog(null, "Are you sure to book?");
						if(result==JOptionPane.YES_OPTION)
						{
							i = stmt.executeUpdate("insert into Calender(Year,Month,Day) values("+Y+",'"+month[M]+"',"+(D+1)+")");
							if(i>0)
								JOptionPane.showConfirmDialog(null, "Book successful");
							else  
								JOptionPane.showMessageDialog(null, "Book fail");
						}				
					*/
					String number1 = ""; String number11="";  int number111;
					String number2 = ""; String number22="";  int number222;
					
				ResultSet j=stmt.executeQuery("select * from booking ");
				while(j.next())
				{
				  if(j.getInt("car1")==1)
				  {   number111=j.getInt("number");
					  if(number111<10)
					  { 
						  number1=Integer.toString(number111);
					      number11+=0+number1;  
					      
					  }
					  else
					  {   number1=Integer.toString(number111);
					      number11+=number1;
					      
					  }
				  }
				  
				  if(j.getInt("car2")==1)
				  {   number222=j.getInt(1);
				      if(number222<10)
				      {
					     number2=Integer.toString(number222);
					     number22+=0+number2;
					     
				      }
				      else
				      {
				    	  number2=Integer.toString(number222);
				    	  number22+=number2;
				    }
				  }
		    		}
				int dath=D+1;
				//stmt1.close();
				//dbConnection.close();
				if(number11=="")
					number11="0";
				if(number22=="")
					number22="0";
		       
				String p=WhereR.c;
			      if(number11!="0" || number22!="0")
			      {   String passw=In.passw;
			          int snum=new_seat_2.num_seat;  
			      int price=new_seat_2.Seat_price;
			    System.out.println("Check\n"+price);
			          //	  System.out.println(p+,"+Y+month[M]+" "+dath+" ,"+number11+" , "+number22);
				  i = stmt.executeUpdate("update up set Place='"+p+"',Year="+Y+", Month='"+month[M]+"', Day="+dath+", car1="+number11+", car2="+number22+", Seat_num='"+snum+"' where password='"+passw+"' ");
			    	//  i = stmt.executeUpdate("insert into Calender values('bb',2000,'feb',1,23,4)");
				  
			      }
				  if(i>0)
				  {
					  JOptionPane.showMessageDialog(this, "Book Successful");
				      this.dispose();
					  new expenses();
				  }
				 System.out.println(p+number11+"\n"+number22);
				 System.out.println(MONTH);
			
                
						
			
				}	
				else
					JOptionPane.showMessageDialog(null, "Please Select Only One day");
				
				stmt.close();
			}
			catch(SQLException ee)
			{
				ee.printStackTrace();
			}
		
	}
		
		
	}
	public void DatabaseConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/tms" ;
		String username = "root";
		String password = "";
		
		
		try{
			dbConnection = DriverManager.getConnection(dbURL, username, password);	
		}
		catch(SQLException e)
		{
			System.out.println("Unable to connect to database  " + e.getMessage());
		}
		
		
	}
	public void closeConnection()
	{
		try {
			dbConnection.close();
			System.out.println("The connection is closed.");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void Month(int st,int mm,int yy) 
	{
		JFrame Month=new JFrame();
		Month.pack();
		Month.setVisible(true);
    	Month.setBounds(50,0,1280,780);
        Month.setLayout(null);
    	Month.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font f6=new Font("Lucida handwriting",Font.ITALIC,20);
        OK=new JPanel();
    	OK.setLayout(new GridLayout(2,1,1,1));
    	OK1=new JPanel();
     	OK1.setLayout(new GridLayout(2,1,1,1));
        j=new JLabel("                                                                         "+month[mm]+" 	                                              "+yy);
		jp=new JPanel();
		jp.setLayout(new GridLayout(6,7,1,1));
		jj=new JLabel("            Sun               Mon                Tue                 Wed                  Thu                    Fri                    Sat");
		j.setBounds(35,30,1190,50);
        jj.setBounds(35,80,1190,50);
        jp.setBounds(35,130,1190,600);
        Month.add(j);
        Month.add(jj);
        Month.add(jp);
        
		switch(st)
		{
		case 1:{
			jp.add(em[0]);
		}break;
		case 2:{
			for(int i=0;i<2;i++)
				jp.add(em[i]);
			
		}break;
		case 3:{
			for(int i=0;i<3;i++)
				jp.add(em[i]);
		}break;
		case 4:{
			for(int i=0;i<4;i++)
				jp.add(em[i]);
		}break;
		case 5:{
			for(int i=0;i<5;i++)
				jp.add(em[i]);
		}break;
		case 6:{
			for(int i=0;i<6;i++)
				jp.add(em[i]);
		}break;
		}
        
        for(int i=0;i<28;i++)
        {
        	jp.add(J[i]);
        }
        switch(mm)
        {
        case 1:{
        	if(yy%4==0)
        	{
        		jp.add(J[28]);
        		switch(st)
            	{
        		case 0:{
        			for(int i=0;i<11;i++)
        				jp.add(em[i]);
        			jp.add(OK1);
            		jp.add(OK);
            	}break;
            	case 1:{
            		for(int i=1;i<11;i++)
        				jp.add(em[i]);
            		jp.add(OK1);
            		jp.add(OK);
            	}break;
            	case 2:{
            		for(int i=2;i<11;i++)
        				jp.add(em[i]);
            		jp.add(OK1);
            		jp.add(OK);
            	}break;
            	case 3:{
            		for(int i=3;i<11;i++)
        				jp.add(em[i]);
            		jp.add(OK1);
            		jp.add(OK);
            	}break;
            	case 4:{
            		for(int i=4;i<11;i++)
        				jp.add(em[i]);
            		jp.add(OK1);
            		jp.add(OK);
            	}break;
            	case 5:{
            		for(int i=5;i<11;i++)
        				jp.add(em[i]);
            		jp.add(OK1);
            		jp.add(OK);
            	}break;
            	case 6:{
            		for(int i=6;i<11;i++)
        				jp.add(em[i]);
            		jp.add(OK1);
            		jp.add(OK);
            	}break;
            	}
        	}
        	else
        		switch(st)
        		{
        		case 0:{
        			for(int i=0;i<12;i++)
        				jp.add(em[i]);
        			jp.add(OK1);
            		jp.add(OK);
            	}break;
        		case 1:{
        			for(int i=1;i<12;i++)
        				jp.add(em[i]);
        			jp.add(OK1);
            		jp.add(OK);
        		}break;
        		case 2:{
        			for(int i=2;i<12;i++)
        				jp.add(em[i]);
        			jp.add(OK1);
            		jp.add(OK);
        		}break;
        		case 3:{
        			for(int i=3;i<12;i++)
        				jp.add(em[i]);
        			jp.add(OK1);
            		jp.add(OK);
        		}break;
        		case 4:{
        			for(int i=4;i<12;i++)
        				jp.add(em[i]);
        			jp.add(OK1);
            		jp.add(OK);
        		}break;
        		case 5:{
        			for(int i=5;i<12;i++)
        				jp.add(em[i]);
        			jp.add(OK1);
            		jp.add(OK);
        		}break;
        		case 6:{
        			for(int i=6;i<12;i++)
        				jp.add(em[i]);
        			jp.add(OK1);
            		jp.add(OK);
        		}break;
        	}	
        	
        }break;
        case 3:
        case 5:
        case 8:
        case 10:{
        	jp.add(J[28]);
        	jp.add(J[29]);
        	switch(st)
        	{
        	case 0:{
        		for(int i=0;i<10;i++)
    				jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 1:{
        		for(int i=1;i<10;i++)
    				jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 2:{
        		for(int i=2;i<10;i++)
    				jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 3:{
        		for(int i=3;i<10;i++)
    				jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 4:{
        		for(int i=4;i<10;i++)
    				jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 5:{
        		for(int i=5;i<10;i++)
    				jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 6:{
        		for(int i=6;i<10;i++)
    				jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	}
        }break;
        default:{
        	jp.add(J[28]);
        	jp.add(J[29]);
        	jp.add(J[30]);
        	switch(st)
        	{
        	case 0:{
        		for(int i=0;i<9;i++)
        			jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 1:{
        		for(int i=1;i<9;i++)
        			jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 2:{
        		for(int i=2;i<9;i++)
        			jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 3:{
        		for(int i=3;i<9;i++)
        			jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 4:{
        		for(int i=4;i<9;i++)
        			jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 5:{
        		for(int i=5;i<9;i++)
        			jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	case 6:{
        		for(int i=6;i<9;i++)
        			jp.add(em[i]);
        		jp.add(OK1);
        		jp.add(OK);
        	}break;
        	}
        }break;
        }
        OK1.add(o1);
        OK1.add(em13);
       OK.add(o);
       OK.add(em14);
       
        j.setFont(f6);
        jj.setFont(f6);
	}
}
