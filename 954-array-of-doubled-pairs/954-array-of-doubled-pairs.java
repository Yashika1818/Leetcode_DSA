class Solution {
    public boolean canReorderDoubled(int[] arr) {
       // -4 -2 2 4 
       //     neg ka rev
       //     1 3 3 6
       //     1 2 2 6
       //     i+=2;
     HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
         if(hm.containsKey(arr[i])){
             hm.put(arr[i],hm.get(arr[i])+1);
         }else
             hm.put(arr[i],1);
        }
        Arrays.sort(arr);
           for(int i=0;i<arr.length;i++){
               int keys=arr[i];
              if(keys!=0 && hm.containsKey(keys) && hm.containsKey(2*keys)){
                 
                  hm.put(keys,hm.get(keys)-1);
                  hm.put(2*keys,hm.get(2*keys)-1);
                   //as we are not iterating thro hashmap , we can remove elements from hashmap
                    if(hm.get(keys)==0){
                   hm.remove(keys);
               }
               if(hm.get(2*keys)==0){
                   hm.remove(2*keys);
               }
              }
              
             
           }
       
        if(hm.size()==0)return true;
        else if(hm.size()==1 && hm.containsKey(0))return true;
        else
          return false; 
    }
}