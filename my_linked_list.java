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

public class Main {

    public static void operate(MyList<?> list) {

        try {

            System.out.println("Size: " + list.size());
            System.out.println("Is Empty: " + list.isEmpty());
            System.out.println("First Element: " + list.get(0));

        } catch (IndexOutOfBoundsException | IllegalStateException e) {

            System.out.println("Exception: " + e.getMessage());

        } finally {

            System.out.println("Operation Completed");
            System.out.println("-------------------");
        }
    }

    public static void main(String[] args) {

        MyList<Integer> list1 = new MyArrayList<>();
        MyList<String> list2 = new MyLinkedList<>();

        try {

            list1.add(10);
            list1.add(20);
            list1.insert(15, 1);

            list2.add("A");
            list2.add("B");
            list2.delete(0);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

        operate(list1);
        operate(list2);

        try {

            list1.get(10);

        } catch (Exception e) {

            System.out.println("Generated Exception: " + e.getMessage());

        }
    }
}

