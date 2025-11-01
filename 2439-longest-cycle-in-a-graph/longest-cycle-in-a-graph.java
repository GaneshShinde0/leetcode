// Find length of longest cycle in graph
// Finding cycle in directed/undirected graph is np complete problem, You can't find polynomial time solution.
// Ususal DFS of finding longest cycle would not work.

// Given: Each node has atmost one outgoing edge.
    // Any node can be part of atmost one cycle.
    // For each node you will either hit dead-end or come back to initial node.
class Solution {
    public int longestCycle(int[] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            graph.computeIfAbsent(i,k->new ArrayList<>()).add(edges[i]);
        }
        int res = -1;
        boolean[] visited = new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
            int start = edges[i];
            HashMap<Integer,Integer> hm = new HashMap<>();
            int curr = 0;
            while(start!=-1){
                if(hm.containsKey(start)){
                    res = Math.max(curr-hm.get(start),res);
                    break;
                }   
                if(visited[start]) break;
                visited[start]=true;        
                hm.put(start,curr);
                start = edges[start];
                curr++;  
            }
        }
        return res; 
    }
}

/*
0->4
1->3
2->3
3->4
4->7
5->2
6->3
7->3

*/