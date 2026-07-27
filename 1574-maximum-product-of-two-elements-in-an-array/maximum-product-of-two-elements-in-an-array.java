class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i:nums){
            if (i>max){
                max2 = max;
                max=i;
            }else if (i<=max && i>max2){
                max2=i;
            }
        }

        return (max2-1)*(max-1);
    }
}