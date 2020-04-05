package exceptions.ex3;
/*
    clasa care sa emuleze un flux de date cu care va lucra programul nostru
    are nevoie sa implementeze AutoCloseable
 */

public class R1 implements AutoCloseable {

    /*public R1() {
        throw new RuntimeException();
    }*/

    @Override
    public void close() throws Exception{
        throw new RuntimeException("in close method");
    }
}
