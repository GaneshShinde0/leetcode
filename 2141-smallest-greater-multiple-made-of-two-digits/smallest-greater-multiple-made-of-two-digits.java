/*
Here basically we are asked with any number greater than k which has either of digits.

## Approach 
We use DFS and backtracking. At each step first try adding digit1, and then digit2. Take the minum of the two in the end.
*/
class Solution {
    public int findInteger(int k, int digit1, int digit2) {
        int rv1 = dfs(k,digit1, digit2, digit1);
        int rv2 = dfs(k,digit1, digit2, digit2);
        if(rv1 == -1 || rv2 == -1){
            return Math.max(rv1,rv2);
        }else{
            return Math.min(rv1, rv2);
        }
    }

    private int dfs(int k, int digit1, int digit2, long curr){
        if(curr>=Integer.MAX_VALUE || curr == 0) return -1;
        if(curr>k && curr%k==0) return (int) curr;
        int res1 = dfs(k,digit1, digit2, curr*10+digit1);
        int res2 = dfs(k,digit1, digit2, curr*10+digit2);

        if(res1 == -1 || res2==-1){
            return Math.max(res1,res2);
        }else{
            return Math.min(res1,res2);
        }
    }























    public int findIntegerTLE(int k, int digit1, int digit2) {
        int d1 = digit1*10+digit2;
        int d2 = digit2*10+digit1;
        if(d1==d2) d1 = digit1;
        int i = Math.min(Math.min(digit1,digit2),Math.min(d1,d2));
        if(k>=100) return -1;

        for(i=Math.max(i,k+k);i<=1000000000;i+=k){
            if(notContainsOtherThanDigits(i,digit1,digit2) && i%k==0) return i;
        }
        return -1;
    }

    private boolean notContainsOtherThanDigits(int n, int d1,int d2){
        while(n>0){
            int temp = n%10;
            n=n/10;
            if(!(temp==d1 || temp==d2)) return false;
        }
        return true;
    }
}