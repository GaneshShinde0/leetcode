class Solution {
    public long zeroFilledSubarrayInitial(int[] nums) {
        List<Long> li = new ArrayList<>();
        long curr = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                curr++;
            }else if(curr!=0){
                li.add(curr);
                curr=0;
            }
        }
        li.add(curr);
        long res =0;
        // System.out.println(li);
        for(Long i:li){
            res+=((i*(i+1))/2);
        }
        return res;
    }

    public long zeroFilledSubarray(int[] nums) {
        long curr = 0;
        long res =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                curr++;
                res+=curr;
            }else if(curr!=0){
                curr=0;
            }
        }
        return res;
    }
}