class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> al=new ArrayList<>();
        al.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>al.get(al.size()-1))
            {
            al.add(nums[i]);
            }else
            justGreaterorEqual(al,nums[i]);
            // System.out.println(al);
        }
        
        return al.size();
    }
    public void justGreaterorEqual(ArrayList<Integer> al,int x){
        if(al.size()==1){
            al.set(0,x);
            return;
        }
        // 10 13 14  12
        int i=0;
        int j=al.size()-1;
        int idx=0;
        
        while(i<=j){
           int mid=(i+j)/2;
            if(al.get(mid)<x)i=mid+1;
            else if(al.get(mid)>x){
                idx=mid;
                j=mid-1;
            }
            else{
                idx=mid;
                break;
            }
        }
        al.set(idx,x);
        return;
    }
    
    // 2 4 5 6 7 12
}