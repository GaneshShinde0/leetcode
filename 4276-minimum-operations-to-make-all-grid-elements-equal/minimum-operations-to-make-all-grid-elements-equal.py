class Solution:
    def minOperations(self, grid: list[list[int]], k: int) -> int:
        m = len(grid)
        n = len(grid[0])
        
        col_sum = [0] * n
        ops_ring = [[0] * n for _ in range(k)]
        
        has_candidate = False
        candidate_x = 0
        
        sum_ops0 = 0
        sum_ops1 = 0
        min_x = float('-inf')
        
        for i in range(m):
            if i >= k:
                evict_row = i % k
                for j in range(n):
                    col_sum[j] -= ops_ring[evict_row][j]
                    ops_ring[evict_row][j] = 0
            
            window_sum = 0
            for j in range(n):
                window_sum += col_sum[j]
                req0 = -grid[i][j] - window_sum
                
                if i <= m - k and j <= n - k:
                    ops_ring[i % k][j] = req0
                    col_sum[j] += req0
                    window_sum += req0
                    
                    o1 = 1 if (i % k == 0 and j % k == 0) else 0
                    sum_ops0 += req0
                    sum_ops1 += o1
                    
                    if o1 == 1:
                        if -req0 > min_x:
                            min_x = -req0
                    else:
                        if req0 < 0:
                            return -1
                else:
                    r0 = req0
                    r1 = 1 if ((i // k) * k > m - k or (j // k) * k > n - k) else 0
                    
                    if r1 != 0:
                        x = -r0
                        if not has_candidate:
                            candidate_x = x
                            has_candidate = True
                        elif candidate_x != x:
                            return -1
                    else:
                        if r0 != 0:
                            return -1
                
                if j >= k - 1:
                    window_sum -= col_sum[j - k + 1]
        
        if has_candidate:
            if candidate_x < min_x:
                return -1
        else:
            candidate_x = min_x
            
        return sum_ops0 + candidate_x * sum_ops1