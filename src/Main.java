import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        // --- CLI interface for input size ---
        int n = 10; // default
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input size! Using default value: 10");
            }
        }

        // Generate two random lists
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list1.add(rand.nextInt(100));
            list2.add(rand.nextInt(100));
        }

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        // Create two Max-Heaps
        MaxHeapClass heap1 = new MaxHeapClass();
        MaxHeapClass heap2 = new MaxHeapClass();

        for (int val : list1) heap1.insert(val);
        for (int val : list2) heap2.insert(val);

        System.out.println("\n=== Initial Heaps ===");
        System.out.print("Heap 1: "); heap1.printHeap();
        System.out.print("Heap 2: "); heap2.printHeap();

        // --- Merge two heaps ---
        MaxHeapClass mergedHeap = new MaxHeapClass();
        for (int val : list1) mergedHeap.insert(val);
        for (int val : list2) mergedHeap.insert(val);

        System.out.println("\n=== Merged Heap ===");
        mergedHeap.printHeap();

        // --- Increase key operation ---
        if (!list1.isEmpty()) {
            int oldValue = list1.get(0);
            int newValue = oldValue + 50;
            System.out.println("\nIncreasing key " + oldValue + " → " + newValue);
            mergedHeap.increaseKey(oldValue, newValue);
        }

        System.out.println("After increaseKey:");
        mergedHeap.printHeap();

        // --- Extract max ---
        int max = mergedHeap.extractMax();
        System.out.println("\nExtracted max: " + max);
        System.out.println("After extractMax:");
        mergedHeap.printHeap();

        // --- Insert new element ---
        mergedHeap.insert(1);
        System.out.println("\nAfter inserting 1:");
        mergedHeap.printHeap();

        // --- Show metrics ---
        mergedHeap.printMetrics();
    }
}