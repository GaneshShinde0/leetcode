class Solution:
    def getResults(self, nums: List[int], queries: List[List[int]]) -> List[int]:

        avlTree, ans = AVLTree(nums, 0, len(nums)), []

        for t, l, r in queries:
            if t == 1:
                avlTree.update(l, r)
            elif t == 2:
                ans.append(avlTree.query(l, r))
            elif l < r:
                lmTree, rMid, rTree = avlTree.split(r)
                lTree, lMid, mTree = lmTree.split(l)
                if mTree:
                    mTree.flipReverse()
                lmTree = rMid.join(lTree, mTree)
                avlTree = lMid.join(lmTree, rTree)

        return ans

class AVLTree:

    def __init__(self, nums: List[int], l: int, r: int):
        mid = (l+r) // 2
        self.size, self.height, self.balance = 0, 0, 0
        self.val, self.xor, self.rev = nums[mid], 0, False
        self.left = AVLTree(nums, l, mid) if l < mid else None
        self.right = AVLTree(nums, mid+1, r) if mid+1 < r else None
        self.collect()

    def update(self, idx: int, val: int):
        self.reverse()
        lsz = self.left.size if self.left else 0
        if lsz == idx:
            self.val = val
        elif lsz > idx:
            self.left.update(idx, val)
        else:
            self.right.update(idx - lsz - 1, val)
        self.collect()

    def query(self, l: int, r: int) -> int:
        if r-l+1 == self.size:
            return self.xor
        self.reverse()
        lsz = self.left.size if self.left else 0
        if r < lsz:
            return self.left.query(l, r)
        if l > lsz:
            return self.right.query(l - lsz - 1, r - lsz - 1)
        res = self.val
        if l < lsz:
            res ^= self.left.query(l, lsz - 1)
        if r > lsz:
            res ^= self.right.query(0, r - lsz - 1)
        return res

    def split(self, idx: int) -> (Self, Self, Self):
        self.reverse()
        lTree, rTree = self.left, self.right
        lsz = self.left.size if self.left else 0
        if lsz == idx:
            return lTree, self, rTree
        elif lsz > idx:
            lChild, mid, rChild = lTree.split(idx)
            return lChild, mid, self.join(rChild, rTree)
        else:
            lChild, mid, rChild = rTree.split(idx - lsz - 1)
            return self.join(lTree, lChild), mid, rChild
        
    def join(self, lTree: Self, rTree: Self) -> Self:
        lh, rh = lTree.height if lTree else 0, rTree.height if rTree else 0
        if rh > lh + 1:
            rTree.reverse()
            rTree.left = self.join(lTree, rTree.left)
            rTree.rebalance()
            return rTree
        elif lh > rh + 1:
            lTree.reverse()
            lTree.right = self.join(lTree.right, rTree)
            lTree.rebalance()
            return lTree
        else:
            self.left, self.right = lTree, rTree
            self.collect()
            return self

    def reverse(self):
        if self.rev:
            self.left, self.right = self.right, self.left
            if self.left:
                self.left.flipReverse()
            if self.right:
                self.right.flipReverse()
            self.balance = -self.balance
            self.rev = False

    def flipReverse(self):
        self.rev ^= True
    
    def collect(self):
        lx = rx = lsz = rsz = lh = rh = 0
        if self.left:
            lx, lsz, lh = self.left.xor, self.left.size, self.left.height
        if self.right:
            rx, rsz, rh = self.right.xor, self.right.size, self.right.height
        self.xor = lx ^ rx ^ self.val
        self.size = lsz + rsz + 1
        self.height = max(lh, rh) + 1
        self.balance = lh - rh

    def rebalance(self):
        self.collect()
        if self.balance == 2:
            self.left.reverse()
            if self.left.balance == -1:
                self.left.right.reverse()
                self.left.leftRotate()
            self.rightRotate()
        elif self.balance == -2:
            self.right.reverse()
            if self.right.balance == 1:
                self.right.left.reverse()
                self.right.rightRotate()
            self.leftRotate()

    def rightRotate(self):
        lVal, rVal = self.left.val, self.val
        self.left.left, self.left.right, self.left, self.right = self.left.right, self.right, self.left.left, self.left
        self.right.val, self.val = rVal, lVal
        self.right.collect()
        self.collect()

    def leftRotate(self):
        lVal, rVal = self.val, self.right.val
        self.right.left, self.right.right, self.left, self.right = self.left, self.right.left, self.right, self.right.right
        self.left.val, self.val = lVal, rVal
        self.left.collect()
        self.collect()