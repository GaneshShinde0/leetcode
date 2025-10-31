class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[101];
        int[] res = new int[2];
        int j = 0;
        for(int i:nums){
            freq[i]++;
            if(freq[i]==2){
                res[j]=i;
                j++;
            }
        }
        return res;
    }
}