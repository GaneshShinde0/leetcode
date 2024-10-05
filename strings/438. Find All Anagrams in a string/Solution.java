class Solution {
    public List<Integer> findAnagrams(String p, String s) {
        int[] sfreq = new int[26];
        int[] pfreq = new int[26];
        int k = s.length();
        List<Integer> result = new ArrayList<>();

        if(p.length()<s.length()) return result;
        for(char c:s.toCharArray()){
            sfreq[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            pfreq[p.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length()-k+1;i++){
            boolean check = checkAnagram(pfreq,sfreq);
            if(check) result.add(i);
            if(i==p.length()-k) break;
            pfreq[p.charAt(i)-'a']--;
            pfreq[p.charAt(i+k)-'a']++;
        }
        return result;
    }

    public boolean checkAnagram(int[] a, int[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
}
