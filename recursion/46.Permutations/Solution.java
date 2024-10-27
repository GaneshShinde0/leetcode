class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i:nums){
            temp.add(i);
        }
        backtrack(li, temp,0,nums.length-1);
        return li;
    }

    private void backtrack(List<List<Integer>> tempList,List<Integer> li, int start,int end){
        if(start==end){
            tempList.add(new ArrayList<>(li));
            return;
        }else{
            for(int i=start;i<=end;i++){
                swap(li, i, start);
                backtrack(tempList, li, start + 1, end); // Move to the next index
                swap(li, i, start); // Swap back to restore the original list
            }
        }
    }
    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public void permuteRec(int[] nums, int begin, List<List<Integer>> result) {
        if (begin == nums.length) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int num : nums) temp.add(num);
            result.add(temp);
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            // Swap
            int temp = nums[begin];
            nums[begin] = nums[i];
            nums[i] = temp;
            
            permuteRec(nums, begin + 1, result);
            
            // Swap back
            temp = nums[begin];
            nums[begin] = nums[i];
            nums[i] = temp;
        }
    }
    
    public List<List<Integer>> permuteAlternate(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteRec(nums, 0, result);
        return result;
    }
}

