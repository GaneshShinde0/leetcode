class Solution {
    int minTime = Integer.MAX_VALUE;
    
    public int findMinimumTime(List<Integer> strength, int k) {
        int n = strength.size();
        boolean[] visited = new boolean[n];
        return solve(strength, k, visited, 1);
    }

    private int solve(List<Integer> strength, int k, boolean[] visited, int currentX) {
        int visitedCount = 0;
        for(boolean v:visited){
            if(v)visitedCount++;
        }
        if(visitedCount==visited.length) return 0;
        
        int res = Integer.MAX_VALUE;
        
        // 2. Try every lock as the next candidate
        for (int i = 0; i < strength.size(); i++) {
            if (!visited[i]) {
                // Mark visited
                visited[i]=true;
                // Calculate cost for this lock
                int cost = (int) Math.ceil(strength.get(i)*1.0/currentX);
                // Recurse: cost + solve(...)
                int currRes =cost +solve(strength,k,visited,currentX+k);
                // Update 'res' with the minimum
                res = Math.min(res, currRes);
                // Backtrack (unmark visited)
                visited[i]=false;
            }
        }
        
        return res;
    }
}