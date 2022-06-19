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
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
    
        int l=helperL(root.left);       
        int r=helperR(root.right);
        if(l==r){
            return (int)Math.pow(2,l+1)-1;
        }
        
        else{
            int cl=countNodes(root.left);
            int rl=countNodes(root.right);
            return cl+rl+1;
        }
    
    }
    public int helperL(TreeNode root){
        int count=0;
        while(root!=null){
            root=root.left;
            count++;
        }
        return count;
    }
        public int helperR(TreeNode root){
        int count=0;
        while(root!=null){
            root=root.right;
            count++;
        }
        return count;
    }
}