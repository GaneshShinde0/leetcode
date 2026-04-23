class Solution:
    def tallestBillboardWorks(self, rods: List[int]) -> int:
        N = len(rods)
        INF = 10**10
        @cache
        def calc(index, total):
            if index ==N:
                if(total==0):
                    return 0
                return -INF                
            return max(calc(index+1,total+rods[index])+rods[index],
            calc(index+1,total-rods[index]),
            calc(index+1,total))
        return calc(0,0)

    
    def tallestBillboard(self, rods: List[int]) -> int:
        N = len(rods)
        max_sum = sum(rods)
        delta = max_sum//2
        INF = 10**10
        
        has_cache = [[False]*(max_sum+1) for _ in range(N)]
        cache = [[None]*(max_sum+1) for _ in range(N)]
        # index -> 0 to N
        # total -> 0 to 5000
        def calc(index, total):
            if index ==N:
                if(total==0):
                    return 0
                return -INF
            if(total*2>max_sum):
                return -INF   
            if has_cache[index][total+delta]:
                return cache[index][total+delta]    
            has_cache[index][total+delta] = True    
            cache[index][total+delta] =  max(calc(index+1,total+rods[index])+rods[index],
            calc(index+1,total-rods[index]),
            calc(index+1,total))
            return cache[index][total+delta]
        return calc(0,0)
