class Solution {
    private static final int HASH_MULTIPLIER = 60001; // Slightly larger than 2 * max coordinate value
    
    // Following takes 12 ms
    public int robotSim(int[] commands, int[][] obstacles) {
        int x=0,y=0;
        int dir =0;
        int len = commands.length;
        int i=0,j=0;
        int maxDistanceSquared=0;
        Set<Integer> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(hashCoordinates(obstacle[0], obstacle[1]));
        }
        while(i<len){
            while(i<len && commands[i]<0){
                if(commands[i]==-1){
                    dir=(dir+1)%4;
                }
                if(commands[i]==-2){
                    dir = (dir + 3) % 4;
                }
                i++;
            }
            while (i < len && commands[i] > 0) {
                for (int step = 0; step < commands[i]; step++) { // Move step by step
                    if (dir == 0) { // North
                        if (obstacleSet.contains(hashCoordinates(x, y + 1))) {
                            break;
                        }
                        y++;
                    }
                    if (dir == 1) { // East
                        if (obstacleSet.contains(hashCoordinates(x + 1, y))) {
                            break;
                        }
                        x++;
                    }
                    if (dir == 2) { // South
                        if (obstacleSet.contains(hashCoordinates(x, y - 1))) {
                            break;
                        }
                        y--;
                    }
                    if (dir == 3) { // West
                        if (obstacleSet.contains(hashCoordinates(x - 1, y))) {
                            break;
                        }
                        x--;
                    }
                    maxDistanceSquared = Math.max(x * x + y * y, maxDistanceSquared);
                }
                i++;
            }
        }
        return maxDistanceSquared;
    }

    public int robotSim13ms(int[] commands, int[][] obstacles) {
        // Store obstacles in an HashSet for efficient lookup
        Set<Integer> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(hashCoordinates(obstacle[0], obstacle[1]));
        }

        // Define direction vectors: North, East, South, West
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int[] currentPosition = { 0, 0 };
        int maxDistanceSquared = 0;
        int currentDirection = 0; // 0: North, 1: East, 2: South, 3: West

        for (int command : commands) {
            if (command == -1) {
                // Turn right
                currentDirection = (currentDirection + 1) % 4;
                continue;
            }
            if (command == -2) {
                // Turn left
                currentDirection = (currentDirection + 3) % 4;
                continue;
            }

            // Move forward
            int[] direction = directions[currentDirection];
            for (int step = 0; step < command; step++) {
                int nextX = currentPosition[0] + direction[0];
                int nextY = currentPosition[1] + direction[1];
                if (obstacleSet.contains(hashCoordinates(nextX, nextY))) {
                    break;
                }
                currentPosition[0] = nextX;
                currentPosition[1] = nextY;
            }

            maxDistanceSquared = Math.max(
                maxDistanceSquared,
                currentPosition[0] * currentPosition[0] +
                currentPosition[1] * currentPosition[1]
            );
        }

        return maxDistanceSquared;
    }

    private int hashCoordinates(int x, int y) {
        return x + HASH_MULTIPLIER * y;
    }
}
