/*

0100
1110
0010

0100
1110
0100

*/


class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] freq = new int[32];
        for(int num:nums){
            int j = 0;
            for(int i=0;i<32;i++){
                if((num&(1<<i))!=0){
                    freq[i]++;
                }
            }
        }
        int res = 0;
        /*
        count of such unique pairs is  
        k
          C 
        1
        ​
        ∗ 
        n−k
          C 
        1
        ​
        =k⋅(n−k) for this particular bit. Hence Hamming Distance for this particular bit is k⋅(n−k).
        */
        for(int i=0;i<32;i++){
            if(freq[i]==0||freq[i]==nums.length) continue;
            res+=(nums.length-freq[i])*freq[i];
        }
        return res;
    }
}