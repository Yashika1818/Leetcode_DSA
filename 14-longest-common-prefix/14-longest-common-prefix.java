class Solution {
    public String longestCommonPrefix(String[] strs) {
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            mini=Math.min(mini,strs[i].length());
        }
        String ans="";
        int end=0;
        boolean flag=true;
          for(int j=0;j<mini;j++){
              char c=strs[0].charAt(j);
        for(int i=0;i<strs.length;i++){
             if(strs[i].charAt(j)!=c)
             {
                 flag=false;
                 break;
             }
            }
             if(flag==true) 
                end++;
              else
                  break;
              
        }
        
        if(end==0)return "";
        else
            return strs[0].substring(0,end);
    }
}