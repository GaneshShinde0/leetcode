class Solution {
    public int[] productExceptSelfWithDivision(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int zeroCount = 0;
        int product = 1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroCount++;
                if(zeroCount == 2) return res;
            }else{
                product*=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(zeroCount == 1 && nums[i]!=0){
                res[i]=0;
            }else if(zeroCount==1 && nums[i]==0){
                res[i]=product;
            }else{
                res[i]=product/nums[i];
            }
        }
        return res;
    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        // System.out.println(Arrays.toString(res));
        int suffix = 1;
        for(int i=n-1;i>=0;i--){
            res[i]*=suffix;
            suffix*=nums[i];
        }
        return res;
    }
}