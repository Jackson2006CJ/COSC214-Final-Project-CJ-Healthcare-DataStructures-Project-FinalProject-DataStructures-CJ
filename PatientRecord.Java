
/**
 * PatientRecord class
 *
 * This class represents a single patient's information.
 * It stores all the fields we need from the dataset.
 *
 * We also include a priorityLevel field:
 *      priorityLevel = 1 → Emergency patient
 *      priorityLevel = 0 → Normal patient
 *
 * This makes it easy to use PatientRecord objects inside
 * a Priority Queue for emergency-based processing.
 */
public class PatientRecord {

    // Basic patient information
    public int id;
    public int age;
    public String gender;
    public String condition;
    public String hospital;
    public String admissionType;
    public double billingAmount;

    // Priority for queue simulation
    // 1 = emergency, 0 = normal
    public int priorityLevel;

    /**
     * Constructor to create a new PatientRecord.
     * All fields are passed in so the record is complete.
     */
    public PatientRecord(int id, int age, String gender, String condition,
                         String hospital, String admissionType, double billingAmount,
                         int priorityLevel) {

        this.id = id;
        this.age = age;
        this.gender = gender;
        this.condition = condition;
        this.hospital = hospital;
        this.admissionType = admissionType;
        this.billingAmount = billingAmount;

        // Priority for queue simulation
        this.priorityLevel = priorityLevel;
    }

    /**
     * A simple method to print the record in a readable format.
     * This helps when traversing data structures.
     */
    public String toString() {
        return "ID: " + id +
                ", Age: " + age +
                ", Gender: " + gender +
                ", Condition: " + condition +
                ", Hospital: " + hospital +
                ", Admission Type: " + admissionType +
                ", Billing: $" + billingAmount +
                ", PriorityLevel: " + priorityLevel;
    }
}
