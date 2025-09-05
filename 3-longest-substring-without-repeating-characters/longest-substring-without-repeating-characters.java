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
        int lastDouble =-1;
        int n = s.length();
        int[] lastIdx = new int[256];
        Arrays.fill(lastIdx,-1);
        for(int i=0; i<n; i++){
            lastDouble = Math.max(lastIdx[s.charAt(i)],lastDouble);
            res =Math.max(res, i-lastDouble);
            lastIdx[s.charAt(i)]=i;
        }
        // System.out.println(lastDouble);
        // if(lastDouble==-1 && n!=0) return res+1;
        // if(n==1) return 1;
        // res =Math.max(res, i-lastDouble);
        return res;
    }

}