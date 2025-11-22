class Solution {
    public int smallestRepunitDivByKInitial(int k) {
        int remainder = 1, lengthOfN = 1;
        Set<Integer> seenRemainders = new HashSet<>();
        while(remainder%k!=0){
            remainder = (remainder*10+1)%k;
            lengthOfN++;
            if(seenRemainders.contains(remainder)){
                return -1;
            }else{
                seenRemainders.add(remainder);
            }
        }
        return lengthOfN;
    }
    public int smallestRepunitDivByK(int k) {
        int count = 1;
        int remainder = 1%k;

        if(k%2 == 0 || k%5 == 0)
        {
            return -1;
        }

        while(remainder != 0){
            remainder = (remainder*10 + 1)%k;
            count++;
        }

        return count;
    }
}
/*
1111111111111111 

n%k==0

... Will have to mimic division.
for all even K's ans -> -1
k = 1 => 1
K = 3 => 111
K = 5 => -1
K = 7 => 

Intuition:

We need to do two things.
1. Check if the required number N exists.
2. Find out length(N)

The second one is easy; we need to keep multiplying N by 10 and add 1 until n%K=0. However, since N might overflow, we need to use remainder.
- Properties of remainder say that if something can be divided by remainder it can be divided by number.

Initially 
    Remainder = 1;
    lengthOfN = 1

While (Remainder%K!=0){
    N = Remainder*10+1
    Remainder = N%K;
    lengthOfN+=1
}
return lengthOfN;
*/