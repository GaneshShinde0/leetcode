class Solution {
    public boolean xorGame(int[] nums) {
        int x = 0;
        for(int num:nums) x ^=num;
        return nums.length%2==0||x==0;
    }
}