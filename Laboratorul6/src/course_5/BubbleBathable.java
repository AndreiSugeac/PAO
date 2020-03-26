package course_5;

public interface BubbleBathable extends Soakable, Scrubbable{

    void takeBubbleBath();

    default void wash() {
        Soakable.super.wash();
        System.out.println("default: wash in bubble bathing");
    }
}
