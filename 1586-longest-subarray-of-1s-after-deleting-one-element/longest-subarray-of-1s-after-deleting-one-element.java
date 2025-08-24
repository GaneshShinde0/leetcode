class Solution {
    public int longestSubarray(int[] nums) {
        // Store index Of last 0 
        List<List<Integer>> li = new ArrayList<>();
        int n = nums.length, curr=1;
        int i=1;
        for(;i<n;i++){
            if(nums[i]!=nums[i-1]){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i-1]);
                temp.add(curr);
                li.add(temp);
                curr=0;
            }
            curr++;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[i-1]);
        temp.add(curr);
        li.add(temp);
        int res = 0;
        for(int j=1;j<li.size()-1;j++){
            if(li.get(j).get(0)==0 && li.get(j).get(1)==1){
                res = Math.max(res,li.get(j-1).get(1)+li.get(j+1).get(1));
            }
            if(li.get(j).get(0)==1) res = Math.max(res,li.get(j).get(1));
        }
        if(li.size()==1 && li.get(0).get(0)==1) return li.get(0).get(1)-1;
        if(li.size()==2){
            if(li.get(0).get(0)==1) return li.get(0).get(1);
            else return li.get(1).get(1);
        }
        // System.out.println(li);
        return res;
    }
}