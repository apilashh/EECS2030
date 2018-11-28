import java.util.ArrayList;
import java.util.List;

/**
 * A weather station measures temperature and pressure and has a list of
 * subscribed weather observers. When there is an update on the measures, the
 * weather station publishes the update to all currently-subscribed observers.
 */
public class WeatherStation {

	/*
	 * Your Task: Declare an attribute for the ***list*** of subscribed weather
	 * observers.
	 */

	private List<WeatherObserver> subscriberList;
	private double temp, p;

	/**
	 * Initialize a new weather station.
	 * 
	 * @param t
	 *            initial temperature measure
	 * @param p
	 *            initial pressure measure
	 */
	public WeatherStation(double t, double p) {
		subscriberList = new ArrayList<>();
		temp = t;
		this.p = p;
	}

	/**
	 * Subscribe the input weather observer o as one of the observers of the
	 * current weather station. Add the input o to the list of subscribed
	 * observers.
	 * 
	 * @param o
	 *            a weather observer
	 */
	public void subscribe(WeatherObserver o) {
		if (o != null) {
			o.setWeatherStation(this);
			subscriberList.add(o);
		}
	}

	/**
	 * Unsubscribe the input weather observer o from the list of observers of
	 * the current weather station. Remove the input o from the list of
	 * subscribed observers. Assume that the input o is an already-subscribed
	 * observer.
	 * 
	 * @param o
	 *            a weather observer
	 */
	public void unsubscribe(WeatherObserver o) {
		o.setWeatherStation(null);
		subscriberList.remove(o);
	}

	/**
	 * Publish the latest readings of weather data to all subscribed observers.
	 * That is, perform an update on each subscribed observer.
	 */
	public void publish() {
		for (WeatherObserver o : subscriberList)
			o.update();
	}

	/**
	 * Get the list of subscribed weather observers.
	 * 
	 * @return an array of subscribed weather observers.
	 */
	public WeatherObserver[] getObservers() {
		int x = subscriberList.size();
		WeatherObserver[] list = new WeatherObserver[x];
		if (x > 0)
			subscriberList.toArray(list);
		return list;
	}

	/**
	 * Get the latest temperature measure.
	 * 
	 * @return latest temperature measure
	 */
	public double getTemperature() {
		return temp;
	}

	/**
	 * Get the latest pressure measure.
	 * 
	 * @return latest pressure measure
	 */
	public double getPressure() {
		return p;
	}

	/**
	 * Update the weather data
	 * 
	 * @param t
	 *            new temperature measure
	 * @param p
	 *            new pressure measure
	 */
	public void set_measurements(double t, double p) {
		temp = t;
		this.p = p;
	}
}