class Solution {
    public List<Integer> findSmallestSetOfVerticesInitial(int n, List<List<Integer>> edges) {
        Set<Integer> ends = new HashSet<>();
        Set<Integer> start = new HashSet<>();
    
        for(List<Integer> edge:edges){ 
            ends.add(edge.get(1));
            start.add(edge.get(0));
        }

        start.removeAll(ends);
        return new ArrayList<>(start);
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] freq = new int[n];
    
        for(List<Integer> edge:edges){ 
            freq[edge.get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(freq[i]==0) res.add(i);
        }
        return res;
    }
}