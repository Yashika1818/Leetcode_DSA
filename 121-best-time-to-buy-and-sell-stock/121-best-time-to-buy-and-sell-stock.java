class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int buy=0,sell=0;
        for(int i=0;i<prices.length;i++){
            if(prices[buy]>=prices[i]){
                buy=i;
                sell=i;
                
            }else{
                
                if(prices[i]-prices[buy]>maxProfit){
                    maxProfit=prices[i]-prices[buy];
                }
                    
                    sell++;
            }
        }
        
        return maxProfit;
    }
}