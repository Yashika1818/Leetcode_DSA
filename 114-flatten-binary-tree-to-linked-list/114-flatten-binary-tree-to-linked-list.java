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
    //static global var 
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null)return;
      //post order 
        flatten(root.right);
        flatten(root.left);
        
        root.left=null;
        root.right=prev;
        prev=root;
    }
 
}