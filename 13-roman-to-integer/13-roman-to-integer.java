class Solution {
    public int romanToInt(String s) {
        
        HashMap<Character,Integer> hm=new HashMap<>();
        hm.put('I',1);
          hm.put('V',5);
          hm.put('X',10);
          hm.put('L',50);
          hm.put('C',100);
          hm.put('D',500);
         hm.put('M',1000);
        int i=0;
        int ans=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(c=='I'){
            if(i+1<s.length() && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')){
                    ans+=hm.get(s.charAt(i+1))-hm.get('I');
                    i=i+2;
                }else{
                    ans+=hm.get(c);
                    i++;
                }
            }else if(c=='X'){
                 if(i+1<s.length() &&  (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')){
                    ans+=hm.get(s.charAt(i+1))-hm.get(c);
                    i=i+2;
                }else{
                    ans+=hm.get(c);
                    i++;
                }
            }
            else if(c=='C'){
                 if(i+1<s.length() && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M')){
                    ans+=hm.get(s.charAt(i+1))-hm.get(c);
                    i=i+2;
                }else{
                    ans+=hm.get(c);
                    i++;
                }
            }else{
                ans+=hm.get(c);
                i++;
            }
            
            
        }
        
        
        return ans;
    }
}