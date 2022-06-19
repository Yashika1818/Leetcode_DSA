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
      TreeNode root=  helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1,hm);
        return root;
    }
    
    
    public TreeNode helper(int[] preorder,int[] inorder, int prelo,int prehi,int inlo,int inhi,HashMap<Integer,Integer> hm){
        if(prelo>prehi || inlo>inhi){
            return null;
        }
        TreeNode node=new TreeNode();
        node.val=preorder[prelo];
        int idx=hm.get(preorder[prelo]);
        int lh=idx-inlo;
        node.left=helper(preorder,inorder,prelo+1,prelo+lh,inlo,idx-1,hm);
        node.right=helper(preorder,inorder,prelo+lh+1,prehi,idx+1,inhi,hm);
        return node;
    }
}