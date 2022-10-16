package by.tms.lesson29сollection.task4;

import java.util.Iterator;
import java.util.Objects;

public class UserLinkedList<E> implements Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    static final int INDEX_IF_NOT_FIND_ELEMENT = -1;

    public UserLinkedList() {
        first = new Node<>(null, null, null);
        last = new Node<>(null, null, null);
    }

    public UserLinkedList<E> add(E element) {

        if (isEpmty()) {
            Node<E> newNode = new Node<>(element, first, last);
            first.next = newNode;
            last.preview = newNode;
        } else {
            Node<E> newNode = new Node<>(element, last.preview, last);
            last.preview.next = newNode;
            last.preview = newNode;
        }
        size++;
        return this;
    }

    public UserLinkedList<E> add(E element, int index) {

        Node<E> oldNode = getNode(index);
        Node<E> newNode = new Node<>(element, oldNode.preview, oldNode);
        oldNode.preview.next = newNode;
        oldNode.preview = newNode;
        size++;
        return this;
    }

    public UserLinkedList<E> addFirst(E element) {
        if (isEpmty()) {
            Node<E> newNode = new Node<E>(element, first, last);
            first.next = newNode;
            last.preview = newNode;
        } else {
            Node<E> newNode = new Node<E>(element, first, first.next);
            first.next.preview = newNode;
            first.next = newNode;
        }
        size++;
        return this;
    }

    public UserLinkedList<E> remove(int index) {
        indexTestAndTrowException(index);

        Node<E> nodeRemove = getNode(index);
        nodeRemove.preview.next = nodeRemove.next;
        nodeRemove.next.preview = nodeRemove.preview;
        size--;
        return this;
    }

    public UserLinkedList<E> removeFirst() {
        testIsEmptyAndThrowException();

        if (size == 1) {
            first.next = last;
            last.preview = first;
        } else {
            first.next = first.next.next;
            first.next.next.preview = first;
        }
        size--;
        return this;
    }

    public UserLinkedList<E> removeLast() {
        testIsEmptyAndThrowException();

        if (size == 1) {
            first.next = last;
            last.preview = first;
        } else {
            last.preview = last.preview.preview;
            last.preview.preview.next = last;
        }
        size--;
        return this;
    }

    public E get(int index) {
        return getNode(index).item;
    }

    public E getFirst() {
        testIsEmptyAndThrowException();
        return first.next.item;
    }

    public E getLast() {
        testIsEmptyAndThrowException();
        return last.preview.item;
    }

    public int size() {
        return size;
    }

    public boolean isEpmty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int indexOf(Object obj) {
        if (isEpmty()) {
            return INDEX_IF_NOT_FIND_ELEMENT;
        }

        Node<E> nodeFind = first.next;
        boolean isContains = Objects.equals(nodeFind.item, obj);
        int index = 0;

        while (index < size && !isContains) {
            index++;
            nodeFind = nodeFind.next;
            isContains = Objects.equals(nodeFind.item, obj);
        }

        return isContains ? index : INDEX_IF_NOT_FIND_ELEMENT;
    }

    public int lastIndexOf(Object obj) {
        if (isEpmty()) {
            return INDEX_IF_NOT_FIND_ELEMENT;
        }

        Node<E> nodeFind = last.preview;
        boolean isContains = Objects.equals(nodeFind.item, obj);
        int index = size - 1;

        while (index >= 0 && !isContains) {
            index--;
            nodeFind = nodeFind.preview;
            isContains = Objects.equals(nodeFind.item, obj);
        }
        return isContains ? index : INDEX_IF_NOT_FIND_ELEMENT;
    }

    public boolean isContains(Object obj) {
        if (isEpmty()) {
            return false;
        }

        Node<E> nodeFind = first.next;
        boolean isContains = Objects.equals(nodeFind.item, obj);

        while (nodeFind.next != null && !isContains) {
            nodeFind = nodeFind.next;
            isContains = Objects.equals(nodeFind.item, obj);
        }
        return isContains;
    }


    private Node<E> getNode(int index) {
        indexTestAndTrowException(index);

        Node<E> node;

        if (index <= Math.ceil(size / 2)) {
            node = first.next;
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }
        } else {
            node = last.preview;
            for (int i = size - 2; i >= index; i--) {
                node = node.preview;
            }
        }
        return node;
    }

    private void indexTestAndTrowException(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index is less than zero");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("index is greater than possible");
        }
    }

    private void testIsEmptyAndThrowException() {
        if (isEpmty()) {
            throw new RuntimeException("List is empty");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new UserLinkedListIterator();
    }

    private static class Node<E> {
        E item;
        Node<E> preview;
        Node<E> next;

        public Node(E item, Node<E> preview, Node<E> next) {
            this.item = item;
            this.preview = preview;
            this.next = next;
        }
    }

    private class UserLinkedListIterator implements Iterator<E> {

        Node<E> node = first;

        @Override
        public boolean hasNext() {
            return !(Objects.equals(node.next, last));
        }

        @Override
        public E next() {
            node = node.next;
            return node.item;
        }
    }
}