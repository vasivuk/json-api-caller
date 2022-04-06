package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rs.ac.bg.fon.np.json_api_caller.Weather;

public class Main2 {
	public static void main(String[] args) {
		Weather w1 = new Weather("Belgrade", "Serbia", new Date(), 21, 123);
		Weather w2 = new Weather("Paris", "France", new Date(), 14, 113);
		Weather w3 = new Weather("Venice", "Italy", new Date(), 25, 123);

		Weather[] weather = { w1, w2, w3 };

		try {
			PrintWriter out = new PrintWriter(new FileWriter("weather.json"));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			out.print(gson.toJson(weather));
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
