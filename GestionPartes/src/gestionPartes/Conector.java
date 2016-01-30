package gestionPartes;
import java.sql.*;


public class Conector
{
	// public constants
	public static final String ORACLE_DRIVER =
			"oracle.jdbc.driver.OracleDriver";
	public static final String SQL_DRIVER = 
			"com.mysql.jdbc.Driver";
	public static final String ORACLE_URL =
			"jdbc:oracle:thin:@localhost:1521:xe";
	// user needs to add database name to SQL URL
	public static final String SQL_URL = 
			"jdbc:mysql://localhost:3306/";
	
	// private properties
	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection connection;
	
	public Conector(String user, String password){
			
			this.driver = SQL_DRIVER;
			this.url = SQL_URL+"gestionpartes";
			this.user = user;
			this.password = password;
		
	}

	
	public Conector(String driver, String url,String user,String password)
	{
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password=password;
	}
		
	
	public boolean openConnection()
	{
		try 
		{
			
			Class.forName(driver);

			
			connection = DriverManager.getConnection(url, user, password);

						
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		} 
		return true;
	}
	
	public void closeConnection()
	{
		try
		{
			
			connection.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
		
		
	public Connection getConnection(){
		
		return connection;
		
	}
		
	
	
		
		
	
}