class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    static int[][] direction = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(i,j,visited,grid);
                }
            }
        }
        return count;
    }
    public static void bfs(int ro,int co,int[][] vis, char[][] grid){
        vis[ro][co]=1;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(ro,co));
        int m=grid.length;
        int n=grid[0].length;
            
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
                
            for (int[] dir : direction) {
                int nRow=row+dir[0];
                int nCol=col+dir[1];
                if(nRow>=0 && nCol>=0 && nRow<m && nCol<n && grid[nRow][nCol]=='1' && vis[nRow][nCol]==0){
                    vis[nRow][nCol]=1;
                    q.add(new Pair(nRow,nCol));
                }
            }
        }
    }
}