package TMS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class admin extends JFrame implements ActionListener{
JButton b1,b2,b3;
JLabel lbl;
JTextArea a;
JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12;
JPanel sp=new JPanel();
Connection conn;
Statement stmt;
admin()
{
	super("Admin Mode");
	this.setSize(340,400);	
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();																
	int x=(int)((d.getWidth()-this.getWidth()))/2;																			
	int y=(int)((d.getHeight()-this.getHeight()))/2;																			
	setLocation(x,y);	
	a=new JTextArea();
	lbl1=new JLabel();
	lbl2=new JLabel();
	lbl3=new JLabel();
	lbl4=new JLabel();
	lbl5=new JLabel();
	lbl6=new JLabel();
	lbl7=new JLabel();
	lbl8=new JLabel();
	lbl9=new JLabel();
	lbl10=new JLabel();
	lbl11=new JLabel();
	lbl12=new JLabel();
	b1=new JButton("View");
	b1.setBounds(155,350,100, 50);
	b2=new JButton("Update");
	b2.setBounds(155,350,100, 50);
	b3=new JButton("Delete");
	b3.setBounds(155,350,100, 50);
	lbl=new JLabel(new ImageIcon(bi("images/images.jpeg")));
	
	setup(b1);
	setup(b2);
	setup(b3);
	
	JPanel p=new JPanel();
	p.setLayout(new GridLayout(5,3));
	p.add(lbl3);
	p.add(b1);
	p.add(lbl4);
	p.add(lbl5);
	p.add(lbl1);
	p.add(lbl6);
	p.add(lbl7);
	p.add(b2);
	p.add(lbl2);
	p.add(lbl8);
	p.add(lbl9);
	p.add(lbl11);
	p.add(lbl12);
	p.add(b3);
	p.add(lbl10);
	
	Container c=getContentPane();
	c.setLayout(new BorderLayout());
	c.add(lbl,BorderLayout.NORTH);
	c.add(p);
	c.add(sp,BorderLayout.SOUTH);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	this.show();
	//this.setResizable(false);
}
public static void main(String[]args)
{
	new admin();
}
public Image bi(String image)
{
	ImageIcon icon=new ImageIcon(image);
	Image imageicon=icon.getImage();
	Image newImage=imageicon.getScaledInstance(350, 150, Image.SCALE_DEFAULT);
	return newImage;
	
}
public void setup(JButton b)
{LineBorder r=new LineBorder(Color.BLACK,1,true);
b.setFocusPainted(false);
b.setBorder(r);
b.setPreferredSize(new Dimension(34,13));
b.setBackground(Color.GRAY);
	
}
public void createDB()
{
	String url="jdbc:mysql://localhost:3306/tms";
	String un="root";
	String pw="";
	try {
		conn=DriverManager.getConnection(url,un,pw);
		
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
	
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1)
	{
		this.dispose();
	new TableEX();
	}
	if(e.getSource()==b2)
	{this.dispose();
	new update();
		
	}
	if(e.getSource()==b3)
	{
		this.dispose();
		new deletion();
	}
	
}
}
