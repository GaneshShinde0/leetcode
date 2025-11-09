class Solution {

    private int rev(int n){
        int rev = 0;
        while(n>0){
            rev = rev*10+n%10;
            n=n/10;
        }
        return rev;
    }
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=num/2;i<=num;i++){
            if(i+rev(i)==num) return true;
        }
        return false;
    }
}