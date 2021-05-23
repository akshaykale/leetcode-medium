/**
https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.

 

Example 1:



Input: root = [4,2,5,1,3]


Output: [1,2,3,4,5]

Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.

Example 2:

Input: root = [2,1,3]
Output: [1,2,3]
Example 3:

Input: root = []
Output: []
Explanation: Input is an empty tree. Output is also an empty Linked List.
Example 4:

Input: root = [1]
Output: [1]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
All the values of the tree are unique.
*/


/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 * }
 */

class Solution {
    
    fun treeToDoublyList(root:Node?): Node? {
        
        if (root == null) return root
        
        val stack: Stack<Node> = Stack()
        
        var cur = root
        
        var prev: Node? = null
        
        var head: Node = Node(0)
        
        while (cur!=null || stack.isNotEmpty()) {
            
            while(cur!=null) {
                stack.push(cur)
                cur = cur.left
            }
            
            cur = stack.pop() 
            
            if(head.right == null) { //only once
                head.right = cur
                println("${head.right?.`val`}")
            }
            
            if (prev != null) {
                prev.right = cur
                cur.left = prev
            }
            
            prev = cur
            println("${prev.`val`}")
            cur = cur.right
        }
        
        head.right?.left = prev
        prev?.right = head.right
        
        return head.right
    }
}
