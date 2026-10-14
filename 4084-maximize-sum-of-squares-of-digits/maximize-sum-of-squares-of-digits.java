class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int nines = sum/9;
        int rem = sum%9;
        if(nines>num||(nines>=num && rem != 0)) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("9".repeat(nines));
        if(rem!=0) sb.append(rem);
        if(num-sb.length()>0)sb.append("0".repeat(num-sb.length()));
        return sb.toString();
    }
}