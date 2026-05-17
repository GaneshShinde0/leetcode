class Solution {
    static class SegmentTree{
        int[] tree;
        int n;
        SegmentTree(int[] arr){
            n = arr.length;
            tree = new int[4*n];
            build(1,0,n-1,arr);
        }
        void build(int node, int start, int end, int[] arr){
            if(start==end){
                tree[node] = arr[start];
                return;
            }
            int mid = (start+end)/2;
            build(2*node, start, mid, arr);
            build(2*node+1,mid+1,end,arr);
            tree[node] = Math.max(tree[2*node], tree[2*node+1]);
        }
        int query(int node, int start, int end, int l, int r){
            if(r<start||end<l) return Integer.MIN_VALUE;
            if(l<=start && end<=r) return tree[node];
            int mid = (start+end)/2;
            int left = query(2*node, start, mid, l, r);
            int right = query(2*node+1, mid+1, end, l, r);
            return Math.max(left, right);
        }
        int rangeMax(int l, int r){
            return query(1,0,n-1,l,r);
        }
    }
    public int countLocalMaximums(int[][] matrix) {
        SegmentTree[] row = new SegmentTree[matrix.length];
        SegmentTree[] col = new SegmentTree[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            row[i] = new SegmentTree(matrix[i]);
        }
        for(int i=0;i<matrix[0].length;i++){
            int[] arr = new int[matrix.length];
            for(int j=0; j<matrix.length;j++){
                arr[j] = matrix[j][i];
            }
            col[i] = new SegmentTree(arr);
        }
        int total = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]!=0){
                    int l = Math.max(j-matrix[i][j],0);
                    int h = Math.min(matrix[i][j]+j,matrix[0].length-1);
                    boolean b = true;
                    for(int k=Math.max(0, i-matrix[i][j]+1); k<Math.min(i+matrix[i][j],matrix.length);k++){
                        if(!b) break;
                        b = row[k].rangeMax(l,h)<=matrix[i][j];
                    }
                    l = Math.max(0,i-matrix[i][j]);
                    h = Math.min(i+matrix[i][j], matrix.length-1);
                    for(int k = Math.max(0,j-matrix[i][j]+1); k<Math.min(j+matrix[i][j], matrix[0].length);k++){
                        if(!b) break;
                        b = col[k].rangeMax(l,h)<=matrix[i][j];
                    }
                    if(b) total++;
                }
            }
        }
        return total;
    }
}