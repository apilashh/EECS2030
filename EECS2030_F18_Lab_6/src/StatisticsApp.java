
/**
 * A weather statistics app calculates the minimum, maximum, and average
 * temperature read so far from its subscribed weather station, if any.
 */
public class StatisticsApp extends WeatherObserver {

	/**
	 * Update the reading of this weather observer. Update the current
	 * temperature and the maximum, minimum, and average accordingly.
	 */
	private double total, max, min, avg;
	private WeatherStation w;
	private int c;

	public void update() {
		double t = w.getTemperature();

		if (c == 0) {
			total = t;
			avg = t;
			max = t;
			min = t;
			c = 1;
		} else {
			total += t;
			c++;
			avg = total / c;
		}

		if (t > max)
			max = t;

		if (t < min)
			min = t;

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
	 * Get the minimum temperature based on the readings so far.
	 * 
	 * @return minimum temperature based on the readings so far
	 */
	public double getMinTemperature() {
		return min;
	}

	/**
	 * Get the maximum temperature based on the readings so far.
	 * 
	 * @return maximum temperature based on the readings so far
	 */
	public double getMaxTemperature() {
		return max;
	}

	/**
	 * Get the average temperature based on the readings so far.
	 * 
	 * @return average temperature based on the readings so far
	 */
	public double getAverageTemperature() {
		return avg;
	}

}
