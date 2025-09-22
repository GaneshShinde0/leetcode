class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = Integer.MIN_VALUE;
        for(int i:nums){
            freq[i]++;
            if(freq[i]>maxFreq) maxFreq = freq[i];
        }
        int res = 0;
        for(int i:freq){
            if(i==maxFreq) res+=i;
        }
        return res;
    }
}