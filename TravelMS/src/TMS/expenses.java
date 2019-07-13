package TMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import TMS.bagodoubleroom;

import javax.swing.*;

public class expenses extends JFrame implements ActionListener
{
    JLabel place,date,seat,contact,expenses,outcome,lbl3;
    JTextField t1,t2,t3;
    JButton back,ok;
    Font f2=new Font("Gadugi",Font.BOLD,21);
    Font f1=new Font("Myriad Pro Light",Font.CENTER_BASELINE,19);
    int total=0;
    int Seat_price=0;
    
    public expenses()
    {
    	 this.setBounds(350, 100,600,550);
         this.setLayout(null);

         this.setTitle("Register");
         this.getContentPane().setBackground(Color.WHITE);
    	
        lbl3=new JLabel();
 		lbl3.setIcon(new ImageIcon("images/1.jpg"));
 		lbl3.setBounds(25,90,1900,540);
 		
         
    	place=new JLabel("Place :");
    	place.setBounds(120,30,100,30);
    	this.add(place);
    	place.setFont(f1);
    	
    	t1=new JTextField("   "+WhereR.c);
    	t1.setBounds(220,30,200,30);
    	this.add(t1);
    	
    	date=new JLabel("Date :");
    	date.setBounds(120,100,100,30);
    	this.add(date);
    	date.setFont(f1);
    	
    	t2=new JTextField("   "+Calender_Update.DAY+"/"+Calender_Update.MONTH+"/"+Calender_Update.YEAR);
    	t2.setBounds(220,100,200,30);
    	this.add(t2);
    	
    	seat=new JLabel("Seat :");
    	seat.setBounds(120,170,100,30);
    	this.add(seat);
    	seat.setFont(f1);
    
    	
    	t3=new JTextField("");
    	t3.setBounds(220,170,200,30);
    	this.add(t3);
    	
    	int k=new_seat_2.num_seat;
    	
        t3.setText("   "+Integer.toString(k));
    	back= new JButton("Back");
    	back.setBounds(240,240,80,50);
    	this.add(back);
        back.addActionListener(this);
        
        expenses=new JLabel("Total Expense:");
        expenses.setBounds(180,317,150,30);
    	this.add(expenses);
    	expenses.setFont(f2);
    	
    	
      		
    	
    	 if(WhereR.c=="Bagan")
    	{   //System.out.println(new_seat_2.num_seat);
    	
    	    Seat_price+=10000*new_seat_2.num_seat;
    		total+=(Seat_price)+(BaganDr.doub)+(BaganFr.fam)+(BaganSr.sing)+(BaganVr.vip);
    		//System.out.print(total);
    	}
    	 if(WhereR.c=="Bago")
     	{   //System.out.println(new_seat_2.num_seat);
     	
     	    Seat_price+=5000*new_seat_2.num_seat;
     		total+=(Seat_price)+(bagodoubleroom.doub)+(bagofamilyroom.fam)+(bagosingleroom.sing)+(bagoviproom.vip);
     		//System.out.print(total);
     	}
    	 if(WhereR.c=="Chaung Tha")
      	{   //System.out.println(new_seat_2.num_seat);
      	
      	    Seat_price+=7000*new_seat_2.num_seat;
      		total+=(Seat_price)+(ChaungthaDr.doub)+(ChaungthaFr.fam)+(ChaungthaSr.sing)+(ChaungthaVr.vip);
      		//System.out.print(total);
      	}
    	 if(WhereR.c=="Dawei")
       	{   //System.out.println(new_seat_2.num_seat);
       	
       	    Seat_price+=10000*new_seat_2.num_seat;
       		total+=(Seat_price)+(ddoubleroom.doub)+(dfamilyroom.fam)+(dsingleroom.sing)+(dviproom.vip);
       		//System.out.print(total);
       	}
    	 if(WhereR.c=="Hpa-an")
        	{   //System.out.println(new_seat_2.num_seat);
        	
        	    Seat_price+=10000*new_seat_2.num_seat;
        		total+=(Seat_price)+(hdoubleroom.doub)+(hfamilyroom.fam)+(hsingleroom.sing)+(hviproom.vip);
        		//System.out.print(total);
        	}
    	 
    	 if(WhereR.c=="Inle")
        	{   //System.out.println(new_seat_2.num_seat);
        	
        	    Seat_price+=10000*new_seat_2.num_seat;
        		total+=(Seat_price)+(InleDr.doub)+(InleFr.fam)+(InleSr.sing)+(InleVr.vip);
        		//System.out.print(total);
        	}
    	 if(WhereR.c=="Kyauk Phyu")
     	{   //System.out.println(new_seat_2.num_seat);
     	
     	    Seat_price+=10000*new_seat_2.num_seat;
     		total+=(Seat_price)+(kyaukphyudoubleroom.doub)+(kyaukphyufamilyroom.fam)+(kyaukphyusingleroom.sing)+(kyaukphyuviproom.vip);
     		//System.out.print(total);
     	}
    	 if(WhereR.c=="Loikaw")
     	{   //System.out.println(new_seat_2.num_seat);
     	
     	    Seat_price+=10000*new_seat_2.num_seat;
     		total+=(Seat_price)+(ladoubleroom.doub)+(lafamilyroom.fam)+(lasingleroom.sing)+(laviproom.vip);
     		//System.out.print(total);
     	}
    	 if(WhereR.c=="Lashio")
     	{   //System.out.println(new_seat_2.num_seat);
     	
     	    Seat_price+=10000*new_seat_2.num_seat;
     		total+=(Seat_price)+(ladoubleroom.doub)+(lafamilyroom.fam)+(lasingleroom.sing)+(laviproom.vip);
     		//System.out.print(total);
     	}
    	 if(WhereR.c=="Mandalay")
      	{   //System.out.println(new_seat_2.num_seat);
      	
      	    Seat_price+=7000*new_seat_2.num_seat;
      		total+=(Seat_price)+(MandalayDr.doub)+(MandalayFr.fam)+(MandalaySr.sing)+(MandalayVr.vip);
      		//System.out.print(total);
      	}
    	 if(WhereR.c=="Mawlamyaing")
      	{   //System.out.println(new_seat_2.num_seat);
      	
      	    Seat_price+=7000*new_seat_2.num_seat;
      		total+=(Seat_price)+(mawlamyaingdoubleroom.doub)+(mawlamyaingfamilyroom.fam)+(mawlamyaingsingleroom.sing)+(mawlamyaingviproom.vip);
      		//System.out.print(total);
      	}
    	 if(WhereR.c=="Myawaddy")
       	{   //System.out.println(new_seat_2.num_seat);
       	
       	    Seat_price+=7000*new_seat_2.num_seat;
       		total+=(Seat_price)+(mdoubleroom.doub)+(mfamilyroom.fam)+(msingleroom.sing)+(mviproom.vip);
       		//System.out.print(total);
       	}
    	 if(WhereR.c=="Myeik")
       	{   //System.out.println(new_seat_2.num_seat);
       	
       	    Seat_price+=10000*new_seat_2.num_seat;
       		total+=(Seat_price)+(MyeikDr.doub)+(MyeikFr.fam)+(MyeikSr.sing)+(MyeikVr.vip);
       		//System.out.print(total);
       	}
    	 if(WhereR.c=="NayPyiTaw")
        	{   //System.out.println(new_seat_2.num_seat);
        	
        	    Seat_price+=7000*new_seat_2.num_seat;
        		total+=(Seat_price)+(NaypyitawDr.doub)+(NaypyitawFr.fam)+(NaypyitawSr.sing)+(NaypyitawVr.vip);
        		//System.out.print(total);
        	}
    	 if(WhereR.c=="Ngapali")
     	{   //System.out.println(new_seat_2.num_seat);
     	
     	    Seat_price+=7000*new_seat_2.num_seat;
     		total+=(Seat_price)+(NgapaliDr.doub)+(NgapaliFr.fam)+(NgapaliSr.sing)+(NgapaliVr.vip);
     		//System.out.print(total);
     	}
    	 if(WhereR.c=="NgweSaung")
      	{   //System.out.println(new_seat_2.num_seat);
      	
      	    Seat_price+=7000*new_seat_2.num_seat;
      		total+=(Seat_price)+(NgwesaungDr.doub)+(NgwesaungFr.fam)+(NgwesaungSr.sing)+(NgwesaungVr.vip);
      		//System.out.print(total);
      	}
    	 if(WhereR.c=="Pathein")
      	{   //System.out.println(new_seat_2.num_seat);
      	
      	    Seat_price+=5000*new_seat_2.num_seat;
      		total+=(Seat_price)+(pdoubleroom.doub)+(pfamilyroom.fam)+(psingleroom.sing)+(pviproom.vip);
      		//System.out.print(total);
      	}
    	 if(WhereR.c=="PyinOoLwin")
       	{   //System.out.println(new_seat_2.num_seat);
       	
       	    Seat_price+=10000*new_seat_2.num_seat;
       		total+=(Seat_price)+(PyinoolwinDr.doub)+(PyinoolwinFr.fam)+(PyinoolwinSr.sing)+(PyinoolwinVr.vip);
       		//System.out.print(total);
       	}
    	 if(WhereR.c=="Sittwe")
        	{   //System.out.println(new_seat_2.num_seat);
        	
        	    Seat_price+=10000*new_seat_2.num_seat;
        		total+=(Seat_price)+(sidoubleroom.doub)+(sifamilyroom.fam)+(sisingleroom.sing)+(siviproom.vip);
        		//System.out.print(total);
        	}
    	 if(WhereR.c=="TaungGyi")
        	{   //System.out.println(new_seat_2.num_seat);
        	
        	    Seat_price+=10000*new_seat_2.num_seat;
        		total+=(Seat_price)+(TaunggyiDr.doub)+(TaunggyiFr.fam)+(TaunggyiSr.sing)+(TaunggyiVr.vip);
        		//System.out.print(total);
        	}
 	 
    	 
    	 
    	  outcome=new JLabel(Integer.toString(total)+" MMK");
          outcome.setBounds(340,317,150,30);
      	  this.add(outcome);
      	  outcome.setFont(f2);
    	
    	ok= new JButton("BOOK");
    	ok.setBounds(240,370,80,50);
    	this.add(ok);
        ok.addActionListener(this);
        
        this.add(lbl3);
     
    	this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
    
    
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==back)
		{
			new new_seat_2();
		}
		if(e.getSource()==ok)
		{
	    int selection=JOptionPane.showConfirmDialog (null, "Confirmed Trip", "Confirmation for user", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
		if(selection==JOptionPane.OK_OPTION)
		{
			new finaljava();
			
		}
			
		}
		}
		
	
    
	public static void main(String args[])
	{
		new expenses();
	}
}

