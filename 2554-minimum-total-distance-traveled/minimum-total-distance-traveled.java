class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory){
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a->a[0]));
        List<Integer> factoryPositions = flattenArray(factory);
        int roboCount = robot.size();
        int factoryCount = factoryPositions.size();
        long[][] dp = new long[roboCount+1][factoryCount+1];

        // Initialize base cases
        for(int i =0;i<roboCount;i++){
            dp[i][factoryCount] = (long) 1e12; // No factories left
        }

        // Fill DP Table BottomUp
        for(int i= roboCount-1;i>=0;i--){
            for(int j = factoryCount-1; j>=0; j--){
                long assign = Math.abs(robot.get(i)-factoryPositions.get(j))+dp[i+1][j+1];
                long skip = dp[i][j+1];
                dp[i][j] = Math.min(assign, skip);
            }
        }
        return dp[0][0];
    }
    public long minimumTotalDistanceMemoizedRecursion(List<Integer> robot, int[][] factory){
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a->a[0]));
        List<Integer> factoryPositions = flattenArray(factory);
        int robotCount = robot.size();
        int factoryCount = factoryPositions.size();
        long[][] memo = new long[robotCount][factoryCount];
        for(long[] row:memo) Arrays.fill(row,-1);
        // Recursively calculate minimum distance with memoization
        return calculateMinDistance(0,0, robot, factoryPositions, memo);
    }

    private long calculateMinDistance(int robotIdx, int factoryIdx, List<Integer> robots, List<Integer> factoryPositions, long[][] memo){
        if(robotIdx==robots.size()) return 0;
        if(factoryIdx == factoryPositions.size()) return (long) 1e12;
        if(memo[robotIdx][factoryIdx]!=-1) return memo[robotIdx][factoryIdx];
        // Option 1: Assign current robot to current factory.
        long assign = Math.abs(robots.get(robotIdx)-factoryPositions.get(factoryIdx)) + calculateMinDistance(robotIdx+1,factoryIdx+1, robots, factoryPositions, memo);
        long skip = calculateMinDistance(robotIdx, factoryIdx+1, robots, factoryPositions, memo);
        memo[robotIdx][factoryIdx] = Math.min(assign, skip);
        return memo[robotIdx][factoryIdx];
    }

    private List<Integer> flattenArray(int[][] arr){
        List<Integer> flattenedList = new ArrayList<>();
        for(int[] a: arr){
            for(int i=0;i<a[1];i++){
                flattenedList.add(a[0]);
            }
        }
        return flattenedList;
    }
    public long minimumTotalDistanceRecursion(List<Integer> robot, int[][] factory){
        Collections.sort(robot);
        // Arrays.sort(facctory,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(factory,Comparator.comparingInt(a->a[0]));
        
        // Flatten factory positions according to their capacities.
        List<Integer> factoryPositions = new ArrayList<>();
        for(int[] f:factory){
            for(int i=0;i<f[1];i++){
                factoryPositions.add(f[0]);
            }
        }
        // Minimum distance starting from 0th robot and 0th factory position
        return calculateMinDistance(0,0, robot, factoryPositions);
    }
    private long calculateMinDistance(int robotIdx, int factoryIdx, List<Integer> robot, List<Integer> factoryPositions){
        if(robotIdx==robot.size()) return 0;
        if(factoryIdx == factoryPositions.size()) return (long) 1e12;

        long assign = Math.abs(robot.get(robotIdx)-factoryPositions.get(factoryIdx)) + calculateMinDistance(robotIdx+1, factoryIdx+1, robot, factoryPositions);
        long skip = calculateMinDistance(robotIdx, factoryIdx+1, robot, factoryPositions);
        return Math.min(assign, skip);
    }
    public long minimumTotalDistanceOptimized(List<Integer> robot, int[][] factory) {
        // Sort robots and factories by position
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        // Flatten factory positions according to their capacities
        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                factoryPositions.add(f[0]);
            }
        }

        int robotCount = robot.size();
        int factoryCount = factoryPositions.size();

        // Initialize dp array
        long[][] dp = new long[robotCount + 1][factoryCount + 1];

        // Initialize base cases
        for (int i = 0; i < robotCount; i++) {
            dp[i][factoryCount] = (long) 1e12; // No factories left
        }

        // Fill DP table bottom-up
        for (int i = robotCount - 1; i >= 0; i--) {
            for (int j = factoryCount - 1; j >= 0; j--) {
                // Option 1: Assign current robot to current factory
                long assign =
                    Math.abs(robot.get(i) - factoryPositions.get(j)) +
                    dp[i + 1][j + 1];

                // Option 2: Skip current factory for the current robot
                long skip = dp[i][j + 1];

                // Take the minimum option
                dp[i][j] = Math.min(assign, skip);
            }
        }

        // Minimum distance starting from first robot and factory
        return dp[0][0];
    }
}