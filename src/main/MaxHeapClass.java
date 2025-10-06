import java.util.*;

/**
 * Max-Heap implementation using Java's PriorityQueue (reverse order).
 * Implements insert, extractMax, and increaseKey operations.
 * Tracks metrics for algorithm analysis.
 */
public class MaxHeapClass {
    private PriorityQueue<Integer> maxHeap;  // Max-Heap (reverse order)
    private int comparisons = 0;
    private int insertions = 0;
    private int extractions = 0;
    private int keyIncreases = 0;

    // Constructor
    public MaxHeapClass() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    /** Insert a new key into the heap */
    public void insert(int key) {
        maxHeap.add(key);
        insertions++;
    }

    /** Return the maximum element without removing it */
    public int getMax() {
        if (maxHeap.isEmpty()) {
            System.out.println("Heap is empty!");
            return Integer.MIN_VALUE;
        }
        comparisons++;
        return maxHeap.peek();
    }

    /** Extract and return the maximum element (root) */
    public int extractMax() {
        if (maxHeap.isEmpty()) {
            System.out.println("Heap is empty!");
            return Integer.MIN_VALUE;
        }
        extractions++;
        return maxHeap.poll();
    }

    /** Increase the key value of an element */
    public void increaseKey(int oldValue, int newValue) {
        if (!maxHeap.contains(oldValue)) {
            System.out.println("Value not found in heap: " + oldValue);
            return;
        }
        if (newValue < oldValue) {
            System.out.println("New value must be greater than the old value!");
            return;
        }

        keyIncreases++;
        comparisons++;
        maxHeap.remove(oldValue);
        maxHeap.add(newValue);
        System.out.println("Increased key: " + oldValue + " → " + newValue);
    }

    /** Print heap contents in sorted order (for readability) */
    public void printHeap() {
        List<Integer> sorted = new ArrayList<>(maxHeap);
        Collections.sort(sorted, Collections.reverseOrder());
        System.out.println(sorted);
    }

    /** Display performance metrics */
    public void printMetrics() {
        System.out.println("\n--- Heap Metrics ---");
        System.out.println("Insertions:   " + insertions);
        System.out.println("Extractions:  " + extractions);
        System.out.println("Key Increases:" + keyIncreases);
        System.out.println("Comparisons:  " + comparisons);
        System.out.println("---------------------\n");
    }
}