/*
Question is asking 

zero/num1 == one/num2

Rephrase

zero*num2 = one*num1;
zero*num2- one*num1 == 0; ==> If this is there then we have result;
*/
class Solution{
    public long fixedRatio(String s, int num1, int num2) {
        int zero = 0;
        int one = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0,1);
        long result = 0;
        for(char c:s.toCharArray()){
            if(c=='0') zero++;
            else one++;
            result+=seen.getOrDefault(zero*num2-one*num1, 0); // If current satisfies all previous would also satisfy.
            seen.put(zero*num2-one*num1, seen.getOrDefault(zero*num2-one*num1,0)+1);
        }
        return result;
    }
}