package strings;

public class Main {
    static String membruClasa;
    public static void main(String[] args) {
        //System.out.println(membruClasa);

        String s1 = "";
        String s2 = "abc"; // string pool
        System.out.println(s2); // abc
        s2.toUpperCase();
        System.out.println(s2); // abc
        //s2 = s2.toUpperCase(); // "ABC"
        //System.out.println(s2); // ABC

        String s3 = new String("abc");
        String s4 = "a\\bc \n de\tf"; // daca vreau sa pun un \ in stringul meu trebuie sa il pun de doua ori si \t = tab

        System.out.println((s2 == s3)); // false
        System.out.println(s3 == s4); // false
        System.out.println((s2 == s4)); // true
        System.out.println(s2.equals(s3)); // true
        s3 = s3.intern();
        System.out.println(s2 == s3);
        System.out.println(s4);

        String adresa = s1 + s2 + s3.toUpperCase() + s4.length();
        StringBuilder sb = new StringBuilder(adresa);
        sb.append(" def ");
        sb.append(100);
        System.out.println(sb);

        StringBuffer sbf = new StringBuffer(adresa);
        StringBuffer sbf1 = new StringBuffer(sb);
        StringBuilder sb1 = new StringBuilder(sbf);

        
    }
}
