class Solution {
      public double myPow(double x, int n){
          double ans=myans(x,n);
          if(n<0)return (1/ans);
          return ans;
      }             
    public double myans(double x, int n) {
        if(n==0)return 1.00;
         double ans=0;
     
       ans=myans(x,n/2);
        if(n%2==0)
      return ans*ans;
        else if(n%2!=0){
      
            return ans*ans*x;
        }
           

        return 0;
    }
}