class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      
        List<Integer> ans=new ArrayList<>();
          if(s.length()<p.length()){
              return ans;
          }
        int n=p.length();
        HashMap<Character,Integer> hmp=new HashMap<>();
        HashMap<Character,Integer> hms=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=p.charAt(i);
            hmp.put(c,hmp.getOrDefault(c,0)+1);
        }
       for(int i=0;i<n;i++){
            char c=s.charAt(i);
            hms.put(c,hms.getOrDefault(c,0)+1);
        }
        //int count=0;
        if(hmp.equals(hms)){
            ans.add(0);
           // count++;
        }
        int i=0;
        int j=n-1;
        while(j !=(s.length()-1)){
            char c=s.charAt(i);
            
            hms.put(c,hms.get(c)-1);
            if(hms.get(c)==0)hms.remove(c);
                
             i++;  
            j++;
            char add=s.charAt(j);
            hms.put(add,hms.getOrDefault(add,0)+1);
            if(hms.equals(hmp))ans.add(i);
        }
        return ans;
    }
}