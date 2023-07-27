class Solution {
    public int minCut(String s) {
        int dp[]=new int[s.length()+1];
        Boolean[][] pal=new Boolean[s.length()+1][s.length()+1];
        Arrays.fill(dp,-1);
        dp[s.length()]=0;
        for(int i=s.length()-1;i>=0;i--){
            int ans=Integer.MAX_VALUE;
        for(int k=i;k<s.length();k++){
            int partitions=Integer.MAX_VALUE;
            if(isPalindrome(i,k,s,pal)){
                partitions=1+dp[k+1];
            }
            ans=Math.min(ans,partitions);  
        }
        dp[i]=ans;
        }
        return dp[0]-1;
    }

    public boolean isPalindrome(int i,int j,String s,Boolean[][] pal){
        if(pal[i][j]!=null)return pal[i][j];
        int x=i,y=j;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))return pal[x][y]=false;
            if(pal[i][j]!=null)return pal[x][y]=pal[i][j];
            i++;
            j--;
        }
        return pal[x][y]=true;
    }
}