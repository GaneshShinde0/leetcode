class Solution {
    public int smallestValueUsingRecursion(int n) {
        int sumOfPrimeFactors = 0;
        int temp = n;
        for(int i=2;i<=temp;i++){
            while(temp%i==0){
                temp/=i;
                sumOfPrimeFactors += i;
            }
        }
        if(n==sumOfPrimeFactors) return n;
        else return smallestValue(sumOfPrimeFactors);
    }
    public int smallestValue(int n) {
        while(true){
            int sumOfPrimeFactors = 0;
            int temp = n;
            for(int i=2;i<=temp;i++){
                while(temp%i==0){
                    temp/=i;
                    sumOfPrimeFactors += i;
                }
            }
            if(n==sumOfPrimeFactors) return n;
            n=sumOfPrimeFactors;
        }
    }
}