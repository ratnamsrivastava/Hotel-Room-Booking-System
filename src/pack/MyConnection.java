package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


	public class MyConnection {
		static Connection c;
		static Connection getConnection()
		{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/logproj","root","estilo2600");
			System.out.println("CONNECTED");
			
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		catch (SQLException se) {
			se.printStackTrace();
			
		}
		return c;
		
	}


	}

