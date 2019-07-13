package TMS;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Contact extends JFrame  implements ActionListener
{
	public JLabel title,fb,mail,phone,label1,label2,label3,logo;
	public JButton back;
	Container contentPane=this.getContentPane();
	public Contact()
	{
		
		
		title=new JLabel("Contact Us");
		label1=new JLabel("www.facebook.com/Chimpzs:Travel&Tour");
		label2=new JLabel("TravelAgency_Chimpzs@gmail.com");
		label3=new JLabel("09-952399904");
		back=new JButton("<<Back");
		logo=new JLabel();
		fb=new JLabel();
		mail=new JLabel();
		phone=new JLabel();
		title.setBounds(300,0,500,100);
		phone.setIcon(new ImageIcon("images/P.png"));
		logo.setIcon(new ImageIcon("images/icon.png"));
		fb.setIcon(new ImageIcon("images/FB.png"));
		mail.setIcon(new ImageIcon("images/Gmail.png"));
		fb.setBounds(150,150,100,100);
		mail.setBounds(135,230,100,130);
		phone.setBounds(135,410,100,220);
		logo.setBounds(0,0,500,80);
		label1.setBounds(300,150,400,100);
		label2.setBounds(300,270,400,100);
		label3.setBounds(310,410,400,100);
		back.setBounds(30,520,100,30);
		
		label2.setFont(new Font("SansSerif",Font.BOLD,20));
		label1.setFont(new Font("SansSeif",Font.BOLD,20));
		title.setFont(new Font("SansSeif",Font.BOLD,40));
		label3.setFont(new Font("SansSeif",Font.BOLD,20));
		contentPane.add(title);
		contentPane.add(fb);
		contentPane.add(mail);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(phone);
		contentPane.add(label3);
		contentPane.add(back);
		contentPane.add(logo);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		back.addActionListener(this);
		
		
	}
	public static void main(String args[])
	{
		Contact c=new Contact();
		c.setBounds(200,50,800,600);
		c.setVisible(true);
		c.setResizable(false);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			this.setVisible(false);
		}
		
	}
}