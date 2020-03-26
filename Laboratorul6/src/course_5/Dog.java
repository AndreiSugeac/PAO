package course_5;

public class Dog extends Animal implements BubbleBathable {
    @Override
    public void wash() {
        System.out.println("washing a dog!");
    }

    @Override
    public void takeBubbleBath() {
        super.takeBubbleBath();
    }

    @Override
    public void scrub() {
        super.scrub();
    }

    @Override
    public void soak() {
        System.out.println("Soak does not apply to dog!");
    }
}
