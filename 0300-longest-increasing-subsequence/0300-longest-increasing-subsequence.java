class Solution {
    public int lengthOfLIS(int[] nums) {
    List<Integer> al=new ArrayList<>();
    al.add(nums[0]);
   
    for(int i=1;i<nums.length;i++){
        if(al.get(al.size()-1)<nums[i]){
            
            al.add(nums[i]);
        }else{
            bs(al,nums[i]);
        }
    }
        return al.size();
    }
    public void bs(List<Integer> al,int num){
        int i=0;
        int j=al.size()-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(num<al.get(mid))j=mid-1;
            else if(num>al.get(mid))i=mid+1;
            else return;
        }
        
        al.set(i,num);
        return;
    }

}