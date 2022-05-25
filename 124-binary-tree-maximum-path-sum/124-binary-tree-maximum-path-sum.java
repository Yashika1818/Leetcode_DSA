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
     int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        
        int s= helper(root);
        return max;
    }
   
    public int helper(TreeNode root) {
        if(root==null)return 0;
        int ls=helper(root.left);
        int rs=helper(root.right);
        ls=Math.max(0,ls);
        rs=Math.max(0,rs);
        int s=root.val + Math.max(ls,rs);
        int rsum=root.val+ls+rs;
        
        if(rsum>max)max=rsum;
      //  System.out.println(max);
        return s;
    }
}