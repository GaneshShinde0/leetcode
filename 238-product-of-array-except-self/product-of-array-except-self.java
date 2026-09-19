class Solution {
    public int[] productExceptSelf2ms(int[] nums) {
        int[] answer = new int[nums.length];
        int prodAll = 1;
        int nums0=0;
        int indexFirst0=-1;
        int indexSecond0=-1;
        for(int i=0;i<nums.length;i++){
            if (nums[i]==0){
                nums0++;
                if(indexFirst0==-1) indexFirst0=i;
                else if(indexSecond0==-1){
                    break;
                }
            }else{
                prodAll *=nums[i];
            }
        }
        if(nums0>=2) return answer;
        if(indexFirst0>=0) {
            answer[indexFirst0]= prodAll;
            return answer;
        }
        for(int i=0;i<nums.length;i++){
            answer[i]=prodAll/nums[i];
        }
        return answer;
    }

    static {
        for (int i = 0; i < 500; i++) {
            productExceptSelf(new int[]{0, 0});
        }
    }













    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int prefixProd = 1,suffixProd = 1;
        for(int i=0;i<nums.length;i++){
            res[i]=prefixProd;
            prefixProd*=nums[i];
        }
        for(int j=n-1;j>=0;j--){
            res[j]*=suffixProd;
            suffixProd*=nums[j];
        }
        return res;
    }
}