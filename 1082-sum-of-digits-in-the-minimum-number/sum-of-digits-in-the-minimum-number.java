class Solution {
    public int sumOfDigits(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i:nums){
            if(i<min)min=i;
        }
        return sumOfDigits(min)%2==0?1:0;
    }

    private int sumOfDigits(int num){
        int res = 0;
        while(num>0){
            res+=num%10;
            num=num/10;
        }
        return res;
    }
}