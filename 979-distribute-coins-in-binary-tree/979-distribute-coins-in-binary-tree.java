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
    class Pair{
        int nodes; //nodes including itself nd below it
        int coins; //coins of itself+below it
        
    }
    int moves=0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return moves;
    }
    public Pair helper(TreeNode root){
        if(root==null){
            Pair p=new Pair();
            return p;
        }
        
        Pair lp=helper(root.left);
        Pair rp=helper(root.right);
        Pair mp=new Pair();
        mp.nodes=lp.nodes+rp.nodes+1;
        mp.coins=lp.coins+rp.coins+root.val;
        moves+=Math.abs(mp.coins-mp.nodes);
        return mp;
    }
}