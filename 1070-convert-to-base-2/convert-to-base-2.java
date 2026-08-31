class Solution {
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        if(n==0) return "0";
        while(n!=0){
            int remainder = n%-2;
            n= n/-2;
            if(remainder<0){
                remainder+=2; // Shift remainder from -1 to 1
                n+=1; // Compensate byadding 1 to quotient
            }
            sb.insert(0,remainder);
        }
        return sb.toString();
    }
}