class Solution {
    public int countCoveredBuildingsNLogN(int n, int[][] buildings) {
        TreeSet<int[]> x = new TreeSet<>((a,b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            else return Integer.compare(a[0],b[0]);
        });
        TreeSet<int[]> y = new TreeSet<>((a,b)->{
            if(a[1]==b[1]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });
        for(int[] b:buildings){
            x.add(b);
            y.add(b);
        }
        int res = 0;
        for(int[] b:buildings){
            int[] xLower = x.lower(b);
            int[] xHigher = x.higher(b);
            int[] yLower = y.lower(b);
            int[] yHigher = y.higher(b);
            if((xLower!=null && xHigher!=null && xLower[0]==b[0] && xHigher[0]==b[0]) && 
            (yLower!=null && yHigher!=null && yLower[1]==b[1] && yHigher[1]==b[1])){
                res++;
            }
        }
        return res;
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxRow = new int[n + 1];
        int[] minRow = new int[n + 1];
        int[] maxCol = new int[n + 1];
        int[] minCol = new int[n + 1];

        Arrays.fill(minRow, n + 1);
        Arrays.fill(minCol, n + 1);

        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            maxRow[y] = Math.max(maxRow[y], x);
            minRow[y] = Math.min(minRow[y], x);
            maxCol[x] = Math.max(maxCol[x], y);
            minCol[x] = Math.min(minCol[x], y);
        }

        int res = 0;
        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            if (
                x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x]
            ) {
                res++;
            }
        }

        return res;
    }
}