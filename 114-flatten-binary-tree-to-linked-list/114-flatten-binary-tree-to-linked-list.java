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
    public void flatten(TreeNode root) {
        if(root==null)return;
        //solution from angle of faith
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null && root.right!=null){
        TreeNode end=find_end(root.left);
        TreeNode tmp=root.right;
        root.right=root.left;
        root.left=null;
        end.right=tmp;
        }else if(root.right==null){
            root.right=root.left;
            root.left=null;
        }
        
    }
    public TreeNode find_end(TreeNode root){
        if(root==null)return null;
        while(root.right!=null){
            root=root.right;
        }
        return root;
    }
}