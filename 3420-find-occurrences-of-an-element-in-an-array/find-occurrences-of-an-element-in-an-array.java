class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int resultSize = queries.length;
        int numOfElements = nums.length;
        int[] result = new int[resultSize];
        int count= 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x) count++;
        }
        int[] freqToIndex = new int[count];
        count = 0;
        for(int i=0;i<numOfElements;i++){
            if(nums[i]==x) freqToIndex[count++] = i;
        }
        for(int i=0;i<resultSize;i++){
            if(queries[i]>count) result[i]=-1;
            else result[i]= freqToIndex[queries[i]-1];
        }
        return result;
    }
}