class Solution {
    //O(log(n))
    private int numDigits(int n){
        int result = 0;
        while(n != 0){
            n = n / 10;
            result += 1;
        }
        return result;
    }
   //O(n)
    public int primePalindrome(int N) {
        while(true){
            if(N>=8 && N<=11){
                return 11;
            }
            if(reverse(N) == N && isPrime(N)){
                return N;
            }
            int digitCount = numDigits(N);
            if(digitCount % 2 == 0){
                N = (int)Math.pow(10,digitCount)+1;
            }else{
                N += 1;
            }
        }
    }
    //O(n)
    private boolean isPrime(int n){
        if(n<2){
            return false;
        }
        if(n==2){
            return true;
        }
        int d = (int)Math.sqrt(n);
        for(int i = 2;i<=d;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    //O(log(n))
    private int reverse(int n){
        int rev = 0;
        while(n>0){
            rev = rev * 10 + (n % 10);
            n = n / 10;
        }
        return rev;
    }
}