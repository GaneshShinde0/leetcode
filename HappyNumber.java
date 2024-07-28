class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sumOfDigitSquare(slow); // move slow pointer one step
            fast = sumOfDigitSquare(sumOfDigitSquare(fast)); // move fast pointer two steps
        } while (slow != fast);
        return slow == 1;
    }

    public int sumOfDigitSquare(int x){
        int sum=0;
        while(x!=0){
            sum+=(x%10)*(x%10);
            x=x/10;
        }
        return sum;
    }
}
