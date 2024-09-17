class Solution {
    public String[] uncommonFromSentencesNaive(String s1, String s2) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        Set<String> combined = new HashSet<>();
        for(String str:s1.split(" ")) {
            map1.put(str,map1.getOrDefault(str,0)+1);
        }
        for(String str:s2.split(" ")){
            map2.put(str,map2.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String,Integer> e:map1.entrySet()){
            if(e.getValue()==1){
                combined.add(e.getKey());
            }
        }
        for(Map.Entry<String,Integer> e:map2.entrySet()){
            if(e.getValue()==1){
                combined.add(e.getKey());
            }
        }
        Set<String> res = new HashSet<>();
        for(String s:combined){
            if((map1.containsKey(s) && !map2.containsKey(s))||(map2.containsKey(s) && !map1.containsKey(s))) res.add(s);
        }
        String[] op = new String[res.size()];
        int i=0;
        for(String s:res){
            op[i]=s;
            i++;
        }
        return op;
    }
    // Optimized
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> map1 = new HashMap<>();
        Set<String> combined = new HashSet<>();
        for(String str:s1.split(" ")) {
            map1.put(str,map1.getOrDefault(str,0)+1);
        }
        for(String str:s2.split(" ")){
            map1.put(str,map1.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String,Integer> e:map1.entrySet()){
            if(e.getValue()==1){
                combined.add(e.getKey());
            }
        }
        return combined.toArray(new String[0]);
    }
}
