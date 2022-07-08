//Tabulation

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>();
        for(String str:wordDict){
            set.add(str);
        }
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int idx=1;idx<=s.length();idx++){
           for(int i=idx-1;i>=0;i--){
            String str=s.substring(i,idx);
            if(set.contains(str)){
                boolean ans=false;
              
                 ans=dp[i];
               
                if(ans){
                    dp[idx]=true ;
                    break;
                  }     
            }
        }
          if(dp[idx]!=true)  dp[idx]=false;
        }
        
        return dp[s.length()];
    }
}