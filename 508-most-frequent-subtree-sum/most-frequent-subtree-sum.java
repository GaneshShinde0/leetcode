/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        helper(root, hm);
        return hm.entrySet().stream().filter(e->e.getValue()==maxCount)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
    public int[] findFrequentTreeSumDoubleStream(TreeNode root) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        helper(root, hm);
        int max = hm.values().stream().max(Integer::compare).get();
        List<Integer> li = hm.keySet().stream().filter(x->hm.get(x)==max).collect(Collectors.toList());
        int[] res = new int[li.size()];
        for(int i=0;i<li.size();i++){
            res[i]=li.get(i);
        }
        return res;
    }
    private int helper(TreeNode root, HashMap<Integer,Integer> hm){
        if(root==null) return 0;
        int leftSum = helper(root.left,hm);
        int rightSum = helper(root.right,hm);
        int total = leftSum+rightSum+root.val;
        hm.put(total, hm.getOrDefault(total,0)+1);
        maxCount = Math.max(maxCount, hm.get(total));
        return total;
    }
}