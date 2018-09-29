package testing_area;

import java.util.Date;

public class Time {

	public static void main(String[] args) throws InterruptedException {
		Time time = new Time();
		System.out.println(time);
			
			Date date = new Date();
			long t = date.getTime();
			System.out.println(t);
			
									//Thread.sleep(5000);
									for(int i = 0; i < 1_000_000; i++){
										//System.out.println(i);
									}
			
			Date date2 = new Date();
			long t2 = date2.getTime();
			System.out.println(t2);
			
			long t3 = t2 - t;
			System.out.println(t3);
			
			
	}

}
