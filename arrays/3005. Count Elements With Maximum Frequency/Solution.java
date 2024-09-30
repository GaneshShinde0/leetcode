class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        int maxFreq=0;
        for(int i:nums){
            arr[i]++;
            if(maxFreq<arr[i])maxFreq=arr[i];
        }
        int result=0;
        for(int i:arr){
            if(i==maxFreq){
                result+=i;
            }
        }
        return result;
    }
}
