class Solution {
    public void rotate(int[][] matrix) {
        for(int j=0;j<matrix[0].length;j++){
            int start=0;
            int end=matrix.length-1;
            while(start<end){
                int temp=matrix[start][j];
                matrix[start][j]=matrix[end][j];
                matrix[end][j]=temp;
                start++;
                end--;
            }
        }
        
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}