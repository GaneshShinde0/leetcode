class BSTIterator {

    List<Integer> arr = new ArrayList();
    int pointer;
    int n;
    
    public void inorder(TreeNode r, List<Integer> arr) {
        if (r == null) return;
        inorder(r.left, arr);
        arr.add(r.val);
        inorder(r.right, arr);
    }

    public BSTIterator(TreeNode root) {
        inorder(root, arr);
        n = arr.size();
        pointer = -1;
    }
    
    public boolean hasNext() {
        return pointer < n - 1;
    }
    
    public int next() {
        ++pointer;
        return arr.get(pointer);
    }
    
    public boolean hasPrev() {
        return pointer > 0;
    }
    
    public int prev() {
        --pointer;
        return arr.get(pointer);
    }
}