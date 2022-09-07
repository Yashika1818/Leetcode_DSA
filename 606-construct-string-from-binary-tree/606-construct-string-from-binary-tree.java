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
    public String tree2str(TreeNode root) {
        if(root==null)return "";
         return tree(root);
    }
    public String tree(TreeNode root){
        if(root==null)return "";
        
        String left=tree(root.left);
            
        String right=tree(root.right);
            
        String r=root.val+"";
            if(left.equals("")==false || (left.equals("")==true && right.equals("")==false))
            r+= "("+left+")";
        
        
             if(right.equals("")==false){
            r+= "("+right+")";
        }  
         
        return  r;
    }
}