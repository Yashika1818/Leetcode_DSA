class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent=new int[s.length()];
        al=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            parent[i]=i;
            PriorityQueue<Character> pq=new PriorityQueue<>();
           // pq.add(s.charAt(i));
            al.add(pq);
        }
        
        for(List<Integer> p:pairs){
            int lead1=find(p.get(0));
            int lead2=find(p.get(1));
           
            // PriorityQueue<Character> l2=al.get(lead2);
            if(lead1!=lead2){
                parent[lead2]=lead1;
                // while(l2.size()>0){
                //     l1.add(l2.remove());
                // }
                
            }
        }
        
        for(int i=0;i<s.length();i++){
            int lead=find(i);
             PriorityQueue<Character> l1=al.get(lead);
            l1.add(s.charAt(i));
        }
        
        String ans="";
        for(int i=0;i<s.length();i++){
            int lead=find(i);
            PriorityQueue<Character> pq=al.get(lead);
            ans+=pq.remove();
        }
        
        return ans;
        
    }
    int[] parent;
    ArrayList<PriorityQueue<Character>> al;
    
    public int find(int x){
        if(parent[x]==x)return x;
        else{
            parent[x]=find(parent[x]);
            return parent[x];
        }
    }
}