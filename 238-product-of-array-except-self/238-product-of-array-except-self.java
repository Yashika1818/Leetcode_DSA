class Solution {
    public int[] productExceptSelf(int[] nums) {
//         ANS= PREFIX*SUFFIX
//         NUMS[0]
//         SUFFIX= TOTAL PRODUCT EXCEPT NUMS[0]
        
//         1   24
//         2   24
//         6  12
//         24  4
        
//         1  PREV*I-1     24
//         1               12
//         2               4
//         6               1
        
        int[] p=new int[nums.length];
        int[] s=new int[nums.length];
        p[0]=1;
        s[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            p[i]=nums[i-1]*p[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            s[i]=nums[i+1]*s[i+1];
        }
         
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=p[i]*s[i];
        }
        return ans;
    }
}