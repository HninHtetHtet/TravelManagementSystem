package TMS;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import java.sql.*;
public class feedback extends JFrame implements ActionListener
{

		public JLabel psw,message,image1,image2;
		public JPasswordField upsw;
		public JTextArea msg;
		public JButton send,cancel,back;
		Container contentPane=this.getContentPane();
		String dbURL =  "jdbc:mysql://localhost:3306/tms";	
		String username = "root";
		String password = "";
		Connection dbConnection = null;
		Statement stmt;
		ResultSet rs;
		public feedback()
		{
			Border border=BorderFactory.createLineBorder(Color.GRAY);
			image1=new JLabel();
			image2=new JLabel();
			psw=new JLabel("Password:");
			message=new JLabel("Message:");
			msg=new JTextArea("");
			upsw=new JPasswordField("");
			send=new JButton("Send");
			cancel=new JButton("Clear");
			back=new JButton("<<Back");
			image1.setIcon(new ImageIcon("images/image1.png"));
			image1.setBounds(0,90,500,500);
			image2.setIcon(new ImageIcon("images/image1.png"));
			image2.setBounds(500,90,510,500);
			upsw.setBounds(450,200,200,30);
			psw.setBounds(300,200,100,30);
			message.setBounds(300,300,100,30);
			msg.setBounds(450,300,400,200);
			send.setBounds(400,600,100,30);
			cancel.setBounds(700,600,100,30);
			back.setBounds(60,600,100,30);
			msg.setBorder(border);
			upsw.setFont(new Font("SansSeif",Font.BOLD,15));
			psw.setFont(new Font("SansSeif",Font.BOLD,20));
			message.setFont(new Font("SansSeif",Font.BOLD,20));
			msg.setFont(new Font("SansSeif",Font.BOLD,15));
			contentPane.add(message);
			contentPane.add(msg);
			contentPane.add(send);
			contentPane.add(cancel);
			contentPane.setLayout(null);
			contentPane.add(back);
			contentPane.add(psw);
			contentPane.add(upsw);
			contentPane.add(image1);
			contentPane.add(image2);
			contentPane.setBackground(Color.LIGHT_GRAY);
			send.addActionListener(this);
			cancel.addActionListener(this);
			back.addActionListener(this);
		}
		public static void main(String[] args)
		{
			feedback f=new feedback();
			f.setBounds(200,50,1000,700);
			f.setVisible(true);
			f.setResizable(false);
			
			
		}
		
		void createDB()
		{
			try {
				dbConnection=DriverManager.getConnection(dbURL,username,password);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		public void actionPerformed(ActionEvent ae)
		{if(ae.getSource()==cancel)
		{
			upsw.setText("");
			msg.setText("");
		}
	   if(ae.getSource()==back)
		{
			this.setVisible(false);
		}
		if(ae.getSource()==send)
		{  
			if(msg.getText().isEmpty() || upsw.getPassword().length==0)
				JOptionPane.showMessageDialog(this,"Please type password and message","Message dialog",JOptionPane.INFORMATION_MESSAGE);
			
								
			
			
			else	
				{
				String s=msg.getText();
				JOptionPane.showMessageDialog(this,"Your messages are sent.","Message dialog",JOptionPane.INFORMATION_MESSAGE);
			    msg.setText("");
			   upsw.setText("");
			try {
				dbConnection = DriverManager.getConnection(dbURL,username,password);
				Statement stmt = dbConnection.createStatement();
				stmt.executeUpdate("insert into message(msg) values(' "+s+"')");
				
				stmt.close();
				dbConnection.close();
			}
			catch (SQLException e) {
				System.out.println("Unable to connect to database " + e.getMessage());
			}
				}
			
		
			 
			
		}
	
	}
}

