/**
https://leetcode.com/problems/path-sum-ii/



Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
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
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val res: MutableList<List<Int>> = mutableListOf()
        root?.dfs(targetSum, LinkedList<Int>(), res)
        return res
    }
    
    fun TreeNode.dfs(remainingSum: Int, path: LinkedList<Int>, pathList: MutableList<List<Int>>) {
        
        var sum = remainingSum
        sum -= this.`val`
        
        path.add(this.`val`)
        
        if (this.left ==null && this.right == null && sum == 0) {
            pathList.add(path.toMutableList())
        } else {
            this.left?.dfs(sum, path, pathList)
            this.right?.dfs(sum, path, pathList)
        }
        path.removeLast()
    }
}
