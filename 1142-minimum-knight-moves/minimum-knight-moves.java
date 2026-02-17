class Solution {
    int[][] dirs = {{-1,-2},{-1,2},{-2,-1},{-2,1},{2,-1},{1,-2},{1,2},{2,1}};
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x); y = Math.abs(y);
        if (x == 0 && y == 0) return 0;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // Use a consistent offset for BOTH Queue and Set
        int offset = 302;
        int start = (0 + offset) * 1000 + (0 + offset);
        
        queue.add(start);
        visited.add(start);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int ptr = 0; ptr < size; ptr++) {
                int curr = queue.poll();
                // Decode using the offset
                int i = (curr / 1000) - offset;
                int j = (curr % 1000) - offset;

                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (ni == x && nj == y) return depth + 1;
                    
                    // Optimization: knight moves in first quadrant + small buffer
                    if (ni < -2 || nj < -2) continue;

                    int nextEnc = (ni + offset) * 1000 + (nj + offset);
                    if (visited.add(nextEnc)) {
                        queue.add(nextEnc);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}