/*
Consecutive Numbers Sum
# Find Divisors/ Integer Factorization problemm
N is the sum of k consecutive numbers i.e. N = (x+1)*(x+2)*...*(x+k)

e.g. 

15 = 14+1 , x = 14, k =1
15 = 7+8 = (6+1)+(6+2), x = 6, k = 2
15 = 7+8 = (6+1) + (6+2) x = 6, k = 2
15 = 4+5+6 = (3+1) + (3+2) + (3+3), x = 3, k = 3
15 = 1+2+3+4+5+6 = (0+1)+(0+2)+(0+3)+(0+4)+(0+5), x = 0, k=5

Lets regroup the terms N = xk + (1+2+...+k) and use well known formula for the sum of natural numbers 1+2+...+k = k(k+1)/2:

N = xk + k(k+1)/2 ----- 1
2N = k(2x+k+1) ----- 2

That means, the problem is to figure out all possible pairs of x and 2x+k+1 which are both divisors of a number 2N. To find a number of ways to factor 2N is so called Integer Factorization problem.

The best way to solve this problem is to run Shor's Algorithm on the quantum computer, that requires O(log^2N log log N log log log N) time. If there is no quantum computer in the interview room, just use classical GNFS Algorithm, which runs in a decent O(e^(log^1/3N (log log N)^2/3)) time.

Speaking seriously, one has to stay reasonable during the interview and figure out the right balance between speed and simplicity.

Time complexity to Target during the interview  O(N^1/2)

First, one could iterate from 1 to N and figure out all divisors in a linear time.

1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 ---- Linear time: iterate from 1 to N.

Second, the divisors are paired, i.e. if number i is a divisor of N, then number N/i is a divisor of N too. That means its enough to iterate up to N^1/2

1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 ---- sqrt(N) time: iterate from 1 to sqrt(N) if i is a divisor, then N/i is a divisor, too

O(N^1/2) is definitely enough for the interview. In this article, we consider two simple solutions, which are well suited for the interview and keep the rest out of scope.

Approach 1: Mathematical: Sum of First K Natural Numbers O(N^1/2)

Intuition 

N = xk+ k(k+1)/2 ----- 1
derive x 
x = N/k - (k+1)/2 ----2

and set two constraints.
- x should be greater or equal to zero.
- x should be an integer.

The first constraint is easy to apply using completing the square tehnique (https://en.wikipedia.org/wiki/Completing_the_square)
N/k >= (k+1)/2 ---- 3
2N + 1/4 >=(k+1/2)^2  ---- 4

k<=(2N+1/4)^1/2 - 1/2 ---- 5

The first constraint sets the upper boundary for k. The second constaint, x should be integer and can be verfied during the iteration over k.

Algorithm:
- Initiate the counter to zero
- Iterate over k from 1 to (2n+1/3)^1/2 - 1/2
- if x = N/k - (k+1)/2 is an integer, increase the counter by one
- return the counter.


*/

class Solution {


    // Mathematical Sum of first K natural Numbers, O(n^1/2)
    // N = (x + 1) + ... + (x + k)
    // N = x k + k(k + 1)/2
    public int consecutiveNumbersSum1(int n) {
        int count = 0;
        // x>0 --> N/k-(k+1)/2>0
        int upper_limit = (int)(Math.sqrt(2*n+0.25)-0.5);
        for(int k =1; (k<=upper_limit); k++){
            // x should be an integer
            if((n-k*(k+1)/2)%k==0) count++;
        }
        return count;
    }

    // Approach 2: Mathematical: Decrease N Gradually
    public int consecutiveNumbersSum(int N){
        int count = 0;
        int upperLimit = (int) (Math.sqrt(2*N+0.25)-0.5);
        for(int k=1; k<=upperLimit;++k){
            N-=k;
            if(N%k==0) count++;
        }
        return count;
    }
}