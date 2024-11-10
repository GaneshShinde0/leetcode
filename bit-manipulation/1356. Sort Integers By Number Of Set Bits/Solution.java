import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] sortByBitsInitial(int[] arr) {
        // Sort the array using a custom comparator
        Integer[] arr1 = new Integer[arr.length];
        for(int i=0;i<arr.length;i++) arr1[i]=arr[i];
        Arrays.sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // Compare based on the count of set bits (1s) in the binary representation
                int bitCountA = Integer.bitCount(a);
                int bitCountB = Integer.bitCount(b);

                if (bitCountA == bitCountB) {
                    // If bit counts are the same, compare numerically
                    return a - b;
                } else {
                    // Sort by the number of set bits in ascending order
                    return bitCountA - bitCountB;
                }
            }
        });
        for(int i=0;i<arr.length;i++) arr[i]=arr1[i];
        return arr;
    }

    public int[] sortByBits(int[] arr) {
        Integer[] arr1 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        Arrays.sort(arr1, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);
            return bitCountA == bitCountB ? a - b : bitCountA - bitCountB;
        });
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr1[i];
        }
        
        return arr;
    }


    public int[] sortByBitsAlternate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10001;
        }
        return arr;
    }
}
