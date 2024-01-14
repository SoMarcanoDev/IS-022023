
public class CoffeMaker {
    boolean on = false;

    public void on() {
        if (isOff()) {
            on = true;
            System.out.println("coffeMaker on");
        }
    }

    public void off() {
        if (!isOff()) {
            on = false;
            System.out.println("coffeMaker off");
        }
    }

    public boolean isOff() {
        return !on;
    }
}
