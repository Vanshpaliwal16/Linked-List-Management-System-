public class DoublyLinkedList {
    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public void insertBeginning(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        System.out.println("Inserted at beginning.");
    }

    public void insertEnd(int value) {
        Node newNode = new Node(value);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

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

        if (current.next == null) {
            insertEnd(value);
            return;
        }

        Node newNode = new Node(value);
        Node nextNode = current.next;

        newNode.prev = current;
        newNode.next = nextNode;
        current.next = newNode;
        nextNode.prev = newNode;

        System.out.println("Inserted at position " + position + ".");
    }

    public void insertAfter(int target, int value) {
        Node current = findNode(target);

        if (current == null) {
            System.out.println("Target value not found.");
            return;
        }

        if (current == tail) {
            insertEnd(value);
            return;
        }

        Node newNode = new Node(value);
        Node nextNode = current.next;

        newNode.prev = current;
        newNode.next = nextNode;
        current.next = newNode;
        nextNode.prev = newNode;

        System.out.println("Inserted after " + target + ".");
    }

    public void insertBefore(int target, int value) {
        Node current = findNode(target);

        if (current == null) {
            System.out.println("Target value not found.");
            return;
        }

        if (current == head) {
            insertBeginning(value);
            return;
        }

        Node newNode = new Node(value);
        Node previousNode = current.prev;

        newNode.prev = previousNode;
        newNode.next = current;
        previousNode.next = newNode;
        current.prev = newNode;

        System.out.println("Inserted before " + target + ".");
    }

    public void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println("Deleted from beginning.");
    }

    public void deleteEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

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
        for (int i = 1; i < position && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        if (current == tail) {
            deleteEnd();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;

        System.out.println("Deleted from position " + position + ".");
    }

    public void deleteByValue(int value) {
        Node current = findNode(value);

        if (current == null) {
            System.out.println("Value not found.");
            return;
        }

        if (current == head) {
            deleteBeginning();
            return;
        }

        if (current == tail) {
            deleteEnd();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;

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
        Node current = findNode(oldValue);

        if (current == null) {
            System.out.println("Value not found.");
            return;
        }

        current.data = newValue;
        System.out.println("Updated first occurrence.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("NULL (empty list)");
            return;
        }

        Node current = head;
        System.out.print("NULL <- ");

        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }

        System.out.println(" -> NULL");
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("NULL (empty list)");
            return;
        }

        Node current = tail;
        System.out.print("NULL <- ");

        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }

        System.out.println(" -> NULL");
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
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = current.prev;
            current.prev = next;
            current = next;
        }

        Node temp = head;
        head = tail;
        tail = temp;

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
                    Node duplicate = runner.next;
                    runner.next = duplicate.next;

                    if (duplicate.next != null) {
                        duplicate.next.prev = runner;
                    } else {
                        tail = runner;
                    }
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }

        System.out.println("Duplicates removed.");
    }

    private Node findNode(int value) {
        Node current = head;

        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }

        return null;
    }
}
