package rs.ac.bg.fon.np.json_api_caller.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import rs.ac.bg.fon.np.json_api_caller.Weather;

public class Main1 {

	public static String ACCESS_KEY = "517f47919c3b31e828fb99f06716c36a";

	public static void main(String[] args) {
		try {
			URL url = new URL("http://api.weatherstack.com/current?access_key=" + ACCESS_KEY + "&query=Belgrade");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			Gson gson = new GsonBuilder().create();
			JsonObject jsonResult = gson.fromJson(in, JsonObject.class);
			in.close();

			Weather weather = createObjectFromData(jsonResult);
			System.out.println(weather);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Weather createObjectFromData(JsonObject source) {
		Weather weather = new Weather();
		JsonObject tempAndWeatherCode = (JsonObject) source.get("current");
		weather.setTemperature(tempAndWeatherCode.get("temperature").getAsInt());
		weather.setWeatherCode(tempAndWeatherCode.get("weather_code").getAsInt());

		JsonObject location = (JsonObject) source.get("location");
		weather.setCountry(location.get("country").getAsString());
		weather.setCity(location.get("name").getAsString());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			weather.setLocalTime(sdf.parse(location.get("localtime").getAsString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return weather;
	}
}
