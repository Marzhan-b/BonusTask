
---

#  MST Edge Removal and Replacement

*A Java demonstration of updating an MST after edge removal*

This project demonstrates how a **Minimum Spanning Tree (MST)** behaves when one of its edges is removed. Using **Kruskal’s algorithm**, **Union-Find**, and **DFS**, the program reconstructs the tree by finding the lightest replacement edge that reconnects the split components.

The goal is to clearly show each step of the MST update process.

---

##  Project Overview

The program performs the following sequence:

1. Build a Minimum Spanning Tree (MST) using Kruskal’s algorithm
2. Display the MST edges
3. Remove one edge from the MST
4. Identify connected components after removal
5. Find a replacement edge that reconnects the components
6. Output the updated MST

This demonstrates dynamic MST updates and how spanning trees react to graph changes.

---

##  Project Structure

```
src/
└─ MSTRemove/
   ├─ Main.java          // Program flow
   ├─ Graph.java         // DFS components & replacement edge logic
   ├─ Kruskal.java       // Kruskal’s MST algorithm
   ├─ Edge.java          // Edge representation
   └─ UnionFind.java     // DSU (path compression + rank)
```
---

##  Running the Program

### 1. Clone the repository

```
git clone <your_repository_url>
```

### 2. Compile the project

```
javac src/MSTRemove/*.java
```

### 3. Run the program

```
java -classpath src MSTRemove.Main
```
##  Example Output

```
Building MST...

MST edges:
0 - 3 (5)
2 - 4 (5)
3 - 5 (6)
0 - 1 (7)
1 - 4 (7)
4 - 6 (9)

Removed edge: 3 - 5 (6)

Components:
 - [0, 3, 1, 4, 2, 6]
 - [5]

Replacement edge: 3 - 5 (6)

New MST:
0 - 3 (5)
2 - 4 (5)
0 - 1 (7)
1 - 4 (7)
4 - 6 (9)
3 - 5 (6)
```
##  How It Works (Simple Explanation)

### **1. Kruskal’s Algorithm**

* Sort all edges by weight
* Add edges without creating cycles
* Use Union-Find (DSU) to detect cycles efficiently
* Result → MST with minimum total weight

### **2. After Removing an MST Edge**

Removing an edge splits the MST into **two components**.
I detect these components using DFS on the MST (excluding the removed edge).

### **3. Finding a Replacement Edge**

I check all original graph edges and choose the **lightest edge** that connects the two components.
Adding this edge restores a valid MST.

---

##  Time & Space Complexity

### **Time Complexity**

* Kruskal’s MST: **O(E log E)**
* DFS for components: **O(V + E)**
* Replacement search: **O(E)**

### **Space Complexity**

* Graph storage: **O(E)**
* MST edges: **O(V)**
* Union-Find: **O(V)**
  **Total: O(V + E)**



---
 Conclusion

**This assignment was about removing an edge from an MST and finding a replacement edge. I implemented the required algorithms, built the MST, removed an edge, checked the components, and added the correct replacement. Everything works as expected, and the program runs right after cloning.**