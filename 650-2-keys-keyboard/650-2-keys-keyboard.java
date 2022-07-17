class Solution {
    public int minSteps(int n) {
        int ans=0;
        if(n==1)return ans;
        for(int i=2;i*i<=n;){
            if(n%i==0){
                ans+=i;
                n/=i;
            }else{
                i++;
            }
        }
        //in case of prime numbers --> ans is n
        if(n!=1){ //if any prime quotient remains after loop
            ans+=n;
        }
        return ans;
    }
}