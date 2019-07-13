package TMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mframe extends JFrame implements ActionListener

{
    JButton in,up,help,close;
    JLabel thank;
    public mframe()
    {
    	super("Travels & Tours");
    	this.pack();
    	this.setVisible(true);
    	this.setBounds(50,0,1280,768);
        this.setLayout(null);
        Font f6=new Font("Lucida handwriting",Font.ITALIC,20);
        Font f1=new Font("Myriad Pro Light",Font.CENTER_BASELINE,15);
       
        in=new JButton("Sign in");
        in.setBounds(550,150, 150, 60);
        this.add(in);
        in.setFont(f6);
        in.addActionListener(this);
        
        up=new JButton("Sign Up");
        up.setBounds(550, 300, 150, 60);
        this.add(up);
        up.addActionListener(this);
        up.setFont(f6);
        
        help=new JButton("Help");
        help.setBounds(550, 450,  150, 60);
        this.add(help);
        help.addActionListener(this);
        help.setFont(f6);
        
        close=new JButton("Exit");
        close.setBounds(550,600, 150, 60);
        this.add(close);
        close.setFont(f6);
        close.addActionListener(this);
        
        thank=new JLabel(new ImageIcon("images/icon.png"));
        thank.setBounds(450,670, 350, 60);
        this.add(thank);
        
        
    	
    	ImagePanel panel = new ImagePanel(new ImageIcon("images/Myanmar.jpg").getImage()); 
    	ImagePanel panel1 = new ImagePanel(new ImageIcon("images/lg.jpg").getImage()); 
    	this.add(panel1);
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
     
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 }   
   
       
    
       /* if(e.getSource()==btnregister)
        {
            //User_Register ur= new User_Register();
            
        }
     */
   
    public static void main(String[] args)
    {
    	mframe ur=new mframe();
    	
    }

@Override
public void actionPerformed(ActionEvent e) 
{
	 if(e.getSource()==close)
     {

         int i=0;
         i=JOptionPane.showConfirmDialog(this,"Are you sure you want to exit?");
     if(i==JOptionPane.OK_OPTION)
     {
    	 System.exit(0);
     }
     }
	 else if(e.getSource()==in)
     {
             new In();
     }
	 else if(e.getSource()==up)
     {
             new Up();
             
     }
	 else if(e.getSource()==help)
     {
		     this.dispose();
		     Help1 h=new Help1();
		     h.setVisible(true);
		     h.setBounds(50,0,1280,768);
     }
}
}

