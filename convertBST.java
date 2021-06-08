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
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if (root!=null) {
            convertBST(root.right);
            sum+=root.val;
            root.val=sum;
            convertBST(root.left);
        }
        return root;
    }
}

********************************

class Solution {
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        int sum=0;
        while (!stack.isEmpty() || node!=null) {
            while (node!=null) {
                stack.push(node);
                node=node.right;
            }
            node=stack.pop();
            sum+=node.val;
            node.val=sum;
            
            node=node.left;
        }
        return root;
    }
}
