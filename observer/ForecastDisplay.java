import java.util.*;
import java.util.Observable;
import java.util.Observer;


public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.2f;
    private float lastPressure;
    private WeatherData weatherData;
    
    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
                
    }

    @Override
    public void update(Observable observable, Object arg){
        if(observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)observable;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
            
        }
    }
    
    @Override
    public void display(){
        System.out.print("Forecast: ");
        if(currentPressure > lastPressure){
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure){
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure){
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
