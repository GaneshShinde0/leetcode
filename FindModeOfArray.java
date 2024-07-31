class Solution {
  // Faster Method Boyer-Moore Voting Algorithm
    public int majorityElementUsingBoyerMoore(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // Find the candidate
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Verify that the candidate is the majority
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        }

        throw new IllegalArgumentException("No majority element found");
    }
  
    public int majorityElementUsingHashMap(int[] nums) {
        Map<Integer, Integer> countDigits = new HashMap<>();
        int res=-1;
        int maxCount=-1;
        for(int n:nums){
            countDigits.put(n,1+countDigits.getOrDefault(n,0));
            if(countDigits.get(n)>maxCount){
                maxCount=countDigits.get(n);
                res=n;
            }
        }  
        return res; 
    }
}
