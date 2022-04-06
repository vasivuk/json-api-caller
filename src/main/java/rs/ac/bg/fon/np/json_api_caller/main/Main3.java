package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rs.ac.bg.fon.np.json_api_caller.Weather;

public class Main3 {
	public static void main(String[] args) {
		try {
			FileReader in = new FileReader("weather.json");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			List<Weather> weather = Arrays.asList(gson.fromJson(in, Weather[].class));

			for (Weather w : weather) {
				System.out.println(w);
			}

			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
