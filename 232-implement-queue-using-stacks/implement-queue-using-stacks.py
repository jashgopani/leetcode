class MyQueue:

    def __init__(self):
        self.queue = [[],[]]
        self.active = 0
        self.inactive = 1
        self.lastOpPush = True

    def push(self, x: int) -> None:
        # print('push', x)
        if not self.lastOpPush:
            self.__swap__()
        self.queue[self.active].append(x)
        self.printq()
        self.lastOpPush = True

    def pop(self) -> int:
        # print('pop:')
        if self.lastOpPush:
            self.__swap__()
        self.printq()
        self.lastOpPush = False
        return self.queue[self.active].pop()

    def peek(self) -> int:
        # print('peek')
        self.printq()
        top = 0 if self.lastOpPush else -1
        return self.queue[self.active][top] 

    def empty(self) -> bool:
        # print('empty')
        self.printq()
        return len(self.queue[self.active]) == 0

    def __swap__(self):
        self.active, self.inactive = self.inactive, self.active
        while len(self.queue[self.inactive]) > 0:
            self.queue[self.active].append(self.queue[self.inactive].pop())

    def printq(self):
        for q in range(len(self.queue)):
            print("*" if q == self.active else " ",self.queue[q])
        
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()