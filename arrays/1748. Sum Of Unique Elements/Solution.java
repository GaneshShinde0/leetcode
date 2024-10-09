class Solution {
    public int sumOfUniqueTwoForLoop(int[] nums) {
        int[] freq = new int[101];
        for(int i:nums){
            freq[i]++;
        }
        int sum=0;
        for(int i=0;i<101;i++){
            if(freq[i]==1)sum+=i;
        }
        return sum;
    }

    public int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        int sum=0;
        for(int i:nums){
            if(freq[i]==0){
                sum+=i;
            }else if (freq[i]==1){
                sum-=i;
            }
            freq[i]++;
        }
        return sum;
    }
}
