package testing_area;

import java.util.ArrayList;

//..*THIS CLASS DELETE ALL TEG OF HTML
public class TegHTML {

	static String s = "<p><strong>Преимущества работы в компании:</strong></p> <ul> <li>Работа в крупной";
	
	public static void main(String[] args) {
		System.out.println("Исходный вариант:");
		System.out.println(s);
		System.out.println();
		
		char[] text = s.toCharArray();
		ArrayList<Character> array = new ArrayList<Character>();
		
		for(int i = 0; i < text.length; i++){
			array.add(text[i]);
			
		}
		
//		for(Character ch : array){
//			System.out.println(ch);
//		}
		
		char ch;
		int a = 0;
		int b = 0;
		boolean flag = false;
		ArrayList<Integer> number = new ArrayList<Integer>();
		
		for(int i = 0; i < array.size(); i++){
			ch = array.get(i);
			
			if(flag == false && ch == '<'){
				flag = true;
			}
			
			if(flag == true && ch != '>') number.add(i);
			if(ch == '>'){
				//array.remove(i);
				flag = false;
				number.add(i);
			}
			
			
		}
		
		
//		for(Integer t : number){
//			System.out.println(t);
//		}
		int abc = number.size() -1;
		System.out.println(abc);
		for(int i = abc; i > -1 ; i--){
			System.out.println(number.get(i));
			int abcd = number.get(i);
			array.remove(abcd);
			
		}
		
		for(Character chr : array){
			System.out.print(chr);
		}
		
		System.out.println();
		System.out.println("Результат:");
		System.out.println();

	}

}
