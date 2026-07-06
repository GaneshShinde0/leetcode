class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        dfs(res,li,nums,0);
        return res;
    }

    private void dfs(List<List<Integer>> res,List<Integer> li, int[] nums, int j){
        res.add(new ArrayList<>(li));

        // At each index we are first considering that element and then not considering.
        for(int i=j;i<nums.length;i++){
            li.add(nums[i]);
            dfs(res,li,nums,i+1);
            li.remove(li.size()-1);
        }
    }
}