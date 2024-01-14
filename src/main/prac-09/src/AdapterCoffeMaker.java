
public class AdapterCoffeMaker extends Connectable {
    CoffeMaker coffeMaker = new CoffeMaker();

    public void turnOn() {
        coffeMaker.on();
    }

    public void turnOff() {
        coffeMaker.off();
    }

    public boolean isOn() {
        return !coffeMaker.isOff();
    }
}

