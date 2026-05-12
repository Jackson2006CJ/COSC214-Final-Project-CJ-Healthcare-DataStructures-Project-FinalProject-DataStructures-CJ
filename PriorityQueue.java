
/**
 * PriorityQueue class
 *
 * HOW IT WORKS:
 * - Binary heap stored in an array.
 * - priorityLevel:
 *        1 = emergency (HIGH)
 *        0 = normal (LOW)
 *
 * Supported Operations:
 *  - insertRecord()
 *  - removeHighestPriority()
 *  - peek()
 *  - traverseRecords()
 */
public class PriorityQueue {

    private PatientRecord[] heap;
    private int size;

    public PriorityQueue(int capacity) {
        heap = new PatientRecord[capacity];
        size = 0;
    }

    public void insertRecord(PatientRecord record) {
        if (size == heap.length) return;
        heap[size] = record;
        bubbleUp(size);
        size++;
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index].priorityLevel > heap[parent].priorityLevel) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    public PatientRecord removeHighestPriority() {
        if (size == 0) return null;
        PatientRecord highest = heap[0];
        heap[0] = heap[size - 1];
        size--;
        bubbleDown(0);
        return highest;
    }

    private void bubbleDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && heap[left].priorityLevel > heap[largest].priorityLevel)
                largest = left;

            if (right < size && heap[right].priorityLevel > heap[largest].priorityLevel)
                largest = right;

            if (largest == index) break;

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        PatientRecord temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public PatientRecord peek() {
        return size == 0 ? null : heap[0];
    }

    public void traverseRecords() {
        for (int i = 0; i < size; i++) {
            System.out.println(heap[i]);
        }
    }

    /**
     * REQUIRED for BenchmarkTests
     */
    public int size() {
        return this.size;
    }

    /**
     * REQUIRED for Main (manual input mode)
     */
    public boolean isEmpty() {
        return size == 0;
    }
}

