package TMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.border.Border;

import com.mysql.jdbc.Connection;

public class Up extends JFrame implements ActionListener
{  
    JLabel username,password,phone,address,gender,thank;
    JTextField txtusername,txtphone;
    JTextArea txaaddress;
    JPasswordField txtpassword;
    JButton btnreg,btnexit,btnlogin;
    JRadioButton jrmale,jrfemale;
    ButtonGroup bg;
    Connection dbConnection=null;
    
    public Up()
    {
        this.setBounds(350, 100,600,550);
        this.setLayout(null);

        this.setTitle("Register");
        this.getContentPane().setBackground(Color.WHITE);
        Font f1=new Font("KaYin2014",Font.CENTER_BASELINE,23);
        Font f2=new Font("Gadugi",Font.BOLD,15);
        // Font f4=new Font("Constantia",Font.BOLD,18);
       

        username=new JLabel("User Name  :  ");
        username.setBounds(100, 20, 200, 50);
        this.add(username);
        username.setFont(f2);
        
        txtusername=new JTextField();
        txtusername.setBounds(300, 20, 200, 50);
        this.add(txtusername);

        password=new JLabel("Password  :  ");
        password.setBounds(100, 90, 200, 50);
        this.add(password);
        password.setFont(f2);

        txtpassword=new JPasswordField();
        txtpassword.setBounds(300, 90, 200, 50);
        this.add(txtpassword);
        
        phone=new JLabel("Phone  :  ");
        phone.setBounds(100, 160, 200, 50);
        this.add(phone);
        phone.setFont(f2);
        
        txtphone=new JTextField();
        txtphone.setBounds(300, 160, 200, 50);
        this.add(txtphone);
        
        address=new JLabel("Address  :  ");
        address.setBounds(100, 230, 200, 50);
        this.add(address);
        address.setFont(f2);
        
        txaaddress=new JTextArea();
        txaaddress.setBounds(300,230, 200, 70);
        this.add(txaaddress);

        gender=new JLabel("Gender  :  ");
        gender.setBounds(100, 300, 200, 50);
        this.add(gender);
        gender.setFont(f2);

        jrmale=new JRadioButton("Male");
        jrmale.setBounds(300,320,85,20);
        jrmale.setSelected(true);
        this.add(jrmale);

        jrfemale=new JRadioButton("Female");
        jrfemale.setBounds(400,320,85,20);
        this.add(jrfemale);

        bg=new ButtonGroup();
        bg.add(jrmale);
        bg.add(jrfemale);

        Font f3=new Font("Constantia",Font.BOLD,16);
        btnreg=new JButton("Register");
        btnreg.setBounds(100, 390, 100, 50);
        this.add(btnreg);
        btnreg.addActionListener(this);
        btnreg.setFont(f3);

        btnexit=new JButton("Close");
        btnexit.setBounds(250, 390, 100, 50);
        this.add(btnexit);
        btnexit.addActionListener(this);
        btnexit.setFont(f3);

        btnlogin=new JButton("Login");
        btnlogin.setBounds(400, 390, 100, 50);
        this.add(btnlogin);
        btnlogin.addActionListener(this);
        btnlogin.setFont(f3);
        
        thank=new JLabel(new ImageIcon("images/icon.png"));
        thank.setBounds(140,440, 300, 60);
        this.add(thank);
        
              
        ImagePanel panel = new ImagePanel(new ImageIcon("images/inup.JPG").getImage()); 
    	this.add(panel);
    	//this.getContentPane().setBackground(new Color(216,191,216));
    	
        
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
        
        DatabaseConnection();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           

    }
    
    public void actionPerformed(ActionEvent e) 
    {    
        
        if(e.getSource()==btnreg)
        {
            if(txtusername.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please type your name!");

                 txtpassword.setText("");
                 txtphone.setText("");
                 txaaddress.setText("");
                 
                
            }
           
            else if(txtpassword.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please type your password!");
                txtusername.setText("");
                 txtpassword.setText("");
                 txtphone.setText("");
                 txaaddress.setText("");
                 
            }
            else if(txaaddress.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please type your address!");
                txtusername.setText("");
                 txtpassword.setText("");
                 txtphone.setText("");
                
            }
            else if(txtphone.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please type your phone number!");
                txtusername.setText("");
                 txtpassword.setText("");
                 txaaddress.setText("");
                 
            }
           /* else
            {
                 
                String g="";
                if(jrmale.isSelected())
                {
                    g="Male";
                }
                else
                {
                    g="Female";
                }
               
            }*/

            String g="";
            if(jrmale.isSelected())
            {
                g="Male";
            }
            else
            {
                g="Female";
            }
            String n1=txtusername.getText();
            String n2=txtpassword.getText();
            int n3=Integer.parseInt(txtphone.getText());
            String n4=txaaddress.getText();
            DatabaseConnection();
			
			try
			{    
				Statement stmt= dbConnection.createStatement();
				
				 int i = stmt.executeUpdate("insert into up(name,password,phone,address,gender) values('"+n1+"','"+n2+"',"+n3+",'"+n4+"','"+g+"')");
				 
			if(i>0) 
				{
				JOptionPane.showMessageDialog(this, "Registration Complete!");
				}
			else 
				{
				JOptionPane.showMessageDialog(this, "Try again!Thanks");
				}
			txtusername.setText("");
			txtpassword.setText("");
			txtphone.setText("");
			txaaddress.setText("");
			
				stmt.close();
				dbConnection.close();
				//	DatabaseConnection.close();

			}
			catch(SQLException ee)
			{
				ee.printStackTrace();
			}
		
		}
        
        if(e.getSource()==btnexit)
        {
        	 this.dispose();
            
        }
        if(e.getSource()==btnlogin)
        {
            In uu= new In();

        }

           
        } 
    public void DatabaseConnection() 
    {
		String dbURL = "jdbc:mysql://localhost:3306/tms" ;
		String username = "root";
		String password = "";
		
		
		try{
			dbConnection = (Connection) DriverManager.getConnection(dbURL, username, password);	
		}
		catch(SQLException e)
		{
			System.out.println("Unable to connect to database  " + e.getMessage());
		}
		
		
	}
	//
	public void closeConnection()
	{
		try {
			dbConnection.close();
			System.out.println("The connection is closed.");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

    public static void main(String[] args) 
    {
        new Up();
    }
}

