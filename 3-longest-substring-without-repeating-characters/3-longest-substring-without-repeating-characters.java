class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        HashMap<Character,Integer> hm=new HashMap<>();
        int l=0,r=0,max=0,len=0;
       while(r<s.length()){
            char c=s.charAt(r);
           
            if(hm.containsKey(c) && hm.get(c)>=l){
                //l is updated if repeated char is in range era
                   l=hm.get(c)+1;
            }
              //len is calculated at every point
           len=r-l+1;
           if(len>max)max=len;
           // at every point hashmap is updated 
            hm.put(c,r);
            r++;
               
            
        }
     
        return max;
    }
}