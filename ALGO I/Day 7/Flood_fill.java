class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int color = image[sr][sc];
        if (color != newColor) 
            dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        
        if (r < 0 ) { return; } 
        if (c < 0) { return; }
        if (r >= image.length) { return; }
        if (c >= image[0].length) { return; }
        if (image[r][c] != color) { return; }
        
        image[r][c] = newColor;
        dfs(image, r-1, c, color, newColor);
        dfs(image, r, c-1, color, newColor);
        dfs(image, r+1, c, color, newColor);
        dfs(image, r, c+1, color, newColor);
    }
}