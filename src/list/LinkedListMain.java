package list;

import list.core.impl.GBLinkedList;

public class LinkedListMain {
    public static void main(String[] args) {

        GBLinkedList<Integer> linkedList = new GBLinkedList<>();
        System.out.println(linkedList);
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.addFirst(-1);
        System.out.println(linkedList);
        System.out.println(linkedList.size());

        linkedList.remove(1);
        System.out.println(linkedList);
        System.out.println(linkedList.size());

        System.out.println(linkedList.get(linkedList.size()-1));

        for (Object x : linkedList){
            System.out.print(x + " ");
        }
    }
}
