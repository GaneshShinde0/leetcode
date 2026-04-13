class Solution {
    HashMap<String,Boolean> hashMap = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        String key = s1+","+s2;
        if(hashMap.containsKey(key)) return hashMap.get(key);
        int n = s1.length();
        if(s1.equals(s2)) return true;
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                hashMap.put(key, false);
                return false;
            }
        }
        for(int i=1;i<s1.length();i++){
            boolean noSwap = isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i));
            boolean swap = isScramble(s1.substring(0,i), s2.substring(n-i)) && isScramble(s1.substring(i),s2.substring(0,n-i));
            if(swap || noSwap){
                hashMap.put(key,true);
                return true;
            }
        }
        hashMap.put(key,false);
        return false;
    }
}

/*

Input: s1 = "abcde", s2 = "caebd"
Output: false

acebd

a cebd
a becd
a b c d e

*/