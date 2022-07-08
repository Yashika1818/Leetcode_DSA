class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int dist[][]=new int[numCourses][numCourses];
        for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist.length;j++){
                if(i==j)
                dist[i][j]=0;
                else
                dist[i][j]=(int)1e9;
            }
        }
        for(int[] p:prerequisites){
            dist[p[0]][p[1]]=1;
        }
        
        for(int k=0;k<numCourses;k++){
            for(int i=0;i<numCourses;i++){
                for(int j=0;j<numCourses;j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        List<Boolean> ans=new ArrayList<>();
        for(int[] q:queries){
            if(dist[q[0]][q[1]]!=(int)1e9)ans.add(true);
            else
                ans.add(false);
        }
        
        return ans;
    }
}