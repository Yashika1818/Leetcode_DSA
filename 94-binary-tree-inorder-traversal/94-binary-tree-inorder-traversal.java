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
//THREADED BINARY TREE
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                al.add(curr.val);
                curr=curr.right;
            } else{
                TreeNode iop=curr.left; //inorder predecessor
                while(iop.right!=null && iop.right!=curr){
                    iop=iop.right;
                }
                //if curr.left has not been processed
                if(iop.right==null){
                    iop.right=curr;
                    curr=curr.left;
                    
                }else{ // iop.right==curr (curr.left has been processed and now this is visited 2nd tym)
                    iop.right=null;
                    al.add(curr.val);
                    curr=curr.right;
                }
                
            }
        }
        
        return al;
    }
}