class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>num*9) return "";
        int nines = sum/9, remainder = sum%9;
        StringBuilder sb = new StringBuilder();
        sb.append("9".repeat(nines));
        if(remainder>0) sb.append(remainder);
        sb.repeat("0",num-sb.length());
        return sb.toString();
    }
}