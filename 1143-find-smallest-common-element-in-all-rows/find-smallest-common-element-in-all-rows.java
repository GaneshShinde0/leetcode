class Solution {
    public int smallestCommonElement(int[][] mat) {
        int i=0,j=0;
        int m = mat.length;
        int n = mat[0].length;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(j=0;j<n;j++) tm.put(mat[0][j],tm.getOrDefault(mat[0][j],0)+1);
        for(i=1;i<m;i++){
            for(j=0;j<n;j++){
                if(tm.containsKey(mat[i][j])){
                    int temp = tm.get(mat[i][j]);
                    if(temp<i) tm.remove(mat[i][j]);
                    else tm.put(mat[i][j],tm.get(mat[i][j])+1);
                }
            }
        }
        for(Map.Entry<Integer,Integer> e: tm.entrySet()){
            if(e.getValue()==m) return e.getKey();
        }
        return -1;
    }
}