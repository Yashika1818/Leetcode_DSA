class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> al1=new ArrayList<>();
        al1.add(1);
        ans.add(al1);
        if(numRows==1)return ans;
        List<Integer> al=new ArrayList<>();
        al.add(1);
        al.add(1);
        ans.add(al);
         if(numRows==2)return ans;
        for(int i=2;i<numRows;i++){
            List<Integer> all=new ArrayList<>();
            all.add(1);
            for(int j=1;j<i;j++){
                int sum=ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                all.add(sum);
            }
              all.add(1);
            ans.add(all);
        }
        return ans;
    }
}