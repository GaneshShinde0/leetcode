class Solution {
    public int[][] permute(int n) {
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = i+1;
        List<int[]> li = new ArrayList<>();
        helper(li, 0, n-1, nums);
        int[][] res = new int[li.size()][n];
        for(int i=0;i<li.size();i++){
            res[i] = li.get(i);
        }
        Arrays.sort(res,(a,b)->{
            for(int i=0;i<n;i++){
                if(a[i]!=b[i]) return Integer.compare(a[i],b[i]);
            }
            return 0;
        });
        return res;
    }

    private void helper(List<int[]> res, int start, int end, int[] nums){
        if(start==end){
            int[] curr = new int[end+1];
            curr[0] = nums[0];
            for(int i=1;i<=end;i++){
                if(nums[i]%2==nums[i-1]%2) return;
                else curr[i] = nums[i];
            }
            res.add(curr);
        }else{
            for(int i=1;i<start;i++){
                if(nums[i]%2==nums[i-1]%2) return;
                
            }
            for(int i=start;i<=end;i++){
                swap(nums, i, start);
                helper(res, start+1, end, nums);
                swap(nums,i, start);
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}