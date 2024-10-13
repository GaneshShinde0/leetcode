class Solution {

    /* 
    Approach 1 : Brute Force

    Algorithm:
    1. Intitialize k to the number of lists in num and create an array indices to keep track of the current index of each list, initializing all to 0.
    2. Initialize an array range(result) to store the smallest possible range we know initially {0, Integer.MAX_VALUE
    3. Enter an infinite Loop.
        3.1 Initialize curMin= Integer.MAX_VALUE, curMax = Integer.MIN_VALUE, minListIndex = 0;
        3.2 Iterate over each list to find the current minimum and maximum values.
            3.2.1 For Each List get current element using indices[i];
            3.2.2 Update curMin if the current element is less than curMin, and set minListIndex to i.
            3.2.3 Update curMax if the current element is greater than curMax.
        3.3 After checking all lists, if the difference curMax-curMin is smaller than the current range (range[1]-range[0]), update range to {curMin,curMax};
        3.4 Move to the next element in the list that had the minimum value by incrementing indices[minListIndex].
            3.4.1 If the updated index equals the size of num[minListIndex], break the loop(all elements have been processed).
    4. Return the smallest range stored in range.

    Complexity Analysis:
    Let n be the total number of elements across all lists and k be the number of lists.

    Time Complexity: O(n.k)
    In each iteration we traerse all k lists to find the current min and max, it takes O(k) time.
    The loop continues until at least one of the lists is fully traversed. In the worst case, every element from every list is visited, and the total number of elements across all lists is n. Therefore, the loop runs O(n) times.
    Overall, the time complexity becomes O(n.k)

    Space Complexity: O(k)
    The space complexity is dominated by the indices and range arrays, both of which have size proportional to k, the number of lists.
    The indices array stores the current index of each list, so it takes O(k) space.
    The range array also stores two integers, so it takes O(1) space.
    */
    public int[] smallestRangeBruteForce(List<List<Integer>> nums) {
        // Generate solution for two rows and utilize them for others.
        int k = nums.size();
        int[] indices = new int[k];
        int[] range = new int[] {0, Integer.MAX_VALUE};

        while(true){
            int curMin = Integer.MAX_VALUE, curMax = Integer.MIN_VALUE, minListIndex = 0;
            for(int i=0;i<k;i++){
                int currentElement = nums.get(i).get(indices[i]);

                // Update the current minimum
                if(currentElement<curMin){
                    curMin = currentElement;
                    minListIndex = i;
                }

                // Update the current maximum
                if(currentElement>curMax){
                    curMax = currentElement;
                }
            }

            // Update the range if a smaller one is found
            if(curMax - curMin <range[1]-range[0]){
                range[0] = curMin;
                range[1] = curMax;
            }

            // Move to the nexe element in the list that had the minimum value
            if(++indices[minListIndex] == nums.get(minListIndex).size()) break;
        }
        return range;
    }

    /*
    Apprach 2 : Priority Queue (Heap)

    Intuition
    
    We can build on idea of always keeping track of smallest element, but we can make this process bit more efficient. Instead of scanning all the lists to find the smallest element at every step. we can use min-heap to manage the selection of the smallest element in logarithmic time.

    We start by inserting the first element from each list into the heap. The heap gives us quick access to the smallest element among the current numbers we have selected. Along with this, we also keep track of the largest number among the selected elements because our range depends on both the samllest and largest values.

    The strategy is simple: at each step, we extract the smallest elemtn from the heap (root of heap), which corresponds to the current smallest number. This number forms the lower bound of our current range. To continue, we replace this smallest number with the next number from the same list and add it to the heap. After updating the heap, we again check the current range between the smallest element (from the heap) and the largest element (which we track separately). If this new range is smaller than the previous best range, we update it.

    We repeat this process until we can no longer add numbers from one of the lists to the heap.


    Algorithm:
    - Intialize  a priority queue pq to store tuples of the form (value, list_index, element_index) for the smallest elements.
    - Initialize maxVal to the minimum integer, rangeStart to 0, and rangeEnd to the maximum integer.
    - Insert the first element from each list into the min-heap.
        - For each list in nums, push the first elements into pq along with its indices.
        - Update maxVal to the maximum of itself and the newly inserted element.
    - Continue processing while the size of the priority queue equals the number of lists.
        - Extract the smallest element minVal from pq, and get its corresponding indices.
        - Update the smallest range.
            - If the difference between maxVal and minVal is smaller thatn the current range(rangeEnd- rangeStart), update rangeStrart with minVal and rangeEnd to maxVal.
        - If there is a next element int he same list (check using col+1):
            - Retrieve the next value from the same list.
            - Push this next value into pq along with its indices.
            - Update maxVal to be the maximum of itself and the next value.
    - Return an array containing rangeStart and rangeEnd, which represents the smallest range covering at least one number from each of the k lists.


    Complexity Analysis:

    Let n be the total number of elements across all lists and k be the number of lists.
    - Time complexity: O(nlogk)
        The initial loop that inserts the first element from each list into the priority queue runs in O(k). The while loop continues until we have exhausted one of the lists in the priority queue. Each iteration of the loop involves.
            - Extracting the minimum element from the priority queue, which takes O(logk).
            - Inserting a new element from the same list into the priority queue, which also takes O(logk).
        In the worst case, we will process all n elements, leading to a total complexity of O(nlogk).
    - Space complexity: O(k)
        The priority queue can hold at most k elements at any time, corresponding to the first element of each of the k lists. Thus, the space complexity is O(k). Additionally, the space for storing the output range (two integers is negligible and does not contribute to the overall complexity)
    */

    public int[] smallestRangeUsingPriorityQueue(List<List<Integer>> nums){
        // Priority queue to store (value, list index, element index)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a->a[0])
        );

        int maxVal = Integer.MIN_VALUE, rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        // Insert the first elemetnt from each list into the min-heap
        for(int i=0; i<nums.size();i++){
            pq.offer(new int[] {nums.get(i).get(0),i,0}); // First value of every element along with its index.
            maxVal = Math.max(maxVal, nums.get(i).get(0));
        }

        // Continue until we can't proceed further
        while(pq.size()==nums.size()){
            int[] data = pq.poll();
            int minVal = data[0], row = data[1], col = data[2];

            // Update the smallest range.
            if(maxVal-minVal <rangeEnd-rangeStart){
                rangeStart = minVal;
                rangeEnd = maxVal;
            }

            // If possible, add the next element from the same row to the heap
            if(col + 1 < nums.get(row).size()){
                int nextVal = nums.get(row).get(col+1);
                pq.offer(new int[] {nextVal, row, col+1});
                maxVal = Math.max(maxVal, nextVal);
            }
        }
        return new int[] {rangeStart, rangeEnd};
    }

    /*
    Approach 3: Two Pointer

    Intuition:
    Since we need a range that includes one number from each of the k lists, we can think of this as subarray problem. However, the nubmers are spread across multiple lists. To simplify, we can combine all the lists into a single sorted list of numbers. When merging, we also keep track of which list each number came from, since the problem requires atleast one number from each original list in the final range.

    Once We have merged list, the problem becomes finding the smallest range(or subarray) in this list that contains at least one element from each of the original k lists. This is a common scenario for sliding window or two-pointer approach: we want to expand and shrink the window (subarray) dynamically to find the minimum range that meets the criteria.

    The right poiter will expand the window by moving forward in the merged list, and the left pointer will shrink the window once we know the window contains at least one element from each list.

    As the right pointer will expand the window by moving forward in the merged list, and the left pointer will shrink window once we know the window contains atleast one element from each list.

    As the right pointer moves throgh the merged list, we need to ensure that the current subarray includes atleast one number from each list. So we keep track of how many lists are "covered" by the current subarray (i.e., how many of the k lists have atleast one number in current window).

    Once all lists are covered, the window between the left and the right pointer represents a valid range. we then check if this range is the smallest we've found so far.

    After findign a valid range, we need to shrink the window (move the left pointer forward) to see if we can make the range even smaller while still keeping one number from each list in the subarray. As we move the left pointer forward, we check if we lost coverage from any list. If we do, we stop shrinking and start expanding the window again by moving the right pointer.

    We will continue this until we can no longer expand the window (i.e., the right pointer reaches the end of the merged list). By this point, we have explored all possible ranges, and the smallest valid range is our final answer.
    


    Algorithm:
    - Initialize an empty array merged to store pairs of numbers and their respective list indices.
    - Merge all lists into merged:
        - For each list in nums, iterate through its numbers and add each number along with its list index to merged.
    - Sort the merged array to facilitate the two pointer technique.
    - Intitialize a frequencey map freq to keep track of how many times each list is represented in the current window.
    - Set the left pointer to 0, count to 0, and initilize rangeStart to 0 and rangeEnd to INT_MAX.
    - Use a right pointer to iterate through the merged array.
        - Increment the count for the list index in freq for merged[right].
        - If the count for this lsit index becomes 1, increment count (indicating a new list is represented).
    - When all lists are represented (i.e., count == nums.size());
        - Calculate the current range as curRange = merged[right].first - merged[left].first.
        - If curRange is smaller than the previously found range(rangeEnd - rangeStart);
            - Update rangeStart and rangeEnd to the current numbers.
        - Decrement the frequency count for the leftmost number (i.e., merged[left]).
        - If this list index's frequencey becomes 0, decrement count (indicating that a list is no longer represented).
        - Move the left pointer to the right to attempt shrinking the window.
    - After completing the iteration, return the smallest range as a array contianing rangeStart and rangeEnd.

    Complexity: 
    n: total number of elements across all lista and k be the number of lists.
    Time Complexity: (n logn)
    - First nested loop iterates over k lists., in worst case it requires )(n).
    - After merging we sort the merged array which contains n elements, sorting takes nlogn.
    - two pointer take O(n).
    Space complexity.
    - O(n) for storing n elements.
    - Other things take less

    */

    public int[] smallestRange(List<List<Integer>> nums){
        List<int[]> merged = new ArrayList<>();

        // Merge all lists with their list index
        for(int i=0; i<nums.size(); i++){
            for(int num:nums.get(i)){
                merged.add(new int[]{num, i});
            }
        }

        // Sort the merged list
        merged.sort(Comparator.comparingInt(a->a[0]));

        // Two pointers to track the smallest range
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0;
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        for(int right = 0; right<merged.size();right++){
            freq.put(
                merged.get(right)[1],
                freq.getOrDefault(merged.get(right)[1],0)+1
            );

            if(freq.get(merged.get(right)[1])==1) count++;

            // When all lists are represented, try to shrink the window.
            while(count == nums.size()){
                int curRange = merged.get(right)[0] - merged.get(left)[0];
                if(curRange< rangeEnd-rangeStart){
                    rangeStart = merged.get(left)[0];
                    rangeEnd = merged.get(right)[0];
                }
                freq.put(
                    merged.get(left)[1],
                    freq.get(merged.get(left)[1])-1
                );
                if(freq.get(merged.get(left)[1])==0) count--;
                left++;
            }
        }
        return new int[] {rangeStart, rangeEnd};
    }

    public int[] smallestRangeFastest(List<List<Integer>> nums) {
        if (nums.size() == 1) {
            return new int[] { nums.get(0).get(0), nums.get(0).get(0) };
        }
        int k = nums.size();
        int minK = nums.get(0).get(0), minArr = 0;
        int maxK = nums.get(0).get(0), maxArr = 0;
        for (int i = 1; i < k; ++i) {
            List<Integer> list = nums.get(i);
            int val = list.get(0);
            if (val > maxK) {
                maxK = val;
                maxArr = i;
            }
            if (val < minK) {
                minK = val;
                minArr = i;
            }
        }
        int[] ret = new int[] { minK, maxK };
        int[] pos = new int[k];
        boolean done = false;
        int curListLen;
        while (!done) {
            List<Integer> curMinList = nums.get(minArr);
            pos[minArr]++;
            if (curMinList.size() == pos[minArr]) {
                done = true;
                continue;
            }
            int next = curMinList.get(pos[minArr]);
            minK = next;
            for (int i = 0; i < k; ++i) {
                curMinList = nums.get(i);
                curListLen = curMinList.size();
                for (int curIdx = pos[i]; curIdx < curListLen && curMinList.get(curIdx) <= next; curIdx++) {
                    pos[i] = curIdx;
                }
                int curVal = curMinList.get(pos[i]);
                if (curVal < minK) {
                    minK = curVal;
                    minArr = i;
                }
                if (curVal > maxK) {
                    maxK = curVal;
                    maxArr = i;
                }
            }
            if (maxK - minK < ret[1] - ret[0]) {
                ret[1] = maxK;
                ret[0] = minK;
            }
        }
        return ret;
    }

}
