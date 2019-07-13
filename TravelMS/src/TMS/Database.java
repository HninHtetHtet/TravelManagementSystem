package  TMS;
import java.sql.*;
import java.util.ArrayList;
public class Database {
	
	Connection c=null;
	PreparedStatement pstmt;
	Statement st;
	ResultSet rs;
	public Database()
	{
	     String dbURL="jdbc:mysql://localhost:3306/tms";
	     try
	     {
	    	 c=DriverManager.getConnection(dbURL,"root","");
	     }
	     catch(SQLException e)
	     {
	    	 e.printStackTrace();
	     }
	}
	public ArrayList<Swapdata> execute() throws SQLException
	{
		ArrayList<Swapdata> list=new ArrayList<Swapdata>();
		Swapdata sw;
		String name,phone,journey,date,seat;
		st=c.createStatement();
		rs=st.executeQuery("select * from up");
		while(rs.next())
		{
			name="     "+rs.getString("name");
			phone="     "+rs.getString("phone");
			journey="     "+rs.getString("Place");
		String m=rs.getString("Month");
		String d=rs.getString("Day");
		String y=rs.getString("Year");
		 date="     "+d+" / "+m+" / "+y;
		seat="     "+rs.getString("Seat_num");
			sw=new Swapdata(name,phone,journey,date,seat);
			list.add(sw);	
		}
		return list;
	}
	public int getSize() throws SQLException
	{
		int a=0;
		st=c.createStatement();
	   rs=st.executeQuery("select * from up");
	   while(rs.next())
		   a++;
	   
	   return a;
	}
	public static void main(String args[]) throws SQLException
	{
		Database d=new Database();
	   System.out.println(d.getSize());
	   ArrayList <Swapdata> s=new ArrayList<Swapdata>();
	   s=d.execute();
	   Swapdata sw=s.get(0);
	  // System.out.println(sw.getPassword());
	}

}
