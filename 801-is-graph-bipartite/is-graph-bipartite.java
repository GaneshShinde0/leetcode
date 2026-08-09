class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                Stack<Integer> stk = new Stack();
                stk.push(i);
                color[i] = 0;
                while(!stk.isEmpty()){
                    Integer node = stk.pop();
                    for(int neighbor: graph[node]){
                        if(color[neighbor]==-1){
                            stk.push(neighbor);
                            color[neighbor] = color[node]^1;
                        }else if(color[neighbor]==color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}