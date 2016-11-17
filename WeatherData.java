import java.util.*;

public class WeatherData implements Subject {
        private ArrayList observers;
        private float temperature;
        private float humidity;
        private float pressure;

  public WeatherData() {
          observers = new ArrayList();
  }

  //When an observer registers, we just add it to the end of the list.
  public void registerObserver (Observer o) {
          observers.add(o);
  }

  public void removeObservers(Observer o){
    int i = observers.indexOf(o);
    if (i >= 0){
      observers.remove(i);
    }
  }

  // Here's the fun part; this is where we tell
  // all the observers about the state.
  // Because they are all Observers, we know
  // they all implement update(), so we know how to notify them.
  public void notifyObservers(){
    for(int i = 0; i < observers.size(); i++){
        Observer observer = (Observer)observers.get(i);
        observer.update(temperature, humidity, pressure);
    }
}

  // Notify the Observers when we get update measurements
  //from the Weather Station.
  public void measurementsChanged() {
      notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
      this.temperature = temperature;
      this.humidity = humidity;
      this.pressure = pressure;
      measurementsChanged();
  }

  // other WeatherData methods here
}
