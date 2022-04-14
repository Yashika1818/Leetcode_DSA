class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j=matrix[0].length-1;
        boolean ans=false;
        while(i<matrix.length && j>=0){
            if(matrix[i][j]<target)
                i++;
            else if(matrix[i][j]>target)
                j--;
            else{
                ans=true;
                break;
            }
        }
        return ans;
    }
}