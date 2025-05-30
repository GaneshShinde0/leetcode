class Solution {
    private int maxLevel = 0;
    private int sum = 0;
    public int deepestLeavesSumDFS(TreeNode root) {
        if(root==null) return 0;
        calculateSumAtLevel(root,0);
        return sum;
    }
    private void calculateSumAtLevel(TreeNode root, int level){
        if(root==null) return;
        if(level>maxLevel){
            sum=0;
            maxLevel = level;
        }
        if(level == maxLevel){
            sum+=root.val;
        }
        calculateSumAtLevel(root.left,level+1);
        calculateSumAtLevel(root.right,level+1);
    }

    public int deepestLeavesSum(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> lastLevel = new ArrayList<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            lastLevel = currentLevel;
        }

        int sum = 0;
        for(int val : lastLevel){
            sum+=val;
        }
        return sum;
    }
}
