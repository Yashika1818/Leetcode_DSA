class Solution {
   class Pair{
       int ith;
       int jth;
       int t;
       Pair(int ith,int jth,int t){
           this.ith=ith;
           this.jth=jth;
           this.t=t;
       }
   }
     
    public int orangesRotting(int[][] grid) {
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        Queue<Pair> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
      
        int time=0;
        while(q.size()>0){
            Pair rem=q.remove();
            
            if(vis[rem.ith][rem.jth]==true)continue;
            vis[rem.ith][rem.jth]=true;
            
            time=Math.max(time,rem.t);
            
            
            int i=rem.ith;
            int j=rem.jth;
            if(grid[i][j]==1)fresh--; //if removal one is fresh , now has become rotten after being added in queue
            int t=rem.t;
            addN(grid,q,vis,i+1,j,t+1);
             addN(grid,q,vis,i-1,j,t+1);
             addN(grid,q,vis,i,j+1,t+1);
             addN(grid,q,vis,i,j-1,t+1);
            
        }
       
       if(fresh==0)return time;
       return -1;
        
    }
    public void addN(int[][] grid,Queue<Pair> q,boolean[][] vis,int i,int j,int t){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j]==true || grid[i][j]==0)return;
     
        q.add(new Pair(i,j,t));
    }
}