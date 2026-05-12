
/**
 * BenchmarkTests class
 * This class runs performance tests on all four data structures:
 *
 *  - DynamicArray
 *  - LinkedList
 *  - HashTable
 *  - PriorityQueue
 *
 * It measures the time for:
 *  - Insert
 *  - Search
 *  - Delete
 *  - Traverse
 *
 * HOW IT WORKS (BreakDown):
 * We generate a list of fake PatientRecords (no CSV needed for testing).
 * Then we run each operation and measure how long it takes using:
 *
 *      System.nanoTime();
 *
 * The results printed from this file can be used directly
 * in your Phase 2 report and presentation.
 */
public class BenchmarkTests {

    /**
     * Generates an array of fake PatientRecords for testing.
     * Each record gets:
     *   - unique ID
     *   - random age
     *   - random billing amount
     *   - random priorityLevel (0 or 1)
     */
    public static PatientRecord[] generateTestData(int count) {
        PatientRecord[] data = new PatientRecord[count];

        for (int i = 0; i < count; i++) {
            int id = i + 1;
            int age = 20 + (i % 60);
            String gender = (i % 2 == 0) ? "Male" : "Female";
            String condition = "Condition_" + (i % 10);
            String hospital = "Hospital_" + (i % 5);
            String admissionType = "Type_" + (i % 3);
            double billing = 1000 + (i * 2.5);
            int priorityLevel = (i % 5 == 0) ? 1 : 0;

            data[i] = new PatientRecord(id, age, gender, condition,
                    hospital, admissionType, billing, priorityLevel);
        }

        return data;
    }

    /**
     * Measures insert time.
     */
    public static long benchmarkInsert(Object structure, PatientRecord[] data) {
        long start = System.nanoTime();

        for (PatientRecord record : data) {
            if (structure instanceof DynamicArray) {
                ((DynamicArray) structure).insertRecord(record);
            } else if (structure instanceof LinkedList) {
                ((LinkedList) structure).insertRecord(record);
            } else if (structure instanceof HashTable) {
                ((HashTable) structure).insertRecord(record);
            } else if (structure instanceof PriorityQueue) {
                ((PriorityQueue) structure).insertRecord(record);
            }
        }

        return System.nanoTime() - start;
    }

    /**
     * Measures search time.
     */
    public static long benchmarkSearch(Object structure, int searchCount) {
        long start = System.nanoTime();

        for (int id = 1; id <= searchCount; id++) {
            if (structure instanceof DynamicArray) {
                ((DynamicArray) structure).searchRecord(id);
            } else if (structure instanceof LinkedList) {
                ((LinkedList) structure).searchRecord(id);
            } else if (structure instanceof HashTable) {
                ((HashTable) structure).searchRecord(id);
            } else if (structure instanceof PriorityQueue) {
                ((PriorityQueue) structure).peek();
            }
        }

        return System.nanoTime() - start;
    }

    /**
     * Measures delete time.
     */
    public static long benchmarkDelete(Object structure, int deleteCount) {
        long start = System.nanoTime();

        for (int id = 1; id <= deleteCount; id++) {
            if (structure instanceof DynamicArray) {
                ((DynamicArray) structure).deleteRecord(id);
            } else if (structure instanceof LinkedList) {
                ((LinkedList) structure).deleteRecord(id);
            } else if (structure instanceof HashTable) {
                ((HashTable) structure).deleteRecord(id);
            } else if (structure instanceof PriorityQueue) {
                ((PriorityQueue) structure).removeHighestPriority();
            }
        }

        return System.nanoTime() - start;
    }

    /**
     * Measures traversal time WITHOUT printing records.
     * This keeps the console clean while still measuring performance.
     */
    public static long benchmarkTraverse(Object structure) {
        long start = System.nanoTime();

        // Simulate traversal without printing
        if (structure instanceof DynamicArray) {
            for (int i = 0; i < ((DynamicArray) structure).size(); i++) { }
        } else if (structure instanceof LinkedList) {
            LinkedList.Node current = ((LinkedList) structure).head;
            while (current != null) current = current.next;
        } else if (structure instanceof HashTable) {
            for (int i = 0; i < ((HashTable) structure).capacity; i++) {
                HashTable.Node node = ((HashTable) structure).table[i];
                while (node != null) node = node.next;
            }
        } else if (structure instanceof PriorityQueue) {
            for (int i = 0; i < ((PriorityQueue) structure).size(); i++) { }
        }

        return System.nanoTime() - start;
    }

    /**
     * Runs all benchmarks for a given dataset size.
     * Prints clean, readable timing tables.
     */
    public static void runAllTests(int count) {
        System.out.println("\nBenchmarking " + count + " Records\n");

        PatientRecord[] data = generateTestData(count);

        DynamicArray da = new DynamicArray();
        LinkedList ll = new LinkedList();
        HashTable ht = new HashTable();
        PriorityQueue pq = new PriorityQueue(count);

        System.out.println("Insert Times:");
        System.out.println("DynamicArray: " + benchmarkInsert(da, data) + " ns");
        System.out.println("LinkedList:   " + benchmarkInsert(ll, data) + " ns");
        System.out.println("HashTable:    " + benchmarkInsert(ht, data) + " ns");
        System.out.println("PriorityQueue:" + benchmarkInsert(pq, data) + " ns");

        System.out.println("\nSearch Times:");
        System.out.println("DynamicArray: " + benchmarkSearch(da, count) + " ns");
        System.out.println("LinkedList:   " + benchmarkSearch(ll, count) + " ns");
        System.out.println("HashTable:    " + benchmarkSearch(ht, count) + " ns");
        System.out.println("PriorityQueue:" + benchmarkSearch(pq, count) + " ns");

        System.out.println("\nDelete Times:");
        System.out.println("DynamicArray: " + benchmarkDelete(da, count / 2) + " ns");
        System.out.println("LinkedList:   " + benchmarkDelete(ll, count / 2) + " ns");
        System.out.println("HashTable:    " + benchmarkDelete(ht, count / 2) + " ns");
        System.out.println("PriorityQueue:" + benchmarkDelete(pq, count / 2) + " ns");

        System.out.println("\nTraverse Times:");
        System.out.println("DynamicArray: " + benchmarkTraverse(da) + " ns");
        System.out.println("LinkedList:   " + benchmarkTraverse(ll) + " ns");
        System.out.println("HashTable:    " + benchmarkTraverse(ht) + " ns");
        System.out.println("PriorityQueue:" + benchmarkTraverse(pq) + " ns");
    }
}

