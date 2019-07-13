package TMS;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class update extends JFrame implements ActionListener{
JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
JButton b1,b2,b3;
JTextField t1,t2,t3,t4,t5,t6;
Connection conn;
Statement stmt;
 static String jj="";
static String nn="";
static String dd="";
static String ss="";
static String mm="";
static int d=0;
static  int yy=0;
update()
{
	super("Admin");
	this.setSize(500,480);	
	
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();																
	int x=(int)((d.getWidth()-this.getWidth()))/2;																			
	int y=(int)((d.getHeight()-this.getHeight()))/2;																			
	setLocation(x,y);	
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	lbl3=new JLabel(new ImageIcon("images/Myanmar.jpg"));
	lbl1=new JLabel("Name:");
	lbl1.setBounds(67, 20, 200, 50);
	lbl1.setFont(new Font("Serif",Font.BOLD,15));
	lbl3.add(lbl1);
	lbl2=new JLabel(" Booked Journey:");
	lbl2.setBounds(34, 100, 200, 50);
	lbl2.setFont(new Font("Serif",Font.BOLD,15));
	lbl3.add(lbl2);
	
	
	
	/*lbl4=new JLabel("Booked Date:");
	lbl4.setBounds(48,37,200,500);
	lbl4.setFont(new Font("Serif",Font.BOLD,15));
	lbl3.add(lbl4);
	*/
	lbl5=new JLabel("Booked Date:");
	lbl5.setBounds(39,184,200,50);
	lbl5.setFont(new Font("Serif",Font.BOLD,15));
	lbl3.add(lbl5);
	
	
	lbl6=new JLabel("Year:");
	lbl6.setBounds(59,230,200,50);
	lbl6.setFont(new Font("Serif",Font.BOLD,15));
	lbl3.add(lbl6);
	
	
	lbl7=new JLabel("Month:");
	lbl7.setBounds(59,264,200,50);
	lbl7.setFont(new Font("Serif",Font.BOLD,15));
	lbl3.add(lbl7);
	
	lbl4=new JLabel("Day:");
	lbl4.setBounds(59,300,200,50);
	lbl4.setFont(new Font("Serif",Font.BOLD,15));
	lbl3.add(lbl4);
	
	t1=new JTextField();
	t1.setBounds(170,20,200,50);
	lbl3.add(t1);
	
	t2=new JTextField();
	t2.setBounds(170,100,200,50);
	lbl3.add(t2);

t3=new JTextField();
t3.setBounds(170,240,200,30);
lbl3.add(t3);

t4=new JTextField();
t4.setBounds(170,275,200,30);
lbl3.add(t4);

t6=new JTextField();
t6.setBounds(170,310,200,30);
lbl3.add(t6);

b1=new JButton("Back");
b1.setBounds(24,380,100,50);
lbl3.add(b1);


b2=new JButton("Cancel");
b2.setBounds(185,380,100,50);
lbl3.add(b2);

b3=new JButton("Change");
b3.setBounds(355,380,100,50);
lbl3.add(b3);

this.add(lbl3);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
this.setResizable(false);
 this.show();
}
	public static void main(String[] args) {
	
new update();
	}
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
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1)
		{
		this.dispose();
		new admin();
		}
		if(e.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			
		}
		if(e.getSource()==b3)
		{  this.dispose();	
		    new udate();
		    nn=t1.getText();
			   jj=t2.getText();
			  // dd=t3.getText();
			  // ss=t4.getText();
			   yy=Integer.parseInt(t3.getText());
			   mm=t4.getText();
			   d=Integer.parseInt(t6.getText());
			//this.dispose();
			//new admin();
		}
		
	}

}
