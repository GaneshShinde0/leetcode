class Solution {
    public int climbStairs(int n) {
        if(n<2) return n;
        int t1 = 1, t2 = 2;
        for(int i=2;i<n;i++){
            int temp = t2;
            t2 = t1+t2;
            t1 = temp;
        }
        return t2;
    }
}