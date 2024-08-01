import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readingHistory;

    // Constructor initializes the list of sensors and reading history
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readingHistory = new ArrayList<>();
    }

    // Method to add a new sensor to the AverageSensor
    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    // Check if all sensors are on
    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    // Turns on all sensors
    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }

    // Turns off at least one sensor (could turn off all)
    @Override
    public void setOff() {
        if (!sensors.isEmpty()) {
            sensors.get(0).setOff();
        }
    }

    // Reads the average value from all sensors
    @Override
    public int read() {
        if (sensors.isEmpty() || !this.isOn()) {
            throw new IllegalStateException("The AverageSensor is either off or has no sensors added.");
        }

        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.read();
        }

        int averageReading = sum / sensors.size();
        readingHistory.add(averageReading); // Store the reading
        return averageReading;
    }

    // Returns the list of all executed readings
    public List<Integer> readings() {
        return new ArrayList<>(readingHistory);
    }
}
