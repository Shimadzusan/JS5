package testing_area;

import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

//CLASS FOR TEST-WORK METHODS "EXTRACT_VALUE"
//INPUT DATA: ID OF VACANCIES
//OUTPUT DATA: VACANCIES VALUE
public class Test2 {
	static String s_file ="";
	static ArrayList<String> vacancies_id = new ArrayList<String>();

	public static void main(String[] args) {
		System.out.println("..test2 started");
		System.out.println();
		
		//26358268
		vacancies_id.add("27955006");
		
				System.out.println("I am Saturn");
				Web web = new Web();
				
				
		for(int i = 0; i < vacancies_id.size(); i++){
				
				String id = vacancies_id.get(i);
				
				String url = "https://api.hh.ru/vacancies/" + id;
				System.out.println(web.getJson(url));
				s_file = web.getJson(url);
				
//------------------------------------------------------------------------------------------
				
				Gson js = new Gson();
				Mars head = js.fromJson(s_file, Mars.class);
				
				//System.out.println(human2.apply_alternate_url);
				//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				System.out.println("location: " + head.area);
				System.out.println(head.employer);
				
				String f = js.toJson(head.address);
				String g = js.toJson(head.employer);
				String e = js.toJson(head.experience);
				String loc = js.toJson(head.area);
				
				Rea place = js.fromJson(loc, Rea.class);
				String mesto = place.name;
				System.out.println("HERE: " + mesto);
				
				System.out.println("------------------------------------");
				System.out.println(f);
				
				Venus cry = js.fromJson(f, Venus.class);
				
//				System.out.println(cry.city);
//				String area_null = cry.city;
				
				Venus cr = js.fromJson(g, Venus.class);
				System.out.println(cr.name);
				System.out.println(head.name);
				
				Phobos phob = js.fromJson(e, Phobos.class);
				System.out.println(phob.name);
				//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

				System.out.println(head.description);
				
//				///!!!!!!!!!!!!!!WRITE TO DATA BASE!!!!!!!!!!!!!!!!!!!!!
//				
//				String specialization = "";
//				String location = "";
//				String experience = "";
//				String enterprise = "";
//				String text = "";
//				String time = "";
//				
//				////
//				Conn20 conn = new Conn20();
//				////
//				
//				//for(int i = 0; i  < 1; i++){
//					//String s = (String) material.get(i);
//					specialization = human2.name;
//					location = area_null;
//					experience = phob.name;
//					enterprise = cr.name;
//					//System.out.println(enterprise +"|||"+ i);
//					text = human2.description;
//					time = time();
//					//System.out.println("№: " + i +  "| text: " + text);
//					//String i2 = Integer.toString(i + 1);
//					//String s2 = i2 + " " + specialization;
//					/////////////////////////////////////////////DATA BASE/////////////////////////////////////
//					//String id = Integer.toString(i+1);
//					conn.Conn();
//					conn.CreateDB();
//					conn.WriteDB(time, specialization, location, enterprise, experience, text);
//					conn.CloseDB();
//					//			|id|time|specialization|location|enterprise|experience|text|
//					
//					
//				System.out.println(time + " " + specialization+ " " + location+ " " + enterprise+ " " + experience);
//				
			}
			
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				////////////////////////////////////////////////////////
				////////////////////////////////////////////////////////
				
//				Gson js2 = new Gson();
//				//js2 = human2.items[1];
//				Venus area = new Venus();
//				System.out.println(area.apply_alternate_url);

	}
	
	public static String time(){
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

	Object[] items;
	
	Object area;

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

class Rea{
	String name;
}


