class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s=="")return 0;
        HashMap<Character,Integer> hm=new HashMap<>();
         int i=0,j=0;
        int max=0;
        while(j<s.length()){
            char c=s.charAt(j);
            if(hm.containsKey(c)){
                int len=j-i;
                if(len>max)max=len;
                 
                while(s.charAt(i)!=c){
                  
                    hm.remove(s.charAt(i));
                    i++;
                }
                hm.remove(c);
                i++;
            }else{
                hm.put(c,j);
                j++;
            }
        }
         int len=j-i;
          if(len>max)max=len;
        return max;
    }
}