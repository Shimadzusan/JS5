import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class Conn20 {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	
	 private static final String SQL = "DELETE FROM users WHERE id = \"3\"";
	 static String s = "";
	 static String s2;
	
	public static void Conn() throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   
		   Class.forName("org.sqlite.JDBC");
		   
		   conn = DriverManager.getConnection("jdbc:sqlite:js5_data_base.s3db", "root", "123");
	   }
	
	public static void CreateDB() throws ClassNotFoundException, SQLException
	   {
		
		 String x = "CREATE TABLE if not exists'v_msk_jj' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'time' date, 'specialization' text, 'location' text, 'enterprise' text, 'experience' text, 'text' text);";
		
		statmt = conn.createStatement();
		//statmt.execute("CREATE TABLE 'v_msk_jj' ('id' text, '1' text, '2' text,'3' text, '4' text, '5' text);");
		statmt.execute(x);
		
	   }
	
	public static void WriteDB(String time, String specialization, String location, String enterprise, String experience, String text) throws SQLException
	{
		statmt = conn.createStatement();
		
		s2 = "INSERT INTO 'v_msk_jj' ('time', 'specialization', 'location', 'enterprise', 'experience', 'text') VALUES ( '"+time+"', '"+specialization+"', '"+location+"', '"+enterprise+"', '"+experience+"', '"+text+"');";
		
	
		//System.out.println(s2);
		
		statmt.execute(s2);
		
//		System.out.println();
//		System.out.println(location);
	
	}
	
	public static ArrayList ReadDB() throws ClassNotFoundException, SQLException
	   {
		resSet = statmt.executeQuery("SELECT * FROM v_msk_jj");
		ArrayList list10 = new ArrayList();
		int i = 0;
		
		while(resSet.next())
		{
			String  enterprise = resSet.getString("enterprise");
			list10.add(enterprise);
			i++;
		}
		
		return list10;
	    }
	
// --------��������--------
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
		   }

}
