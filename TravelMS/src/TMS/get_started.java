package TMS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class get_started extends JFrame implements ActionListener
{    JLabel main_title=new JLabel("CHIMPZS");
     JLabel sub_title =new JLabel("MYANMAR TRAVEL AND TOUR");
     JLabel three      =new JLabel(" BOOKING IN THREEE MINUTES");
     JLabel free       =new JLabel("Service Free");
     JLabel available  =new JLabel("Available in BAGAN, MANDALAY, NAY PYI TAW, PATHEIN, SHWEBO, AND MANY OTHER CITIES IN MYANMAR");
     JButton start     =new JButton("Get Started");
     JPanel main=new JPanel();
	 public get_started()
	    {
	    	super("Chimpzs( Travels & Tours )");
	    	this.pack();
	    	this.setVisible(true);
	    	this.setBounds(50,0,1280,768);
	        this.setLayout(null);
	        Font f6=new Font("Lucida handwriting",Font.ITALIC,20);
	        Font f1=new Font("Myriad Pro Light",Font.CENTER_BASELINE,15);
	        
	        this.add(main_title);
	        this.add(sub_title);
	        this.add(three);
	        this.add(free);
	        this.add(available);
	        this.add(start);
	                
	        main_title.setFont(new Font("SansSeif",Font.BOLD,50));
	        sub_title.setFont(new Font("SansSeif",Font.BOLD,40));
	        three.setFont(new Font("Lucida handwriting",Font.ITALIC,20));
	        free.setFont(new Font("Lucida handwriting",Font.ITALIC,20));
	        available.setFont(new Font("SansSeif",Font.BOLD,20));
	        start.setFont(new Font("SansSeif",Font.BOLD,20));
	        
	        main_title.setBounds(500,20,400,100);
	        sub_title.setBounds(300,50,600,200);
	        three.setBounds(450,200,400,200);
	        free.setBounds(575,280,200,100);
	        available.setBounds(100,300,1100,200);
	        start.setBounds(490,550,300,50);
	        start.setBackground(Color.LIGHT_GRAY);
	        ImagePanel panel = new ImagePanel(new ImageIcon("images/Myanmar.jpg").getImage()); 
	    //	ImagePanel panel1 = new ImagePanel(new ImageIcon("images/lg.jpg").getImage()); 
	    //	this.add(panel1);
	    	this.add(panel);
	    	this.getContentPane().setBackground(Color.white);
	    	
	        
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
	           
	              start.addActionListener(this); 
	              this.setVisible(true);
	              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	       }   
	public static void main(String[] args)
	{
	new get_started();

	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==start)
		{	this.dispose();
			new WhereR();
		}
	}

}
