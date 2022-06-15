//NOTE : we can't take cntcell or boolean isTrue inside the call because during backtrack --> everything even their values will be backtracked and result will be same as what we passed initially.
//therefore , make them global variables.


class Solution {
     boolean isTrue=true;
     int cntcell=0;
    
    public int numEnclaves(int[][] grid) {
        int count=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
       
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
             
              if(visited[i][j]==false && grid[i][j]==1 ){
  
                  cntcell=0;
                  isTrue=true;
            traverse(grid,visited,i,j);
 
                  if(isTrue==true)count+=cntcell;
                  
              }
            }
        }
        return count;
    }
    public void traverse(int[][] grid,boolean[][] visited,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            isTrue=false;
            return;
        }else if(visited[i][j]==true || grid[i][j]==0)return;
        
        visited[i][j]=true;
      cntcell++;
        traverse(grid,visited,i,j+1);
        traverse(grid,visited,i+1,j);
        traverse(grid,visited,i-1,j);
        traverse(grid,visited,i,j-1);

    }
}