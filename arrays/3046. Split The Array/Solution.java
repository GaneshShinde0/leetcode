class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] freq = new int[101];
        for(int i:nums){
            freq[i]++;
        }
        int numTwos=0;
        int numOnes=0;
        for(int i:freq){
            if(i>=3) return false;
            if(i==1) numOnes++;
            if(i==2) numTwos++;
        }
        if(numOnes%2==1) return false;
        return true;
    }
}
