package collections.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {

    public static void main(String[] args) {

        // without generics
        List bulklist = new ArrayList();
        bulklist.add(1);
        bulklist.add("Salut");
        bulklist.add(new Object());
        System.out.println(bulklist);

        List<String> list1 = new ArrayList<>();
        System.out.println(list1.isEmpty());
        list1.add("one");
        list1.add("two");
        list1.add(0, "be Voli");
        list1.add(1, "John Cena");
        System.out.println(list1.size());

        if(list1.contains("John Cena")) {
            System.out.println(list1.remove(0));
            System.out.println(list1.remove("John Cena"));
        }
        System.out.println(list1);

        List<Integer> ints = new ArrayList<>(bulklist);
        ints.add(1);
        System.out.println(ints);

        List<String> list2 = new ArrayList<String>(list1);
        System.out.println(list2);
        list2.addAll(1, list2);
        System.out.println(list2);

        list2.add("last element");
        list2.removeAll(list1);
        System.out.println("after remove all: " + list2);

        list1.clear();
        System.out.println("list1 after clear: " + list1);
    }
}
