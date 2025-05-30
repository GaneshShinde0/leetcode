
class Solution {
    public TreeNode help(int[] nums, int left, int right){
        if(left>right) return null;
        int maxIndex = left;
        for(int i= left+1; i<=right; i++){
            if(nums[i]>nums[maxIndex]) maxIndex = i;
        }
        TreeNode head = new TreeNode(nums[maxIndex]);
        head.left = help(nums, left, maxIndex-1);
        head.right = help(nums, maxIndex+1, right);
        return head;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return help(nums, 0, nums.length-1);
    }

}
