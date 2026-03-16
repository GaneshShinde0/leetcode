/*
Approach: Enumerate All Rhombuses.

How many degrees of freedom does a rhombus have? In other words, how many variables are required to uniquely represent a rhombus.
-> Rhombus has three degrees of freedom; Two variables represent the co-ordinates of the top vertex of the rhombus, and one variable represents the width of the rhombus in the horizontal or vertical direction.

To Quickly calculate each part/side of the rhombus, we use prefixx sums.
- Let sum1[x][y] denote the sum of all elements along the diagonal from the cell (x-1, y-1) toward the top-left direction.
- Let sum2[x][y] denote the sum of all elements along the diagonal from the cell (x-y, y-1) toward the top-right direction.

## Intuition

First, we preprocess all values of sum1[i][j] and sum2[i][j] using a double loop. The recurrence relations are
left right
 /\
/  \
    sum1[i][j] = sum1[i-1][j-1]+grid[i-1][j-1]
and 
    sum2[i][j] = sum2[i-1][j+1]+grid[i-1][j-1]

Where the ranges of i and j are [1,m] and [1,n] respectively

Next we use a triple loop to enumerate the position of the top vertex of the rhombus and its width in the horizontal direction. From these values, we can determine the posisitions of the four vertices of the rhombus, denoted as (Ux, Uy), (Dx, Dy), (Lx, Ly) and (Rx, Ry)

Using these vertices, we can compute the border sum of the rhombus in O(1) time. Specially, the sum consists of the five parts 
    sum2[Lx+1][Ly+1] - sum2[Ux][Uy+2] , sum1[Rx+1][Ry+1] -sum1[Ux][Uy], sum1[Dx+1][Dy+1]-sum1[Lx][Ly], sum2[Dx+1][Dy+1]-sum2[Rx][Ry+2], grid[Ux][Uy]+grid[Dx][Dy]+grid[Lx][Ly]+grid[Rx][Ry]

    In addition, we can design a small data structure that maintains top three ditinct rhombus sums dynamically as they are computed. The implementation is showsn below.


*/ 

class Answer{
    int[] ans;
    public Answer(){
        ans = new int[3];
    }

    void put(int x){
        if(x>ans[0]){
            ans[2] = ans[1];
            ans[1] = ans[0];
            ans[0] = x;
        }else if(x!=ans[0] && x>ans[1]){
            ans[2] = ans[1];
            ans[1] = x;
        }else if(x!=ans[0] && x!=ans[1] && x>ans[2]){
            ans[2] = x;
        }
    }

    List<Integer> get(){
        List<Integer> result = new ArrayList<>();
        for(int num:ans){
            if(num!=0) result.add(num);
        }
        return result;
    }
}

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] sum1 = new int[m+1][n+2];
        int[][] sum2 = new int[m+1][n+2];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                sum1[i][j] = sum1[i-1][j-1] + grid[i-1][j-1]; // Coming from top left. \
                                                                                  //    \
                sum2[i][j] = sum2[i-1][j+1] + grid[i-1][j-1];
            }
        }
        Answer ans = new Answer();
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                // A single cell is also a rhombus.
                ans.put(grid[i][j]);
                for(int k=i+2;k<m;k+=2){
                    int ux = i;
                    int uy = j;
                    int dx = k;
                    int dy = j;
                    int lx = (i+k)/2;
                    int ly = j-(k-i)/2;
                    int rx = (i+k)/2;
                    int ry = j+(k-i)/2;
                    if(ly<0||ry>=n) break;
                    int sum = (sum2[lx+1][ly+1]-sum2[ux][uy+2])+
                                (sum1[rx+1][ry+1]-sum1[ux][uy])+
                                (sum1[dx+1][dy+1]-sum1[lx][ly])+
                                (sum2[dx+1][dy+1]-sum2[rx][ry+2])-
                                    (grid[ux][uy]+grid[dx][dy]+grid[lx][ly]+grid[rx][ry]);
                    ans.put(sum);
                }
            }
        }

        List<Integer> resultList = ans.get();
        int[] result = new int[resultList.size()];
        for(int i=0;i<resultList.size();i++){
            result[i] = resultList.get(i);
        }
        return result;
    }
}