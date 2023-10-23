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
        int count1=(int)1e9,count2=(int)1e9,count3=(int)1e9,count4=(int)1e9;
        
        if(w1.charAt(i)==w2.charAt(j)){
            count1=rec(w1,w2,i+1,j+1,dp);
        }else{
            count2=1+rec(w1,w2,i,j+1,dp);
            count3=1+rec(w1,w2,i+1,j+1,dp);
            count4=1+rec(w1,w2,i+1,j,dp);
          
            
        }
        return dp[i][j]=Math.min(count1,Math.min(count2,Math.min(count3,count4)));
    }
}


// h o r s e
  
// r o s
// if(not match)
// i++ j++
// i++ j
// i j++