class Solution {
    public int binaryGap(int n) {
        int res = 0, curr = 0, prev = -1;
        while(n>0){
            int rem = n%2;
            n=n/2;
            if(rem==1 && prev !=-1 ){
                res = Math.max(res, curr-prev);
                prev = curr;
            }else if(rem==1){
                prev=curr;
            }
            curr++;
        }
        return res;
    }
}
/*

22

10110

prev = 0

*/
