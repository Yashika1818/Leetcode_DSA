class Solution {
    public int longestPalindromeSubseq(String s) {
        String text1=s;
        StringBuilder rev=new StringBuilder(s);
        String text2= rev.reverse().toString();
        int[][] dp=new int[text1.length()+1][text2.length()+1];

        for(int i=text1.length()-1;i>=0;i--){
            for(int j=text2.length()-1;j>=0;j--){
                  int ans=0;
                if(text1.charAt(i)==text2.charAt(j)){
                  ans=1+dp[i+1][j+1];
                }else 
                {
                    ans=Math.max(dp[i+1][j],dp[i][j+1]);
                }   
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
        
    }
}