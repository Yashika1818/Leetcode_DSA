class Solution {
    public List<Integer> partitionLabels(String s) {
        int map[]=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map[c-'a']=i;
        }
        
        int start=0;
        int end=0;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            end=Math.max(end,map[ch-'a']);
            
            if(i==end){
                ans.add(end-start+1);
                end++;
                start=end;
            }
        }
        return ans;
    }
}