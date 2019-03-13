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
		specialization = delete_trash(specialization);
		enterprise = delete_trash(enterprise);
		text = delete_trash(text);
		
		
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
//			conn.close();
//			statmt.close();
			
			conn.close();
			
		   }
		public static String delete_trash(String data) {
			String result = "";
			String result2 = "";
			char[] symbols_array = data.toCharArray();
			ArrayList<Character> list = new ArrayList<Character>();
			
			for(int i = 0; i < symbols_array.length; i++) {
				
				if(symbols_array[i] == '"')symbols_array[i] = ' ';
				if(symbols_array[i] == '\'')symbols_array[i] = ' ';
				if(symbols_array[i] == '�' && symbols_array[i+1] == '?')symbols_array[i] = 'И';
//				if(symbols_array[i] == '?')symbols_array[i] = ' ';
				//if(list.get(i) == '?')list.remove(i);
				result += "" + symbols_array[i];
			}
			symbols_array = result.toCharArray();
			
			for(int i = 0; i < symbols_array.length; i++) {
				if(symbols_array[i] != '?')list.add(symbols_array[i]);
				
				//if(list.get(i) == '?')list.remove(i);
				//result += "" + symbols_array[i];
			}
			
			for(int i = 0; i < list.size(); i++) {
			
				result2 += "" + list.get(i);
			}
			
			
			
		return result2;
		}

}
/**
 * <p>�?щем в существующий проект тестировщика. Проект - корпоративное веб-приложение на vue.js + API на 1С. �? проект и процесс разработки довольно хорошо структурирован. Работаем двухнедельными спринтами в JIRA. На текущий момент тестирование только ручное. В ближайших планах добавить автоматизированное тестирование API.</p> <p>Если у вас есть опыт тестирования приложений и вы хотите развиваться в этой профессии, то наш проект вам хорошо подойдет. Тестировщик - сложная профессия, для которой нужна не только тщательность и въедливость, но и системность мышления, умение применять современные технологии для автоматизации всего, что можно автоматизировать.</p> <p><strong>Что делать</strong><br />- Участие в постановке задач<br />- Разработка тест кейсов<br />- Актуализация разнообразных чек-листов<br />- Ручное тестирование<br />- Автоматизированное тестирование</p> <p><strong>Что уметь</strong><br />- Запускать post запросы и разбирать возвращаемый json (Postman, SoapUI или другие инструменты)<br />- Разрабатывать тест-кейсы по описанию функционала<br />- Работать с Git<br />- �?нструменты разработчика Chome</p> <p><strong>Что знать</strong><br />- Типы и методологии тестирования<br />- Знание JavaScript, Java, Python будет преимуществом</p> <p><strong>Условия:</strong></p> <ul> <li>Официальное трудоустройство</li> <li>Работа с командой разработки ( git / vue.js)</li> <li>Длинный интересный проект</li> </ul>
 * 
 * /
 */