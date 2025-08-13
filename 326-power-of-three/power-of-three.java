class Solution {
    public boolean isPowerOfThree8ms(int n) {
        if(n==1) return true;
        while(n!=0){
            if(n%3!=0) return false;
            n=n/3;
            if(n==1) return true;
        }
        return false;
    }
    // 7 ms
    public boolean isPowerOfThree(int n) {
        while(n%3==0&&n>1){
            n=n/3;
        }
        return n==1;
    }
}