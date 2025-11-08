class Solution {
    public int minimumOneBitOperations1(int n) {
        if(n==0) return 0;
        int k=0;
        int curr = 1;
        while(curr*2<=n){
            curr*=2;
            k++;
        }
        return (1<<(k+1))-1-minimumOneBitOperations(n^curr);
    }

    public int minimumOneBitOperations(int n) {
        int[] f = new int[32];
        f[0] = 1;
        for(int j=1;j<32;j++) f[j] = f[j-1]*2+1;
        int ans = 0, plus =1 ;
        for(int j=31;j>=0;j--){
            if(!(((1<<j)&n)!=0)) continue;
            if(plus==1) ans += f[j];
            else ans-=f[j];
            plus^=1;
        }
        return ans;
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