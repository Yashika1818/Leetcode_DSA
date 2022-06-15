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
    public int[][] updateMatrix(int[][] mat) {
        ArrayDeque<Pair> q=new ArrayDeque<>();
        int dist=0;
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int[][] ans=new int[mat.length][mat[0].length];
        boolean[][] visited=new boolean[mat.length][mat[0].length];
        while(q.size()>0){
            Pair rem=q.remove();
            
            if(visited[rem.x][rem.y]==true)continue;
            visited[rem.x][rem.y]=true;
            
            ans[rem.x][rem.y]=rem.d;
            
            addNeighbour(q,mat,rem.x+1,rem.y,visited,rem.d+1);
            addNeighbour(q,mat,rem.x-1,rem.y,visited,rem.d+1);
            addNeighbour(q,mat,rem.x,rem.y+1,visited,rem.d+1);
            addNeighbour(q,mat,rem.x,rem.y-1,visited,rem.d+1);
        }
        
        
        return ans;
    }
    
  public void addNeighbour(ArrayDeque<Pair> q,int[][] mat,int x,int y,boolean[][] visited,int d){
        if( x<0 || x>=mat.length || y<0 || y>=mat[0].length || visited[x][y]==true){
            return;
        }
        q.add(new Pair(x,y,d));
    }
    
}