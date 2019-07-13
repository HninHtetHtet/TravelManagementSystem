package TMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class finaljava extends JFrame implements ActionListener
{

	JLabel logo,tip,pray;
	JButton feedback,ok,exit,contact;
	 
	  Font f6=new Font("Lucida handwriting",Font.ITALIC,33);
      Font f4=new Font("Gadugi",Font.BOLD,15);
	public finaljava()
	{
		this.setBounds(350, 100,600,550);
        this.setLayout(null);

        this.setTitle("Register");
        this.getContentPane().setBackground(Color.WHITE);
        
        logo=new JLabel();
        logo.setIcon(new ImageIcon("images/icon.png"));
        logo.setBounds(200,10,1000,100);
        this.add(logo);
   	
        tip=new JLabel("Tip   :   PLease pay cash 2 days before trip day ");
       tip.setBounds(150,385,350,50);
       tip.setFont(f4);
       this.add(tip);
       
       pray=new JLabel("Enjoy the trip!");
       pray.setBounds(150,200,1000,100);
       pray.setFont(f6);
       this.add(pray);
       
       feedback= new JButton("Main Menu");
       feedback.setBounds(20,460,100,50);
       feedback.setBackground(new Color(255,250,205));
   	   this.add(feedback);
   	   feedback.addActionListener(this);
       
       ok= new JButton("Exit");
   	   ok.setBounds(450,460,100,50);
   	   ok.setBackground(new Color(255,250,205));
   	   this.add(ok);
       ok.addActionListener(this);
       
       contact= new JButton("Contact Us");
       contact.setBounds(300,460,100,50);
       contact.setBackground(new Color(255,250,205));
   	   this.add(contact);
   	   contact.addActionListener(this);
       
       exit= new JButton("Feedback");
   	   exit.setBounds(160,460,100,50);
   	   exit.setBackground(new Color(255,250,205));
   	   this.add(exit);
       exit.addActionListener(this);

    	this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		new finaljava();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==feedback)
		{
			new mframe();
		}
		if(e.getSource()==ok)
		{
			JOptionPane.showMessageDialog(this,"Thank You!");
			System.exit(0);
		}
		if(e.getSource()==exit)
		{
			feedback f=new feedback();
			f.setBounds(200,50,1000,700);
			f.setVisible(true);
			f.setResizable(false);
		}
		if(e.getSource()==contact)
		{
			Contact c=new Contact();
			c.setBounds(200,50,800,600);
			c.setVisible(true);
			c.setResizable(false);
		}
		
	}

}
