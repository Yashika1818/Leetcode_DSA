class Solution {
    public String getPermutation(int n, int k) {
        k=k-1;
        int fact=1;
        StringBuilder  s=new StringBuilder();
        StringBuilder ans=new StringBuilder();
        for(int i=1;i<=n;i++){
            fact*=i;
            s.append(i);
        }
       
        while(s.length()!=1){
             fact=fact/n;
            int remove=k/fact;
            ans.append(s.charAt(remove));
             k=k%fact;
            
            n=n-1;
          //  int rem=(s.charAt(remove))-'0';
            
            
            s.delete(remove,remove+1);
           
        }
        ans.append(s.charAt(0));
        
        return ans.toString();
    }
}