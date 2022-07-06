class Solution {
    public int fib(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        int prev=1;
        int prevp=0;
        int curr=0;
        for(int i=2;i<=n;i++){
            curr=prev + prevp;
             prevp=prev;
            prev=curr;
        }
        return curr;
    }
}