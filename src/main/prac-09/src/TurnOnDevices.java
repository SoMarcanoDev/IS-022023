
public class TurnOnDevices {
    public static void main(String[] args) {
        turnOnDevice(new Lamp());
        turnOnDevice(new Computer());
        turnOnDevice(new AdapterCoffeMaker());
        }
        private static void turnOnDevice(Connectable device) {
        device.turnOn();
        System.out.println(device.isOn());
        }
}
