/**
https://leetcode.com/problems/validate-binary-search-tree/


Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
*/


/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE)
        
    }
    
    fun traverse(root: TreeNode?, low: Long, high: Long): Boolean {
        if(root == null) return true
        
        if ((root.`val`).toLong() >= high) return false
        if ((root.`val`).toLong() <= low) return false

        return traverse(root.left, low, (root.`val`).toLong()) && traverse(root.right, (root.`val`).toLong(), high)
    }
}
