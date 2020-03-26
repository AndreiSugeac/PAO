package course_5;

public interface Soakable extends Washable{
    void soak();
    default void wash() {

    }
}
