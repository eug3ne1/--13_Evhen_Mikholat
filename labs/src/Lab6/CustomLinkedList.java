package Lab6;

import java.util.*;

public class CustomLinkedList<Stone>{


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

    public boolean add(Stone  item) {
        Node<Stone> newNode = new Node<>(item);
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

    public void add(int index, Stone item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            Node<Stone> newNode = new Node<>(item);
            newNode.next = head;
            head = newNode;
        } else {
            Node<Stone> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<Stone> newNode = new Node<>(item);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public Stone remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<Stone> removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else {
            Node<Stone> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = current.next.next;
        }
        size--;
        return removedNode.data;
    }

    public boolean remove(Object o) {
        Node<Stone> current = head;
        Node<Stone> prev = null;
        while (current != null) {
            if (Objects.equals(o, current.data)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

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

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(Stone o) {
        return indexOf(o) != -1;
    }
    public boolean containsAll(Collection<Stone> collection) {
        Objects.requireNonNull(collection);
        for (Stone item : collection) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends Stone> collection) {
        boolean modified = false;
        for (Stone item : collection) {
            if (add(item)) {
                modified = true;
            }
        }
        return modified;
    }

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



    public boolean removeAll(Collection<Stone> collection) {
        Objects.requireNonNull(collection);
        boolean modified = false;
        for (Stone item : collection) {
            while (contains(item)) {
                remove(item);
                modified = true;
            }
        }
        return modified;
    }

    public boolean retainAll(Collection<Stone> collection) {
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
    public void reverse() {
        Node<Stone> prev = null;
        Node<Stone> current = head;
        Node<Stone> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public CustomLinkedList<Stone> subList(int fromIndex, int toIndex) {
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

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomLinkedList)) {
            return false;
        }
        CustomLinkedList<?> other = (CustomLinkedList<?>) o;
        if (size != other.size) {
            return false;
        }
        Node<Stone> current = head;
        Node<?> otherCurrent = other.head;
        while (current != null) {
            if (!Objects.equals(current.data, otherCurrent.data)) {
                return false;
            }
            current = current.next;
            otherCurrent = otherCurrent.next;
        }
        return true;
    }





}
