package testing_area;
import java.util.ArrayList;

import com.google.gson.Gson;
//CLASS FOR TEST-WORK METHODS "EXTRACT_ID"
//INPUT DATA: URL
//OUTPUT DATA: ARRAY WITH ID OF VACANCIES(VACANCIES_ID)
public class Test {

	public static String s_file = "";
	public static ArrayList<String> vacancies_id = new ArrayList<String>();
	
	public static void main(String[] args) {
		System.out.println("..test started");
		System.out.println();

		
//PART 2.
		//ИЗВЛЕЧЕНИЕ FROM JSON-OBJECT ID OF VACANCIES
		extract_id();
		System.out.println(vacancies_id.size());
		System.out.println(vacancies_id.get(5));

	}
public static void extract_id(){
//PART 1.
			Web web = new Web();
			s_file = web.getJson("https://api.hh.ru/vacancies?text=java+junior&area=1002&per_page=100");
			System.out.println(s_file);//ПОЛУЧИЛИ JSON-OBJECT
			
//PART 2.
//ИЗВЛЕЧЕНИЕ FROM JSON-OBJECT ID OF VACANCIES
	
//..* Test.s_file - это json-object в формате Стринг, из которого мы что-то извлекаем
	Gson first_json = new Gson();
	Head_object head = first_json.fromJson(Test.s_file, Head_object.class);//преобразовали first_json to head
	
	System.out.println("размер массива: " + head.items.length);

		Gson second_json = new Gson();
		Area area = new Area();	
	
			for(int i = 0; i < head.items.length; i++){
			
			String z = second_json.toJson(head.items[i]);
			Area area2 = second_json.fromJson(z, Area.class);
			Test.vacancies_id.add(area2.id);
			// выодит требования: System.out.println(area2.snippet);
			}
}

}

class Head_object{
//..* специфический тип данных, находится в json-object, содержит id вакансий
	Object[] items;
	
}

class Area{
	String id = "";
	
}