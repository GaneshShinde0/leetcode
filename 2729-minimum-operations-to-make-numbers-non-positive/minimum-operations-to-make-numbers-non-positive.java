class Solution {
    int diffXY;
    public int minOperations(int[] nums, int x, int y) {
        this.diffXY = x - y;
        int left = 1, right = 0;
        for (int num : nums)
            right = Math.max(right, (num + y - 1) / y);
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(nums, x, y, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
    public boolean check(int[] nums, int x, int y, int steps) {
        int countX = steps;
        for (int num : nums) {
            int curSteps = (num + y - 1) / y;
            if (curSteps > steps) {
                countX -= (num - steps * y + diffXY - 1) / diffXY;
                if (countX < 0) return false;
            }
        }
        return true;
    }
}