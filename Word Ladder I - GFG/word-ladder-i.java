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
        String s;
        int cnt;
        Pair(String s,int cnt){
            this.s=s;
            this.cnt=cnt;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String> hm=new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            hm.add(wordList[i]);
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord,1));
        hm.remove(startWord);
        while(q.size()>0){
            Pair r=q.remove();
            
            if((r.s).equals(targetWord))return r.cnt;
            
            for(int i=0;i<startWord.length();i++){
            for(char ch='a';ch<='z';ch++){
                StringBuilder sb=new StringBuilder(r.s);
                sb.setCharAt(i,ch);
                String str=sb.toString();
                if(hm.contains(str)){
                q.add(new Pair(str,r.cnt+1));
                hm.remove(str);
                }
            }
            }
        }
        return 0;
    }
}