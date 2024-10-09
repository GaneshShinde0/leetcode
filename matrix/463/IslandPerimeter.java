class IslandPerimeter {
    public int islandPerimeter7ms(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] temp = new int[row+2][col+2];
        int perimeter =0;
        for(int i=0;i<row+1;i++){
            for(int j=0;j<col+1;j++){
                if (i==0||j==0||i==(row+1)||j==(col+1)) temp[i][j] =0;
                else temp[i][j]=grid[i-1][j-1];
            }
        }
        // print2DArray(temp);
        for(int i=1;i<row+2;i++){
            for(int j=1;j<col+2;j++){
                if(temp[i][j]==1){
                    if(temp[i-1][j]==0) perimeter++;
                    if(temp[i+1][j]==0) perimeter++;
                    if(temp[i][j-1]==0) perimeter++;
                    if(temp[i][j+1]==0) perimeter++;
                }
            }
        }
        return perimeter;
    }

    public static void print2DArray(int[][] array) {
        // Iterate through rows
        for (int i = 0; i < array.length; i++) {
            // Iterate through columns
            for (int j = 0; j < array[i].length; j++) {
                // Print each element followed by a space
                System.out.print(array[i][j] + " ");
            }
            // Print a newline after each row
            System.out.println();
        }
    }

    // Following Takes 4ms
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int row = grid.length;
        int col = grid[0].length;

        // Iterate through each cell in the grid
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    // Check all four directions around the cell
                    // Top
                    if (i == 0 || grid[i - 1][j] == 0) perimeter++;
                    // Bottom
                    if (i == row - 1 || grid[i + 1][j] == 0) perimeter++;
                    // Left
                    if (j == 0 || grid[i][j - 1] == 0) perimeter++;
                    // Right
                    if (j == col - 1 || grid[i][j + 1] == 0) perimeter++;
                }
            }
        }
        return perimeter;
    }
}
