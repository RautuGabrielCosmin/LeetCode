public class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    bfs(n, m, i, j, grid);
                }
            }
        }
        return count;
    }

    public void bfs(int n, int m, int row, int col, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        grid[row][col] = '0';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];

            for(int[] d : directions ) {
                int nextRow = r + d[0];
                int nextCol = c + d[1];
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && grid[nextRow][nextCol] == '1') {
                    q.add(new int[]{nextRow, nextCol});
                    grid[nextRow][nextCol] = '0';
                }
            }
        }
    }
}
