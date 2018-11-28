
/**
 * A weather forecast app determines if the pressure readings from its
 * subscribed weather station, if any, indicate it is likely to rain due to a
 * reduction on the pressure level.
 */
public class ForecastApp extends WeatherObserver {

	/**
	 * Update the reading of this weather observer. Update the current and last
	 * readings of pressure.
	 */
	private double currentP, lastP;
	private WeatherStation w;

	public void update() {
		
		if (currentP != 0) {
			lastP = currentP;
		} else {
			lastP = w.getPressure();
		}
		currentP = w.getPressure();
	}

	/* See the method description in the parent class */
	public WeatherStation getWeatherStation() {
		return w;
	}

	/* See the method description in the parent class */
	public void setWeatherStation(WeatherStation ws) {
		w = ws;
	}

	/**
	 * Get the pressure level read from the last update.
	 * 
	 * @return pressure level read from the last update
	 */
	public double getCurrentPressure() {
		return currentP;
	}

	/**
	 * Get the pressure level read from the second last update.
	 * 
	 * @return pressure level read from the second last update
	 */
	public double getLastPressure() {
		return lastP;
	}

	/**
	 * Based on the last and second last readings of the pressure level, it is
	 * determined as likely to rain if there is a reduction on the pressure
	 * level; otherwise it is unlikely to rain.
	 * 
	 * @return whether or not it is likely to rain.
	 */
	public boolean isLikelyToRain() {
		if (currentP < lastP)
			return true;
		return false;
	}
}