class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stk = new Stack<>();

        for (char c : num.toCharArray()) {
            while (!stk.isEmpty() && k > 0 && stk.peek() > c) {
                stk.pop();
                k--;
            }
            stk.push(c);
        }

        for (int i = 0; i < k; i++) {
            if (!stk.isEmpty())
                stk.pop();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!stk.isEmpty()) {
            sb.insert(0, stk.pop());
        }

        if (sb.length() == 0)
            return "0";

        int nonZeroIndex = 0;
        while (nonZeroIndex < sb.length() && sb.charAt(nonZeroIndex) == '0') {
            nonZeroIndex++;
        }

        String result = sb.substring(nonZeroIndex);
        return result.isEmpty() ? "0" : result;

    }
}