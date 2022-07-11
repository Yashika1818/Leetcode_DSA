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
       
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
         if(root==null)return ans;
        q.add(root);
        int count=1;
        while(q.size()>0){
            count--;
            TreeNode node=q.remove();
           if(node.left!=null) q.add(node.left);
            if(node.right!=null)q.add(node.right);
            if(count==0){
                ans.add(node.val);
                count=q.size();
            }
            
            
        }
        return ans;
    }
}