class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        return lengthOfLongestSubstringKDistinct(s, 2);
    }
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        int res = 0;
        int left = 0, right = 0, n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(;right<n;right++){
            char rightChar = s.charAt(right);
            hm.put(rightChar,hm.getOrDefault(rightChar,0)+1);
            while(left<right && hm.size()>k){
                char leftChar = s.charAt(left);
                hm.put(leftChar,hm.getOrDefault(leftChar,0)-1);
                if(hm.get(leftChar)<=0) hm.remove(leftChar);
                left++;
            }
            res = Math.max(right-left+1,res);
        }
        return res;
    }
}