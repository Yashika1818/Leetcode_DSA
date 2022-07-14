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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,0,inorder.length-1,hm);
    }
    public TreeNode helper(int[] pre,int prelo,int prehi,int inlo,int inhi,HashMap<Integer,Integer> hm){
        if(prelo>prehi || inlo>inhi)return null;
        
        TreeNode node=new TreeNode(pre[prelo]);
       int i= hm.get(pre[prelo]);
        node.left=helper(pre,prelo+1,prelo+i-inlo,inlo,i-1,hm);
        node.right=helper(pre,prelo+i-inlo+1,prehi,i+1,inhi,hm);
        
        return node;
    }
}