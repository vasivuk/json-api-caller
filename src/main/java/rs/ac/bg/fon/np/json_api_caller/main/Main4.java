package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Main4 {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonObject w = new JsonObject();
		w.addProperty("city", "New York");
		w.addProperty("country", "USA");
		w.addProperty("localTime", "Apr 6, 2022 4:58:53 PM");
		w.addProperty("temperature", 19);
		w.addProperty("weatherCode", 123);

		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter("rucni_upis.json"));
			out.print(gson.toJson(w));
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
