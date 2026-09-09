class Solution {
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = str1.length();
        for(int i=0;i<n;i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if(hm.containsKey(c1) && hm.get(c1)!=c2-c1) return false;
            hm.put(c1,c2-c1);
        }
        
        // To handle cycles (e.g., a->b, b->a), str2 must have 
        // at least one unused character to act as a temporary buffer.
        HashSet<Character> uniqueCharsInStr2 = new HashSet<>();
        for (int i = 0; i < str2.length(); i++) {
            uniqueCharsInStr2.add(str2.charAt(i));
        }

        return uniqueCharsInStr2.size() < 26;
    }
}