class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, prod =1;
        int temp = n, div = 0;
        while(temp>0){
            div = temp%10;
            sum+=div;
            prod*=div;
            temp = temp/10;
        }
        return n%(sum+prod)==0;
    }
}