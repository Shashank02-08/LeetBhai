class Solution {
    public int countIslands(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        int count=0;
        for (int i = 0 ; i< r ; i++)
        {
            for ( int j = 0 ; j < c ; j++)
            {
                if (grid[i][j] != 0)
                {
                    if (dfs(grid,i,j) % k == 0)
                    {
                        count++;
                    }
                }
            }
        }
        return count;
        
    }

    private long dfs ( int grid[][],int r , int c){
        int n = grid.length;
        int m = grid[0].length;
        
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0) {
            return 0L;
        }
        long sum = grid[r][c];
        grid[r][c] = 0;

        boolean isClosed = true;

        if (r == 0 || r == n - 1 || c == 0 || c == m - 1) {
            isClosed = false;
        }

        long up = dfs(grid, r - 1, c);
        long down = dfs(grid, r + 1, c);
        long left = dfs(grid, r, c - 1);
        long right = dfs(grid, r, c + 1);

        sum += up + down + left + right;

        return sum;
    }
}