/*
Input: nums = [1,3,1,1,2]
result = [5,0,3,4,0]

fromFront = {1:0}
fromFront = {1:0,3:1}
fromFront = {1:2,3:1}
for every element we willstore sum coming in from previous elements and size of previous elements.. and last lastIndex

Same goes goes for  from right

fromFront: {1:[0,1,0]}
fromFront: {1:[0,1,0],{3:[0,1,1]}}
fromFront: {1:[2,2,2],{3:[0,1,1]}}
(i-lastIdx)*size
*/

class Solution {
    private static class SumSizelastIndex{
        long sum;
        int size;
        int lastIndex;
        SumSizelastIndex(int sum, int size, int lastIndex){
            this.sum = sum;
            this.size=size;
            this.lastIndex = lastIndex;
        }
    }
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        Map<Integer, SumSizelastIndex> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            final int idx = i;
            SumSizelastIndex curr = hm.computeIfAbsent(nums[i],k->new SumSizelastIndex(0,0,idx));
            curr.sum += (i-curr.lastIndex)*(curr.size);
            curr.lastIndex=i;
            curr.size++;
            res[i]=curr.sum;
        }
        Map<Integer, SumSizelastIndex> hm2 = new HashMap<>();
        for(int i=nums.length-1;i>=0;i--){
            final int idx = i;
            SumSizelastIndex curr = hm2.computeIfAbsent(nums[i],k->new SumSizelastIndex(0,0,idx));
            curr.sum += (curr.lastIndex-i)*(curr.size);
            curr.size++;
            curr.lastIndex=i;
            res[i]+=curr.sum;
        }
        return res;
    }
}