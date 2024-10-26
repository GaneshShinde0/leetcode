class Solution {

    public int[] treeQueries(TreeNode root, int[] queries) {
        // Map to store the index of each node value
        Map<Integer, Integer> nodeIndexMap = new HashMap<>();

        // Map to store the number of nodes in subtree for each node
        Map<Integer, Integer> subtreeSize = new HashMap<>();

        // Lists to store node depths and maximum depths from left and right
        List<Integer> nodeDepths = new ArrayList<>();
        List<Integer> maxDepthFromLeft = new ArrayList<>();
        List<Integer> maxDepthFromRight = new ArrayList<>();

        // Perform DFS to populate nodeIndexMap and nodeDepths
        dfs(root, 0, nodeIndexMap, nodeDepths);

        int totalNodes = nodeDepths.size();

        // Calculate subtree sizes
        calculateSubtreeSize(root, subtreeSize);

        // Calculate maximum depths from left and right
        maxDepthFromLeft.add(nodeDepths.get(0));
        maxDepthFromRight.add(nodeDepths.get(totalNodes - 1));

        for (int i = 1; i < totalNodes; i++) {
            maxDepthFromLeft.add(
                Math.max(maxDepthFromLeft.get(i - 1), nodeDepths.get(i))
            );
            maxDepthFromRight.add(
                Math.max(
                    maxDepthFromRight.get(i - 1),
                    nodeDepths.get(totalNodes - i - 1)
                )
            );
        }
        Collections.reverse(maxDepthFromRight);

        // Process queries
        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryNode = queries[i];
            int startIndex = nodeIndexMap.get(queryNode) - 1;
            int endIndex = startIndex + 1 + subtreeSize.get(queryNode);

            int maxDepth = maxDepthFromLeft.get(startIndex);
            if (endIndex < totalNodes) {
                maxDepth = Math.max(maxDepth, maxDepthFromRight.get(endIndex));
            }

            results[i] = maxDepth;
        }

        return results;
    }

    // Depth-first search to populate nodeIndexMap and nodeDepths
    private void dfs(
        TreeNode root,
        int depth,
        Map<Integer, Integer> nodeIndexMap,
        List<Integer> nodeDepths
    ) {
        if (root == null) return;

        nodeIndexMap.put(root.val, nodeDepths.size());
        nodeDepths.add(depth);

        dfs(root.left, depth + 1, nodeIndexMap, nodeDepths);
        dfs(root.right, depth + 1, nodeIndexMap, nodeDepths);
    }

    // Calculate the size of subtree for each node
    private int calculateSubtreeSize(
        TreeNode root,
        Map<Integer, Integer> subtreeSize
    ) {
        if (root == null) return 0;

        int leftSize = calculateSubtreeSize(root.left, subtreeSize);
        int rightSize = calculateSubtreeSize(root.right, subtreeSize);

        int totalSize = leftSize + rightSize + 1;
        subtreeSize.put(root.val, totalSize);

        return totalSize;
    }
}
