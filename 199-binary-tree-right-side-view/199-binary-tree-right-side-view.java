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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> al=new ArrayList<>();
        if(root==null){
            return al;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean flag=true;
        while(q.size()>0){
            TreeNode rem=q.remove();
            if(rem==null){
                flag=true;
                if(q.size()>0)q.add(null);
                continue;
            }
            if(flag){
                al.add(rem.val);
                flag=false;
            }
            
            if(rem.right!=null)q.add(rem.right);
            if(rem.left!=null)q.add(rem.left);
        }
        return al;
    }
}