class Solution:
    # @param {TreeNode} root
    # @return {integer}
    def countNodes(self, root):
        ret = 0
        while root != None:
            l = root.left
            r = root.right
            h = 0
            while l != None and r != None:
                l = l.left
                r = r.left
                h += 1
            ret += (1 << h)
            if l == None:
                root = root.right
            else:
                root = root.left
        return ret
