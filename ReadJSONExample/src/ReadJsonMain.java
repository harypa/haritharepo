import java.io.FileReader;
import java.io.IOException;


import com.google.gson.stream.JsonReader;


public class ReadJsonMain {

	public static void main(String[] args) throws IOException {

	    JsonReader jsonReader = new JsonReader(new FileReader("C:\\Selenium Training\\JSONExample\\ReadJSONExample\\src\\JSonFile1.json"));

	    jsonReader.beginObject();

	    while (jsonReader.hasNext()) {

	    String name = jsonReader.nextName();
	        if (name.equals("descriptor")) {
	             readApp(jsonReader);

	        }
	    }

	   jsonReader.endObject();
	   jsonReader.close();

	}

	public static void readApp(JsonReader jsonReader) throws IOException{
	    jsonReader.beginObject();
	     while (jsonReader.hasNext()) {
	         String name = jsonReader.nextName();
	         System.out.println(name);
	         if (name.contains("app")){
	             jsonReader.beginObject();
	             while (jsonReader.hasNext()) {
	                 String n = jsonReader.nextName();
	                 if (n.equals("name")){
	                     System.out.println(jsonReader.nextString());
	                 }
	                 if (n.equals("age")){
	                     System.out.println(jsonReader.nextInt());
	                 }
	                 if (n.equals("messages")){
	                     jsonReader.beginArray();
	                     while  (jsonReader.hasNext()) {
	                          System.out.println(jsonReader.nextString());
	                     }
	                     jsonReader.endArray();
	                 }
	             }
	             jsonReader.endObject();
	         }

	     }
	     jsonReader.endObject();
	}
}
