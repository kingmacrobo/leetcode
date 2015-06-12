class Stack:
    # initialize your data structure here.
    def __init__(self):
        self.list_1 = []
        self.list_2 = []

    # @param x, an integer
    # @return nothing
    def push(self, x):
        self.list_1.append(x)
        while len(self.list_2):
            self.list_1.append(self.list_2.pop(0))
        self.list_2 = self.list_1
        self.list_1 = []

    # @return nothing
    def pop(self):
        if len(self.list_2):
            self.list_2.pop(0)
        
    # @return an integer
    def top(self):
        if len(self.list_2):
            return self.list_2[0]

    # @return an boolean
    def empty(self):
        return len(self.list_2) == 0
