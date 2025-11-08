class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0) return 0;
        int k=0;
        int curr = 1;
        while(curr*2<=n){
            curr*=2;
            k++;
        }
        return (1<<(k+1))-1-minimumOneBitOperations(n^curr);
    }
}
/*
110

1 step for -> 010

from 010 to 000
3 steps
011
001
000


*/