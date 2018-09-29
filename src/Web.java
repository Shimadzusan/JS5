import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
//НАЗНАЧЕНИЕ КЛАССА ПРИНИМАТЬ URL, И ВОЗВРАЩАТЬ JSON-OBJECT

public class Web {
	Web(){
		System.out.println("..constructor Web run");
	}
	
	public String getJson(String url){
		
		String query = url;
		String line = "";
		HttpURLConnection connection = null;
		
		try{
			connection = (HttpURLConnection) new URL(query).openConnection();
	
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", "api-test-agent");
			connection.connect();
			
			StringBuilder sb = new StringBuilder();
			
			if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){
				
				//System.out.println(HttpURLConnection.HTTP_OK == connection.getResponseCode());
				//System.out.println("..response code: " + connection.getResponseCode());
				
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				line = in.readLine();		
			}
			else{
				System.out.println("каккой-то пипец кароче.....");
			}
		}
		catch(Throwable cause){
			cause.printStackTrace();
		}
		finally{
			if(connection != null){
				connection.disconnect();
			}
		}
		
		return line;
	}

}