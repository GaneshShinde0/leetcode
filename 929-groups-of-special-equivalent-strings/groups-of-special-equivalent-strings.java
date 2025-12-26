class Solution {
    public int numSpecialEquivGroups(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        int res = 0;
        for(String s:words){
            int[] oddFreq = new int[26];
            int[] evenFreq = new int[26];
            for(int i=0;i<s.length();i++){
                if(i%2==0) evenFreq[s.charAt(i)-'a']++;
                else oddFreq[s.charAt(i)-'a']++;
            }
            String temp = Arrays.toString(oddFreq)+Arrays.toString(evenFreq);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        return map.size();
    }
}