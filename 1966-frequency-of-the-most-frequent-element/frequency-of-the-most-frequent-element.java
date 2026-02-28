class Solution {

    /*
    Time Complexity: O(nlongn) => sorting nlogn , while loop is O(1), for loop is O(n)
    Space Complexity: If you look at code it might look O(1) but.
        Space gets used in sorting and it can be O(logn) or O(n) based on programming language.
        - Java, Arrays.sort() for primitive is implemented using a variant of the Quick Sort algorithm, which has space complexity of O(logn)
        - In C++, the sort() function provided by STL uses a hybrid of Quick Sort, Heap Sort and Insertion Sort, with  a worst case space complexity of O(logn)
        - In Python, the sort() function is implemented using the Timsort algorithm which has a worst case space complexity of O(n).
    */
    public int maxFrequencySlidingWindow(int[] nums, int k) {
        Arrays.sort(nums); // We want to make most elements equal, sorting will help with that
        int left = 0, ans = 0; // left pointer, best answer so far, sum of elements in our window
        long currSum = 0;
        for(int right = 0; right<nums.length; right++){
            long target = nums[right]; // considering long as multiplication might become 10^5*10^5 = 10^10 => outside 2^32 => 2,147,483,647
            currSum+=target;
            // previous window * target - current sum is>k 
            // i.e. consider array as 3 6 7 12 19 22 44 150
            // consider right is 3, so target will become 12
            // currentSum = 28, (target = 12) (target*4=48)
            // If our k is greater than (48-28 ) i.e. 20 then we can take window otherwise we will shrink the window.
            while((right-left+1)*target-currSum>k){ 
                currSum-=nums[left];
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }


    // Advanced Sliding Window
    // Basically once we got longest window we will hold on to it, until we find larger window.
    // Same time and space complexity.
    public int maxFrequencyAdvancedSlidingWindow(int[] nums, int k){
        Arrays.sort(nums);
        int n = nums.length, left = 0;
        long currSum = 0;
        for(int right = 0; right<n;right++){
            long target = nums[right];
            currSum+=nums[right];
            if((right-left+1)*target-currSum>k){ // Single if makes sure we dont decrease the window size.
                currSum -= nums[left];
                left++;
            }
        }
        return n-left;
    }

    public int maxFrequency(int[] nums, int k){
        Arrays.sort(nums);
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            prefix[i] = nums[i]+prefix[i-1];
        }

        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans = Math.max(ans, check(i, k, nums, prefix));
        }
        return ans;
    }
    public int check(int i, int k, int[] nums, long[] prefix){
        int target = nums[i];
        int left = 0, right = i, best = i;

        while(left<=right){
            int mid = (left+right)/2;
            long count = i-mid+1;
            long finalSum = count*target;
            long originalSum = prefix[i]-prefix[mid]+nums[mid];
            long operationsRequired = finalSum-originalSum;
            if(operationsRequired>k){
                left = mid+1;
            }else{
                best = mid;
                right  = mid-1;
            }
        }

        return i-best+1;
    }
}

