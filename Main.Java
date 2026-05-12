
public static void main(String[] args) {

    // -----------------------------------------
    // USER INPUT MODE (Scanner)
    // -----------------------------------------
    Scanner sc = new Scanner(System.in);

    System.out.println("Do you want to enter patients manually?");
    System.out.println("1 = Yes, 2 = No (skip to demos/benchmarks)");
    int mode = sc.nextInt();

    if (mode == 1) {

        // Show example patient
        System.out.println("\nEXAMPLE PATIENT (for reference):");
        System.out.println("--------------------------------");
        System.out.println("ID: 101");
        System.out.println("Age: 45");
        System.out.println("Gender: Male");
        System.out.println("Condition: Flu");
        System.out.println("Hospital: UMMS");
        System.out.println("Admission Type: WalkIn");
        System.out.println("Billing Amount: 1200.0");
        System.out.println("Priority Level: 1 (Emergency)");
        System.out.println("--------------------------------");

        // Show list of fields user must fill in
        System.out.println("\nYou will need to enter the following for EACH patient:");
        System.out.println("1. Patient ID (number)");
        System.out.println("2. Age (number)");
        System.out.println("3. Gender (Male/Female)");
        System.out.println("4. Condition (one word or use _ )");
        System.out.println("5. Hospital (one word or use _ )");
        System.out.println("6. Admission Type (one word or use _ )");
        System.out.println("7. Billing Amount (number)");
        System.out.println("8. Priority Level (0 = Normal, 1 = Emergency)");
        System.out.println("--------------------------------\n");

        // Get number of patients
        System.out.print("How many patients do you want to enter? ");
        int count = sc.nextInt();

        // Store user-entered patients
        PriorityQueue pqUser = new PriorityQueue(count);
        LinkedList llUser = new LinkedList();

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Enter Patient " + (i + 1) + " ---");

            System.out.print("ID: ");
            int id = sc.nextInt();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Gender (Male/Female): ");
            String gender = sc.next();

            System.out.print("Condition: ");
            String condition = sc.next();

            System.out.print("Hospital: ");
            String hospital = sc.next();

            System.out.print("Admission Type: ");
            String admissionType = sc.next();

            System.out.print("Billing Amount: ");
            double billing = sc.nextDouble();

            System.out.print("Priority Level (0 = Normal, 1 = Emergency): ");
            int priorityLevel = sc.nextInt();

            PatientRecord p = new PatientRecord(
                    id, age, gender, condition,
                    hospital, admissionType, billing, priorityLevel
            );

            // Add to both structures
            pqUser.insertRecord(p);
            llUser.insertRecord(p);
        }

        // Choose processing mode
        System.out.println("\nChoose Processing Mode:");
        System.out.println("1 = First Come First Serve (LinkedList)");
        System.out.println("2 = Emergency Priority (PriorityQueue)");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("\nProcessing Patients (FCFS):");
            llUser.traverseRecords();
        } else {
            System.out.println("\nProcessing Patients (Emergency Priority):");
            while (!pqUser.isEmpty()) {
                System.out.println(pqUser.removeHighestPriority());
            }
        }

        System.out.println("\n--- End of Manual Input Mode ---\n");
    }

    // -----------------------------------------
    // ORIGINAL DEMO CODE (unchanged)
    // -----------------------------------------
    System.out.println("Patient Record Data Structures Demo\n");

    PatientRecord[] sampleData = BenchmarkTests.generateTestData(10);

    System.out.println("DynamicArray Demo:");
    DynamicArray da = new DynamicArray();
    for (PatientRecord record : sampleData) da.insertRecord(record);
    da.traverseRecords();

    System.out.println("\nLinkedList Demo:");
    LinkedList ll = new LinkedList();
    for (PatientRecord record : sampleData) ll.insertRecord(record);
    ll.traverseRecords();

    System.out.println("\nHashTable Demo:");
    HashTable ht = new HashTable();
    for (PatientRecord record : sampleData) ht.insertRecord(record);
    ht.traverseRecords();

    System.out.println("\nPriorityQueue Demo (Emergency First):");
    PriorityQueue pq = new PriorityQueue(20);
    for (PatientRecord record : sampleData) pq.insertRecord(record);
    pq.traverseRecords();

    System.out.println("\nRemoving highest priority (emergency) patient:");
    System.out.println(pq.removeHighestPriority());

    // -----------------------------------------
    // BENCHMARKS
    // -----------------------------------------
    System.out.println("\nRunning Performance Benchmarks");
    BenchmarkTests.runAllTests(100);

    System.out.println("\nAll tests completed.");
}

