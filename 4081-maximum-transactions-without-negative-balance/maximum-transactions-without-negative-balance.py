import heapq
from typing import List

class Solution:
    def maxTransactions(self, transactions: List[int]) -> int:
        count = 0
        current_sum = 0
        pq = []  # This will act as our min-heap
        
        for t in transactions:
            # If taking the transaction makes the balance negative
            if current_sum + t < 0:
                # If the heap is not empty and the most negative transaction 
                # we've taken is worse (smaller) than the current one
                if pq and pq[0] < t:
                    temp = heapq.heappop(pq)
                    current_sum = current_sum + t - temp
                    heapq.heappush(pq, t)
            else:
                # We can safely take this transaction
                current_sum += t
                count += 1
                if t < 0:
                    heapq.heappush(pq, t)
                    
        return count