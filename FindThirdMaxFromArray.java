import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FindThirdMaxFromArray {

    public int thirdMax(int[] nums) {
        long m1 = Long.MIN_VALUE;
        long m2 = Long.MIN_VALUE;
        long m3 = Long.MIN_VALUE;

        for (int n : nums) {
            if (n > m1) {
                m3 = m2;
                m2 = m1;
                m1 = n;
            } else if (n > m2 && n < m1) {
                m3 = m2;
                m2 = n;
            } else if (n > m3 && n < m2) {
                m3 = n;
            }
        }

        return m3 != Long.MIN_VALUE ? (int) m3 : (int) m1;
    }
    
    public int thirdMax5Ms(int[] nums) {
        // Using a min-heap to track the top 3 distinct maximums
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // Skip if the number is already in the heap
            if (!seen.contains(num)) {
                // Add the new number to the heap
                minHeap.offer(num);
                seen.add(num);

                // If the heap has more than 3 elements, remove the smallest one
                if (minHeap.size() > 3) {
                    seen.remove(minHeap.poll());
                }
            }
        }

        // If the heap has less than 3 elements, return the maximum (largest element)
        if (minHeap.size() < 3) {
            while (minHeap.size() > 1) {
                minHeap.poll(); // Remove the smaller elements
            }
        }
        
        // The root of the heap is the third largest if the size is 3
        return minHeap.peek();
    }
}
