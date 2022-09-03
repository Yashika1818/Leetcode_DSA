class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
//         <10
//         1+k     --> 1 , 8 --> repeat
//         2+k     ---> 2,9 
//         3+k
        
//         n=4
//         k=1
            
//         -+k 
            
//         1212
            
           HashSet<Integer> set=new HashSet<>();
            for(int i=1;i<=9;i++){
            int l=n-1;
            sol(i,k,i+"",l,set);
            }
            int ans[]=new int[set.size()];
        int cnt=0;
         Iterator<Integer> iterator = set.iterator();
            while(iterator.hasNext()){
                   ans[cnt]=iterator.next();
                   cnt++;
               }
                
              return ans;
        
            
    
       
            
        
    }
    public void sol(int n,int k,String str,int l,HashSet<Integer> set){
        
        if(l==0){
          set.add(Integer.valueOf(str));
            return;
        }
     if(n+k<10){
                int d=n+k;
                sol(n+k, k,str+d+"",l-1,set);
            }
       if(n-k>=0){
            int d=n-k;
            sol(n-k,k,str+d+"",l-1,set);
        }
          return;
    }
}