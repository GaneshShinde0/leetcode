class Solution {
    public int residuePrefixes(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            set.add(c);
            if(set.size()==(i+1)%3) res++;
        }
        return res;
    }
}