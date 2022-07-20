class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        //brute force
    //    each word is checked --> s
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<words.length;i++){
            String w=words[i];
            hm.put(w,hm.getOrDefault(w,0)+1);
        }
        int cnt=0;
            for(String w:hm.keySet()){
                int k=0;
                int j=0;
                while(k<w.length() && j<s.length()){
                    if(w.charAt(k)==s.charAt(j)){
                        k++;
                        j++;
                    }else{
                        j++;
                    }
                }
                
                if(k==w.length()){
                    cnt+=hm.get(w);
                }
            }
        return cnt;
    }
}