class Solution {
    public String rearrangeString(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int max = 0;
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int ptr=0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        while(ptr<n){
            max = 0;
            for(int i=0;i<26;i++){
                if(freq[i]>=freq[max]){
                    if(hashMap.containsKey(i) && ptr-hashMap.get(i)<k) continue;
                    max=i;
                }
            }
            int temp = k;
            int added = 0;
            for(int i=max;i<26;i++){
                if(freq[i]>0){
                    if(hashMap.containsKey(i) && ptr-hashMap.get(i)<k) continue;
                    sb.append((char) (i+'a'));
                    hashMap.put(i,ptr);
                    freq[i]--;
                    ptr++;
                    temp--;
                    added++;
                }
                if(added==1) break;
            }
            if(added ==0) return "";
        }
        return sb.toString();
    }
}