package course_5;

public class Cup implements BubbleBathable {
    double volume;
    String color;

    public int getLevelOfFragility() {
        return Washable.FRAGILE;
    }

    @Override
    public boolean needsWashing() {
        return false;
    }

    @Override
    public void wash() {
        needsWashing();
        System.out.println("washing a cup!");
    }

    @Override
    public void takeBubbleBath() {
        System.out.println("Doesn't need bubble bath!");
    }

    @Override
    public void scrub() {

    }

    @Override
    public void soak() {

    }
}
