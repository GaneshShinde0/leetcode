class Solution {
    public int[] rearrangeArrayGivesWithoutInputOrder(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int n=nums.length;
        for(int i=0;i<n/2;i+=1){
            res[2*i]=nums[n/2+i];
            res[2*i+1]=nums[i];
        }
        return res;
    }

    public int[] rearrangeArrayAlternative(int[] nums) {
        int posidx = 0;
        int negidx=0;
        int n = nums.length;
        int[] res = new int[n];
        int i=0;
        while(posidx<n&&negidx<n){
            while(nums[posidx]<0) posidx++;
            while(nums[negidx]>0) negidx++;
            res[i]=nums[posidx];
            res[i+1]=nums[negidx];
            posidx++;
            negidx++;
            i+=2;
        }
        return res;
    }

    // Fastest
    public int[] rearrangeArray(int[] nums) {
        int p=0,n=1;
        int[] result = new int[nums.length];
        for(int i : nums){
            if(i>0){
                result[p] = i;
                p+=2;
            }else{
                result[n] = i;
                n+=2;
            }
        }
        return result;
    }
}
