package list.core.impl;

import list.core.GBList;

import java.util.Iterator;

public class GBLinkedList<T> implements GBList, Iterable {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public GBLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    private static class Node<T> {
        T elem;
        Node<T> prev;
        Node<T> next;

        Node(Node<T> prev, T element, Node<T> next) {
            this.elem = element;
            this.prev = prev;
            this.next = next;
        }
    }

    /*
    Метод для добавления в конец списка
     */
    @Override
    public void add(Object elem) {
        if (size == 0) {
            first = new Node<>(null, (T) elem, null);
            last = first;
        } else {
            last.next = new Node<>(last, (T) elem, null);
            last = last.next;
        }
        size++;
    }

    /*
    Метод для добавления в начало списка
     */
    public void addFirst(Object elem) {
        if (size == 0) {
            first = new Node<>(null, (T) elem, null);
            last = first;
        } else {
            first.prev = new Node<>(null, (T) elem, first);
            first = first.prev;
        }
        size++;
    }

    /*
    Метод для удаления элемента
     */
    @Override
    public void remove(int index) {
        Node<T> temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }
    /*
    Метод для получения элемента
     */
    @Override
    public Object get(int index) {
        Node<T> temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.elem;
    }
    /*
    Метод для получения размера списка
     */
    @Override
    public int size() {
        return size;
    }
    /*
    Переопределенный итератор
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node<T> temp = first;

            @Override
            public boolean hasNext() {
                if (temp == null) return false;
                return true;
            }

            @Override
            public Object next() {
                Object mark = temp.elem;
                temp = temp.next;
                return mark;
            }
        };
    }
    /*
    Переопределенный toString
     */
    @Override
    public String toString() {
        if (first == null) return null;
        Node<T> temp = first;
        StringBuilder result = new StringBuilder();
        while (true) {
            if (temp.next != null) {
                result.append(temp.elem + " ");
                temp = temp.next;
            } else {
                result.append(temp.elem);
                break;
            }
        }
        return String.valueOf(result);
    }
}
