class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
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
}