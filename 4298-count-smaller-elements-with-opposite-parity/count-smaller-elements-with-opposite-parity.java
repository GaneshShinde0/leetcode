class Solution{
    class Fenwick{
        int[] tree;
        int n; 
        Fenwick(int n){
            this.n = n;
            tree = new int[n+1];
        }
        void update(int i, int delta){
            while(i<=n){
                tree[i] += delta;
                i+=i&-i;
            }
        }
        int query(int i){
            int sum = 0;
            while(i>0){
                sum+=tree[i];
                i-=i&-i;
            }
            return sum;
        }
    }
    public int[] countSmallerOppositeParity(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer> rank = new HashMap<>();
        int r = 1;
        for(int num:sorted){
            if(!rank.containsKey(num)){
                rank.put(num,r++);
            }
        }
        Fenwick evenBIT = new Fenwick(r);
        Fenwick oddBIT = new Fenwick(r);
        for(int i= n-1;i>=0;i--){
            int idx = rank.get(nums[i]);
            if(nums[i]%2==0){
                result[i] = oddBIT.query(idx-1);
                evenBIT.update(idx,1);
            }else{
                result[i] = evenBIT.query(idx-1);
                oddBIT.update(idx,1);
            }
        }
        return result;
    }
}
class SolutionInitial {
    public static class Node{
        Node left;
        Node right;
        int val;
        int size;
        Node(int val){
            this.val = val;
            this.size = 1;
            this.left = null;
            this.right = null;
        }
    }
    private static class TreeNode{
        Node root;
        TreeNode(int val){
            root = new Node(val);
        }
        void insert(Node root, int val){
            if(root.val>=val){
                if(root.left==null){
                    root.left = new Node(val);
                }else insert(root.left,val);
                root.left.size++;
            }else if(root.val<val){
                if(root.right==null){
                    root.right = new Node(val);
                }else insert(root.right,val);
                root.right.size++;
            }
        }
    }
    public int[] countSmallerOppositeParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            final int curr = nums[i];
            if(nums[i]%2==1) {
                res[i]= (int) evens.stream().filter(x->x<curr).count();
                odds.add(nums[i]);
            }else{
                res[i]= (int) odds.stream().filter(x->x<curr).count();
                evens.add(nums[i]);
            }
        }
        return res;
    }
}
