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
	//public  static String s = "INSERT INTO 'users' ('time', 'syria', 'russia', 'usa') VALUES ('12:48','Masha', 'Pascha', 'Jok'); ";
	 private static final String SQL = "DELETE FROM users WHERE id = \"3\"";
	 static String s = "";
	 static String s2;
	
	// --------����������� � ���� ������--------
	public static void Conn() throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   
		   Class.forName("org.sqlite.JDBC");
		   
		   
		   conn = DriverManager.getConnection("jdbc:sqlite:DataBase5000.s3db", "root", "123"); //...
  
// System.out.println("Base is ON!");
	   }
	
	public static void CreateDB() throws ClassNotFoundException, SQLException
	   {
		
		 String x = "CREATE TABLE if not exists'v_msk_jj' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'time' date, 'specialization' text, 'location' text, 'enterprise' text, 'experience' text, 'text' text);";
		 //System.out.println(x);
		
		statmt = conn.createStatement();
		//statmt.execute("CREATE TABLE 'v_msk_jj' ('id' text, '1' text, '2' text,'3' text, '4' text, '5' text);");
		statmt.execute(x);
		
	   }
	
	// enterprise, experience, text
	
	public static void WriteDB(String time, String specialization, String location, String enterprise, String experience, String text) throws SQLException
	{
		statmt = conn.createStatement();
		
		s2 = "INSERT INTO 'v_msk_jj' ('time', 'specialization', 'location', 'enterprise', 'experience', 'text') VALUES ( '"+time+"', '"+specialization+"', '"+location+"', '"+enterprise+"', '"+experience+"', '"+text+"');";
		
	
		System.out.println(s2);
		
		statmt.execute(s2);
		
		

		//////////////////////////////////////////////////////////////////////////////////////
		
		//Sar sar = new Sar();
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		Date day = new Date();
		int hours = day.getHours();
		int min = day.getMinutes();
		
		String data_time = hours + ":"+ min;
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("I am Last!!!");
		//Sar sar = new Sar();
		//sar.main(null);
//		int a = sar.req(0); //Syria
//		int b = sar.req1(0); //Russia
//		int c = sar.req2(0); //USA
//		int d = sar.req3(0); //America
		System.out.println();
		System.out.println("*************************************");
	
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
			
			
			//System.out.println(i + "   : " + enterprise);
		}
//System.out.println("Read DB");
		return list10;
	    }
	
		// --------��������--------
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
			//resSet.close();
			
//System.out.println("Close DB");
		   }

}
