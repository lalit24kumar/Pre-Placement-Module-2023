class Solution {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int x, int y) {
        if (validateInput(grid, x, y)) return;
        grid[x][y] = '0';
        for (int i = 0; i < dx.length; i++) {
            dfs(grid, x + dx[i], y + dy[i]);
        }
    }

    private boolean validateInput(char[][] grid, int x, int y) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0';
    }
}