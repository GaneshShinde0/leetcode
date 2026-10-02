class Solution:
    def minOperations(self, nums: List[int]) -> int:
        c = Counter(nums)
        n = len(nums)
        
        # If every element is already 1 (or already all equal), 0 ops needed.
        if c[1] == n:
            return 0
        
        max_val = max(nums) + 1
        divisor = Counter()
        multiple = Counter()
        for num in c.keys():
            for val in range(num, max_val, num):
                divisor[val] += c[num]
                multiple[num] += c[val]
        
        ans = n
        acc = 0
        for num in sorted(c.keys()):   # <-- must process in increasing order
            acc += c[num]
            if num == 1:
                continue  # target 1 is unreachable unless all elements are 1 (handled above)
            cost_below = 2 * (acc - c[num]) - divisor[num] + c[num]
            cost_above = 2 * (n - acc) - multiple[num] + c[num]
            ans = min(ans, cost_below + cost_above)
        return ans