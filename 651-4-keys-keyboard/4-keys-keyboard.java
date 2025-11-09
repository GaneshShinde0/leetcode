class Solution {
    public int maxA(int n) {
        int[] dp = new int[n+1];
        if(n<=6) return n;
        for(int i=0;i<6;i++){
            dp[i]=i+1;
        }
        for(int i=0;i<n-3;i++){
            for(int j=i+3;j<=Math.min(n,i+6);j++){
                dp[j]= Math.max(dp[j],(j-i-1)*dp[i]);
            }
        }
        return dp[n-1];
    }
}

/*
N = 7
dp[7] = {1,2,3,4,5,6,0}
for 7


Z Z Z
A
C
V
V

for 8

Z Z Z Z
A
C
V
V
=> 12 

9
Z Z Z Z
A
C
V
V
V

10 

n = 10
Z Z Z Z
A
C
V
V
V
V

Z Z Z Z Z
A
C
V
V
V

n = 11
25

Z Z Z Z Z
A
C
V
V
V
V

n= 12
Z Z Z Z Z Z
A
C
V
V
V
V

n = 13 => 42
Z Z Z Z Z Z 
A
C
V
A
C
V
V


n = 14 => 64
Z Z Z Z 
A
C
V
A
C
V
V
V
V


*/