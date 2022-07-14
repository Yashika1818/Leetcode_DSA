class Solution {
    public String longestPalindrome(String s) {
        if(s=="")return "";
        int[][] dp=new int[s.length()][s.length()];
        for(int[] d:dp){
            Arrays.fill(d,0);
        }
        for(int d=0;d<s.length();d++){
            for(int i=0;i<s.length();i++){
                int j=i+d;
                if(j>=s.length())break;
                else if(i==j){
                    dp[i][j]=1;
                }
                else{
                    if(dp[i+1][j-1]!=-1 && s.charAt(i)==s.charAt(j)){
                   dp[i][j]= dp[i+1][j-1]+2;
                        }else{
                        dp[i][j]=-1;
                    }
                }
            }
        }
        int max=0;
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(dp[i][j]>max){
                max=dp[i][j];
                start=i;
                end=j;
                }
            }
        }
        
      // System.out.println(max);
        return s.substring(start,end+1);
    }
}