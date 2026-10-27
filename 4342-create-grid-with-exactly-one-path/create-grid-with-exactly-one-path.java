class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        res[0] = ".".repeat(n);
        for(int i=1;i<m;i++){
            res[i] = "#".repeat(n-1);
            res[i]+='.';
        }
        return res;
    }
}