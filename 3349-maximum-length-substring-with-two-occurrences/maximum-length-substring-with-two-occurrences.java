class SolutionNxN {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            char[] data = new char[26];
            int count = 0;
            // boolean check = true;
            for(int j=i;j<s.length();j++){
                // System.out.println(i+" "+j);
                data[s.charAt(j)-'a']++;
                if(data[s.charAt(j)-'a'] > 2)  break;
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
class Solution {

    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            int ch = s.charAt(right) - 'a';
            count[ch]++;
            while (count[ch] > 2) {
                int ch2 = s.charAt(left) - 'a';
                count[ch2]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}