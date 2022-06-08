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
    int x=0;
    public TreeNode convertBST(TreeNode root) {
        x=0;
       helper(root);
        return root;
    }
    public int helper(TreeNode root){
        if(root==null)return 0;
        
         
      int r=  helper(root.right);
        root.val=x+root.val;
        x=root.val;
       int l= helper(root.left);
        
        return x;
    }
}