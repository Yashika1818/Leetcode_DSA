class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] =new int[word1.length()+1][word2.length()+1];
        for(int []d:dp){
            Arrays.fill(d,-1);
        }
        return rec(word1,word2,0,0,dp);
    }
    public int rec(String w1,String w2,int i,int j,int[][] dp){
        if(i==w1.length() && j==w2.length())return dp[i][j]=0;
        else if(i==w1.length())return dp[i][j]=w2.length()-j;
        else if(j==w2.length()) return dp[i][j]=w1.length()-i;
        if(dp[i][j]!=-1)return dp[i][j];
        int count=0;
        
        if(w1.charAt(i)==w2.charAt(j)){
            count=rec(w1,w2,i+1,j+1,dp);
        }else{
        
            count=1+Math.min(rec(w1,w2,i,j+1,dp),Math.min(rec(w1,w2,i+1,j+1,dp),rec(w1,w2,i+1,j,dp)));
            
        }
        return dp[i][j]=count;
    }
}


// h o r s e
  
// r o s
// if(not match)
// i++ j++
// i++ j
// i j++