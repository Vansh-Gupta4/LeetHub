class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[sr][sc]==newColor){
            return grid;
        }
        dfs(grid,sr,sc,grid[sr][sc],newColor);
        return grid;
    }
     public static void dfs(int[][] image,int sr,int sc, int color ,int newColor){
         if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color){
               return;  
         } 
         image[sr][sc]=newColor;
         dfs(image,sr+1,sc,color,newColor);
         dfs(image,sr-1,sc,color,newColor);
         dfs(image,sr,sc+1,color,newColor);
         dfs(image,sr,sc-1,color,newColor);
    }
}