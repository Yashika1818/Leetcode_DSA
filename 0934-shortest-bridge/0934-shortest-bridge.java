class Solution {
    class Pair{
        int x;
        int y;
        int l;
        Pair(int x,int y,int l){
            this.x=x;
            this.y=y;
            this.l=l;
        }
    }
    public int shortestBridge(int[][] grid) {
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        Queue<Pair> q=new LinkedList<>();
        boolean flag=false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && vis[i][j]==false && flag==false){
                    flag=true;
                    dfs(i,j,q,vis,grid);
                }
                    
            }
        }
       boolean[][] visbfs=new boolean[grid.length][grid[0].length];
        while(q.size()>0){
            Pair rem=q.remove();
            
            if(visbfs[rem.x][rem.y]==true)continue;
            visbfs[rem.x][rem.y]=true;
            
            if(grid[rem.x][rem.y]==1 && vis[rem.x][rem.y]==false){
                return rem.l-1;
            }
            
            addNbr(q,rem.x+1,rem.y,rem.l+1,visbfs,grid);
            addNbr(q,rem.x,rem.y+1,rem.l+1,visbfs,grid);
            addNbr(q,rem.x-1,rem.y,rem.l+1,visbfs,grid);
            addNbr(q,rem.x,rem.y-1,rem.l+1,visbfs,grid);
            
        }
        
        return 0;
    }
    public void dfs(int i,int j,Queue<Pair> q,boolean[][] vis,int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j]==true || grid[i][j]==0)return;
        
        if(grid[i][j]==1)q.add(new Pair(i,j,0));
        vis[i][j]=true;
        dfs(i+1,j,q,vis,grid);
        dfs(i-1,j,q,vis,grid);
        dfs(i,j+1,q,vis,grid);
        dfs(i,j-1,q,vis,grid);
        
    }
    public void addNbr(Queue<Pair> q,int i,int j,int level,boolean[][] visbfs,int[][] grid){
         if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visbfs[i][j]==true)return;
        q.add(new Pair(i,j,level));
        return;
    }
}