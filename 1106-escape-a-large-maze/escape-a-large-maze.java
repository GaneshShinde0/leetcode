class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int lowX = 0;
    int lowY = 0;
    private static final long MIL = 1_000_000;
    long highX = MIL;
    long highY = MIL;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockedSet = new HashSet<>();
        for(int[] block:blocked){
            blockedSet.add(block[0]+MIL*block[1]);
        }
        return dfs(source, target, blockedSet) && dfs(target, source, blockedSet);
    }
    public boolean dfs(int[] source, int[] target, Set<Long> blockedSet){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(source);
        Set<Long> visited = new HashSet<>();
        visited.add(source[0]+MIL*source[1]);
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for(int[] dir:dirs){
                int newX = x+dir[0];
                int newY = y+dir[1];
                long comb = newX+MIL*newY;
                if(newX<lowX||newY<lowY||newX>=highX||newY>=highY||visited.contains(comb)||blockedSet.contains(comb)) continue;
                if(newX == target[0] && newY==target[1]) return true;
                queue.add(new int[]{newX,newY});
                visited.add(comb);
                if(visited.size()>=20000) return true;
            }
        }
        return false;
    }
}

class SolutionInitial {
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashSet<String> blockedSet = new HashSet<>();
        for(int[] block:blocked) blockedSet.add(block[0]+","+block[1]);
 
        return possiblePoints(source, target, blockedSet) && possiblePoints(target, source ,blockedSet);
    }

    private boolean possiblePoints(int[] source, int[] target, Set<String> blocked){
        Set<String> hashSet = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        int xPosLim = 1_000_000;
        int yPosLim = 1_000_000;
        int xNegLim = Math.max(0,source[0]-200);
        int yNegLim = Math.max(0,source[1]-200);
        queue.add(source);
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for(int[] dir:dirs){
                int newX = x+dir[0], newY=y+dir[1];
                String currPoint = newX+","+newY;
                if(newX<xNegLim||newY<yNegLim||newX>=xPosLim||newY>=yPosLim||hashSet.contains(currPoint)||blocked.contains(currPoint)) continue;
                if(newX == target[0] && newY == target[1]) return true;
                hashSet.add(currPoint);
                queue.add(new int[]{newX,newY});
                if(hashSet.size()==20000) return true;
            }
        }
        return hashSet.size()>=20000;
    }
}

/*
(0,2)
(0,1)
(0,0),(1,0)

*/