package TMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class MyeikVr extends JFrame implements ActionListener,ItemListener
{
	
	Font ff1=new Font("Arno Pro Smbd",Font.ITALIC,20);
	String no[]= {"0","1","2","3","4","5","6"};
	public JLabel l,l1,l2;
	public JButton b1,b2;
	public JTextArea txtdisplay;
	public JScrollPane jspdisplay;
	public JComboBox jcb=new JComboBox(no);
	static int vip;
	int tot=0;
	
	public MyeikVr()
	{
		this.setLayout(null);
		this.setSize(500,300);
		this.setLocation(500,50);
		this.getContentPane().setBackground(new Color(192,192,192));
		this.setTitle("Hotel Plan");
		
		l=new JLabel("VIP Rooms");
		l.setBounds(180,10,120,20);
		l.setFont(ff1);
		this.add(l);
		
		l1=new JLabel("Rooms");
		l1.setBounds(10,30,150,20);
		l1.setFont(ff1);
		this.add(l1);
		
		
		b1=new JButton("Sure");
		b1.setBounds(350,70,100,30);
		this.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("Back");
		b2.setBounds(350,150,100,30);
		this.add(b2);
		b2.addActionListener(this);
		
		txtdisplay=new JTextArea();
		jspdisplay=new JScrollPane(txtdisplay,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspdisplay.setBounds(10,130,100,50);
		this.add(jspdisplay);
		
		l2=new JLabel("Cost");
		l2.setBounds(10,100,150,20);
		l2.setFont(ff1);
		this.add(l2);
		 
		//jcb=new JComboBox();
		jcb.setBounds(10,35,100,30);
		this.add(jcb);
		jcb.addItemListener(this);
		
		this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       

	}
	
	public static void main(String[] args)
	{
		MyeikVr p=new MyeikVr();
		//p.adddata();
       
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource()==jcb)
		{
			
			int i=jcb.getSelectedIndex();
			switch(i)
			{
			case 0:{vip=0;}break;
			case 1:{txtdisplay.setText("Ks 85,000");vip=85000;}break;
			case 2:{txtdisplay.setText("Ks 170,000");vip=170000;}break;
			case 3:{txtdisplay.setText("Ks 255,000");vip=225000;}break;
			case 4:{txtdisplay.setText("Ks 340,000");vip=340000;}break;
			case 5:{txtdisplay.setText("Ks 425,000");vip=425000;}break;
			case 6:{txtdisplay.setText("Ks 510,000");vip=510000;}break;
			}
		}
		
	}
	/*public void adddata()
	{
		for(int i=0;i<=6;i++)
		{
			jcb.addItem(i);
		}
	} */
	@Override
	public void actionPerformed(ActionEvent a) 
	{
		if(a.getSource()==b1)
		{
			tot=tot+vip;
			this.dispose();
		}
		else if(a.getSource()==b2)
		{
			this.setVisible(false);
			tot+=0;
		}
		else
		{
			tot+=0;
		}
				
	} 
	
	

	
	
}


