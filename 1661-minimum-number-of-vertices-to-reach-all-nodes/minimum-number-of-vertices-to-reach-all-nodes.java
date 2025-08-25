class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> ends = new HashSet<>();
        Set<Integer> start = new HashSet<>();
    
        for(List<Integer> edge:edges){ 
            ends.add(edge.get(1));
            start.add(edge.get(0));
        }

        start.removeAll(ends);
        return new ArrayList<>(start);
    }
}