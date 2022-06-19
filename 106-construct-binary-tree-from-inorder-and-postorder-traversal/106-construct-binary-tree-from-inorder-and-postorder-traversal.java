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
  
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
       HashMap<Integer,Integer> hm=new HashMap<>();
       for(int i=0;i<inorder.length;i++){
           hm.put(inorder[i],i);
       }
       TreeNode root=helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1,hm);
       return root;
    }
    
    public TreeNode helper(int[] inorder,int[] postorder,int inlo,int inhi,int postlo,int posthi,HashMap<Integer,Integer> hm){
        if(inlo>inhi || postlo>posthi)return null;
        TreeNode node=new TreeNode();
        node.val=postorder[posthi];
        int idx=hm.get(postorder[posthi]);
        int d=inhi-idx;
        node.left=helper(inorder,postorder,inlo,idx-1,postlo,posthi-d-1,hm);
        node.right=helper(inorder,postorder,idx+1,inhi,posthi-d,posthi-1,hm);
        return node;
    }
}