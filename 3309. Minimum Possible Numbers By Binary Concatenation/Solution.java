import java.util.Arrays;

class Solution {
    public int maxGoodNumber(int[] nums) {
        // Sort the nums array based on the number of 1s in their binary representation
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new); // Convert to Integer array
        Arrays.sort(boxedNums, (a, b) -> {
            String binA = Integer.toBinaryString(a);
            String binB = Integer.toBinaryString(b);
            return (binB + binA).compareTo(binA + binB);
        });
        // Build a binary string from the sorted array
        StringBuilder sb = new StringBuilder();
        for (Integer num : boxedNums) {
            sb.append(Integer.toBinaryString(num));
        }

        // Parse the binary string as an integer
        return Integer.parseInt(sb.toString(), 2);
    }
}
