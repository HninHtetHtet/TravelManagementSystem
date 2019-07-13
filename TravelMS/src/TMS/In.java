package TMS;
import javax.swing.*;

import com.mysql.jdbc.Connection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

public class In extends JFrame implements ActionListener

{
	 public static String passw;
    JLabel title,username,password,welcome,no,tfu,thank;
    JTextField txtusername;
    JPasswordField txtpassword;
    JButton btnlogin,btnclose,btnregister;
    JRadioButton admin,user;
    ButtonGroup bg;
    Connection dbConnection=null;
   
    public In()
    {
        this.setBounds(350, 100,600,550);
        this.setLayout(null);
        this.setTitle("Login");
        this.getContentPane().setBackground(Color.WHITE);
        Font f1=new Font("Myriad Pro Light",Font.CENTER_BASELINE,15);
        Font f6=new Font("Lucida handwriting",Font.ITALIC,20);
        Font f4=new Font("Gadugi",Font.BOLD,15);


        username=new JLabel("User Name  :  ");
        username.setBounds(100, 20, 200, 50);
        this.add(username);
        username.setFont(f1);
        
        txtusername=new JTextField();
        txtusername.setBounds(300, 20, 200, 50);
        this.add(txtusername);
        
        password=new JLabel("Password  :  ");
        password.setBounds(100, 100, 200, 50);
        this.add(password);
        password.setFont(f1);

        txtpassword=new JPasswordField();
        txtpassword.setBounds(300, 100, 200, 50);
        this.add(txtpassword);
        
        user=new JRadioButton("User Account");
        user.setBounds(125,200,120,30);
        user.setSelected(true);
        this.add(user);

        admin=new JRadioButton("Admin Account");
        admin.setBounds(350,200,120,30);
        this.add(admin);

        bg=new ButtonGroup();
        bg.add(user);
        bg.add(admin);
        
        btnlogin=new JButton("Login");
        btnlogin.setBounds(125, 260, 100, 50);
        this.add(btnlogin);
        btnlogin.addActionListener(this);
        btnlogin.setFont(f1);
        
        btnclose=new JButton("Close");
        btnclose.setBounds(360, 260, 100, 50);
        this.add(btnclose);
        btnclose.addActionListener(this);
        btnclose.setFont(f1);


        no=new JLabel("Don't have your own account?");
        no.setBounds(180, 325, 500, 50);
        this.add(no);
        no.setFont(f4);
        
        btnregister=new JButton("Register");
        btnregister.setBounds(240,370,100, 50);
        this.add(btnregister);
        btnregister.setFont(f1);
        btnregister.addActionListener(this);
      
        thank=new JLabel(new ImageIcon("images/icon.png"));
        thank.setBounds(140,440, 300, 60);
        this.add(thank);
        
        ImagePanel panel = new ImagePanel(new ImageIcon("images/inup.JPG").getImage()); 
    	this.add(panel);
        
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
    
    public void actionPerformed(ActionEvent e) 
    { 
    	char [] a=txtpassword.getPassword();
        String m=new String (a);
        passw=(String)m;
    	
        if(e.getSource()==btnlogin)
        {
        	if(user.isSelected())
        	{
             if(txtusername.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please type your name!");
                txtusername.setText("");
                txtpassword.setText("");
            }
             else  if(txtpassword.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please type your password!");
                txtusername.setText("");
                txtpassword.setText("");
            }
             else
             {
            
            	// if(e.getSource()==btnlogin)
         		//{
         		Statement stmt;
         		String n1=txtusername.getText();
                String n2=txtpassword.getText();
                int check=0;
                DatabaseConnection();
                try 
         		{
         			stmt = dbConnection.createStatement();
         			ResultSet rs = stmt.executeQuery("select name,password from up");
         			//String result="";
         			while(rs.next())
         			{
         				if(rs.getString(1).equals(n1) && rs.getString(2).equals(n2))
             			{
             				      check=1;

                        }
             			// else
                        // {
                        //     check=0;
                        // }
         				
         			}
         			if(check==1)
                    {
                        txtusername.setText("");
                        txtpassword.setText("");
                        JOptionPane.showMessageDialog(null, "Login Available");
                        new get_started();
                        this.dispose();
                        
                    }
                    else// if(check==0)
                    {
                        txtusername.setText("");
                        txtpassword.setText("");
                        JOptionPane.showMessageDialog(null, "Something wrong!Check again or do register");
                    }
         		}
         			
         			 
         		
            	 catch (SQLException e1) 
         		{
         			
         			e1.printStackTrace();
         		}
         		
         		}
             }

            
        	
        	else
        	{
        		if(txtusername.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please type admin name!");
                    txtusername.setText("");
                    txtpassword.setText("");
                }
                 else  if(txtpassword.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please type admin password!");
                    txtusername.setText("");
                    txtpassword.setText("");
                }
                 else
                 {
                
                	 //if(e.getSource()==btnlogin)
             		//{
             		Statement stmt;
             		String n1=txtusername.getText();
                    String n2=txtpassword.getText();
                    int check=0;
                    DatabaseConnection();
                    try 
             		{
             			stmt = dbConnection.createStatement();
             			ResultSet rs = stmt.executeQuery("select aname,apassword from admin");
             			//String result="";
             			while(rs.next())
             			{
             				if(rs.getString(1).equals(n1)  && rs.getString(2).equals(n2))
                 			{
                 				      check=1;

                              }
                 			 else
                             {
                                 check=0;
                             }
             				
             			}
             			if(check==1)
                        {
                            txtusername.setText("");
                            txtpassword.setText("");
                            JOptionPane.showMessageDialog(null, "Login Available");
                            this.dispose();
                     new admin();       
                        }
                        else
                        {
                            txtusername.setText("");
                            txtpassword.setText("");
                            JOptionPane.showMessageDialog(null, "Something wrong!Check again or do register");
                        }
                } 
             			
             	     		 
             		
                	 catch (SQLException e1) 
             		{
             			
             			e1.printStackTrace();
             			// JOptionPane.showMessageDialog(null, "Something wrong!Check again or do register");
             		}
             		
             		}
                 }
        		
        	}
        
        if(e.getSource()==btnclose)
        {

            this.dispose();

        }
        if(e.getSource()==btnregister)
        {
            Up ur= new Up();
            
        }
     
   }
    public void DatabaseConnection() 
    {
		String dbURL = "jdbc:mysql://localhost:3306/tms" ;
		String username = "root";
		String password = "";
		
		
		try{
			dbConnection = (Connection)DriverManager.getConnection(dbURL, username, password);	
		}
		catch(SQLException e)
		{
			System.out.println("Unable to connect to database  " + e.getMessage());
		}
		
		
	}
    public static void main(String[] args)
    {
       new In();
    }
}
