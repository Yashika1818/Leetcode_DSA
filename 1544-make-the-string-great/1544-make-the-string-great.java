class Solution {
    public String makeGood(String s) {
     

          
            
        int c=0;
        int p=-1;
        StringBuilder sb=new StringBuilder(s);
        while(c<sb.length()){
            if(sb.length()==0 || sb.length()==1)return sb.toString();  
                if (p==-1){
                  p++;
                  c++;
              }
            char c1=sb.charAt(p);
            char c2=sb.charAt(c);
            if((Character.isLowerCase(c1) && Character.toUpperCase(c1)==c2) || (Character.isLowerCase(c2) && Character.toUpperCase(c2)==c1)){
                sb.delete(p,c+1);
                
                p--;
                c--;
            }else{
                p++;
                c++;
            }
        }
        return sb.toString();
    }
}