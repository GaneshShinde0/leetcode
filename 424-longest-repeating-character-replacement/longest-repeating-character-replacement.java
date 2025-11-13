class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int res = 0, n = s.length();
        int left = 0, right= 0, maxCount = 0;
        for(;right<n;right++){
            char c = s.charAt(right);
            hm.put(c, hm.getOrDefault(c,0)+1);
            maxCount = Math.max(maxCount, hm.get(c));
            if(((right-left+1)-maxCount)>k){
                char leftChar = s.charAt(left);
                left++;
                hm.put(leftChar,hm.get(leftChar)-1);
                if(hm.get(leftChar)<=0) hm.remove(leftChar);
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}