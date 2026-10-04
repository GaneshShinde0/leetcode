class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length==0) return res;
        int prev = nums[0], start = nums[0];
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            if(prev==num-1){
                prev = num;
            }else{
                if(start!=prev){
                    res.add(start+"->"+prev);
                }else{
                    res.add(""+start);
                }
                start = num;
            }
            prev = num;
        }
        if(start!=prev){
            res.add(start+"->"+prev);
        }else{
            res.add(""+start);
        }
        return res;
    }
}