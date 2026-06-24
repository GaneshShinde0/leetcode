/*
Input: Three integers n, l, r

ZigZag array of length N is defined as follows
- Each Element lies in the range [l,r]
- No two adjacent elements are equal
- No three consecutive elements form a strictly increasing or decreasing sequence.

Output: Total Number of Valid ZigZag Arrays. (MODULO 10^9+7)

Approach: Dynamic Programming + Matrix Exponentiation
- Refer https://leetcode.com/problems/number-of-zigzag-arrays-i before solving this.

Compared to previous problem, the range of the lower and upper bounds, l and r is significantly smaller while the array length can be as large as 10^9 as a result it is no longer feasible to perform transitions by iterating through all positions.

In Previous problem, prefix sums were used to optimize individual state transitions. This reveals that each state can be expressed as a linear combination of the components of the previous state, which means the transition can be represented using a state transition Matrix. Repeatedly multiplying the initial state by this transition matrix yields the final state. Once the transition is expressed in matrix form, the transition matrix must be square, and repeated transitions correspond to taking powers of that matrix, we can therefore apply fast matrix exponentiation, reducing the outer time complexity from O(n) to O(logn).

Next, let us construct the state vector and transition matrix.
Let m = r-l+1 denote the size of the value range. As in the previous problem, we maintain two state vectors of length m: dp0 and dp1
- dp0 represents states where the last two elements form a strictly decreasing pair.
- dp1 represents states where last two elements form a strictly increasing pair.
- Each state vector has its own transition matrix. Let:
- A be the transition matrix from dp0 to dp1. 
- B be the transition matrix from dp1 to dp0.

The transition can then be written as 
- dp0[i] = dp1[i-1].B
- dp1[i] = dp0[i-1].A

Using block matrices, we can merge the two state vectors into a single state vector of length 2m:

dp0[i], dp1[i]

This yields the unified transition equation.
[dp0[i] dp1[i]] = [dp0[i-1] dp1[i-1]] .[[O A], [B O]]

Among them, the large square matrix U = [[O A], [B O]] is the merged state transition matrix of size (2.m)*(2.m), where O is the m*m zero matrix. The block anti-diagonal structure arises because the two state vectors transition into each other alternatively: dp0 depends only on the previous dp1, and vice versa.

The Reamining Task is to construct matrices A and B.

Both Matrices are of size m*m.

## Matrix A(Transition from dp0 to dp1)

Let i and j denote row and column indices, respectively (1 indexed). When computing dp0.A the jth component of the new state is obtained by taking the dot product of dp0 with t he jth column of A.

To transition into dp1, the new element must be strictly greater than the previous element. Therefore, we need to sum all previous states whose values are smaller than j.

Consequently, in the jth column of A, rows 1 through j-1 contain 1, while all other entries are 0.  Thus A is a strictly upper triangular matrix whose entries above the main diagonal are all 1.

## Matrix B (Transition from dp1 to dp0)
Similarly, transitioning into dp0 requires the new element to be strictly smaller than the previous element. Therefore in the jth ccolumn of B, rows j+1 throgh m contain 1 while all other entries are 0.

Thus B is strictly lower triangular matrix whose entries below the main diagonal are all 1.

For an intuitive understanding, take m = 3 as an example. Then matricces A and B are respectivley.

int[][] A = {
    {0, 0, 0},
    {1, 0, 0},
    {1, 1, 0}
};

int[][] B = {
    {0, 1, 1},
    {0, 0, 1},
    {0, 0, 0}
};

int[][] U = {
    {0, 0, 0, 0, 1, 1},
    {0, 0, 0, 0, 0, 1},
    {0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0},
    {1, 0, 0, 0, 0, 0},
    {1, 1, 0, 0, 0, 0}
};

Suppose the length of the target zigzag array is n, then the final state is dp[n-1], and then the solution process is as follows.

dp[n-1] = dp[0].U^(n-1)

We initialize dp[0] as a vector whose componenta are all 1, compute U^(n-1) fast matrix exponentiation, and then sum all components of the resulting state vector to obtain the answer.

The Matrix Exponentiation procedure is identical to ordinary binary exponentiation, except that multiplication is replaced by matrix multiplication. One implementation detail is worth noting: Instead of starting with an identify matrix, we can directly use dp[0] as the accumulator during exponentiation. SInce dp[0] is a 1*2m vector, every multiplication still produces a 1*2m vector, reducing the cost of several intermediate matrix multiplications.


*/ 
public class Solution {

    private static final int MOD = 1_000_000_007;

    static class Matrix{
        int n, m;
        long[] data;

        Matrix(int n, int m){
            this.n = n;
            this.m = m;
            this.data = new long[n*m];
        }

        long get(int i, int j){
            return data[i*m+j];
        }

        void set(int i, int j, long val){
            data[i*m+j] = val;
        }

        Matrix mul(Matrix b){
            Matrix res = new Matrix(n, b.m);
            for(int i=0;i<n;i++){
                for(int k=0;k<m;k++){
                    long r = this.get(i,k);
                    if(r==0) continue;
                    for(int j=0;j<b.m;j++){
                        res.set(i,j,(res.get(i,j)+r*b.get(k,j))%MOD);
                    }
                }
            }
            return res;
        }

        Matrix pow(long exp, Matrix res){
            Matrix base = new Matrix(n,m);
            System.arraycopy(this.data, 0, base.data, 0, this.data.length);
            while(exp>0){
                if((exp&1l)==1l){
                    res = res.mul(base);
                }
                base = base.mul(base);
                exp>>=1l;
            }
            return res;
        }
    }
    public int zigZagArrays(int n, int l, int r) {
        int m = r-l+1;
        if(n==1) return m;
        Matrix u = new Matrix(2*m,2*m);
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                u.set(i,j+m,1l);
            }
            for(int j= i+1;j<m;j++){
                u.set(i+m,j,1l);
            }
        }
        Matrix dp = new Matrix(1,2*m);
        for(int i=0;i<2*m;i++){
            dp.set(0,i,1l);
        }
        dp = u.pow(n-1,dp);
        long ans = 0;
        for(int i=0;i<2*m;i++){
            ans = (ans+dp.get(0,i))%MOD;
        }
        return (int) ans;
    }
}