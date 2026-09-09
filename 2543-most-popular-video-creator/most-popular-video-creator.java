class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, PriorityQueue<Integer>> creatorToVid = new HashMap<>();
        HashMap<String, Long> creatorToViewCount = new HashMap<>();
        long maxViews = 0;
        for(int i=0;i<creators.length;i++){
            creatorToViewCount.put(creators[i],creatorToViewCount.getOrDefault(creators[i],0l)+views[i]);
            maxViews = Math.max(maxViews, creatorToViewCount.get(creators[i]));
            creatorToVid.computeIfAbsent(creators[i], x->new PriorityQueue<Integer>((a,b)->{
                    if(views[b]==views[a]) return ids[a].compareTo(ids[b]);
                    return Integer.compare(views[b],views[a]);
                })
                ).add(i);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,Long> e: creatorToViewCount.entrySet()){
            if(e.getValue()==maxViews){
                res.add(List.of(e.getKey(), ids[creatorToVid.get(e.getKey()).poll()]));
            }
        }
        return res;
    }
}