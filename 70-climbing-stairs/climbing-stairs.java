class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int t1=1, t2=2, i=2;
        while(i<n){
            i++;
            int temp = t1;
            t1 = t2;
            t2 = temp+t2;
        }
        return t2;
    }
}