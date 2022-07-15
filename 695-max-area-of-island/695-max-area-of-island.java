class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        int area=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    int cnt=dfs(grid,vis,i,j);
                    area=Math.max(area,cnt);
                }
            }
        }
        
        return area;
    }
    public int dfs(int[][] grid,boolean[][] vis,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j]==true || grid[i][j]==0)return 0;
    int c=0;
        vis[i][j]=true;
       int h=dfs(grid,vis,i+1,j);
       int r=dfs(grid,vis,i-1,j);
        int v=dfs(grid,vis,i,j+1);
        int d=dfs(grid,vis,i,j-1);
        
        
      c+=h+r+v+d+1;
        return c;
    }
}