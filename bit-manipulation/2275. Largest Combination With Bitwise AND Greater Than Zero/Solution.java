class Solution {
    public int largestCombinationAlternate(int[] candidates) {
        int[] bitCount = new int[24];
        for(int i=0;i<24;i++){
            for(int num:candidates){
                if((num & 1<<i)!=0){
                    bitCount[i]++;
                }
            }
        }
        // Return the maximum Count
        int max = 0;
        for(int count: bitCount){
            if(count>max){
                max = count;
            }
        }
        return max;
    }

    public int largestCombination(int[] candidates){
        int maxCount = 0; // Variable to track the maximum count of set bits
        for(int i=0;i<24;i++){
            int count =0;
            for(int num:candidates){
                if((num & (1<<i)) !=0){
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
