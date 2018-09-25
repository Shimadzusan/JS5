

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;

public class Jupiter {
	//static String s_file ="";

	Jupiter(){
		Unit unit = new Unit();
		Gson js = new Gson();
		String s = js.toJson(unit);
		System.out.println(s);
		String ss = "{\"life\":500,\"kind\":\"Human\",\"craft\":300}";
		
		Unit human = js.fromJson(ss, Unit.class);
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
		
		Unit human2 = js.fromJson(Alpha.s_file, Unit.class);
		//System.out.println(human2.quick_responses_allowed + "  j s " + human2.alternate_url + "imya" + human2.name);
		System.out.println(Alpha.s_file);
		//System.out.println(human2.id);
		System.out.println("размер массива: " + human2.items.length);
//		System.out.println(human2.items[0]);
		
		Gson js2 = new Gson();
		//js2 = human2.items[1];
		Area area = new Area();
		for(int i = 0; i < human2.items.length; i++){
		
		String z = js2.toJson(human2.items[i]);
		Area area2 = js2.fromJson(z, Area.class);
		
		//System.out.println(z + "!!!");
		//System.out.println(human2.items[1]);
		System.out.println(i + ": " + area2.id);
		Alpha.vacancies_id.add(area2.id);
		// выодит требования: System.out.println(area2.snippet);
		}
		
	}
		//{"quick_responses_allowed":false
	
		

	}


class Unit{
	String id;
	
	
	//int page;
	Object[] city = {"moscow","piter","new york"};
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
class Area{
	String id = "5";
	Object snippet;
	String requirement;
}
