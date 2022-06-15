class Solution {
    class Pair{
        int x;
        int y;
        int t;
        
        Pair(int x,int y,int t){
            this.x=x;
            this.y=y;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        ArrayDeque<Pair> q=new ArrayDeque<>();
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
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        while(q.size()>0){
            //remove
            Pair rem=q.remove();
            //mark*
            if(visited[rem.x][rem.y]==true){
                continue;
            }
            visited[rem.x][rem.y]=true;
            //work
            if(rem.t>time){
                time=rem.t;
            }
            if(grid[rem.x][rem.y]==1)fresh--;
            //add neighbour*
            addNeighbour(rem.x+1,rem.y,grid,visited,rem.t+1,q);
            addNeighbour(rem.x,rem.y+1,grid,visited,rem.t+1,q);
              addNeighbour(rem.x-1,rem.y,grid,visited,rem.t+1,q);
              addNeighbour(rem.x,rem.y-1,grid,visited,rem.t+1,q);
            
            
        }
        
        if(fresh==0){
            return time;
        }else{
            return -1;
        }
        
    }
    
    public void addNeighbour(int x,int y,int[][] grid,boolean[][] visited,int t,ArrayDeque<Pair> q){
        //rotten oranges has already been visited
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length)return;
        if(visited[x][y]==true || grid[x][y]==0)return;
        q.add(new Pair(x,y,t));
        
    }
}