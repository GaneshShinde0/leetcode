class Solution {
    public List<List<Integer>> shiftGridInitial(int[][] grid, int k) {
        Queue<Integer> li = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                li.add(grid[i][j]);
            }
        }
        k = k%(grid[0].length*grid[0].length);
        k=grid[0].length*grid[0].length-k;
        while(k>0){
            li.add(li.poll());
            k--;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for(int i=0;i<grid.length*grid[0].length;i++){
            curr.add(li.poll());
            if((i+1)%grid[0].length==0){
                result.add(curr);
                curr = new ArrayList<>();
            }
        }
        return result;
    }

    
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        k = k%(m*n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int newPos = (posToVal(i,j,n)+k)%(m*n);
                int[] temp = valToPos(newPos,n);
                result[temp[0]][temp[1]]=grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int[] arr:result){
            List<Integer> li = new ArrayList<>();
            for(int i:arr) li.add(i);
            res.add(li);
        }
        return res;
    }

    private int posToVal(int r,int c, int n){
        return r*n+c;
    }

    private int[] valToPos(int value, int n){
        return new int[]{value/n,value%n};
    } 


    public List<List<Integer>> shiftGridAlternate(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int temp = m * n;
        int a[] = new int[temp];
        k = k % temp;
        int q = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[q++] = grid[i][j];
            }
        }
        int[] t = new int[temp];
        q = 0;
        for (int i = 0; i < k; i++)
            t[i] = a[temp - k + i];

        for (int i = k; i < temp; i++)
            t[i] = a[i - k];
            
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = t[q++];
            }
        }
        return (List) Arrays.asList(grid);
    }
}