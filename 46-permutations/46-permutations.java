class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        permutation(nums,0,ans);
        return ans;
    }
    public void permutation(int[] nums,int i,List<List<Integer>> ans) {
        if(i==nums.length-1){
            List<Integer> al=new ArrayList<>();
            for(int k=0;k<nums.length;k++){
                al.add(nums[k]);
            }
            ans.add(al);
            return;
        }
        for(int j=i;j<nums.length;j++){
            swap(i,j,nums);
         //   System.out.println(nums);
            permutation(nums,i+1,ans);
            swap(i,j,nums);
        }
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        return;
    }
}