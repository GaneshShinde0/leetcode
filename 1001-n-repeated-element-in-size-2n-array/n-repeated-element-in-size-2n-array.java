class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] freq = new int[10001];
        for(int i:nums){
            freq[i]++;
            if(freq[i]>1)return i;
        }
        return -1;
    }
}