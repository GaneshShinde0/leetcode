/*
Enumerate String From Right to Left

Intuition:
Observe that the prime factors of t can only be 2,3,5,7; since these are the only prime factors that can appear in the digits 1 through 9. Therefore, if t contains any other prime factor, we can immediatley return "-1"; otherwise a valid solution is guaranteed to exist.

Constructing the answer.

Problem requires finding the smallest number that is greater than or equal to the given string num. For example, suppose num = 111. If we keep the most significant digit  equal to 1, then second digit cannot be smaller than its original value; otherwise, the constructed number would become smaller than num. However, once we increase a digit, all subsequent digits can be choosen arbitrarily from 1,9.

Consider how to determine whether the constructed number is divisible by t.

Suppose the current digit is x, The contribution of this digit to the product is captured by gcd(t,x) so after fixing the digit, the product of remaining digits only needs to be multiple of t/gcd(t,x)

Based on this observation, define an array rem, where rem[i] represents the factor that the product of the digits from position i to the position n-1 must still contribute initially,

rem[0] = t, and the transition is rem[i+1] = rem[i]/gcd(rem[i], num[i])

Using this array, when enumerating positions from right to left, we immediately know the remaining factor that still needs to be constructed after fixing the prefix.

if rem[n] = 1, then the product of the digits in num is already divisible by t, so no modification is required and we can simply return num.

Otherwise, we need to modify the string.

Assume that num does not contain any '0' characters. We start enumerating position from i= n-1 toward 0.

- First Increase nums[n-1] after increasing it compute
    tNow = rem[n-1]/ gcd(rem[n-1], num[n-1])

If tNow = 1, then the modified number already satisfies the divisibility requirement, so return it immediatly.

- If all digits from the current value upto 9 have been tried without success, stop modifying num[n-1] and move to num[n-2]
- After increasing num[n-2] compute

tNow = rem[n-2]/gcd(rem[n-2], num[n-2])

At this poing, the last digit can be choosen freely. We greedily enumerate digits from 9 to 1. Whenever the current digit dibides tNow, we place it at the current position and update

tNow = tNow/digit.

If tNow becomes 1, then the required product has been completely constructed and we return the current string.

We continue this process for every position. Specifically, we enumerate i from right to left, try increasing num[i] and compute the corresponding tNow. Since num[i] has already been increased, every position after i can be chosen freely.

To obtain the smallest possible annwer,earlier positions should be as small as possible. THerefor ewhen filling the suffix, we greedily process positions from right to left and assign the largest possible digits first. Specifically, for each position j from n-1 down to i+1, we enumerate digits from 9 down to 1. Whenever a digit divides tNow we place it at position j, update tNow accordingly and continue. If the entire suffix can be constucted successfully, we have found the answer. otherwise, we continue trying larger values for num[i]

If No solution is found after processing every position, then the answer must contian more digits than num. In this case, we repeatedly extract factors from t using digits from 9 down to 2, and then prepend enough '1' characters to obtain the shotest possible valid number.

Finally, if num contains a '0', every such digit must be modified because answer cannot contain zeros. While constructing the rem array, we record the position pos of the leftmost '0' and start enumeration directly from that position. This guarantes that every '0' will be replaced in the final answer.


*/
class Solution {
    public String smallestNumber(String num, long t) {
        long temp = t;
        for(int i=2; i<=9;i++){
            while(temp%i==0){
                temp/=i;
            }
        }
        if(temp>1) return "-1";

        int n = num.length();
        long[] rem = new long[n+1];
        rem[0] = t;
        int pos = n-1;

        char[] numChars = num.toCharArray();
        for(int i=0;i<n;i++){
            if(numChars[i]=='0'){
                pos = i;
                break;
            }
            rem[i+1] = rem[i]/gcd(rem[i], numChars[i]-'0');
        }

        if(rem[n]==1) return num;

        for(int i=pos; i>=0; i--){
            while(++numChars[i]<='9'){
                long tNow = rem[i]/gcd(rem[i], numChars[i]-'0');
                int k = 9;
                for(int j=n-1;j>i;j--){
                    while(tNow%k!=0){
                        k--;
                    }
                    tNow /= k;
                    numChars[j] = (char) ('0'+k);
                }
                if(tNow==1) return new String(numChars);
            }
        }

        StringBuilder ans = new StringBuilder();
        long originalT = t;
        for(int i=9;i>1;i--){
            while (originalT%i==0){
                ans.append((char)('0'+i));
                originalT /= i;
            }
        }

        int padding = Math.max(n+1-ans.length(),0);
        for(int i=0;i<padding; i++) ans.append('1');
        return ans.reverse().toString();
    }

    private long gcd(long a, long b){
        while(b!=0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
