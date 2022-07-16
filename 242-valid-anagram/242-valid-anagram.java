class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                int f=hm.get(s.charAt(i));
                hm.put(s.charAt(i),f+1);
            }else{
                hm.put(s.charAt(i),1);
            }
        }
     HashMap<Character,Integer> hm1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm1.containsKey(t.charAt(i))){
                int f=hm1.get(t.charAt(i));
                hm1.put(t.charAt(i),f+1);
            }else{
                hm1.put(t.charAt(i),1);
            }
        }
       
        if(hm.equals(hm1))return true;
        return false;
    }
}