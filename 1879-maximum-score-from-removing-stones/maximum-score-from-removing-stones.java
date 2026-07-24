class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] temp = {a,b,c};
        int sum = a+b+c;
        int max = Math.max(Math.max(a,b),c);
        return Math.min(sum/2, sum-max);
    }
}