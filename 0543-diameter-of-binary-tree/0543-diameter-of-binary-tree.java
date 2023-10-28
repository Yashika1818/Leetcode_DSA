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
    public int maxi=0;
    public int diameterOfBinaryTree(TreeNode root) {
        int hmax=maximumht(root);
        return maxi;
    }
    public int maximumht(TreeNode root){
        if(root==null)return 0;
        
        int hl=0,hr=0;
        if(root.left!=null)hl=1+maximumht(root.left);
        if(root.right!=null)hr=1+maximumht(root.right);
        
        maxi=Math.max(maxi,hl+hr);
        
        return Math.max(hl,hr);
    }
}