/*
Intuition:
Problem is string + recursion combination. We simulate the process of forming an additive sequence by picking the first two numbers and checking whether the rest of the string follows by  matching expected sums.

Try all possible pairs of first and second numbers avoiding leading zeros. Use recursion to validate whether the remaining string starts with the sum of the previous two. This mimics the backtracking structure often seen in real interviews.
*/
class Solution {
    public boolean isAdditiveNumber(String num) {
        for(int i=1;i<num.length();i++){
            for(int j=i+1;j<num.length();j++){
                if((num.charAt(0)=='0' && i>1) || (num.charAt(i)=='0' && j>i+1)){
                    continue;
                }
                if(check(num.substring(0,i), num.substring(i,j), num.substring(j))) return true;
            }
        }
        return false;
    }
    private boolean check(String a, String b, String s){
        if(s.length()==0) return true;
        String c = add(a,b);
        return s.startsWith(c) && check(b, c, s.substring(c.length()));
    }

    private String add(String a, String b){
        StringBuilder sb = new StringBuilder();
        int aPtr = a.length()-1, bPtr = b.length()-1;
        int carry = 0;
        while(aPtr>=0 || bPtr>=0){
            int currA = (aPtr>=0?a.charAt(aPtr):'0')-'0';
            int currB = (bPtr>=0?b.charAt(bPtr):'0')-'0';
            sb.insert(0, (currA+currB+carry)%10);
            carry = (currA+currB+carry)/10;
            aPtr--;
            bPtr--;
        }
        if(carry>0) sb.insert(0,carry);
        return sb.toString();
    }
}