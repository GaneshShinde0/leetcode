/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private StringBuilder reserialize(TreeNode root, StringBuilder sb){
        if(root==null) sb.append("Null,");
        else{
            sb.append(root.val).append(",");
            reserialize(root.left, sb);
            reserialize(root.right, sb);
        }
        return sb;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reserialize(root, new StringBuilder()).toString();
    }

    private TreeNode deserialize(String[] arr, int[] index) {
        if(arr[index[0]].equals("Null")){
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[index[0]]));
        index[0]++;
        node.left = deserialize(arr, index);
        node.right = deserialize(arr, index);
        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String dataArr[] = data.split(",");
        return deserialize(dataArr, new int[]{0});
    }

}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;