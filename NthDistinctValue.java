class Solution {
    public String kthDistinctNaive14Ms(String[] arr, int k) {
        if(k>arr.length) return "";
        Map<String,Integer> hm = new LinkedHashMap<>();
        for(String str:arr){
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        int ptr=0;
        System.out.println(hm);
        for(Map.Entry<String,Integer> e:hm.entrySet()){
            if (e.getValue()==1){
                ptr+=1;
                if (ptr==k){
                    return e.getKey();
                }
            }
        }
        return "";
    }
    // Optimized 4 MS
    public String kthDistinct(String[] arr, int k) {
        List<String> uniqueValInArray = new LinkedList<>();
        int totalDistinctVal = 0;
        Set<String> nonDistinctSet = new HashSet<>();
        Set<String> distinctSet = new HashSet<>();
        for(String s:arr) {
            if(!nonDistinctSet.contains(s)) {
                if(!distinctSet.contains(s)) {
                    distinctSet.add(s);
                    totalDistinctVal++;
                } else {
                    nonDistinctSet.add(s);
                    distinctSet.remove(s);
                    totalDistinctVal--;
                }
            }
        }
        if(totalDistinctVal<k) {
            return "";
        }
        for(String s:arr) {
            if(distinctSet.contains(s)){
                k--;
                if(k==0){
                    return s;
                }
            }
        }
        return "";
    }
}
