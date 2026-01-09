// Define a simple class to avoid external dependencies like 'Pair'
class CharCount {
    char c;
    int val;
    CharCount(char c, int val) { this.c = c; this.val = val; }
}

class Solution {
    public String reorganizeString(String s) {
        // 1. Frequency Map
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            // Fail Fast Check
            if (count[c - 'a'] > (s.length() + 1) / 2) return "";
        }

        // 2. Max Heap
        PriorityQueue<CharCount> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) pq.offer(new CharCount((char)('a' + i), count[i]));
        }

        StringBuilder sb = new StringBuilder();
        
        // 3. Greedy Placement
        while (pq.size() >= 2) {
            CharCount p1 = pq.poll();
            CharCount p2 = pq.poll();
            
            sb.append(p1.c);
            sb.append(p2.c);
            
            if (--p1.val > 0) pq.offer(p1);
            if (--p2.val > 0) pq.offer(p2);
        }

        if (!pq.isEmpty()) sb.append(pq.poll().c);

        return sb.toString();
    }
    public String reorganizeStringInitial(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>((a,b)-> Integer.compare(b.getValue(),a.getValue()));
        for(Map.Entry<Character,Integer> e: hm.entrySet()){
            pq.add(new Pair(e.getKey(),e.getValue()));
        }
        while(pq.size()>=2){
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();
            sb.append(p1.getKey()).append(p2.getKey());
            if((int)p1.getValue()>1) pq.offer(new Pair(p1.getKey(), (int)p1.getValue()-1));
            if((int)p2.getValue()>1) pq.offer(new Pair(p2.getKey(), (int)p2.getValue()-1));
        }
        if(pq.size()==1 && (int) pq.peek().getValue()!=1)return "";
        if(!pq.isEmpty())sb.append(pq.peek().getKey());
        return sb.toString();
    }
}