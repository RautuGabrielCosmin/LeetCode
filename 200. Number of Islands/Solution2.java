public class Solution {
    private int rows; 
    private int cols; 
    private int island = 0; 
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') { 
                    mark(grid, row, col); 
                    island++; 
                }
            }
        }

        return island; 
    }
    //DFS
    public void mark(char[][] grid, int row, int col) {
        grid[row][col] = '*'; 

        for(int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >=0 && newRow < rows && newCol >=0 && newCol < cols && grid[newRow][newCol] == '1') {
                mark(grid, newRow, newCol);
            }
        }
    }
}
