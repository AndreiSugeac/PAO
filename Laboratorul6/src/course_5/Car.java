package course_5;

public class Car implements BubbleBathable {
    @Override
    public void wash() {
        System.out.println("washing a car!");
    }

    @Override
    public void soak() {
        System.out.println("soaking a car!");
    }

    @Override
    public void takeBubbleBath() {
        System.out.println("Bubble bathing the car!");
    }

    @Override
    public void scrub() {
        System.out.println("soft scrub!");
    }
}
