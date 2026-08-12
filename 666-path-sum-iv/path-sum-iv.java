class Solution {
    int totalSum = 0;
    public int pathSum(int[] nums) {
        List<int[]> li = new ArrayList<>();
        for(int num:nums){
            int depth = num/100;
            int pos = (num%100)/10;
            int elem = num%10;
            if(li.size()<depth){
                int[] newArr = new int[1<<(depth-1)];
                Arrays.fill(newArr,-1);
                li.add(newArr);
            }
            li.get(depth-1)[pos-1] = elem;
        }
        // Start DFS from the root (depth 0, pos 0) with an initial sum of 0
        dfs(li, 0, 0, 0);
        
        return totalSum;
    }

    private void dfs(List<int[]> li, int depth, int pos, int currentSum) {
        // If out of bounds or node doesn't exist, return
        if (depth >= li.size() || li.get(depth)[pos] == -1) return;

        // Add current node's value to the running sum
        currentSum += li.get(depth)[pos];

        // Calculate children's positions
        int leftPos = pos * 2;
        int rightPos = pos * 2 + 1;

        // Check if left and right children exist
        boolean hasLeft = (depth + 1 < li.size()) && (li.get(depth + 1)[leftPos] != -1);
        boolean hasRight = (depth + 1 < li.size()) && (li.get(depth + 1)[rightPos] != -1);

        // If the current node has no valid children, it is a leaf node
        if (!hasLeft && !hasRight) {
            totalSum += currentSum;
            return;
        }

        // Traverse children
        if (hasLeft) {
            dfs(li, depth + 1, leftPos, currentSum);
        }
        if (hasRight) {
            dfs(li, depth + 1, rightPos, currentSum);
        }
    }
}