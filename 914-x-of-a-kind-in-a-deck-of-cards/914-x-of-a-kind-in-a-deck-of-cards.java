class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // no of cards >=2
        // same num of cards
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<deck.length;i++){
            if(hm.containsKey(deck[i])){
                hm.put(deck[i],hm.get(deck[i])+1);
            }else
                hm.put(deck[i],1);
        } 
        int gcd=hm.get(deck[0]);
        //multiple of chck
        
        for(int keys: hm.keySet()){
            
            gcd=GCD(hm.get(keys),gcd);
          
        }
    
        if(gcd==1)return false;
        
        return true;
    }
    public int GCD(int n1,int n2){
        
        while(n1%n2!=0){
            int rem=n1%n2;
            n1=n2;
            n2=rem;
        }
        return n2;
    }
}