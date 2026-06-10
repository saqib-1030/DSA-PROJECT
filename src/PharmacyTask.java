public class PharmacyTask implements Comparable<PharmacyTask> {

    private String taskName;
    private int    priority;   // 1 = High, 2 = Medium, 3 = Low

    // ---------- Constructor ----------
    public PharmacyTask(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;
    }

    // ---------- Getters ----------
    public String getTaskName() { return taskName; }
    public int    getPriority() { return priority; }

    // ---------- compareTo ----------
    // PriorityQueue in Java is a MIN-heap → smaller number = higher priority
    @Override
    public int compareTo(PharmacyTask other) {
        return Integer.compare(this.priority, other.priority);
    }

    // ---------- Display ----------
    public void displayTask() {
        String level;
        if      (priority == 1) level = "HIGH";
        else if (priority == 2) level = "MEDIUM";
        else                    level = "LOW";

        System.out.println("  Task     : " + taskName);
        System.out.println("  Priority : " + level + " (" + priority + ")");
    }
}