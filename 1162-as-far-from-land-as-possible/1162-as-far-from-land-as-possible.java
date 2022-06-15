class Solution {
    class Pair{
        int x;
        int y;
        int d;
        Pair(int x,int y,int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    public int maxDistance(int[][] grid) {
        ArrayDeque<Pair> q=new ArrayDeque<>();
        int cnt1=0,cnt0=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j,0));
                    cnt1++;
                }else{
                    cnt0++;
                }
            }
        }
        if(cnt0==0 || cnt1==0)return -1;
        
        int max=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        while(q.size()>0){
        Pair rem=q.remove();
        if(visited[rem.x][rem.y]==true)continue;
        visited[rem.x][rem.y]=true;
        
        if(rem.d>max){
            max=rem.d;
        }
        
        addNeighbour(q,visited,rem.x+1,rem.y,rem.d+1);
        addNeighbour(q,visited,rem.x,rem.y+1,rem.d+1);
        addNeighbour(q,visited,rem.x-1,rem.y,rem.d+1);
        addNeighbour(q,visited,rem.x,rem.y-1,rem.d+1);
        }
        return max;
    }
    public void addNeighbour(ArrayDeque<Pair> q,boolean[][] visited,int x,int y,int d){
        if(x<0 || y<0 || x>=visited.length || y>=visited.length || visited[x][y]==true)return;
        q.add(new Pair(x,y,d));
    }
    
}