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
    int MONITOR=1;
    int CAM=2;
    int Not_mon=3;
    int count=0;
    public int minCameraCover(TreeNode root) {
      int ans=helper(root);
      
        //edge case when left and right nodes of the root node are monitored . Now it doesnt have any parent to be monitored, therefore it should be cam.
        if(ans==Not_mon)count++;
          return count;
    }
    public int helper(TreeNode root){
        if(root==null){
            return MONITOR;
        }
        int l=helper(root.left);
        int r=helper(root.right);
        if(l==MONITOR && r==MONITOR)return Not_mon;
        else if(l==Not_mon || r== Not_mon){
            count++;
            return CAM;
        }else if(l==CAM || r==CAM)return MONITOR;
        
        return MONITOR;
    }
}