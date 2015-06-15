class Solution:
    # @param {TreeNode} root
    # @param {TreeNode}
    def invertTree(self, root):
        if root != None:
            tempPtr = root.left
            root.left = root.right
            root.right = tempPtr
            self.invertTree(root.right)
            self.invertTree(root.left)
        return root
