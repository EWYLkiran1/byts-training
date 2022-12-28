class Solution {
    public int minPathSum(int[][] grid) {
    if(grid.length == 0) return 0;
    int row = grid.length;
    int col = grid[0].length;
    
    for(int i=0;i<row; i++) {
        for(int j=0; j<col; j++) {
            int leftSum = (j>0) ? grid[i][j-1] : Integer.MAX_VALUE;
            int topSum = (i>0) ? grid[i-1][j] : Integer.MAX_VALUE;
            if(i==0 && j==0) continue;
            
            grid[i][j] += Math.min(leftSum, topSum);
        }
    }
    return grid[row-1][col-1];
 }
}