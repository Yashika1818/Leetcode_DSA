class Solution {
    public String reverseWords(String s) {
      HashMap<Integer,String> hm=new HashMap<>();
        int ind=0;
        String str="";
      for(int i=0;i<s.length();i++){
          if(s.charAt(i)!=' '){
              str+=s.charAt(i);
          }else{
             if(str!="") {
                 hm.put(ind,str);
                 ind++;
                 str="";
             }
              
          }
      }
        
        if(str!=""){
            hm.put(ind,str);
        }
        String ans="";
        for(int i=hm.size()-1;i>=0;i--){
            ans+=hm.get(i);
            if(i!=0)ans+=" ";
        }
       // System.out.println(hm);
        return ans;
    }
}