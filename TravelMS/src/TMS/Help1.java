package TMS;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Help1 extends JFrame implements ActionListener
{
	public JButton back,feedbk,contact,signUp;
	public JLabel thank,help,write;
	public Help1()
	{
		super("Help");
		back=new JButton("<<Back");
		feedbk=new JButton("Feedback");
		signUp=new JButton("Sign Up");
		contact=new JButton("Contact Us");
		thank=new JLabel();
		help=new JLabel("HELP");
		write=new JLabel();
		
		thank.setIcon(new ImageIcon("images/icon.png"));
		//this.add(help);
		
		this.add(contact);	
		//this.add(feedbk);
		this.add(back);
		this.add(thank);
		this.add(signUp);
		contact.setBounds(1000,250,170,60);
		signUp.setBounds(1000,80,170,60);
		back.setBounds(1000,570,170,60);
		feedbk.setBounds(550,600,170,60);
		help.setBounds(20,10,400,200);
		write.setIcon(new ImageIcon("Capture.JPG"));
		write.setBounds(550,50,400,200);
		help.setFont(new Font("SansSeif",Font.BOLD,50));
		back.setBackground(Color.LIGHT_GRAY);
		signUp.setBackground(Color.LIGHT_GRAY);
		contact.setBackground(Color.LIGHT_GRAY);
		back.setFont(new Font("Lucida handwriting",Font.ITALIC,20));
		signUp.setFont(new Font("Lucida handwriting",Font.ITALIC,20));
		feedbk.setFont(new Font("Lucida handwriting",Font.ITALIC,20));
		contact.setFont(new Font("Lucida handwriting",Font.ITALIC,20));
	    thank.setBounds(550,670, 350, 60);
	    thank.setFont(new Font("Lucida handwriting",Font.ITALIC,20));
    	ImagePanel panel = new ImagePanel(new ImageIcon("images/Capture.JPG").getImage()); 
    	ImagePanel panel1 = new ImagePanel(new ImageIcon("images/1.jpg").getImage());
    	//panel1.setBounds(0,0,400, 800);
    	//panel.setBounds(300,0,1000, 300);
    	//
    	
    	
    	//this.add(panel1);
    	this.add(panel);
    	
    	this.getContentPane().setBackground(Color.white);
    	back.addActionListener(this);
    	contact.addActionListener(this);
    	signUp.addActionListener(this);
        feedbk.addActionListener(this);
       class ImagePanel extends JPanel 
      {
        	private Image img,img1;
        	public ImagePanel(String img,String img1)
        	{
        	this(new ImageIcon(img).getImage(), null);
      	    }
        	public ImagePanel(Image img,Image img1) 
        	{
        	this.img = img;
        	this.img1 = img1;
        	Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        	setPreferredSize(size);
        	setMinimumSize(size);
        	setMaximumSize(size);
        	setSize(size);
        	setLayout(null);
        	}	
       public void paintComponent(Graphics g)
       {
    	   g.drawImage(img, 0, 0, null);
       } 
       
     } 
       this.add(write);
	}

	public static void main(String[] args)
	{
		Help1 h=new Help1();
        h.setVisible(true);
        h.setBounds(50,0,1280,768);
        h.setResizable(false);
        h.setBackground(Color.white);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			this.dispose();
			new mframe();
		}
		else if(ae.getSource()==feedbk)
		{
			feedback f=new feedback();
			f.setBounds(200,50,1000,700);
			f.setVisible(true);
			f.setResizable(false);
			
		}
		else if(ae.getSource()==signUp)
		{
		       Up s=new Up();
			s.setVisible(true);
			s.setBounds(350, 100,600,550);
			
		}
		
		else if(ae.getSource()==contact)
		{
			Contact c=new Contact();
			c.setBounds(280,100,800,600);
			c.setVisible(true);
			c.setResizable(false);
			
		}
	}

}
