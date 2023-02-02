//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
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
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Pair{
        String str;
        ArrayList<String> al;
        int moves;
        
        Pair(String str,ArrayList<String> al,int moves){
            this.str=str;
            this.al=al;
            this.moves=moves;
        }
    }
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        int minmoves=Integer.MAX_VALUE;
        ArrayList<ArrayList<String>> ans=new ArrayList<ArrayList<String>>();
        Queue<Pair> q=new LinkedList<>();
        ArrayList<String> ar=new ArrayList<>();
        ar.add(startWord);
        set.remove(startWord);
        q.add(new Pair(startWord,ar,1));
        
        while(q.size()>0){
            Pair p=q.remove();
            //  System.out.println(p.str +" "+p.al);
            set.remove(p.str);
            if(p.moves>minmoves) return ans; //it means target has been achieved at minmoves level
            if((p.str).equals(targetWord)){
                minmoves=p.moves;

                ans.add(p.al);
            }
            // if((p.str).equals(targetWord))continue;
            for(int j=0;j<startWord.length();j++){
                for(char ch='a';ch<='z';ch++){
                    StringBuilder s=new StringBuilder(p.str);
                    
                    s.setCharAt(j,ch);
                    String st=s.toString();
                    if(set.contains(st)){
                        ArrayList<String> all=new ArrayList<>(p.al);
                        all.add(st);
                       
                        q.add(new Pair(st,all,p.moves+1));
                    }
                    
                }
            }
        }
       return ans;
    }
  
}
// minmoves
// pair 
// str,arraylist,moves

// if(str==target && moves<=minmoves){
//   ans.add(arraylist)
// }else if(moves>minmoves)
// return ans;   
// if(moves>minmoves)continue;