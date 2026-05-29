class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            int sumOfDigits = 0;
            while(num>0){
                sumOfDigits +=num%10;
                num = num/10;
            }
            min = Math.min(sumOfDigits, min);
        }
        return min;
    }
}