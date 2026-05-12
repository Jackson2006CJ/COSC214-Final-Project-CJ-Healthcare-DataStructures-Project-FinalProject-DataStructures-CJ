/**
 * HashTable class
 *
 * This class implements a simple hash table from scratch using
 * SEPARATE CHAINING to handle collisions.
 *
 * HOW IT WORKS :
 * A hash table stores data in "buckets".
 *
 * 1. We take the patient ID and run it through a hash function.
 * 2. The hash function gives us a bucket index.
 * 3. Each bucket is a LinkedList of PatientRecords.
 *
 * Why a LinkedList?
 * -----------------
 * Because multiple IDs can hash to the same bucket.
 * This is called a "collision".
 *
 * Example:
 *   hash(101) = 5
 *   hash(205) = 5
 *
 * Both records go into bucket 5, but in a linked list.
 *
 * Supported Operations:
 *  - insertRecord()
 *  - searchRecord()
 *  - deleteRecord()
 *  - traverseRecords()
 */
public class HashTable {

    private final int BUCKET_COUNT = 1000;

    /** REQUIRED for BenchmarkTests */
    public int capacity = BUCKET_COUNT;

    /** REQUIRED for BenchmarkTests */
    public Node[] table;

    /**
     * REQUIRED by BenchmarkTests:
     * A PUBLIC STATIC Node class directly inside HashTable.
     *
     * BenchmarkTests expects:
     *     HashTable.Node node = ...
     */
    public static class Node {
        public PatientRecord record;
        public Node next;

        public Node(PatientRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    /**
     * Constructor: create an array of empty buckets.
     */
    public HashTable() {
        table = new Node[BUCKET_COUNT];
    }

    /**
     * Hash function: id % BUCKET_COUNT
     */
    private int hash(int id) {
        return id % BUCKET_COUNT;
    }

    /**
     * Insert a record into the correct bucket.
     */
    public void insertRecord(PatientRecord record) {
        int index = hash(record.id);

        Node head = table[index];

        // Update existing
        Node current = head;
        while (current != null) {
            if (current.record.id == record.id) {
                current.record = record;
                return;
            }
            current = current.next;
        }

        // Insert at head
        Node newNode = new Node(record);
        newNode.next = head;
        table[index] = newNode;
    }

    /**
     * Search for a record by ID.
     */
    public PatientRecord searchRecord(int id) {
        int index = hash(id);
        Node current = table[index];

        while (current != null) {
            if (current.record.id == id) return current.record;
            current = current.next;
        }
        return null;
    }

    /**
     * Delete a record by ID.
     */
    public boolean deleteRecord(int id) {
        int index = hash(id);
        Node head = table[index];

        if (head == null) return false;

        if (head.record.id == id) {
            table[index] = head.next;
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

    /**
     * Traverse all buckets and print all records.
     */
    public void traverseRecords() {
        for (int i = 0; i < BUCKET_COUNT; i++) {
            Node current = table[i];
            while (current != null) {
                System.out.println(current.record);
                current = current.next;
            }
        }
    }
}

