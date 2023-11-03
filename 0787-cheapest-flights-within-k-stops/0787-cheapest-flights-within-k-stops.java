class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist=new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src]=0;
        
      //  dist  -> denotes prev level
      // temp -> new next level
        for(int level=0;level<=k;level++){
            int[] temp=dist.clone(); 
            for(int[] r:flights){
                if((dist[r[0]]+r[2]) < temp[r[1]])temp[r[1]]=dist[r[0]]+r[2] ;
            }
            dist=temp;
        }

        return dist[dst]==(int)1e9 ?-1: dist[dst];
    }
}

