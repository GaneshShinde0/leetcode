/*

### **Problem: Minimum Adjacent Swaps for K Consecutive Ones**

Whenever we have a problem about moving specific elements (like `1`s) through a sea of other elements (like `0`s), working directly with the original array can be messy. 

#### **Step 1: Change the Perspective**
Instead of looking at `0`s and `1`s, let's only look at the positions of the `1`s.
* **Example:** `nums = [1, 0, 0, 1, 0, 1]` can be represented as a list of indices: `arr = [0, 3, 5]`.

If we decide to group `k` consecutive `1`s together, we are essentially picking a contiguous sub-array of length `k` from our new list `arr`.
* If `k = 2` and we pick the `1`s at `arr[0]` (which is `0`) and `arr[1]` (which is `3`), it will take `arr[1] - arr[0] - 1` swaps to make them adjacent.

When dealing with `k` elements instead of just `2`, we want to bring them all together into a block. Keeping track of exactly how many spaces each element needs to move to become adjacent (not on top of each other, but side-by-side) gets mathematically messy because of the `-1`, `-2`, `-3` offsets.

#### **Step 2: The Mathematical Trick**
There is a mathematical trick to completely eliminate this mess. What if we create a new array `a` where `a[i] = arr[i] - i`?

* **Test the trick:** Imagine we have three `1`s that are *already* adjacent at indices `4`, `5`, and `6`. So `arr = [4, 5, 6]`.
* If we calculate `a[i] = arr[i] - i` (meaning we subtract `0` from the first element, `1` from the second, and `2` from the third), the new array `a` becomes `[4, 4, 4]`.

This completely changes our problem into something much easier: 
Instead of trying to make `k` elements **adjacent** in `nums`, our goal is now to make `k` elements **equal** in `a`. Conveniently, doing `1` adjacent swap in `nums` corresponds exactly to changing a value in `a` by `1`.

#### **Step 3: Sliding Window & The Median**
We now have a sorted array `a`. We want to take a window of `k` elements from `a` and make them all equal to some target `T`. The cost is the sum of the absolute differences: `|a[i] - T|`. To minimize this cost, **the optimal target `T` is always the median of the window**.

* Slide a window of size `k` across `a`, from `left` to `right`.
* For each window, the median element is simply the element in the middle, at index `mid = left + k / 2`.
* We need to calculate the total cost to make all elements in that window equal to `a[mid]`.

#### **Step 4: Optimization using Prefix Sums**
If `k` is very large, looping through all elements inside the window to calculate the cost takes $O(k)$ time. Doing this for every window results in $O(N \cdot k)$ time complexity, which is too slow (since $N$ can be up to $10^5$). 

We need to calculate the cost in $O(1)$ time. Since `a` is sorted:
* All elements to the right of the median are `>= a[mid]`.
* All elements to the left of the median are `<= a[mid]`.

The cost formula splits nicely:
* **Right side of median:** 
  Cost = $\sum (a[i] - a[mid])$
  Simplifies to: `(Sum of a from mid + 1 to right) - (countRight * a[mid])`
* **Left side of median:**
  Cost = $\sum (a[mid] - a[i])$
  Simplifies to: `(countLeft * a[mid]) - (Sum of a from left to mid - 1)`

*(Note: `countLeft = mid - left` and `countRight = right - mid`)*

By building a **Prefix Sum Array** (`pref`), we can get these block sums instantly!
> *Pro-Tip for Java:* Make your prefix array 1-based (size `a.length + 1`) so `pref[i]` stores the sum of the first `i` elements. This makes the range sum from index `L` to `R` simply `pref[R + 1] - pref[L]`, avoiding `IndexOutOfBounds` exceptions.

---

### **Summary of the Complete Algorithm**

1. Traverse the input array `nums` and populate a list `arr` with the indices of all the `1`s.
2. Convert `arr` into an array `a` by applying `a[i] = arr.get(i) - i`.
3. Build a prefix sum array `pref` from `a` (use `int[]` to prevent integer overflow, as sums can get very large).
4. Initialize `minCost = int.MAX_VALUE`.
5. Loop through `a` with a sliding window of size `k` (from `left = 0` to `right = k - 1`), shifting both pointers up to the end of `a`.
6. For each window:
   * Find `mid = left + k / 2`.
   * Calculate `countLeft = mid - left` and `countRight = right - mid`.
   * Use `pref` to instantly calculate the sum of the left half and the sum of the right half.
   * Calculate the `leftCost` and `rightCost` using the simplified formulas.
   * Calculate `currentCost = leftCost + rightCost`.
   * Update `minCost = Math.min(minCost, currentCost)`.
7. Return `minCost`.

*/
class Solution {
    public int minMoves(int[] nums, int k) {

        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++) if(nums[i]==1) arr.add(i);

        int onesCount = arr.size();
        int[] A = new int[onesCount];
        for(int i=0;i<arr.size();i++){
            A[i] = arr.get(i)-i;
        }

        int[] prefixSum = new int[onesCount];
        prefixSum[0] = A[0];
        for(int i=1;i<arr.size();i++){
            prefixSum[i] = A[i]+prefixSum[i-1];
        }

        int minCost = Integer.MAX_VALUE;
        for(int left = 0, right=k-1;right<onesCount;right++, left++){
            int mid = left + k/2;
            int countLeft = mid-left;
            int countRight = right-mid;
            int leftSum = getSum(prefixSum, left,mid-1);
            int rightSum = getSum(prefixSum, mid+1, right);
            int leftCost = (countLeft*A[mid]-leftSum);
            int rightCost = (rightSum-countRight*A[mid]);
            minCost = Math.min(minCost, leftCost+rightCost);
        }

        return (int) minCost;

    }

    private int getSum(int[] pref, int l, int r) {
        if (l > r) return 0;
        return l == 0 ? pref[r] : pref[r] - pref[l - 1];
    }
}