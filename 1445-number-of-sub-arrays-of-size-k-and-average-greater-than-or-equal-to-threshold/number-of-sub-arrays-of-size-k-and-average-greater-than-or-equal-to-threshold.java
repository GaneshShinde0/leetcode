class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0, windowSum = 0;
        int i = 0, j = 0;
        while(j < arr.length){
            windowSum += arr[j];
            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k){
                if((windowSum / k) >= threshold) count++;
                windowSum -= arr[i];
                i++;
                j++;
            }
        }
        return count;
    }
}