class Solution {
    public int closestFair(int n) {
        int len = Integer.toString(n).length();

        //odd number of digits
        if (len % 2 != 0) {
            return minNum(len + 1);
        }

        int nextPow = (int) Math.pow(10, len);
        //even number of digits
        for (int i = n; i < nextPow; i++) {
            if (isFair(i)) {
                return i; 
            }
        }
        return minNum(len + 2);
    }

    public int minNum(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        for (int i = 0; i < x / 2; i++)
            sb.append('0');
        for (int i = 0; i < x / 2 - 1; i++)
            sb.append('1');
        return Integer.parseInt(sb.toString());
    }

    public boolean isFair(int x) {
        String str = Integer.toString(x);
        int oddCount = 0;
        for (char c : str.toCharArray()) {
            if (c % 2 != 0) {
                oddCount++;
            }
        }
        return 2 * oddCount == str.length();
    }
}