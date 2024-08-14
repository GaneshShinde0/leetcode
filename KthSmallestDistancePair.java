class KthSmallestDistancePair {
    /**
     * Naive approach to find the k-th smallest distance pair.
     * This method generates all possible pair distances, sorts them, and returns the k-th smallest.
     *
     * Time Complexity: O(n^2 log n)
     * Space Complexity: O(n^2)
     *
     * @param nums the input array
     * @param k the k-th smallest distance to find
     * @return the k-th smallest distance
     */
    public int smallestDistancePairNaive(int[] nums, int k) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                li.add(Math.abs(nums[i] - nums[j]));
            }
        }
        Collections.sort(li);
        return li.get(k - 1);
    }

    /**
     * Optimized approach using HashMap to store frequency of distances.
     * This method counts the frequency of each distance, sorts the distances by key, and then finds the k-th smallest.
     *
     * Time Complexity: O(n^2 + d log d) where d is the number of unique distances
     * Space Complexity: O(d)
     *
     * @param nums the input array
     * @param k the k-th smallest distance to find
     * @return the k-th smallest distance
     */
    public int smallestDistancePairUsingHashMap(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                hm.put(diff, hm.getOrDefault(diff, 0) + 1);
            }
        }

        // Convert the HashMap to a List of Map.Entry and sort by key (distance)
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort(Map.Entry.comparingByKey());

        // Iterate through sorted entries to find the k-th smallest distance
        for (Map.Entry<Integer, Integer> e : list) {
            k -= e.getValue();
            if (k <= 0) return e.getKey();
        }
        return -1;
    }

    /**
     * Attempt using TreeMap to store distances (Failed due to Time Limit Exceeded).
     *
     * Time Complexity: O(n^2 log n)
     * Space Complexity: O(n^2)
     *
     * @param nums the input array
     * @param k the k-th smallest distance to find
     * @return the k-th smallest distance
     */
    public int smallestDistancePairTreeMap(int[] nums, int k) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                tm.put(diff, tm.getOrDefault(diff, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            k -= entry.getValue();
            if (k <= 0) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * Optimized approach using a bucket sort mechanism based on distance values.
     *
     * Time Complexity: O(n^2 + M) where M is the maximum distance
     * Space Complexity: O(M)
     *
     * @param nums the input array
     * @param k the k-th smallest distance to find
     * @return the k-th smallest distance
     */
    public int smallestDistancePairUsingDistanceBucket(int[] nums, int k) {
        int arrayLength = nums.length;
        int maxElement = Integer.MIN_VALUE;

        // Find the maximum element in the array
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        // Initialize a bucket array to store counts of each distance
        int[] distanceBucket = new int[maxElement + 1];

        // Populate the bucket array with counts of each distance
        for (int i = 0; i < arrayLength; ++i) {
            for (int j = i + 1; j < arrayLength; ++j) {
                int distance = Math.abs(nums[i] - nums[j]);
                ++distanceBucket[distance];
            }
        }

        // Find the k-th smallest distance
        for (int dist = 0; dist <= maxElement; ++dist) {
            k -= distanceBucket[dist];
            if (k <= 0) {
                return dist;
            }
        }

        return -1;
    }

    /**
     * Most optimized approach using binary search on distances and sliding window technique.
     *
     * Time Complexity: O(n log n + n log M) where M is the maximum possible distance
     * Space Complexity: O(1) additional space
     *
     * @param nums the input array
     * @param k the k-th smallest distance to find
     * @return the k-th smallest distance
     */
    public int smallestDistancePairMostOptimized(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];

        // Binary search on the possible distances
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * Count the number of pairs with distance <= maxDistance using a sliding window.
     *
     * @param nums the sorted input array
     * @param maxDistance the maximum allowed distance
     * @return the count of pairs with distance <= maxDistance
     */
    private int countPairs(int[] nums, int maxDistance) {
        int count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > maxDistance) {
                left++;
            }
            count += right - left;
        }
        return count;
    }

    /**
     * Alternative approach using binary search and dynamic programming with prefix sums.
     *
     * Time Complexity: O(n log n + n log M)
     * Space Complexity: O(M)
     *
     * @param nums the input array
     * @param k the k-th smallest distance to find
     * @return the k-th smallest distance
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int arraySize = nums.length;
        int maxElement = nums[arraySize - 1];
        int prefixCountSize = maxElement * 2;

        // Initialize prefix counts and value counts
        int[] prefixCount = new int[prefixCountSize];
        int[] valueCount = new int[maxElement + 1];

        // Compute prefix counts and value counts
        int prefixIndex = 0;
        for (int value = 0; value < prefixCountSize; ++value) {
            while (prefixIndex < arraySize && nums[prefixIndex] <= value) {
                ++prefixIndex;
            }
            prefixCount[value] = prefixIndex;
        }
        for (int i = 0; i < arraySize; ++i) {
            ++valueCount[nums[i]];
        }

        // Binary search to find k-th smallest distance
        int left = 0, right = maxElement;
        while (left < right) {
            int middle = (left + right) / 2;
            int count = countPairs(nums, prefixCount, valueCount, middle);
            if (count < k) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    /**
     * Count the number of pairs with distance <= maxDistance using prefix counts.
     *
     * @param nums the sorted input array
     * @param prefixCount the precomputed prefix counts
     * @param valueCount the count of each value in the array
     * @param maxDistance the maximum allowed distance
     * @return the count of pairs with distance <= maxDistance
     */
    private int countPairs(int[] nums, int[] prefixCount, int[] valueCount, int maxDistance) {
        int count = 0;
        int arraySize = nums.length;
        int index = 0;
        while (index < arraySize) {
            int currentValue = nums[index];
            int valueCountForCurrent = valueCount[currentValue];
            int pairsWithLargerValues = prefixCount[Math.min(currentValue + maxDistance, prefixCount.length - 1)] - prefixCount[currentValue];
            int pairsWithSameValues = (valueCountForCurrent * (valueCountForCurrent - 1)) / 2;
            count += pairsWithLargerValues * valueCountForCurrent + pairsWithSameValues;
            while (index + 1 < arraySize && nums[index] == nums[index + 1]) {
                ++index;
            }
            ++index;
        }
        return count;
    }
}
