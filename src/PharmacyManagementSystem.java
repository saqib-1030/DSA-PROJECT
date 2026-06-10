import java.util.*;
public class PharmacyManagementSystem {

    // DSA Data Structures
    private TreeMap<String, Medicine>   medicines;   // Key = medicineId
    private PriorityQueue<PharmacyTask> taskQueue;   // Min-Heap
    private MergeSort                   mergeSort;

    private static final int LOW_STOCK_LIMIT = 10;

    // ---------- Constructor ----------
    public PharmacyManagementSystem() {
        medicines = new TreeMap<>();
        taskQueue = new PriorityQueue<>();
        mergeSort = new MergeSort();
    }


    //  1. MEDICINE MANAGEMENT


    // Add Medicine → O(log n)

    public void addMedicine(Medicine m) {
        if (medicines.containsKey(m.getMedicineId())) {
            System.out.println("  [ERROR] Medicine ID already exists: " + m.getMedicineId());
            return;
        }
        medicines.put(m.getMedicineId(), m);
        System.out.println("  [SUCCESS] Medicine added: " + m.getMedicineName());

        if (m.getQuantity() < LOW_STOCK_LIMIT) {
            System.out.println("  [ALERT] Low Stock Warning for: " + m.getMedicineName());
        }
    }

    // Update Medicine → O(log n)

    public void updateMedicine(String id, String name, String category,
                               double price, int quantity, String expiry, String manufacturer) {
        Medicine m = medicines.get(id);
        if (m == null) {
            System.out.println("  [ERROR] Medicine not found: " + id);
            return;
        }
        m.setMedicineName(name);
        m.setCategory(category);
        m.setPrice(price);
        m.setQuantity(quantity);
        m.setExpiryDate(expiry);
        m.setManufacturer(manufacturer);
        System.out.println("  [SUCCESS] Medicine updated: " + id);
    }

    // Delete Medicine → O(log n)

    public void deleteMedicine(String id) {
        if (medicines.remove(id) != null) {
            System.out.println("  [SUCCESS] Medicine deleted: " + id);
        } else {
            System.out.println("  [ERROR] Medicine not found: " + id);
        }
    }

    // Search Medicine → O(log n)

    public void searchMedicine(String id) {
        Medicine m = medicines.get(id);
        if (m != null) {
            System.out.println("  [FOUND] Medicine Details:");
            m.displayMedicine();
        } else {
            System.out.println("  [NOT FOUND] No medicine with ID: " + id);
        }
    }

    // Display All (TreeMap keeps them sorted by ID automatically)

    public void displayAllMedicines() {
        if (medicines.isEmpty()) {
            System.out.println("  No medicines in the system.");
            return;
        }
        System.out.println("\n  Total Medicines: " + medicines.size());
        for (Medicine m : medicines.values()) {
            m.displayMedicine();
        }
    }


    //  2. INVENTORY MANAGEMENT


    public void checkInventoryStatus() {
        if (medicines.isEmpty()) {
            System.out.println("  Inventory is empty.");
            return;
        }
        System.out.println("\n  INVENTORY STATUS");
        for (Medicine m : medicines.values()) {
            System.out.print("  " + m.getMedicineName() + "  |  Qty: " + m.getQuantity());
            if (m.getQuantity() < LOW_STOCK_LIMIT) {
                System.out.print("  ⚠ LOW STOCK WARNING");
            }
            System.out.println();
        }

    }


    //  3. SALES MANAGEMENT


    public void sellMedicine(String id, int qtySold) {
        Medicine m = medicines.get(id);
        if (m == null) {
            System.out.println("  [ERROR] Medicine not found: " + id);
            return;
        }
        if (m.getQuantity() < qtySold) {
            System.out.println("  [ERROR] Insufficient stock. Available: " + m.getQuantity());
            return;
        }

        m.setQuantity(m.getQuantity() - qtySold);
        double total = m.getPrice() * qtySold;

        System.out.println("\n BILL:");
        System.out.println("  Medicine   : " + m.getMedicineName());
        System.out.println("  Quantity   : " + qtySold);
        System.out.println("  Unit Price : Rs. " + m.getPrice());
        System.out.println("  Total      : Rs. " + total);
        System.out.println("  ...................");
        System.out.println("  [SUCCESS] Remaining Stock: " + m.getQuantity());

        if (m.getQuantity() < LOW_STOCK_LIMIT) {
            System.out.println("  [ALERT] Low Stock Warning for: " + m.getMedicineName());
        }
    }


    //  4. PRIORITY TASK MANAGEMENT


    // Add Task → O(log n) heap insertion

    public void addTask(String taskName, int priority) {
        taskQueue.add(new PharmacyTask(taskName, priority));
        System.out.println("  [SUCCESS] Task added: " + taskName + " (Priority: " + priority + ")");
    }

    // Process Highest Priority Task → O(log n) heap deletion

    public void processHighestPriorityTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("  No tasks in the queue.");
            return;
        }
        PharmacyTask task = taskQueue.poll();
        System.out.println("\n PROCESSING TASK:");
        task.displayTask();
        System.out.println("  [DONE] Task processed successfully!");
        System.out.println(".........................");
    }

    // View all pending tasks

    public void viewAllTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("  No pending tasks.");
            return;
        }
        List<PharmacyTask> tempList = new ArrayList<>(taskQueue);
        tempList.sort(Comparator.comparingInt(PharmacyTask::getPriority));

        System.out.println("\nPENDING TASKS:");
        int count = 1;
        for (PharmacyTask t : tempList) {
            System.out.println("  " + count++ + ". " + t.getTaskName()
                    + "  → Priority: " + t.getPriority());
        }
        System.out.println(".................................");
    }


    //  5. SORTING  (Merge Sort)


    public void sortMedicines(int choice) {
        if (medicines.isEmpty()) {
            System.out.println("  No medicines to sort.");
            return;
        }

        List<Medicine> list   = new ArrayList<>(medicines.values());
        List<Medicine> sorted;

        switch (choice) {
            case 1 -> { sorted = mergeSort.mergeSortByName(list);
                System.out.println("\n  === Sorted by Name (A → Z) ==="); }
            case 2 -> { sorted = mergeSort.mergeSortByPrice(list);
                System.out.println("\n  === Sorted by Price (Low → High) ==="); }
            case 3 -> { sorted = mergeSort.mergeSortByQuantity(list);
                System.out.println("\n  === Sorted by Quantity (Low → High) ==="); }
            default -> { System.out.println("  Invalid sort choice."); return; }
        }

        for (Medicine m : sorted) {
            m.displayMedicine();
        }
    }
}