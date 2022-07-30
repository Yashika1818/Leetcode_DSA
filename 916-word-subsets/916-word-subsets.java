class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> al=new ArrayList<>();
          HashMap<Character,Integer> hm2 =new HashMap<>();
          int map[]=new int[26];
        for(String s:words2){
            hm2 =new HashMap<>();
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
              
                hm2.put(ch,hm2.getOrDefault(ch,0)+1);
            }
            for(char key:hm2.keySet()){
                map[key-'a']=Math.max(map[key-'a'],hm2.get(key));
            }
        }
       for(int i=0;i<words1.length;i++){
         
               if(chck(words1[i],map)==true){
                 al.add(words1[i]);
               }
        
       }
      
        return al;
    }
    public boolean chck(String s1,int[] map){
  
        HashMap<Character,Integer> hm1=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
        }
    
        for(int i=0;i<26;i++){
            char ch=(char)('a'+i);
        
            if(map[ch-'a']!=0 && hm1.containsKey(ch)){
                int f=hm1.get(ch);
                if(f>=map[ch-'a'])continue;
                else
                    return false;
            }else if(map[ch-'a']!=0 && hm1.containsKey(ch)==false)return false;
        }
        return true;
    }
}