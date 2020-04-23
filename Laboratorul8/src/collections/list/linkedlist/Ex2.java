package collections.list.linkedlist;

import java.util.LinkedList;

public class Ex2 {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.offer("c");
        System.out.println(list);
        list.offerFirst("i");
        list.offerLast("z");
        System.out.println(list);
        System.out.println(list.element()); // returneaza head ul .. si returneaza NoSuchElementException if list is emp

        System.out.println(list.peek()); // tot head ul il returneaza
        list.poll(); // elimina primul element
        System.out.println(list);

        // from deque
        System.out.println(list.pop());

    }

}
