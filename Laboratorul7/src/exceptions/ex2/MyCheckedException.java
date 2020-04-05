package exceptions.ex2;

/*
    custom checked exception
    Pentru a crea o exceptie proprie, trebuie sa extind clasa Exception
 */

public class MyCheckedException extends Exception{

    public MyCheckedException(String s) {
        super(s);
    }

}
