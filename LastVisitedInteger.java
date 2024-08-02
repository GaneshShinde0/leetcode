class LastVisitedInteger {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                seen.add(0,nums[i]);
                k=0;
            }else if(nums[i]==-1){
                k+=1;
                if(k<=seen.size()){
                    ans.add(seen.get(k-1));
                }else{
                    ans.add(-1);
                }
            }
        }
        return ans;
    }
}
