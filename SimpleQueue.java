
/**
 * SimpleQueue class
 * ------------------
 * This class implements a basic FIFO (First-In, First-Out) queue
 * completely from scratch.
 *
 * HOW IT WORKS (Breakdown):
 * ------------------------------------
 * - A queue processes items in the order they arrive.
 * - The first patient added is the first patient processed.
 *
 * We use a simple array to store PatientRecords:
 *      front → index of the first element
 *      rear  → index where the next element will be added
 *
 * When we enqueue:
 *      - We add a record at 'rear'
 *      - Then increase 'rear'
 *
 * When we dequeue:
 *      - We return the record at 'front'
 *      - Then increase 'front'
 *
 * Supported Operations:
 *  - enqueue() → add patient to queue
 *  - dequeue() → remove next patient
 *  - isEmpty() → check if queue is empty
 *  - traverseRecords() → print all patients in queue
 */
public class SimpleQueue {

    private PatientRecord[] queueArray;  // internal array storage
    private int front;                   // index of first element
    private int rear;                    // index where next element goes
    private int capacity;                // max size of queue

    /**
     * Constructor: create a queue with a fixed capacity.
     * You can adjust the size depending on your dataset.
     */
    public SimpleQueue(int capacity) {
        this.capacity = capacity;
        queueArray = new PatientRecord[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * Adds a new PatientRecord to the queue.
     * This simulates a patient arriving at the hospital.
     */
    public void enqueue(PatientRecord record) {
        if (rear == capacity) {
            System.out.println("Queue is full — cannot add more patients.");
            return;
        }

        queueArray[rear] = record;
        rear++;  // move rear forward
    }

    /**
     * Removes and returns the next patient in line.
     * This simulates processing the next patient.
     */
    public PatientRecord dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty — no patients to process.");
            return null;
        }

        PatientRecord record = queueArray[front];
        front++;  // move front forward
        return record;
    }

    /**
     * Checks if the queue is empty.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Prints all patients currently in the queue.
     */
    public void traverseRecords() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        for (int i = front; i < rear; i++) {
            System.out.println(queueArray[i]);
        }
    }
}

