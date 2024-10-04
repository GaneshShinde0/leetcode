class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count =0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                if(nums[j]-nums[i]==diff){
                    for(int k=j+1;k<nums.length;k++){
                        if(nums[k]-nums[j]==diff){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    // Function to find the number of arithmetic triplets in an array
    public int arithmeticTripletsOptimized(int[] nums, int diff) {
        // An array to keep track of the presence of elements up to the maximum possible value
        boolean[] seen = new boolean[301];
      
        // Mark the presence of each number in the 'seen' array
        for (int num : nums) {
            seen[num] = true;
        }
      
        // Initialize the count for arithmetic triplets
        int count = 0;
      
        // Iterate through the array to find arithmetic triplets
        for (int num : nums) {
            // Check if the two subsequent numbers (with the given difference 'diff') are present
            if (seen[num + diff] && seen[num + 2 * diff]) {
                // If both are present, we found an arithmetic triplet, increment the count
                ++count;
            }
        }
      
        // Return the total count of arithmetic triplets found
        return count;
    }
}
