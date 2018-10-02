import java.sql.SQLException;
import java.util.Date;

public class Launch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//02-10-2018 время выполнения: 2 мин. 41 сек.
// 2 мин. 53 сек.
		Date date = new Date();
		long d1 = date.getTime();
		
		new Alpha();
		//new Saturn();
		
		Date date2 = new Date();
		long d2 = date2.getTime();
		long d3 = d2 - d1;
		System.out.println(d3);

	}

}
