class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] visitedrow=new boolean[matrix.length];
        boolean[] visitedcol=new boolean[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0){
                    visitedrow[i]=true;
                    visitedcol[j]=true;
                }
            }
        }
         for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                
                if(visitedrow[i]==true|| visitedcol[j]==true)
                    matrix[i][j]=0;
            }
             
            }
        
    }
    

}