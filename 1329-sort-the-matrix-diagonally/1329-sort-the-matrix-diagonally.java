//tc: m*n*log(min(m,n))
// in hashmap--> keys ke lie we have some rules but not for values
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,PriorityQueue<Integer>> hm=new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int gap=i-j;
                if(hm.containsKey(gap)==false){
                    hm.put(gap,new PriorityQueue<>());
                }
                hm.get(gap).add(mat[i][j]);
            }
        }
        
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int gap=i-j;
                mat[i][j]=hm.get(gap).remove();
            }
        }
        return mat;
    }
}