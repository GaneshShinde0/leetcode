class Solution {    
    /*
Compare to Python
class Solution:
    def mostPopularCreator(self, creators: list[str], ids: list[str], views: list[int]) -> list[list[str]]:
        tot, vid = defaultdict(int), defaultdict(list)                    # Line 1
        for c, i, v in zip(creators, ids, views):                         # Line 2
            tot[c] += v                                                   # Line 3
            vid[c].append((-v,i))                                         # Line 4
        m = max(tot.values())                                             # Line 5
        return [[c,min(v)[1]] for c, v in vid.items() if tot[c] == m]     # Line 6
    */

    public List<List<String>> mostPopularCreatorShorteningVariables(String[] creators, String[] ids, int[] views) {
        HashMap<String, PriorityQueue<Integer>> cTV = new HashMap<>();
        HashMap<String, Long> cTVC = new HashMap<>();
        long mV = 0;
        for(int i=0;i<creators.length;i++){
            cTVC.put(creators[i],cTVC.getOrDefault(creators[i],0l)+views[i]);
            mV = Math.max(mV, cTVC.get(creators[i]));
            cTV.computeIfAbsent(creators[i], x->new PriorityQueue<Integer>((a,b)->{
                    if(views[b]==views[a]) return ids[a].compareTo(ids[b]);
                    return Integer.compare(views[b],views[a]);
                })
                ).add(i);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,Long> e: cTVC.entrySet()){
            if(e.getValue()==mV){
                res.add(List.of(e.getKey(), ids[cTV.get(e.getKey()).poll()]));
            }
        }
        return res;
    }

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