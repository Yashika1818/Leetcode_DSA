class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> hm=new HashMap<>();
        ArrayList<String> al=new ArrayList<>();
        int start=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==' '){
                al.add(s.substring(start,i));
                start=i+1;
            }
        }
        al.add(s.substring(start,s.length()));
        if(al.size()!=pattern.length())return false;
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String str=al.get(i);
            if(hm.containsKey(ch)){
                 
                if(hm.get(ch).equals(str)==false)return false;
            }else{
              //   System.out.println(1);
                if(set.contains(str))return false;
                hm.put(ch,str);
                set.add(str);
            }
        }
       
        return true;
    }
}