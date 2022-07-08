//Bellman ford algo
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
       
    int[] d1=new int[n];
    for(int i=0;i<n;i++){
        if(i==src)d1[i]=0;
        else
            d1[i]=(int)1e9;
    }
    int[] d2;
     d2=d1.clone();
   
        for(int i=1;i<=k+1;i++){
        for(int[] f:flights){
            int start=f[0];
            int end=f[1];
            if(d1[start]+f[2] < d2[end]){
                d2[end]=d1[start]+f[2];
            }
        }
            d1=d2.clone();
        }
     
       
        if(d2[dst]!=1e9)return d2[dst];
        return -1;
    }
}