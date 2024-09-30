class Solution {
    public int maxProductDifference(int[] nums) {
        int max = 0, secondMax = 0;
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n < min) {
                secondMin = min;
                min = n;
            } else if (n < secondMin) {
                secondMin = n;
            }

            if (n > max) {
                secondMax = max;
                max = n;
            } else if (n > secondMax) {
                secondMax = n;
            }
        }

        return max * secondMax - min * secondMin;
    }
}
