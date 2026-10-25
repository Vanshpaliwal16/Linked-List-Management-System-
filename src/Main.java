import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SinglyLinkedList singly = new SinglyLinkedList();
    private static final DoublyLinkedList doubly = new DoublyLinkedList();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==============================================");
            System.out.println("       LINKED LIST MANAGEMENT SYSTEM");
            System.out.println("==============================================");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly Linked List");
            System.out.println("4. Exit");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> singlyMenu();
                case 2 -> doublyMenu();
                case 3 -> compareLists();
                case 4 -> {
                    System.out.println("Thank you for using Linked List Management System.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void singlyMenu() {
        while (true) {
            System.out.println("\n********** Operation on Singly Linked List **********");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle Element");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Exit");

            int choice = readInt("Enter the choice: ");

            switch (choice) {
                case 1 -> singly.insertBeginning(readInt("Enter value: "));
                case 2 -> singly.insertEnd(readInt("Enter value: "));
                case 3 -> singly.insertAtPosition(
                        readInt("Enter position (1-based): "),
                        readInt("Enter value: "));
                case 4 -> singly.insertAfter(
                        readInt("Enter existing value: "),
                        readInt("Enter new value: "));
                case 5 -> singly.insertBefore(
                        readInt("Enter existing value: "),
                        readInt("Enter new value: "));
                case 6 -> singly.deleteBeginning();
                case 7 -> singly.deleteEnd();
                case 8 -> singly.deleteAtPosition(readInt("Enter position (1-based): "));
                case 9 -> singly.deleteByValue(readInt("Enter value to delete: "));
                case 10 -> {
                    int value = readInt("Enter value to search: ");
                    int position = singly.search(value);
                    System.out.println(position == -1
                            ? "Value not found."
                            : "Value found at position " + position + ".");
                }
                case 11 -> singly.update(
                        readInt("Enter old value: "),
                        readInt("Enter new value: "));
                case 12 -> singly.display();
                case 13 -> System.out.println("Count = " + singly.countNodes());
                case 14 -> printResult("Maximum", singly.findMaximum());
                case 15 -> printResult("Minimum", singly.findMinimum());
                case 16 -> printResult("Middle", singly.findMiddle());
                case 17 -> singly.reverse();
                case 18 -> singly.sort();
                case 19 -> singly.removeDuplicates();
                case 20 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void doublyMenu() {
        while (true) {
            System.out.println("\n********** Operation on Doubly Linked List **********");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Exit");

            int choice = readInt("Enter the choice: ");

            switch (choice) {
                case 1 -> doubly.insertBeginning(readInt("Enter value: "));
                case 2 -> doubly.insertEnd(readInt("Enter value: "));
                case 3 -> doubly.insertAtPosition(
                        readInt("Enter position (1-based): "),
                        readInt("Enter value: "));
                case 4 -> doubly.insertAfter(
                        readInt("Enter existing value: "),
                        readInt("Enter new value: "));
                case 5 -> doubly.insertBefore(
                        readInt("Enter existing value: "),
                        readInt("Enter new value: "));
                case 6 -> doubly.deleteBeginning();
                case 7 -> doubly.deleteEnd();
                case 8 -> doubly.deleteAtPosition(readInt("Enter position (1-based): "));
                case 9 -> doubly.deleteByValue(readInt("Enter value to delete: "));
                case 10 -> {
                    int value = readInt("Enter value to search: ");
                    int position = doubly.search(value);
                    System.out.println(position == -1
                            ? "Value not found."
                            : "Value found at position " + position + ".");
                }
                case 11 -> doubly.update(
                        readInt("Enter old value: "),
                        readInt("Enter new value: "));
                case 12 -> doubly.displayForward();
                case 13 -> doubly.displayBackward();
                case 14 -> System.out.println("Count = " + doubly.countNodes());
                case 15 -> printResult("Maximum", doubly.findMaximum());
                case 16 -> printResult("Minimum", doubly.findMinimum());
                case 17 -> printResult("Middle", doubly.findMiddle());
                case 18 -> doubly.reverse();
                case 19 -> doubly.sort();
                case 20 -> doubly.removeDuplicates();
                case 21 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void compareLists() {
        System.out.println("\n========== Singly vs Doubly Linked List ==========");
        System.out.println("Singly: each node stores data and next reference.");
        System.out.println("Doubly: each node stores data, previous and next references.");
        System.out.println("Singly uses less memory per node.");
        System.out.println("Doubly supports forward and backward traversal.");
        System.out.println("Both support dynamic insertion and deletion.");
    }

    private static void printResult(String label, Integer value) {
        if (value == null) {
            System.out.println(label + ": list is empty.");
        } else {
            System.out.println(label + " = " + value);
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Please enter a valid integer.");
            scanner.next();
        }
    }
}
