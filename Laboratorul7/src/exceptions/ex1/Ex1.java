package exceptions.ex1;

/*
    Cand apelez metoda main vom avea urmatoarea stiva de apeluri:

    m3()
    m2()
    m1()
    main() care este la baza

    Atunci cand dorim sa tratam o exceptie ne folosim de sintaxa try, catch, finally

    java.lang -> Throwable
                    Error
                        OutOfMemoryException
                        StackOverflowException
                    Exception
                        RuntimeException -> unchecked exceptions
                            java.lang, NPE, ArithmeticException, IllegalArgumentException (NumberFormatException), ClassCastException
                        otherExceptions -> checked exceptions
                            IOExceptions (java.io), SqlException (java.sql)
                                FileFoundException (java.io)
*/

public class Ex1 {

    public static void main(String[] args) throws Exception{
        try {
            m1();
        }   catch(NullPointerException npe) {
            System.out.println(npe);
        }   finally {
            System.out.println("in finally");
        }
    }

    static void m1() throws Exception{
        System.out.println("in m1");
        m2();
        throw new Exception();
    }
    static void m2() {
        System.out.println("in m2");
        throw new RuntimeException("exception in m2");
        //m3();
    }
    static void m3() {
        // throws null pointer exception (NPE)
        System.out.println("in m3");
        Object o = null;
        o.toString();

    }
}
