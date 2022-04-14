class Solution {
    
    public double myPow(double x, int n) {
        return n>0 ? pow(x,n) : 1.0/pow(x,-n);
    }
    
    public double pow(double x, int n){
        
        if(n==0){
            return 1.0;
        }else{
            double half=pow(x,n/2);
            return n%2==0 ? half*half : half*half*x;
        }
    }
}