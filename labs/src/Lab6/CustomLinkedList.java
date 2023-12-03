package Lab6;

import java.util.*;
import java.util.function.UnaryOperator;

public class CustomLinkedList<Stone> implements List<Stone>{


    private static class Node<Stone> {


        Stone data;
        Node<Stone> next;

        Node(Stone data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<Stone> head;
    private int size;
    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }




    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        Node<Stone> current = head;
        while (current != null) {
            if (Objects.equals(o, current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    @Override
    public Iterator<Stone> iterator() {
        return new Iterator<Stone>() {
            private Node<Stone> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Stone next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Stone data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<Stone> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public <Stone> Stone[] toArray(Stone[] a) {
        return null;
    }

    @Override
    public boolean add(Stone stone) {
        Node<Stone> newNode = new Node<>(stone);
        if (head == null) {
            head = newNode;
        } else {
            Node<Stone> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (Objects.equals(o, head.data)) {
            head = head.next;
            size--;
            return true;
        }
        Node<Stone> current = head;
        while (current.next != null) {
            if (Objects.equals(o, current.next.data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        Objects.requireNonNull(collection);
        for (Object item : collection) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Stone> c) {
        boolean modified = false;
        for (Stone item : c) {
            if (add(item)) {
                modified = true;
            }
        }
        return modified;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List<?> other = (List<?>) obj;
        if (this.size() != other.size()) {
            return false;
        }
        Iterator<Stone> thisIterator = this.iterator();
        Iterator<?> otherIterator = other.iterator();
        while (thisIterator.hasNext()) {
            Stone thisElement = thisIterator.next();
            Object otherElement = otherIterator.next();
            if (!(thisElement == null ? otherElement == null : thisElement.equals(otherElement))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Stone> collection) {
        Objects.requireNonNull(collection);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<Stone> newNode;
        Node<Stone> current = head;
        int currentIndex = 0;

        while (currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            for (Stone item : collection) {
                newNode = new Node<>(item);
                newNode.next = head;
                head = newNode;
                size++;
            }
        } else {
            for (Stone item : collection) {
                newNode = new Node<>(item);
                newNode.next = current.next;
                current.next = newNode;
                current = newNode;
                size++;
            }
        }

        return !collection.isEmpty();
    }


    @Override
    public boolean removeAll(Collection<?> collection) {
        Objects.requireNonNull(collection);
        boolean modified = false;
        for (Object item : collection) {
            while (remove(item)) {
                modified = true;
            }
        }
        return modified;
    }


    @Override
    public boolean retainAll(Collection<?> collection) {
        Objects.requireNonNull(collection);
        boolean modified = false;
        Node<Stone> current = head;
        while (current != null) {
            if (!collection.contains(current.data)) {
                remove(current.data);
                modified = true;
            }
            current = current.next;
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Stone get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<Stone> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public Stone set(int index, Stone element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<Stone> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Stone oldValue = current.data;
        current.data = element;
        return oldValue;
    }

    @Override
    public void add(int index, Stone element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            Node<Stone> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        } else {
            Node<Stone> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<Stone> newNode = new Node<>(element);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;

    }

    @Override
    public Stone remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<Stone> current = head;
        if (index == 0) {
            head = head.next;
            size--;
            return current.data;
        }
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node<Stone> removedNode = current.next;
        current.next = removedNode.next;
        size--;
        return removedNode.data;
    }


    @Override
    public int indexOf(Object o) {
        Node<Stone> current = head;
        int index = 0;
        while (current != null) {
            if (Objects.equals(o, current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        int currentIndex = 0;
        Node<Stone> current = head;

        while (current != null) {
            if (Objects.equals(o, current.data)) {
                lastIndex = currentIndex;
            }
            current = current.next;
            currentIndex++;
        }
        return lastIndex;
    }

    @Override
    public ListIterator<Stone> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Stone> listIterator(int index) {
        return null;
    }

    @Override
    public List<Stone> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("From Index: " + fromIndex + ", Stoneo Index: " + toIndex + ", Size: " + size);
        }
        CustomLinkedList<Stone> sub = new CustomLinkedList<>();
        Node<Stone> current = head;
        int index = 0;
        while (current != null) {
            if (index >= fromIndex && index < toIndex) {
                sub.add(current.data);
            }
            current = current.next;
            index++;
        }
        return sub;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<Stone> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }







}
