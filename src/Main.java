import java.util.Scanner;
public class Main {

    static Scanner sc  = new Scanner(System.in);
    static PharmacyManagementSystem pms = new PharmacyManagementSystem();

    public static void main(String[] args) {

        loadSampleData();   // Pre-load test data

        int choice;
        do {
            printMenu();
            System.out.print("  Enter your choice: ");
            choice = getInt();

            switch (choice) {
                case 1  -> addMedicine();
                case 2  -> updateMedicine();
                case 3  -> deleteMedicine();
                case 4  -> searchMedicine();
                case 5  -> pms.displayAllMedicines();
                case 6  -> sellMedicine();
                case 7  -> addTask();
                case 8  -> pms.processHighestPriorityTask();
                case 9  -> pms.viewAllTasks();
                case 10 -> sortMenu();
                case 11 -> pms.checkInventoryStatus();
                case 0  -> System.out.println("\n  Exiting... Thank you!\n");
                default -> System.out.println("  Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }

    // Menu
    static void printMenu() {
        System.out.println("\n  PHARMACY MANAGEMENT SYSTEM ");
        System.out.println("1.  Add Medicine ");
        System.out.println("2.  Update Medicine ");
        System.out.println("3.  Delete Medicine ");
        System.out.println("4.  Search Medicine ");
        System.out.println("5.  Display All Medicines ");
        System.out.println("6.  Sell Medicine ");
        System.out.println("7.  Add Priority Task ");
        System.out.println("8.  Process Highest Priority Task ");
        System.out.println("9.  View All Pending Tasks ");
        System.out.println("10. Sort Medicines ");
        System.out.println("11. Inventory Status ");
        System.out.println("0.  Exit ");
    }

    //  Option Handlers
    static void addMedicine() {
        System.out.println("\n  --- Add Medicine ---");
        System.out.print("  Medicine ID   : "); String id    = sc.nextLine().trim();
        System.out.print("  Name          : "); String name  = sc.nextLine().trim();
        System.out.print("  Category      : "); String cat   = sc.nextLine().trim();
        System.out.print("  Price         : "); double price = getDouble();
        System.out.print("  Quantity      : "); int qty       = getInt();
        System.out.print("  Expiry Date   : "); String exp    = sc.nextLine().trim();
        System.out.print("  Manufacturer  : "); String mfr    = sc.nextLine().trim();
        pms.addMedicine(new Medicine(id, name, cat, price, qty, exp, mfr));
    }

    static void updateMedicine() {
        System.out.println("\n  --- Update Medicine ---");
        System.out.print("  Medicine ID       : "); String id    = sc.nextLine().trim();
        System.out.print("  New Name          : "); String name  = sc.nextLine().trim();
        System.out.print("  New Category      : "); String cat   = sc.nextLine().trim();
        System.out.print("  New Price         : "); double price = getDouble();
        System.out.print("  New Quantity      : "); int qty       = getInt();
        System.out.print("  New Expiry Date   : "); String exp    = sc.nextLine().trim();
        System.out.print("  New Manufacturer  : "); String mfr    = sc.nextLine().trim();
        pms.updateMedicine(id, name, cat, price, qty, exp, mfr);
    }

    static void deleteMedicine() {
        System.out.println("\n  --- Delete Medicine ---");
        System.out.print("  Medicine ID: ");
        pms.deleteMedicine(sc.nextLine().trim());
    }

    static void searchMedicine() {
        System.out.println("\n  --- Search Medicine ---");
        System.out.print("  Medicine ID: ");
        pms.searchMedicine(sc.nextLine().trim());
    }

    static void sellMedicine() {
        System.out.println("\n  --- Sell Medicine ---");
        System.out.print("  Medicine ID      : "); String id = sc.nextLine().trim();
        System.out.print("  Quantity to sell : "); int qty   = getInt();
        pms.sellMedicine(id, qty);
    }

    static void addTask() {
        System.out.println("\n  --- Add Priority Task ---");
        System.out.print("  Task Name      : "); String name = sc.nextLine().trim();
        System.out.println("  Priority       : 1=High  2=Medium  3=Low");
        System.out.print("  Enter Priority : "); int priority = getInt();
        pms.addTask(name, priority);
    }

    static void sortMenu() {
        System.out.println("\n  --- Sort Medicines ---");
        System.out.println("  1. Sort by Name");
        System.out.println("  2. Sort by Price");
        System.out.println("  3. Sort by Quantity");
        System.out.print("  Choose: ");
        pms.sortMedicines(getInt());
    }

    //Sample Data
    static void loadSampleData() {
        pms.addMedicine(new Medicine("M001", "Panadol",     "Painkiller",  50.0,  100, "2025-12-01", "GSK"));
        pms.addMedicine(new Medicine("M002", "Augmentin",   "Antibiotic",  350.0, 8,   "2025-06-15", "GSK"));
        pms.addMedicine(new Medicine("M003", "Paracetamol", "Painkiller",  30.0,  5,   "2024-11-30", "Abbott"));
        pms.addMedicine(new Medicine("M004", "Brufen",      "Anti-inflam", 80.0,  50,  "2026-03-20", "Abbott"));
        pms.addMedicine(new Medicine("M005", "Amoxicillin", "Antibiotic",  200.0, 3,   "2024-08-10", "Pfizer"));
        pms.addTask("Expired Medicine Check",  1);
        pms.addTask("Low Stock Alert",         2);
        pms.addTask("Daily Report Generation", 3);
        System.out.println("\n  [INFO] Sample data loaded!");
    }

    // Safe Input Helpers
    static int getInt() {
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("  [WARN] Invalid, using 0."); return 0; }
    }

    static double getDouble() {
        try { return Double.parseDouble(sc.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("  [WARN] Invalid, using 0."); return 0; }
    }
}