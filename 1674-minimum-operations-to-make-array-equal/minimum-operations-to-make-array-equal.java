/*
n=6
1, 3, 5, 7, 9, 11

(n-1)+(n-3)+(n-5)

5+3+1
*/
class Solution {
    public int minOperations(int n) {
        int res = 0;
        while(n>0){
            res+=(n-1);
            n-=2;
        }
        return res;
    }
}