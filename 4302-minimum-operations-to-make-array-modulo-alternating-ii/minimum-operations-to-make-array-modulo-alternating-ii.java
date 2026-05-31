/*
Input: nums = [1,4,2,8], k = 3
evens => 1,2
odds  => 1,2

# Intuition:
If we could somehow instantly know how many operations it would take to make all even elements have a modulo of any x, and all the odd elements have modulo y, this would be easy.

Lets say we figure out that. Since x and y must be different, we could then just find the minimum and second minimum cost among all x from 0 upto k, do the same with y.

Then, if the x value with the min cost is different than the y value with the min cost, we can just return the sum of the min x cost and the min y cost. Otherwise, we just use the second min cost for either x or y.

Okay, but how do we find the cost instantly for any x or any y?
- We must first make two frequency arrays, one for even indexed elements, and other for odd indexed elements. 
- These will track the frequency of all elements %k, as only the remainders of each element%k matter.

We must use the frequencies to make two arrays, costE and costO, both length k, where costE[i] is the cost to make all even indexed elements eqal to i, and costO[i] is the cost to make all odd indexed elements equal to i.

We can calculate these arrays once in O(k), because, if we can find the cost of i, the transition to i+1 is O(1) with some clever logic, so we can just calculate cost[0] and then fill the array from there.


*/
class Solution {
    public long minOperations(int[] nums, int k) {
        int n = nums.length;
        int[] freqE = new int[k], freqO = new int[k];
        for(int i=0;i<n;i++){
            int curr = nums[i]%k;
            if(i%2==0) freqE[curr]++;
            else freqO[curr]++;
        }
        long[] costE = calcCost(freqE,k,(n+1)>>1);

        long minE = Long.MAX_VALUE/2, secondMinE = Long.MAX_VALUE/2;
        int bestE = -1;
        for(int i=0;i<k;i++){
            long cost = costE[i];
            if(cost<minE){
                secondMinE = minE;
                minE = cost;
                bestE = i;
            }else if(cost<secondMinE) secondMinE = cost;
        }

        long[] costO = calcCost(freqO, k, n>>1);
        long minO = Long.MAX_VALUE/2, secondMinO = Long.MAX_VALUE/2;
        int bestO = -1;
        for(int i=0;i<k;i++){
            long cost = costO[i];
            if(cost<minO){
                secondMinO=minO;
                minO = cost;
                bestO = i;
            }else if(cost<secondMinO) secondMinO = cost;
        }
        if(bestE==bestO) return Math.min(minE+secondMinO, minO+secondMinE);

        return minE+minO;
    }
    
    private long[] calcCost(int[] freq, int k, int totalCount){
        long[] cost = new long[k]; 
        for(int i=0;i<k;i++) cost[0] += (long)freq[i]*Math.min(i,k-i);
        
        long count = 0;
        int half = k>>1;
        for(int i=1;i<=half;i++) count+=freq[i];
        
        if((k&1)==0){
            for(int i=1;i<k;i++){
                cost[i]+=cost[i-1]+totalCount-2*count;
                count+=freq[(i+half)%k]-freq[i];
            }
        }else{
            for(int i=1;i<k;i++){
                cost[i] = cost[i-1]+totalCount-2*count-freq[(i+half)%k];
                count += freq[(i+half)%k]-freq[i];
            }
        }
        return cost;
    }
}

/*
Time Complexity: O(n+k)
Space complexity: O(k)


*/