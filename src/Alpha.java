import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import testing_area.Web;

public class Alpha {
	
	public String msk = "https://api.hh.ru/vacancies?text=java+junior&area=1&per_page=100";
	public String spb = "https://api.hh.ru/vacancies?text=java+junior&area=2&per_page=100";
	public String mnsk = "https://api.hh.ru/vacancies?text=java+junior&area=1002&per_page=100";
	
	Web web = new Web();
	static String s_file = "";
	static ArrayList<String> vacancies_id = new ArrayList<String>();
	
	Alpha() throws ClassNotFoundException, SQLException{
		System.out.println("Interface JS-5");
	
		extract_id();
		extract_value();
		write_db();
		System.out.println();
		System.out.println("....................*");
		System.out.println("...end of JS-5");
	}
//-------------------------CORE OF METHODS--------------------------------------
	public void extract_id(){
//..*INPUT_DATA 3 URL ADDRESSES(MSK, SPB, MNSK)
//..*OUTPUT_DATA ARRAY WITH ID_VACANCIES(ArrayList vacancies_id)
		
		System.out.println();
		System.out.println("..begin of extract_id");
		
		id(msk);
		id(spb);
		id(mnsk);
		
		System.out.println("..extract_id completed");
		System.out.println("************************");
//!!		
//		System.out.println(vacancies_id.size());
//		for(String x : vacancies_id){
//			System.out.println(x);
//		}
	}
	
	public void extract_value() {
		System.out.println();
		System.out.println("..begin of extract_value");
		
		System.out.println("..extract_value completed");
	}
	
	public void write_db() throws ClassNotFoundException, SQLException{
		System.out.println();
		System.out.println("..begin write_db");
		

//ЗДЕСЬ ВСЯ КАША ПО ИЗВЛЕЧЕНИЮ ПАРАМЕТРОВ И ЗАПИСИ В ДБ
		test2();
		
		System.out.println("..write_db completed");
	}
//---------------------FIRST RING OF METHODS------------------------------------
	public void id(String url){
//..*input data URL
//..*output id in array vacancies_id
		System.out.println();
		System.out.println("..begin method web");


		//PART 1.
		//Web web = new Web();
		s_file = web.getJson(url);
		//System.out.println(s_file);//ПОЛУЧИЛИ JSON-OBJECT
		
//PART 2.
//ИЗВЛЕЧЕНИЕ FROM JSON-OBJECT ID OF VACANCIES

//..* Test.s_file - это json-object в формате Стринг, из которого мы что-то извлекаем
		Gson first_json = new Gson();
		Head_object head = first_json.fromJson(s_file, Head_object.class);//преобразовали first_json to head

//System.out.println("размер массива: " + head.items.length);

		Gson second_json = new Gson();
		Area area = new Area();	

		for(int i = 0; i < head.items.length; i++){
			
				String z = second_json.toJson(head.items[i]);
				Area area2 = second_json.fromJson(z, Area.class);
				vacancies_id.add(area2.id);
				// выодит требования: System.out.println(area2.snippet);
		}

		System.out.println("..method web completed");	
	}
	
public void test2() throws ClassNotFoundException, SQLException{
		
		System.out.println("..test2 started");
		System.out.println();
		String s = "";

				Web web = new Web();
				
				
		for(int i = 0; i < vacancies_id.size(); i++){
			
				String id = vacancies_id.get(i);
				
				String url = "https://api.hh.ru/vacancies/" + id;
//System.out.println(web.getJson(url));
				s = web.getJson(url);
				
//------------------------------------------------------------------------------------------
				
				Gson js = new Gson();
				Mars head = js.fromJson(s, Mars.class);
				
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				
//System.out.println("location: " + head.area);
//System.out.println("enterprise: " + head.employer);
				
				String f = js.toJson(head.address);
				String g = js.toJson(head.employer);
				String e = js.toJson(head.experience);
				System.out.println("---------------------------------------");
//System.out.println("address: " + f);
				
				Venus cry = js.fromJson(f, Venus.class);
				//**************
				
				String loc = js.toJson(head.area);
				
				Rea place = js.fromJson(loc, Rea.class);
				String mesto = place.name;
//System.out.println("HERE: " + mesto);
				//************
				
				Venus cr = js.fromJson(g, Venus.class);
				//System.out.println(cr.name);
				//System.out.println(head.name);
				
				Phobos phob = js.fromJson(e, Phobos.class);
//System.out.println(phob.name);
				//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//System.out.println(head.description);
				
//////////////////////////////////////////////!!!!!!!!!!!!!!WRITE TO DATA BASE!!!!!!!!!!!!!!!!!!!!!
				
				String specialization = "";
				String location = "";
				String experience = "";
				String enterprise = "";
				String text = "";
				String time = "";
				
									////
									Conn20 conn = new Conn20();
									////
				
					specialization = head.name;
					location = mesto;
					experience = phob.name;
					enterprise = cr.name;
					text = head.description;
					time = time();
					
/////////////////////////////////////////////DATA BASE/////////////////////////////////////
					
					conn.Conn();
					conn.CreateDB();
					conn.WriteDB(time, specialization, location, enterprise, experience, text);
					conn.CloseDB();
//|id|time|specialization|location|enterprise|experience|text|
					
					
//System.out.println(time + " " + specialization+ " " + location+ " " + enterprise+ " " + experience);
				System.out.println("Выполнено: " + i + " из: " + vacancies_id.size());
			}

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
		
		String data_time = year + moon + day;
		return data_time;
	}
}
class Head_object{
	//..* специфический тип данных, находится в json-object, содержит id вакансий
		Object[] items;
		
	}

class Area{
		String id = "";
		
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
//FOR EXTRACTING LOCATION FROM JSON
	String name;
}
