//The Observer interface is implemented by all observers, so they all
//have to implement the update() method. Here we're following Mary and
//Sue's lead and passing the measurements to the observers.

public interface Observer {
  //temp, float, humidity, and pressure are the state values the Observers
  //get from the Subject when a weather measurement changes

  public void update(float temp, float humidity, float pressure);
}
