class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in=new int[numCourses];
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<Integer>();
        }
        
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for(int v=0;v<numCourses;v++){
            for(int nbr:graph[v]){
                in[nbr]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0)q.add(i);
        }
        int cnt=numCourses;
        int[] ans=new int[numCourses];
        while(q.size()>0){
            int rem=q.remove();
            ans[cnt-1]=rem;
            cnt--;
            for(int i:graph[rem]){
                in[i]--;
                if(in[i]==0)q.add(i);
            }
        }
        if(cnt==0)return ans;
        else
            return new int[0];
    }
}