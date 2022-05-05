class Solution {
    public List<List<String>> partition(String s) {
   //partition will be done from start , the next recursion call will be made when that first substring is itself palindromic , If the frst substring is not palindromic then no need to do further partition in this case.
        List<String> asf=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
        helper(s,asf,ans);
        return ans;
            
    }
   
    public void helper(String s,List<String> asf,List<List<String>> ans){
        if(s==""){
           //System.out.println(asf);
            ans.add(new ArrayList<String>(asf));
           
            return;
        
        }
        // str --> upto p
        // remain --> after p
        for(int i=1;i<=s.length();i++){
            String str=s.substring(0,i);
            
           if(isPalindrome(str)){
               asf.add(str);
               //s=s.substring(i);
               helper(s.substring(i),asf,ans);
               //
               asf.remove(asf.size()-1);
               
           }
        }
       
    }
    
    public boolean isPalindrome(String str){
        if(str.length()==1)return true;
        int start=0;
        int end=str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}