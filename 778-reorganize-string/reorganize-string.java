class Solution {
    public String reorganizeString(String s) {
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