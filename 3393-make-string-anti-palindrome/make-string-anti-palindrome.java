class Solution {
    // time = O(nlogn), space = O(n)
    public String makeAntiPalindrome(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int n = chars.length;
        for (int i = n / 2 - 1, k = n - 1 - i; i >= 0; i--) {
            int j = n - 1 - i;
            if (chars[j] == chars[i]) {
                while (k < n && chars[k] == chars[i]) k++;
                if (k < n) swap(chars, j, k);
                else return "-1";
            } else break;
        }
        return String.valueOf(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}