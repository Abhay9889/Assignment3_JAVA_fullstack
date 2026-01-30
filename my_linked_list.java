public class MyLinkedList<T> implements MyList<T> {

    private class Node {

        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T element) {

        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        size++;
    }

    public void insert(T element, int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node newNode = new Node(element);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {

            Node temp = head;

            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }

        size++;
    }

    public T get(int index) {

        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    public void delete(int index) {

        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (index == 0) {
            head = head.next;
        } else {

            Node temp = head;

            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
        }

        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
