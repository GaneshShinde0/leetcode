class Solution {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Pair<Integer, Character>> free=
                    new PriorityQueue<Pair<Integer, Character>>((a, b) -> b.getKey() - a.getKey());

        for (char c : freq.keySet()){
            free.offer(new Pair<>(freq.get(c), c));
        }
        
        StringBuffer ans = new StringBuffer();
        // This queue stores the characters that cannot be used now.
        Queue<Pair<Integer, Character>> busy = new LinkedList<>();
        while (ans.length() != s.length()) {
            int index = ans.length();
            
            // Insert the character that could be used now into the free heap.
            if (!busy.isEmpty() && (index - busy.peek().getKey()) >= k) {
                Pair<Integer, Character> q = busy.remove();
                free.offer(new Pair<>(freq.get(q.getValue()), q.getValue()));
            }
            
            // If the free heap is empty, it implies no character can be used at this index.
            if (free.isEmpty()) {
                return "";
            }
            
            Character currChar = free.peek().getValue();
            free.remove();
            ans.append(currChar);
            
            // Insert the used character into busy queue with the current index.
            freq.put(currChar, freq.get(currChar) - 1);
            if (freq.get(currChar) > 0) {
                busy.add(new Pair<>(index, currChar));
            }
        }
        
        return ans.toString();
    }
}


class SolutionInitial {
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