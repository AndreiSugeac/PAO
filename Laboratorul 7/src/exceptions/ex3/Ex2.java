package exceptions.ex3;

public class Ex2 {

    public static void main(String[] args) {

        try (R1 r1 = new R1();
             R1 r2 = new R1();) { // ce am scris in Ex1 intr-o singura linie de cod
            // some logic here
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
