//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution

{
    class Pair{
        String str;
        int dist;
        Pair(String str,int dist){
            this.str=str;
            this.dist=dist;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        
        Queue<Pair> q=new LinkedList<>();
        // rmwa
        q.add(new Pair(startWord,1));
        while(q.size()>0){
            Pair p=q.remove();
            
            if(set.contains(p.str)){
                set.remove(p.str);
            }
            
            if((p.str).equals(targetWord))
            return p.dist;
            for(int j=0;j<startWord.length();j++){
            for(int i=1;i<=26;i++){
                char c=(char)(96+i);
                StringBuilder s=new StringBuilder(p.str);
                s.setCharAt(j,c);
                String st=s.toString();
                if(set.contains(st)){
                    q.add(new Pair(st,p.dist+1));
                }
                
                
            }
            }
            
        }
        return 0;
    }
}