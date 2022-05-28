class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        int[] map1=new int[123];
        int[] map2=new int[123];
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
         map1[c]++;
           
        }
        
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        String minwin="";
        while(j<s.length()){
          //acquiring till we get the map equals
                char c=s.charAt(j);
                 map2[c]++;
                j++;
            
          
         //once the map gets equal , we will start releasing till map gets            unequalized
            while( equals(map1,map2)==true){
                //each time when map is equal, we will check len and update                     it
               int len=j-i;
                  if(len<min){
                    min=len;
                    minwin=s.substring(i,j); 
                   }
                char ch=s.charAt(i);
                map2[ch]--;
                i++;
                
            }
           
        }
        return minwin;
    }
    public boolean equals(int[] map1,int[] map2){
        for(int i=0;i<123;i++){
            // agr map1[i]==0 h toh no issue else check
            if(map1[i]==0)continue;
            else{
                if(map1[i]>map2[i])return false;
            }
        }
        return true;
    }
}