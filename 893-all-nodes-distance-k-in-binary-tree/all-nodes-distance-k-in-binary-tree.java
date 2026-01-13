/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SolutionWithParentPointers {
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        addParent(root,null);
        List<Integer> answer = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        dfs(target,k,answer,visited);
        return answer;
    }

    private void addParent(TreeNode curr, TreeNode parent){
        if(curr!=null){
            this.parent.put(curr, parent);
            addParent(curr.left, curr);
            addParent(curr.right, curr);
        }
    }

    private void dfs(TreeNode curr, int distance, List<Integer> answer, Set<TreeNode> visited){
        if(curr==null||visited.contains(curr)) return;
        visited.add(curr);
        if(distance ==0){
            answer.add(curr.val);
            return;
        }

        dfs(parent.get(curr), distance-1, answer, visited);
        dfs(curr.left, distance-1, answer, visited);
        dfs(curr.right, distance-1, answer, visited);
    }
}

class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfsBuild(root, null, graph);

        List<Integer> answer = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        // Add the target node to the queue with a distance of 0
        queue.add(new int[] { target.val, 0 });
        visited.add(target.val);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], distance = cur[1];

            // If the current node is at distance k from target,
            // add it to the answer list and continue to the next node.
            if (distance == k) {
                answer.add(node);
                continue;
            }

            // Add all unvisited neighbors of the current node to the queue.
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[] { neighbor, distance + 1 });
                }
            }
        }

        return answer;
    }

    // Recursively build the undirected graph from the given binary tree.
    private void dfsBuild(
        TreeNode cur,
        TreeNode parent,
        Map<Integer, List<Integer>> graph
    ) {
        if (cur != null && parent != null) {
            int curVal = cur.val, parentVal = parent.val;
            graph.putIfAbsent(curVal, new ArrayList<>());
            graph.putIfAbsent(parentVal, new ArrayList<>());
            graph.get(curVal).add(parentVal);
            graph.get(parentVal).add(curVal);
        }

        if (cur != null && cur.left != null) {
            dfsBuild(cur.left, cur, graph);
        }

        if (cur != null && cur.right != null) {
            dfsBuild(cur.right, cur, graph);
        }
    }
}