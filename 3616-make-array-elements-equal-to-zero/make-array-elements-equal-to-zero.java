class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int validSelections = 0;

        for (int start = 0; start < n; start++) {
            if (nums[start] == 0) {
                if (isValidSelection(nums, start, -1)) {
                    validSelections++;
                }
                if (isValidSelection(nums, start, 1)) {
                    validSelections++;
                }
            }
        }
        return validSelections;
    }

    private boolean isValidSelection(int[] nums, int curr, int direction) {
        int n = nums.length;
        int[] temp = nums.clone();

        while (curr >= 0 && curr < n) {
            if (temp[curr] == 0) {
                curr += direction;
            } else {
                temp[curr]--;
                direction *= -1;
                curr += direction;
            }
        }

        for (int num : temp) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}