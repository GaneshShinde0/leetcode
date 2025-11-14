class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        int start = 0, end = nums.length-1;
        helper(li, start, end, nums);
        return li;
    }

    private void helper(List<List<Integer>> li, int start, int end, int[] nums){
        if(start==end){
            List<Integer> curr = new ArrayList<>();
            for(int i:nums){
                curr.add(i);
            }
            li.add(curr);
        }
        for(int i=start;i<=end;i++){
            swap(nums,start, i);
            helper(li, start+1, end, nums);
            swap(nums,start, i);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}