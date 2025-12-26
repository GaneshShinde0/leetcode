class Solution {
    // Takes 18 ms
    public int numSpecialEquivGroupsInitial(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        int res = 0;
        for(String s:words){
            int[] oddFreq = new int[26];
            int[] evenFreq = new int[26];
            for(int i=0;i<s.length();i++){
                if(i%2==0) evenFreq[s.charAt(i)-'a']++;
                else oddFreq[s.charAt(i)-'a']++;
            }
            String temp = Arrays.toString(oddFreq)+Arrays.toString(evenFreq); // We know string concatenation is expensive
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        return map.size();
    }
    // Takes 16 ms; 
    public int numSpecialEquivGroups2(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        int res = 0;
        for(String s:words){
            int[] freq = new int[52]; // We will save even initially and odds later ()
            for(int i=0;i<s.length();i++){
                if(i%2==0) freq[s.charAt(i)-'a']++;
                else freq[26+s.charAt(i)-'a']++;
            }
            String temp = Arrays.toString(freq);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        return map.size(); // We Are just using size ... so we wont need map as well
    }
    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet<>();
        int res = 0;
        for(String s:words){
            int[] freq = new int[52]; // We will save even initially and odds later ()
            for(int i=0;i<s.length();i++){
                if(i%2==0) freq[s.charAt(i)-'a']++;
                else freq[26+s.charAt(i)-'a']++;
            }
            set.add(Arrays.toString(freq));
        }
        return set.size();
    }
}