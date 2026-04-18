class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n-reverse(n));
    }
    int reverse(int num){
        int temp = 0;
        while(num>0){
            temp = temp*10+num%10;
            num=num/10;
        }
        return temp;
    }
}