class NumArray {
int[] arr;
int totalsum;
    public NumArray(int[] nums) {
       arr=nums;
        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];
        }

    }
    
    public void update(int index, int val) {
        totalsum-=arr[index];
       arr[index]=val;
      totalsum+=arr[index];
    }
    
    public int sumRange(int left, int right) {
        int sum=totalsum;
        int i=0,j=right+1;
        while(i<left){
            sum-=arr[i];
            i++;
        }
        while(j<arr.length){
            sum-=arr[j];
            j++;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */