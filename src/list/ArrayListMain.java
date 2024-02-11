package list;

import list.core.GBList;
import list.core.impl.GBArrayList;
import list.core.impl.GBLinkedList;

public class ArrayListMain {
    public static void main(String[] args) {
        GBList<Integer> list = new GBArrayList<>();
        list.add(2);
        list.add(3);
        list.remove(1);
        System.out.println(list);
    }
}
