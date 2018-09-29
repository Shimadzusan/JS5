import java.sql.SQLException;
import java.util.ArrayList;

public class Alpha {
	
	public String msk = "https://api.hh.ru/vacancies?text=java+junior&area=1&per_page=100";
	public String spb = "https://api.hh.ru/vacancies?text=java+junior&area=2&per_page=100";
	public String mnsk = "https://api.hh.ru/vacancies?text=java+junior&area=1002&per_page=100";
	Web web = new Web();
	static String s_file = "";
	//static ArrayList<String> list = new ArrayList<String>();
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
		
		id(web(msk));
		id(web(spb));
		id(web(mnsk));
		
		System.out.println("..extract_id completed");
		System.out.println("************************");
		
		System.out.println(vacancies_id.size());
		for(String x : vacancies_id){
			System.out.println(x);
		}
	}
	
	public void extract_value() {
		System.out.println();
		System.out.println("..begin of extract_value");
		
		System.out.println("..extract_value completed");
	}
	
	public void write_db() throws ClassNotFoundException, SQLException{
		System.out.println();
		System.out.println("..begin write_db");
		
			new Saturn();
//ЗДЕСЬ ВСЯ КАША ПО ИЗВЛЕЧЕНИЮ ПАРАМЕТРОВ И ЗАПИСИ В ДБ
		
		System.out.println("..write_db completed");
	}
//---------------------FIRST RING OF METHODS------------------------------------
	public String web(String url){
//..*input data URL
//..*output data json-object
		System.out.println();
		System.out.println("..begin method web");
		//Web web = new Web();
		String line = web.getJson(url);
		System.out.println("..method web completed");
		return line;
	}
	
	public void id(String json){
//ЗДЕСЬ ВСЯ КАША ПО ИЗВЛЕЧЕНИЮ ID ИЗ ПЕРВИЧНЫХ JSON-ОВ
		s_file = json;
		new Jupiter();	
	}
}
