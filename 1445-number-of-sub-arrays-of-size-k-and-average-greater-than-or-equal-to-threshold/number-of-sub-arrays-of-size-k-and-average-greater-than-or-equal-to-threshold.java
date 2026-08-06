class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int winSum = 0;
        int i = 0, j = 0;
        while(j < arr.length){
            winSum += arr[j];

            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k){
                if((winSum / k) >= threshold) count++;
                winSum -= arr[i];
                i++;
                j++;
            }
        }
        return count;
    }
}