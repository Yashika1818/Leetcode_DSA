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
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        //here  we'll play with upper bound as preorder is node left right . therefore left is coming first , hence we need to check upperbound only for left node, next will automatically be right node
        int ub=Integer.MAX_VALUE;
        TreeNode root=helper(preorder,ub);
        return root;
    }
    public TreeNode helper(int[] pre,int ub){
        if(idx==pre.length || pre[idx]>ub)return null;
        TreeNode root=new TreeNode(pre[idx]);
        idx++;
        root.left=helper(pre,root.val);
        root.right=helper(pre,ub);
        return root;
    }
}