/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //mid 
        //mid-1 -> left -> lo , mid-1
        //hi-> right -> mid+1,hi
        
      //  left node right
        TreeNode root=helper(nums,0,nums.length-1);
        return root;
        
    }
    public TreeNode helper(int[] nums,int lo,int hi){
        int mid=(lo+hi+1)/2;
        if(mid<lo || mid>hi)return null;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,lo,mid-1);
        root.right=helper(nums,mid+1,hi);
        return root;
    }
}