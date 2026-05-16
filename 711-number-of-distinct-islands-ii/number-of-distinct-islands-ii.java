/*
Approach: Cannonical hash
For Number of Distinct Islands we determine local co-ordinates for each island.

Afterward, we will rotate and reflect the co-ordinates about the origin and translate the shape so that the bottom-left most co-ordinate is (0,0). At the end, the smallest of these list co-ordinates will be the canonical representation of the shape.

Algorithm:
We feature two different implementations, but the core idea is same. We start with the code from the previous problem, Number of Distinct islands.

For each of the 8 possible rotations and reflections of the shape, we will perform the transformation and then translate the shape so that the bottom-left-most co-ordinate is (0,0). Afterward, we will consider the canonical hash of the shape to be the minimum of these 8 intermediate hashes.

In Python, the motivation to use complex numbers is that rotation by 90 degrees is the same as multiplying by imaginary unit, 1j. In java, we manipulate the co-ordinates directly. The 8 rotations and reflections of each point are (x,y), (-x,y), (x,-y), (-x,-y
,(y,x), (-y,x), (y,-x), (-y,-x)
*/
class Solution {
    int[][] grid;
    boolean[][] seen;
    ArrayList<Integer> shape;
    int m, n;
    public int numDistinctIslands2(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        seen = new boolean[m][n];
        Set<String> shapes = new HashSet<String>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                shape = new ArrayList<>();
                explore(i,j);
                if(!shape.isEmpty()){
                    shapes.add(canonical(shape));
                }
            }
        }
        return shapes.size();
    }

    public void explore(int i, int j){
        if(i<0||i>=m||j<0||j>=n||seen[i][j]||grid[i][j]==0) return;
        seen[i][j]=true;
        shape.add(i*n+j);
        explore(i+1,j);
        explore(i-1,j);
        explore(i,j+1);
        explore(i,j-1);
    }
    private String canonical(ArrayList<Integer> shape){
        String ans = "";
        int lift = m+n;
        int[] out = new int[shape.size()];
        int[] xs = new int[shape.size()];
        int[] ys = new int[shape.size()];
        for(int c=0;c<8;c++){
            int t = 0;
            for(int z:shape){
                int x = z/n;
                int y  = z%n;
                //x y, x -y, -x y, -x -y
                //y x, y -x, -y x, -y -x
                xs[t] = c<=1?x:c<=3?-x:c<=5?y:-y;
                ys[t++] = c<=3?(c%2==0?y:-y):(c%2==0?x:-x);
            }
            int mx = xs[0], my = ys[0];
            for(int x:xs) mx = Math.min(x,mx);
            for(int y:ys) my = Math.min(y,my);
            for(int j=0;j<shape.size();j++){
                out[j] = (xs[j]-mx)*lift+(ys[j]-my);
            }
            Arrays.sort(out);
            String candidate = Arrays.toString(out);
            if(ans.compareTo(candidate)<0) ans = candidate;
        }
        return ans;
    }
}