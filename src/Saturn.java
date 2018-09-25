

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;

public class Saturn  {
	static String s_file ="";

	Saturn() throws ClassNotFoundException, SQLException{
		//26358268
		//String q = Alpha.vacancies_id.get(5);
		System.out.println("I am Saturn");
		//System.out.println(Alpha.list.size());
		Web web = new Web();
		
		for(int x10 = 0; x10 < Alpha.vacancies_id.size(); x10++){
		String q3 = Alpha.vacancies_id.get(x10);
		
		String q2 = "https://api.hh.ru/vacancies/" + q3;
		System.out.println(web.getJson(q2));
		s_file = web.getJson(q2);
		
		Mars unit = new Mars();
		Gson js = new Gson();
		String s = js.toJson(unit);
		System.out.println(s);
		String ss = "{\"life\":500,\"kind\":\"Human\",\"craft\":300}";
		
		Mars human = js.fromJson(ss, Mars.class);
		//System.out.println(human.life + " ");
/////////////////////////////////////////////////////////////////////////////////////
//		File main_text = new File("C:\\Users\\Stalin\\workspace\\S1199\\text.txt");//*input
//		Scanner scan_main_text = null;
//			
//		try {
//		scan_main_text = new Scanner(main_text);
//		}
//		catch (FileNotFoundException e) {
//		e.printStackTrace();
//		}
//					  
//		while(scan_main_text.hasNextLine()){		
//		s_file += scan_main_text.nextLine() + " ";
//		
//		}
//		scan_main_text.close();
//		
		//System.out.println(s_file);//*output
//////////////////////////////////////////////////////////////////////////////////////
		
		Mars human2 = js.fromJson(s_file, Mars.class);
		//System.out.println(human2.apply_alternate_url);
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		System.out.println(human2.address);
		System.out.println(human2.employer);
		
		String f = js.toJson(human2.address);
		String g = js.toJson(human2.employer);
		String e = js.toJson(human2.experience);
		System.out.println(f);
		
		Venus cry = js.fromJson(f, Venus.class);
		
		//System.out.println(cry.city);
		
		Venus cr = js.fromJson(g, Venus.class);
		System.out.println(cr.name);
		System.out.println(human2.name);
		
		Phobos phob = js.fromJson(e, Phobos.class);
		System.out.println(phob.name);
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
//		String[] s5 = (String) zzz;
//		System.out.println(s5[1]);
//		Gson exempele = new Gson();
//		 exempele = (Gson)zzz;
//		 //Venus area2 = new Venus();
//		 Venus area2 = exempele.fromJson(ss, Venus.class);
//		 System.out.println(area2.local);
		 
		//System.out.println(human2.employer);
		
		
		
		System.out.println(human2.description);
		//System.out.println(human2.quick_responses_allowed + "  j s " + human2.alternate_url + "imya" + human2.name);
		//System.out.println(s_file);
		//System.out.println(human2.id);
		//System.out.println("размер массива: " + human2.items.length);
//		System.out.println(human2.items[0]);
		
		
		///!!!!!!!!!!!!!!WRITE TO DATA BASE!!!!!!!!!!!!!!!!!!!!!
		
		String specialization = "";
		String location = "";
		String experience = "";
		String enterprise = "";
		String text = "";
		String time = "";
		
		////
		Conn20 conn = new Conn20();
		////
		
		//for(int i = 0; i  < 1; i++){
			//String s = (String) material.get(i);
			specialization = human2.name;
			location = "MSK&SPB";
			experience = phob.name;
			enterprise = cr.name;
			//System.out.println(enterprise +"|||"+ i);
			text = human2.description;
			time = time();
			//System.out.println("№: " + i +  "| text: " + text);
			//String i2 = Integer.toString(i + 1);
			//String s2 = i2 + " " + specialization;
			/////////////////////////////////////////////DATA BASE/////////////////////////////////////
			//String id = Integer.toString(i+1);
			conn.Conn();
			conn.CreateDB();
			conn.WriteDB(time, specialization, location, enterprise, experience, text);
			conn.CloseDB();
			//			|id|time|specialization|location|enterprise|experience|text|
			
			//Add_to_file_txt("C:\\Users\\Stalin\\workspace\\JS4\\output_text.txt", s2);
			
//			if(i == 2){
//				break;
//			}
			
		
		System.out.println(time + " " + specialization+ " " + location+ " " + enterprise+ " " + experience);
		
		}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////
		
		Gson js2 = new Gson();
		//js2 = human2.items[1];
		Venus area = new Venus();
		System.out.println(area.apply_alternate_url);
		
//		Gson z = human2.address;
//		String xxx = z.toJson(human2.address);
//		Venus area2 = z.fromJson(xxx, Venus.class);
//		System.out.println("!!! " + area2.local);
		
//		for(int i = 0; i < human2.items.length; i++){
//		
//		
//		
//		
//		//System.out.println(z + "!!!");
//		//System.out.println(human2.items[1]);
//		System.out.println(i + ": " + area2.id);
//		Alpha.vacancies_id.add(area2.id);
//		// выодит требования: System.out.println(area2.snippet);
//		}
		
	}
		//{"quick_responses_allowed":false
	
	public String time(){
		Date date = new Date();
		int year = date.getYear() + 1900;
		
		int day = date.getDate();
		int month = date.getMonth();
		String moon = "";
		
		switch(month){
		case 0: moon = "01"; break;
		case 1: moon = "02"; break;
		case 2: moon = "03"; break;
		case 3: moon = "04"; break;
		case 4: moon = "05"; break;
		case 5: moon = "06"; break;
		case 6: moon = "07"; break;
		case 7: moon = "08"; break;
		case 8: moon = "09"; break;
		case 9: moon = "10"; break;
		case 10: moon = "11"; break;
		case 11: moon = "12"; break;
		}
		
		String data_time = year + moon +day;
		return data_time;
	}	

	}


class Mars{
	String name;
//	String apply_alternate_url;
	Object address;
	Object employer;
	String description;
	Object experience;
	
	//int page;
	//Object[] city = {"moscow","piter","new york"};
	Object[] items;
////	int life = 100;
//	int weapon = 20;
//	
//	String kind = "Human";
//	boolean quick_responses_allowed;
//	String alternate_url;
//	String name;
//	String description;
//	String[] items;
	
}
class Venus{
	String name;
	String apply_alternate_url;
	
	String id = "5";
	Object snippet;
	String city;
}
class Phobos{
	String name;
}


