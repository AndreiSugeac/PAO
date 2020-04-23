package collections.list.linkedlist;

/*
    List
    Queue
        Deque
            Array Deque
            Linked List
 */

import java.util.LinkedList;

public class Ex1 {

    public static void main(String[] args) {

        LinkedList<String> list1 = new LinkedList<>();
        list1.add("aa");
        list1.add(1, "bb");
        list1.add(0, "cc");
        System.out.println(list1);
        list1.addFirst("gg");
        list1.addLast("hh");
        System.out.println(list1);
        list1.remove("aa");
        list1.remove(1);
        System.out.println(list1);

        System.out.println(list1.removeFirst());
        System.out.println(list1);

        list1.addLast("bb");
        System.out.println(list1);
        list1.removeFirstOccurrence("bb");
        System.out.println(list1);
    }


}
