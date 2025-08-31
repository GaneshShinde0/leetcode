class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int left = 0, right =0, res =0, n = s.length();
        for(;right<n;right++){
            char rightChar = s.charAt(right);
            hm.put(rightChar,hm.getOrDefault(rightChar,0)+1);
            while(hm.get(rightChar)>1 && left<right){
                hm.put(s.charAt(left),hm.get(s.charAt(left))-1);
                left++;
            }
            // System.out.println("Left: "+left+" Right: "+right);
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}