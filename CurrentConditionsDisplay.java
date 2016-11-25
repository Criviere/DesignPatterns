import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Crivi002
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;
    
    public CurrentConditionsDisplay(Observable observeable){
        this.observable = observeable;
        observeable.addObserver(this);
    }
    
    
    public void update(Observable obs, Object arg){
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
    
    @Override
     public void display(){
         System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity\n");
     }
}
