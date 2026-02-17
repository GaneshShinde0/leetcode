class Solution {
    int[][] dirs = {{-1,-2},{-1,2},{-2,-1},{-2,1},{2,-1},{1,-2},{1,2},{2,1}};
    public int minKnightMoves(int x, int y) {
        if(x == 0 && y == 0) return 0;
        x = Math.abs(x);
        y = Math.abs(y);
        
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // Change 1: Add the +2 offset to the start to match decoding
        queue.add(2*1000 + 2);
        set.add(2*1000 + 2);
        
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int ptr = 0; ptr < size; ptr++){
                int curr = queue.poll();
                // Change 2: Subtract the 2 to decode the actual coordinates
                int i = (curr / 1000) - 2;
                int j = (curr % 1000) - 2;
                
                for(int[] dir : dirs){
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if(ni == x && nj == y) return depth + 1;
                    if(ni < -2 || nj < -2) continue;
                    int newCurr = (ni + 2) * 1000 + (nj + 2);
                    if(!set.contains(newCurr)){
                        queue.add(newCurr);
                        set.add(newCurr);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}