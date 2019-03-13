import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;

public class Launch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
//02-10-2018 время выполнения: 2 мин. 41 сек.
// 2 мин. 53 сек.
// 3 мин. 03 сек.
// 3 мин. 07 сек. point A of memory 50 Mb, point B 33 Mb (11-10-2018)
// 3 мин. 39 сек. 15-10-2018
// 2 мин. 02 сек. 17-10-2018 ...after remove system.out
// 1 мин. 18 сек. 22-10-2018 ...наверно из-за хорошего интернета
		Date date = new Date();
		long d1 = date.getTime();
		
		new Alpha();
		//new Saturn(); 
		
		Date date2 = new Date();
		long d2 = date2.getTime();
		long d3 = d2 - d1;
		System.out.println("Время выполнения: " + d3 + " mls");

	}

}
