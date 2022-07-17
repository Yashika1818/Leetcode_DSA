//memoization
class Solution {
    public int minInsertions(String s) {
         StringBuilder sb=new StringBuilder(s);
         String rev=sb.reverse().toString();
         int[][] dp=new int[s.length()][rev.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
		return s.length()-helper(s,rev,s.length()-1,rev.length()-1,dp);
    }
    	public static int helper(String s,String r,int i,int j,int[][] dp){
	    if(i<0 || j<0){
	        return 0;
	    }
            if(dp[i][j]!=-1)return dp[i][j];
	    int maxi=0;
	    if(s.charAt(i)==r.charAt(j)){
	        maxi=1+helper(s,r,i-1,j-1,dp);
	    }else{
	        maxi=Math.max(helper(s,r,i-1,j,dp),helper(s,r,i,j-1,dp));
	    }
	    
	    return dp[i][j]=maxi;
	}
    
}