 /**
 * HOW IT WORKS:
 * - A linked list is made of "nodes".
 * - Each node stores:
 *        1. A PatientRecord
 *        2. A pointer (reference) to the next node
 *
 * - The list starts at "head".
 * - To insert, we walk to the end and attach a new node.
 * - To search, we walk through each node until we find the ID.
 * - To delete, we relink the pointers to skip over the deleted node.
 *
 * Supported Operations:
 *  - insertRecord()
 *  - searchRecord()
 *  - deleteRecord()
 *  - traverseRecords()
 *
 * Algorithms Used:
 *  - Insert: O(n)
 *  - Search: O(n)
 *  - Delete: O(n)
 *  - Traverse: O(n)
 */
public class LinkedList {

    /**
     * Inner Node class
     * Must be PUBLIC + STATIC so BenchmarkTests can access it.
     */
    public static class Node {
        PatientRecord record;
        Node next;

        Node(PatientRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    /** Head of the list — must be PUBLIC for BenchmarkTests */
    public Node head;

    public LinkedList() {
        head = null;
    }

    public void insertRecord(PatientRecord record) {
        Node newNode = new Node(record);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }

    public PatientRecord searchRecord(int id) {
        Node current = head;
        while (current != null) {
            if (current.record.id == id) return current.record;
            current = current.next;
        }
        return null;
    }

    public boolean deleteRecord(int id) {
        if (head == null) return false;
        if (head.record.id == id) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.record.id == id) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void traverseRecords() {
        Node current = head;
        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }
}

