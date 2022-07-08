
class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp=new int[m][n+1][target+1];
        for(int[][] d:dp){
            for(int[] row:d){
                Arrays.fill(row,-1);
            }
        }
        int mincost=(int)1e9;
        if(houses[0]!=0){
            mincost=find(houses,cost,target-1,1,houses[0]-1,dp);
        }else{
      
            mincost=find(houses,cost,target,0,-1,dp);
            
        }
        
        return mincost==(int)1e9 ? -1 : mincost;
    }
    
    public int find(int[] houses, int[][] cost,int target,int i,int j,int[][][] dp){
        
        if(target==-1 && i<cost.length)return (int)1e9;
        if(target!=0 && i==cost.length)return (int)1e9;
        if(target==0 && i==cost.length){
          
            return 0;
        }
        if(dp[i][j+1][target]!=-1)return dp[i][j+1][target];
         int mcost=(int)1e9;
        if(i>0 && houses[i]!=0){
            if(j != houses[i]-1){
                mcost=find(houses,cost,target-1,i+1,houses[i]-1,dp);
            }else{
                mcost=find(houses,cost,target,i+1,j,dp);
            }
        }
        else{
  
        for(int k=0;k<cost[0].length;k++){
            int csf=(int)1e9;
            if(k==j){
               csf=cost[i][k]+find(houses,cost,target,i+1,k,dp);
            }else{
               csf=cost[i][k]+find(houses,cost,target-1,i+1,k,dp);
            }
            mcost=Math.min(mcost,csf);
        }
        }
        
        return dp[i][j+1][target]=mcost;
    }
}