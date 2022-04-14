class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> al1=new ArrayList<>();
        al1.add(1);
        ans.add(al1);
        if(numRows==1)return ans;
          List<Integer> al2=new ArrayList<>();
        al2.add(1);
        al2.add(1);
        ans.add(al2);
        if(numRows==2)return ans;
        
        for(int i=2;i<numRows;i++){
              List<Integer> al=new ArrayList<>();
            al.add(1);
            for(int j=1;j<i;j++){
                Integer n=ans.get(i-1).get(j-1);
                Integer n2=ans.get(i-1).get(j);
                al.add(n+n2);
            }
            
            al.add(1);
            ans.add(al);
        }
        
        return ans;
    }
}