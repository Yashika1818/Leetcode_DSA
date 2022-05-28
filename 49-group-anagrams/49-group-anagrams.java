class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
   
        List<List<String>> ans=new ArrayList<List<String>>();
             if(strs.length==0){
                 return ans;
             }else if(strs.length==1){
                 List<String> al=new ArrayList<>();
                 al.add(strs[0]);
                 ans.add(al);
                 return ans;
             }
        HashMap<HashMap,Integer> hm=new HashMap<>();
        int j=0;
        for(int k=0;k<strs.length;k++){
            String s=strs[k];
            HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            if(hm.containsKey(map)){
                int jth=hm.get(map);
                ans.get(jth).add(s);
            }else{
                hm.put(map,j);
                List<String> al=new ArrayList<>();
                al.add(s);
                ans.add(al);
                j++;
            }
        }
        return ans;
    }
}