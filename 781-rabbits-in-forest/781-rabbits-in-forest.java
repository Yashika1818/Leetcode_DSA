class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<answers.length;i++){
         if(hm.containsKey(answers[i])){
             hm.put(answers[i],hm.get(answers[i])+1);
         }else{
             hm.put(answers[i],1);
         }
        }
        int count=0;
        for(int keys:hm.keySet()){
            if(keys==0){
                count+=hm.get(0);
                continue;
            }
            int n1=hm.get(keys);
            int n2=keys+1;
            
            if(n1>n2){
            int rem=n1%n2;
            int quot=n1/n2;
           // count+=(rem>0 ? n2 : 0)+(quot*n2);  //floor + something = ceil
                count+=(int)Math.ceil((n1*1.0)/(n2*1.0))*n2;
            }else
                count+=keys+1;
        }
        return count;
    }
}