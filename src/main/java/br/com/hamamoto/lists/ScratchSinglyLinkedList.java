package br.com.hamamoto.lists;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ScratchSinglyLinkedList<T> implements ScratchList<T> {

    public static final int EXTRA_COMMA_THRESHOLD = 2;

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private int size;

    private Node<T> head;
    private Node<T> last;

    public ScratchSinglyLinkedList() {
        this.size = 0;
    }

    public ScratchSinglyLinkedList(Node<T> head) {
        this.head = head;

        while (Objects.nonNull(head)) {
            size++;
            last = head;
            head = head.getNext();
        }

    }

    @Override
    public void add(T item) {
        var node = new Node<T>(item);

        if (Objects.isNull(head)) {
            head = node;
        } else {
            last.next = node;
        }
        last = node;

        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        var node = head;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node.getData();
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            head = head.getNext();
        } else {
            var node = getNode(index - 1);
            node.setNext(node.getNext().getNext());

            if (index == size) {
                last = getNode(size - 1);
            }
        }

        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Node<T>> iterator() {
        final AtomicReference<Node<T>> cursor = new AtomicReference<>(head);

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return Objects.nonNull(cursor.get().getNext());
            }

            @Override
            public Node<T> next() {
                var current = cursor.get();
                cursor.set(cursor.get().next);
                return current;
            }
        };
    }

    private void checkIndex(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private Node<T> getNode(int index) {
        checkIndex(index);

        var node = head;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }

    public Node<T> getHead() {
        return head;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[");

        var current = head;

        while (Objects.nonNull(current)) {
            sb.append(current.data).append(", ");
            current = current.getNext();
        }

        if (sb.length() > EXTRA_COMMA_THRESHOLD) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }

        sb.append("]");

        return sb.toString();
    }

    /**
     *<a href="https://leetcode.com/problems/reverse-linked-list/"> LeetCode problem </a> - Reverse a linked list
     * */
    public void reverse() {
        last = head;

        Node<T> previous = null;

        while (Objects.nonNull(head)) {
            var next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }

        head = previous;
    }
}
