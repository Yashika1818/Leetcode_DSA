 //tabulation with space optimization

class Solution {
    public int minCostClimbingStairs(int[] cost) {
     
        int prevp=(int)1e9;
        int prev=0;
      
        for(int i=cost.length-1;i>=0;i--){
        int ans1=cost[i]+Math.min(prev,prevp); 
        prevp=prev;
        prev=ans1;
       
        }
  
        return Math.min(prev,prevp);
    }

}