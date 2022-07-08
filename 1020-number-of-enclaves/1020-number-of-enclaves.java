class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
            {
                count=0;
                if(grid[i][j]!=0 && vis[i][j]==false){
                    boolean chck=dfs(grid,vis,i,j);
                    if(chck)cnt+=count;
                }
            }
        }
        
        return cnt;
    }
    int count=0;
    public boolean dfs(int[][] grid,boolean[][] vis,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length )return false;
        
        if(vis[i][j]==true || grid[i][j]==0)return true;
        vis[i][j]=true;
        count++;
        boolean c1=dfs(grid,vis,i+1,j);
        boolean c2=dfs(grid,vis,i-1,j);
        boolean c3=dfs(grid,vis,i,j+1);
        boolean c4=dfs(grid,vis,i,j-1);
        if(c1==false || c2==false || c3==false || c4==false)
            return false;
        return true;
    }
}