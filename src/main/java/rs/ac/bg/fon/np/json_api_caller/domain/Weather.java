package rs.ac.bg.fon.np.json_api_caller.domain;

import java.util.Date;

public class Weather {
	private String city;
	private String country;
	private Date localTime;
	private int temperature;
	private int weatherCode;

	public Weather() {
		// TODO Auto-generated constructor stub
	}

	public Weather(String city, String country, Date localTime, int temperature, int weatherCode) {
		super();
		this.city = city;
		this.country = country;
		this.localTime = localTime;
		this.temperature = temperature;
		this.weatherCode = weatherCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLocalTime() {
		return localTime;
	}

	public void setLocalTime(Date localTime) {
		this.localTime = localTime;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getWeatherCode() {
		return weatherCode;
	}

	public void setWeatherCode(int weatherCode) {
		this.weatherCode = weatherCode;
	}

	@Override
	public String toString() {
		return "Weather [city=" + city + ", country=" + country + ", localTime=" + localTime + ", temperature="
				+ temperature + ", weatherCode=" + weatherCode + "]";
	}

}
