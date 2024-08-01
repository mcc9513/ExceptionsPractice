public class Main {
    public static void main(String[] args) {
        // Creating instance of StandardSensor and TemperatureSensor
        Sensor standardSensor = new StandardSensor(10);
        Sensor temperatureSensor = new TemperatureSensor();


        // Creating an AverageSensor and adding the sensors to it
        AverageSensor averageSensor = new AverageSensor();
        averageSensor.addSensor(standardSensor);
        averageSensor.addSensor(temperatureSensor);


        // Turning on the temperature sensors
        temperatureSensor.setOn();

        // Reading and printing the values from the sensors individually
        System.out.println("Standard Sensor reading: " + standardSensor.read());
        System.out.println("Temperature Sensor 1 reading: " + temperatureSensor.read());


        // Reading and printing the average reading from the AverageSensor
        System.out.println("Average Sensor reading: " + averageSensor.read());

        // Reading multiple times from the AverageSensor and printing the history
        System.out.println("Average Sensor reading: " + averageSensor.read());
        System.out.println("Average Sensor reading: " + averageSensor.read());

        // Printing the reading history from the AverageSensor
        System.out.println("Average Sensor reading history: " + averageSensor.readings());
    }
}
