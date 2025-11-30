class Solution {
    public int lengthOfLongestSubstringFirst(String s) {
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

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] lastIdxArr = new int[256];
        Arrays.fill(lastIdxArr,-1);
        int lastIdx = -1;
        for(int i=0;i<s.length();i++){
            int curr = s.charAt(i);
            lastIdx = Math.max(lastIdxArr[curr],lastIdx);
            res = Math.max(i-lastIdx, res);
            lastIdxArr[curr] = i;
        }
        return res;
    }

}