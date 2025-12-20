class Solution {
    public long lastInteger(long n) {
        long head = 1;
        long step = 1;
        long remaining = n;
        boolean leftToRight = true;

        while (remaining > 1) {
            if (!leftToRight && remaining % 2 == 0) {
                head += step;
            }
            remaining = (remaining+1)/2;
            step *= 2;
            leftToRight = !leftToRight;
        }

        return head;
    }
}
