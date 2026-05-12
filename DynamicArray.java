
/**
 * DynamicArray class
 *
 * HOW IT WORKS (Breakdown):
 * - We start with a normal fixed-size array.
 * - When the array becomes full, we create a NEW array that is twice as big.
 * - Then we copy all old elements into the new array.
 * - This allows the structure to "grow" as more PatientRecords are added.
 *
 * Supported Operations:
 *  - insertRecord()   → add a new record
 *  - searchRecord()   → find a record by ID
 *  - deleteRecord()   → remove a record by ID
 *  - traverseRecords() → print all records
 *
 * Algorithms Used:
 *  - Insert: append to end (O(1))
 *  - Search: linear search (O(n))
 *  - Delete: shift elements left (O(n))
 *  - Traverse: simple loop (O(n))
 */
public class DynamicArray {

    private PatientRecord[] array;  // internal storage
    private int size;               // number of elements currently stored

    /**
     * Constructor: start with a small array (size 10).
     * We will grow it automatically when needed.
     */
    public DynamicArray() {
        array = new PatientRecord[10];
        size = 0;
    }

    /**
     * Inserts a new PatientRecord at the end of the array.
     * If the array is full, we resize it first.
     */
    public void insertRecord(PatientRecord record) {
        if (size == array.length) {
            resizeArray();
        }
        array[size] = record;
        size++;
    }

    /**
     * Doubles the size of the internal array.
     * This is what makes the structure "dynamic".
     */
    private void resizeArray() {
        PatientRecord[] newArray = new PatientRecord[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    /**
     * Searches for a PatientRecord by ID.
     * Uses a simple linear search.
     */
    public PatientRecord searchRecord(int id) {
        for (int i = 0; i < size; i++) {
            if (array[i].id == id) return array[i];
        }
        return null;
    }

    /**
     * Deletes a record by ID.
     * After removing the record, we shift all elements left.
     */
    public boolean deleteRecord(int id) {
        for (int i = 0; i < size; i++) {
            if (array[i].id == id) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Traverses (loops through) all stored records and prints them.
     */
    public void traverseRecords() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * Returns the number of stored records.
     * REQUIRED for BenchmarkTests traversal timing.
     */
    public int size() {
        return this.size;
    }
}

