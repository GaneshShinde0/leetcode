class Solution {
    public boolean checkDivisibility(int n) {
        int prod = 1, sum = 0, temp = n;
        while(temp>0){
            int curr = temp%10;
            temp/=10;
            prod *= curr;
            sum += curr;
        }
        return n%(sum+prod)==0;
    }
}