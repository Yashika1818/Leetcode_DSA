//Memoization

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>();
        for(String str:wordDict){
            set.add(str);
        }
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,set,s.length()-1,dp);
    }
    
    public boolean helper(String s,HashSet<String> set,int idx,int[] dp){
         if(idx<0)return true;
        if(dp[idx]!=-1)return (dp[idx]==1) ? true: false;
        for(int i=idx;i>=0;i--){
            String str=s.substring(i,idx+1);
            if(set.contains(str)){
                boolean ans=helper(s,set,i-1,dp);
                if(ans){
                    dp[idx]=1 ;
                    return true ;
                }
                    
            }
            
        }
         dp[idx]=0 ;
        return false ;
    }
}