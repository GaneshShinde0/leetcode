class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int maxX = -1, minX = n, maxY = -1, minY = m;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(image[i][j]=='1'){
                    maxX = Math.max(maxX,j+1);
                    maxY = Math.max(maxY,i+1);
                    minX = Math.min(minX,j);
                    minY = Math.min(minY,i);
                }
            }
        }
        return (maxX-minX)*(maxY-minY);
    }
}

/*
0,1

maxX = 2
maxY = 1
minX = 1
minY = 
*/