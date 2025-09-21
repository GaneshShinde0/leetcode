class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sumOfEvens = 0;
        for(int i:nums){
            if(i%2==0){
                sumOfEvens+=i;
            }
        }
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int index = queries[i][1];
            int val = queries[i][0];
            if((nums[index]+val)%2==0){
                if(Math.abs(nums[index])%2==1){
                    sumOfEvens+= nums[index]+val;
                }else{
                    sumOfEvens +=val;
                }
            }else if(nums[index]%2==0){
                sumOfEvens-=nums[index];
            }
            // System.out.println("After: "+sumOfEvens);
            nums[index]=val+nums[index];
            res[i]=sumOfEvens;
            // System.out.println(Arrays.toString(nums));
        }
        return res;
    }
}