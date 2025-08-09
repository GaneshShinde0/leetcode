class Solution {
    public boolean judgeSquareSum(int c) {
        long lb = 0;
        long ub = (long)Math.sqrt(c);
        while (lb <= ub) {
            long sum = lb * lb + ub * ub;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                lb++;
            } else {
                ub--;
            }
        }
        return false;
    }
}