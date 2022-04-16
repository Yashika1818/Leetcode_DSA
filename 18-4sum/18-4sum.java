class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        ArrayList<List<Integer>> ans=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length-1;j++){
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    long sum=(long)nums[left]+(long)nums[right];
                       ArrayList<Integer> al=new ArrayList<>();
                    int tar=target-nums[i]-nums[j];
                    if(sum>tar){
                        right--;
                    }else if(sum<tar)left++;
                    else{
                     
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[left]);
                        al.add(nums[right]);
                        ans.add(al);
                        left++;
                        right--;
                         // Processing the duplicates of number 3
                        while (left < right && nums[left] == al.get(2)) ++left;
                    
                        // Processing the duplicates of number 4
                        while (left < right && nums[right] == al.get(3)) --right;
                    }
                    // //removing duplicates while using two ptr sum algo
                    // while(al.size()>0 && left<right && nums[left]==al.get(2)   && nums[right]==al.get(3)){
                    //     left++;
                    //     right--;
                    // }
                      
                }
                //we will do j+1 , not j-1 bcz j-1 is i nd ith element can be same as jth but both jth elements cant be same
                while(j+1<nums.length && nums[j+1]==nums[j])j++;
                // now jth ptr is again one back from its orginial pos where it should be there , but as in for loop above in start, we have used j++, so one j ++ will be done nd we will reach to the original position.
                
            }
            
              while(i+1<nums.length && nums[i+1]==nums[i])i++;
        }
        
        return ans;
    }
}