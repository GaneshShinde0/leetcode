class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length, res =0;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B'){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B' && row[i]==1 && col[j]==1){
                    res++;
                }
            }
        }
        return res;
    }
    public int findLonelyPixelChecksSurroundings(char[][] picture) {
        int m = picture.length, n = picture[0].length, res =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B'){
                    boolean lonely = true;
                    for(int[] dir:dirs){
                        int newI = i+dir[0];
                        int newJ = j+dir[1];
                        if(newI>=m || newJ>=n || newI<0||newJ<0) continue;
                        else if(picture[newI][newJ]=='B'){
                            lonely = false;
                            break;
                        }
                    }
                    if(lonely) res++;
                }
            }
        }
        return res;
    }
}