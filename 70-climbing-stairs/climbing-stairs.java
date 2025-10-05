class Solution {
    public int climbStairs(int n) {
        int n1 = 0, n2 =1;
        int i=1;
        if(n==1) return 1;
        while(i<=n){
            i++;
            int temp = n2;
            n2=n1+n2;
            n1=temp;
        }
        return n2;
    }
}