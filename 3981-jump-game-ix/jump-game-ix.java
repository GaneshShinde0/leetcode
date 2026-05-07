/*
Approach 1: Interval Divide and Conquer
*/
class Solution1 {
    record Item(int value, int index){}
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Item[] maxFromLeft = new Item[n];
        Item prev = new Item(0,-1);
        for(int i=0;i<n;i++){
            if(nums[i]>prev.value()){
                prev = new Item(nums[i],i);
            }
            maxFromLeft[i] = prev;
        }
        process(n-1,Integer.MAX_VALUE,0,maxFromLeft, ans, nums);
        return ans;
    }
    private void process(int r, int rightMin, int rightMax, Item[] maxFromLeft, int[] ans, int[] nums){
        int prevMax = maxFromLeft[r].value();
        int pivotIdx = maxFromLeft[r].index();
        
        int currMax = prevMax<=rightMin?prevMax:rightMax;
        int nextRightMin = Math.min(prevMax, rightMin);
        for(int i=pivotIdx; i<=r;i++){
            ans[i] = currMax;
            nextRightMin = Math.min(nextRightMin, nums[i]);
        }
        if(pivotIdx==0) return;
        process(pivotIdx-1,nextRightMin, currMax, maxFromLeft, ans,nums);
    }
}


class Solution {
    record Item(int value, int left, int right){}
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        List<Item> stack = new ArrayList<>();
        for(int i=0;i<n;i++){
            Item curr = new Item(nums[i],i,i);
            while(!stack.isEmpty() && stack.getLast().value()>nums[i]){
                Item top = stack.removeLast();
                curr = new Item(Math.max(curr.value(), top.value()), top.left(), curr.right());
            }
            stack.add(curr);
        }
        for(int i=0;i<stack.size();i++){
            for(int j=stack.get(i).left(); j<=stack.get(i).right(); j++){
                ans[j]=stack.get(i).value();
            }
        }
        return ans;
    }
}