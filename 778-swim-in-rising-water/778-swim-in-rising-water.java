//this is the type of dijkstra+bfs using priorityqueue
class Solution {
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        int tesf;  //time estimated so far
        Pair(int x,int y,int tesf){
            this.x=x;
            this.y=y;
            this.tesf=tesf;
        }
        
       public int compareTo(Pair o){
           return this.tesf-o.tesf;
       }
    }
    public int swimInWater(int[][] grid) {
     PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0,grid[0][0]));
        boolean[][] visited=new boolean[grid.length][grid[0].length];
    while(pq.size()>0){
        Pair rem=pq.remove();
        if(visited[rem.x][rem.y]==true)continue;
        visited[rem.x][rem.y]=true;
        if(rem.x== grid.length-1 && rem.y==grid[0].length-1)
            return rem.tesf;
        
        addN(rem.x+1,rem.y,grid,visited,rem.tesf,pq);
        addN(rem.x-1,rem.y,grid,visited,rem.tesf,pq);
        addN(rem.x,rem.y+1,grid,visited,rem.tesf,pq);
        addN(rem.x,rem.y-1,grid,visited,rem.tesf,pq);

    }
        return -1;
    }
    public void addN(int x,int y,int[][] grid,boolean[][] visited,int ot,PriorityQueue<Pair> pq){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || visited[x][y]==true)return;
        
        pq.add(new Pair(x,y,Math.max(grid[x][y],ot)));
    }
}