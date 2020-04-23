package collections.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex3 {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(2, 31, 3,  5, 666, 7, 99, 10);
        System.out.println(ints);

        ints.toArray();
        Object[] arrayOfInt = ints.toArray();

        Collections.sort(ints);
        System.out.println(ints);
        System.out.println(Collections.binarySearch(ints, 99));
        System.out.println(Collections.binarySearch(ints, -21));


    }
}
