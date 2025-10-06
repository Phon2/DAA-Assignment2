import java.util.*;

public class MaxHeapTest {
    public static void main(String[] args) {
        MaxHeapClass heap = new MaxHeapClass();
        int[] sizes = {100, 1000, 10000, 100000};
        for (int n : sizes) {
            runBenchmark(n);
        }
    }


    private static void runBenchmark(int n) {
        MaxHeapClass heap = new MaxHeapClass();
        Random rand = new Random(19);


        long start = System.nanoTime();
        for (int i = 1; i <= n; i++) {
            heap.insert(i);
        }
        long end = System.nanoTime();
        double buildMs = (end - start) / 1_000_000.0;


        start = System.nanoTime();
        int count = 0;
        while (true) {
            int val = heap.extractMax();
            if (val == Integer.MIN_VALUE) break;
            count++;
        }
        end = System.nanoTime();
        double extractMs = (end - start) / 1_000_000.0;

        System.out.printf("n = %-6d | build = %8.3f ms | extractAll = %8.3f ms\n",
                n, buildMs, extractMs);
    }
}

