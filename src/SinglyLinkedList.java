public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void insertBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted at beginning.");
    }

    public void insertEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            System.out.println("Inserted at end.");
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        System.out.println("Inserted at end.");
    }

    public void insertAtPosition(int position, int value) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            insertBeginning(value);
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted at position " + position + ".");
    }

    public void insertAfter(int target, int value) {
        Node current = head;

        while (current != null && current.data != target) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Target value not found.");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted after " + target + ".");
    }

    public void insertBefore(int target, int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == target) {
            insertBeginning(value);
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Target value not found.");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted before " + target + ".");
    }

    public void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        head = head.next;
        System.out.println("Deleted from beginning.");
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            System.out.println("Deleted from end.");
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
        System.out.println("Deleted from end.");
    }

    public void deleteAtPosition(int position) {
        if (position < 1 || head == null) {
            System.out.println("Invalid position or empty list.");
            return;
        }

        if (position == 1) {
            deleteBeginning();
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Invalid position.");
            return;
        }

        current.next = current.next.next;
        System.out.println("Deleted from position " + position + ".");
    }

    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == value) {
            deleteBeginning();
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found.");
            return;
        }

        current.next = current.next.next;
        System.out.println("Deleted first occurrence of " + value + ".");
    }

    public int search(int value) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == value) {
                return position;
            }
            current = current.next;
            position++;
        }

        return -1;
    }

    public void update(int oldValue, int newValue) {
        Node current = head;

        while (current != null) {
            if (current.data == oldValue) {
                current.data = newValue;
                System.out.println("Updated first occurrence.");
                return;
            }
            current = current.next;
        }

        System.out.println("Value not found.");
    }

    public void display() {
        if (head == null) {
            System.out.println("NULL (empty list)");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public int countNodes() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public Integer findMaximum() {
        if (head == null) return null;

        int max = head.data;
        Node current = head.next;

        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }

        return max;
    }

    public Integer findMinimum() {
        if (head == null) return null;

        int min = head.data;
        Node current = head.next;

        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }

        return min;
    }

    public Integer findMiddle() {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public void reverse() {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
        System.out.println("List reversed.");
    }

    public void sort() {
        if (head == null || head.next == null) {
            System.out.println("List sorted.");
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;

            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("List sorted in ascending order.");
    }

    public void removeDuplicates() {
        Node current = head;

        while (current != null) {
            Node runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }

        System.out.println("Duplicates removed.");
    }
}
