# Pharmacy Management System

## Project Overview

The Pharmacy Management System is a Java-based application developed to efficiently manage pharmacy operations. The system focuses on medicine inventory management, task prioritization, and record organization using advanced Data Structures and Algorithms (DSA).

This project demonstrates the practical implementation of:

* Priority Queue (Heap)
* TreeMap
* Merge Sort Algorithm

The system allows pharmacy staff to manage medicines, process important tasks according to priority, and maintain organized records.

---

## Objectives

* Manage medicine inventory efficiently.
* Organize medicines using TreeMap for fast searching and retrieval.
* Process pharmacy tasks according to priority using Priority Queue.
* Sort medicine records and sales data using Merge Sort.
* Demonstrate real-world applications of Data Structures and Algorithms.

---

## Data Structures Used

### 1. Priority Queue (Heap)

The Priority Queue is used to manage pharmacy tasks based on their priority level.

Examples:

* Emergency medicine restocking
* Expiring medicine alerts
* High-priority customer requests

#### Operations

* Insert Task: O(log n)
* Remove Highest Priority Task: O(log n)
* Peek Highest Priority Task: O(1)

---

### 2. TreeMap

TreeMap is used to store medicine records in sorted order based on medicine IDs or names.

#### Advantages

* Automatic sorting of records
* Fast searching
* Efficient insertion and deletion

#### Complexity

* Insert: O(log n)
* Search: O(log n)
* Delete: O(log n)

---

## Algorithm Used

### Merge Sort

Merge Sort is used to sort medicine inventory and sales records.

#### Steps

1. Divide the list into smaller parts.
2. Recursively sort each part.
3. Merge the sorted parts.

#### Complexity

* Best Case: O(n log n)
* Average Case: O(n log n)
* Worst Case: O(n log n)

---

## Features

### Medicine Management

* Add new medicines
* View medicine records
* Search medicines
* Update medicine information

### Inventory Management

* Maintain stock records
* Track medicine quantities
* Manage medicine availability

### Task Management

* Add pharmacy tasks
* Assign priorities
* Process highest-priority tasks first

### Sorting System

* Sort medicine inventory
* Organize records efficiently using Merge Sort

---

## Project Structure

src/

├── Main.java

├── Medicine.java

├── PharmacyTask.java

├── MergeSort.java

└── PharmacyManagementSystem.java

---

## How to Run the Project

### Requirements

* Java JDK 8 or higher
* IntelliJ IDEA (Recommended)

### Steps

1. Clone the repository:

git clone https://github.com/saqib-1030/DSA-PROJECT.git

2. Open the project in IntelliJ IDEA.

3. Run Main.java.

4. Use the menu options to manage medicines and pharmacy tasks.

---

## Sample Workflow

1. Add medicines to inventory.
2. Store records in TreeMap.
3. Add pharmacy tasks with different priorities.
4. Process tasks using Priority Queue.
5. Sort inventory using Merge Sort.
6. Display organized records.

---

## Time Complexity Analysis

| Operation       | Data Structure | Complexity |
| --------------- | -------------- | ---------- |
| Add Medicine    | TreeMap        | O(log n)   |
| Search Medicine | TreeMap        | O(log n)   |
| Delete Medicine | TreeMap        | O(log n)   |
| Add Task        | Priority Queue | O(log n)   |
| Remove Task     | Priority Queue | O(log n)   |
| Peek Task       | Priority Queue | O(1)       |
| Merge Sort      | Merge Sort     | O(n log n) |

---

## Conclusion

The Pharmacy Management System successfully demonstrates the practical implementation of Data Structures and Algorithms in a real-world scenario. By using TreeMap, Priority Queue, and Merge Sort, the system provides efficient inventory management, task scheduling, and record organization while maintaining optimal performance.

---

## Author

Muhammad Saqib Javed

BS Software Engineering

University of Central Punjab (UCP)
