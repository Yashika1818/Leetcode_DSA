class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
    for(int i=0;i<s.length();i++){
        char chs=s.charAt(i);
        char cht=t.charAt(i);
        if(map.containsKey(chs)){
            if(cht!=map.get(chs))return false;     
        }else{
            if(set.contains(cht))return false;
            map.put(chs,cht);
            set.add(cht);
        }
    }
        return true;
    }
}