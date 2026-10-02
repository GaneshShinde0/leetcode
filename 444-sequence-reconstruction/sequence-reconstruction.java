class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // Do a topological sort. It should only have one node with indegree = 0; 
        // If at any point, more than one option for topological ==> false
        if (seqs.size() == 0) {
            return org.length == 0;
        }
        int n = org.length;
        int[] inDegree = new int[n + 1];
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (List<Integer> seq: seqs) {
            for (int i = 0; i + 1 < seq.size(); i++) {
                int src = seq.get(i);
                int dst = seq.get(i + 1);
                
                if (src <= 0 || src > n) {
                    return false;
                }
                
                if (dst <= 0 || dst > n) {
                    return false;
                }
                
                adjList.get(src).add(dst);
                inDegree[dst] += 1;
            }
        }
        
        Set<Integer> seqNodes = new HashSet<>();
        for (List<Integer> seq: seqs) {
            for (int i = 0; i < seq.size(); i++) {
                int src = seq.get(i);
                seqNodes.add(src);
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (!seqNodes.contains(i)) {
                return false;
            }
        }
        
        if (seqNodes.size() != org.length) {
            return false;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int nodesVisited = 0;
        while (q.size() > 0) {
            int size = q.size();
            if (q.size() != 1) {
                return false;
            }
            
            int node = q.poll();
            if (org[nodesVisited] != node) {
                return false;
            }
            nodesVisited++;
            for (int nextNode: adjList.get(node)) {
                inDegree[nextNode] -= 1;
                if (inDegree[nextNode] == 0) {
                    q.offer(nextNode);
                }
            }
            
        }
        
        return nodesVisited == n;
    }
}