class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
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
