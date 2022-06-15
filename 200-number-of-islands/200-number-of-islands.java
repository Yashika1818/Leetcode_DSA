class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    traverse(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void traverse(char[][] grid,boolean[][] visited,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j]==true || grid[i][j]=='0' ){
            return;
        }
        visited[i][j]=true;
        traverse(grid,visited,i,j+1);
         traverse(grid,visited,i,j-1);
         traverse(grid,visited,i+1,j);
         traverse(grid,visited,i-1,j);
        
        
    }
}