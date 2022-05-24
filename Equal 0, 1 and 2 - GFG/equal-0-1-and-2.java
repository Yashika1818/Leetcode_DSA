// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        int c0=0;
        int c1=0;
        int c2=0;
        String key="0#0";
        HashMap<String, Integer> hm=new HashMap<>();
        hm.put(key,1);
        long count=0;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c-'0'==0){
                c0++;
            }else if(c-'0'==1){
                c1++;
            }else{
                c2++;
            }
            String d1=(c1-c0)+"";
            String d2=(c2-c1)+"";
            String s=d1+"#"+d2;
            if(hm.containsKey(s)){
                count+=hm.get(s);
                hm.put(s,hm.get(s)+1);
            }else{
                hm.put(s,1);
            }
        }
        return count;
    }
} 