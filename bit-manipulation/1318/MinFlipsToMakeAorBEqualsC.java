class Solution {
    public int minFlips(int a, int b, int c) {
        int differentBitsInAorBxorC = Integer.bitCount(c ^= (a | b));
        int bitsWhereBothAandBNeedsToBeFlipped = Integer.bitCount(a & b & c);

        return differentBitsInAorBxorC + bitsWhereBothAandBNeedsToBeFlipped;
    }
}
