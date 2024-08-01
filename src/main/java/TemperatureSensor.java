import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean isOn;
    private Random random;

    // Constructor initializes the sensor to be off and creates a new Random instance
    public TemperatureSensor() {
        this.isOn = false;
        this.random = new Random();
    }

    // Checks if the sensor is on
    @Override
    public boolean isOn() {
        return this.isOn;
    }

    // Turns the sensor on
    @Override
    public void setOn() {
        this.isOn = true;
    }

    // Turns the sensor off
    @Override
    public void setOff() {
        this.isOn = false;
    }

    // Reads a temperature value if the sensor is on; throws an exception if it's off
    @Override
    public int read() {
        if (!this.isOn) {
            throw new IllegalStateException("The sensor is off. Please turn it on before reading.");
        }

        // Generates a random number between 0 and 60, then adjusts it to the range -30 to 30
        int temperature = random.nextInt(61) - 30;
        return temperature;
    }
}
