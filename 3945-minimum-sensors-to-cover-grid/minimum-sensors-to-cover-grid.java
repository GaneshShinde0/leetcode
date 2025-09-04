class Solution {
    public int minSensors(int n, int m, int k) {
        int a = (int) Math.ceil(m*1.0/(2*k+1));
        int b = (int) Math.ceil(n*1.0/(2*k+1));
        return a*b;
    }
}