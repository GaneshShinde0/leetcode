class Solution {
    public int longestSubarrayInitialSolution(int[] nums) {
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

    public int longestSubarray(int[] nums) {
        // Number of zero's in the window.
        int zeroCount = 0;
        int longestWindow = 0;
        // Left end of the window.
        int start = 0;
        
        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);
                          
            // Shrink the window until the count of zero's
            // is less than or equal to 1.
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
              
            longestWindow = Math.max(longestWindow, i - start);
        }
        return longestWindow;
    }
}