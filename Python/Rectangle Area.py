class Solution:
    # @param {integer} A
    # @param {integer} B
    # @param {integer} C
    # @param {integer} D
    # @param {integer} E
    # @param {integer} F
    # @param {integer} G
    # @param {integer} H
    # @return {integer}
    def computeArea(self, A, B, C, D, E, F, G, H):
        res = (D-B) * (C-A) + (G-E) * (H-F)
        lb = max(A,E)
        rb = min(C,G)
        ub = min(D,H)
        db = max(B,F)
        return res - max(0, rb-lb) * max(0, ub-db)
